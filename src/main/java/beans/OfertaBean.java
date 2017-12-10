/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.context.FacesContext;
import modelo.Automovel;
import modelo.Concessionaria;
import modelo.Oferta;
import modelo.Usuario;
import org.primefaces.event.FileUploadEvent;
import servico.AdmConcessionariaServico;
import servico.AutomovelServico;
import servico.OfertaServico;

/**
 *
 * @author Matheus Levi
 */
public class OfertaBean {

    @EJB
    OfertaServico ofertaServico;
    
    @EJB
    AdmConcessionariaServico admConcessionariaServico;
    
    @EJB
    AutomovelServico automovelServico;
    
    Concessionaria concessionaria;
    Automovel automovel;
    String descricao;
    String cor;
    float preco;
    boolean ehZeroKm;
    boolean ehAutomatico;
    boolean eh4Portas;
    boolean ehDirecaoHidraulica;
    boolean temComputadorBordo;
    boolean temSistemaAntiRoubo;
    
    List<Oferta> ofertas;
    List<Oferta> minhasOfertas;
    List<Oferta> melhoresOfertas;
    List<Automovel> listaAutomoveis;
    
    
    public OfertaBean() {
    }
    
    public OfertaServico getOfertaServico() {
        return ofertaServico;
    }

    public void setOfertaServico(OfertaServico ofertaServico) {
        this.ofertaServico = ofertaServico;
    }

    public Concessionaria getConcessionaria() {
        return concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean getEhZeroKm() {
        return ehZeroKm;
    }

    public void setEhZeroKm(boolean ehZeroKm) {
        this.ehZeroKm = ehZeroKm;
    }

    public boolean getEhAutomatico() {
        return ehAutomatico;
    }

    public void setEhAutomatico(boolean ehAutomatico) {
        this.ehAutomatico = ehAutomatico;
    }

    public boolean getEh4Portas() {
        return eh4Portas;
    }

    public void setEh4Portas(boolean eh4Portas) {
        this.eh4Portas = eh4Portas;
    }

    public boolean getEhDirecaoHidraulica() {
        return ehDirecaoHidraulica;
    }

    public void setEhDirecaoHidraulica(boolean ehDirecaoHidraulica) {
        this.ehDirecaoHidraulica = ehDirecaoHidraulica;
    }

    public boolean getTemComputadorBordo() {
        return temComputadorBordo;
    }

    public void setTemComputadorBordo(boolean temComputadorBordo) {
        this.temComputadorBordo = temComputadorBordo;
    }

    public boolean getTemSistemaAntiRoubo() {
        return temSistemaAntiRoubo;
    }

    public void setTemSistemaAntiRoubo(boolean temSistemaAntiRoubo) {
        this.temSistemaAntiRoubo = temSistemaAntiRoubo;
    }

    public List<Oferta> getOfertas() {
        ofertas = this.ofertaServico.getListaOfertas();
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Oferta> getMinhasOfertas() {
        minhasOfertas = this.ofertaServico.getListaOfertasConcessionaria(concessionaria);
        return minhasOfertas;
    }

    public void setMinhasOfertas(List<Oferta> minhasOfertas) {
        this.minhasOfertas = minhasOfertas;
    }

    public List<Automovel> getListaAutomoveis() {
        listaAutomoveis = this.automovelServico.getListaAutomoveis();
        return listaAutomoveis;
    }

    public void setListaAutomoveis(List<Automovel> listaAutomoveis) {
        this.listaAutomoveis = listaAutomoveis;
    }

    public List<Oferta> getMelhoresOfertas() 
    {
        melhoresOfertas = this.ofertaServico.getMelhoresOfertas(this.automovel);
        return melhoresOfertas;
    }

    public void setMelhoresOfertas(List<Oferta> melhoresOfertas) {
        this.melhoresOfertas = melhoresOfertas;
    }
    
    public AdmConcessionariaServico getAdmConcessionariaServico() {
        return admConcessionariaServico;
    }

    public void setAdmConcessionariaServico(AdmConcessionariaServico admConcessionariaServico) {
        this.admConcessionariaServico = admConcessionariaServico;
    }

    public AutomovelServico getAutomovelServico() {
        return automovelServico;
    }

    public void setAutomovelServico(AutomovelServico automovelServico) {
        this.automovelServico = automovelServico;
    }

    
    public String salvar()
    {
        
        try 
        {
            Map<String,String> params;
            params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	    int idUsuario = Integer.parseInt(params.get("idUsuario"));
 
            concessionaria = this.admConcessionariaServico.getConcessionariaUsuario(idUsuario);
            
            Oferta oferta = new Oferta();
            
            
            
            oferta.setIdConcessionaria(concessionaria);
            oferta.setIdAutomovel(automovel);
            oferta.setDescricao(descricao);
            oferta.setCor(cor);
            oferta.setPreco(preco);
            oferta.setEhZeroKm(ehZeroKm);
            oferta.setEhAutomatico(ehAutomatico);
            oferta.setEh4Portas(eh4Portas);
            oferta.setEhDirecaoHidraulica(ehDirecaoHidraulica);
            oferta.setTemComputadorBordo(temComputadorBordo);
            oferta.setTemSistemaAntiRoubo(temSistemaAntiRoubo);
            
            this.ofertaServico.salvar(oferta);
        } 
        catch (EJBException ex) {
            ex.printStackTrace();
        }
        
        return "minhasOfertas.xhtml?faces-redirect=true";
        
        
    }
    
    
    
    
}
