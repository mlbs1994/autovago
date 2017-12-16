/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import modelo.Automovel;
import modelo.Categoria;
import modelo.Fabricante;
import modelo.Oferta;
import org.primefaces.event.FileUploadEvent;
import servico.AutomovelServico;
import servico.CategoriaServico;
import servico.FabricanteServico;
import servico.OfertaServico;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean
@SessionScoped
public class AutomovelBean implements Serializable{

    @EJB
    private CategoriaServico categoriaServico;
    
    @EJB
    private FabricanteServico fabricanteServico;
    
    @EJB
    private AutomovelServico automovelServico;
    @EJB
    private OfertaServico ofertaServico;
    
    String modelo;
    int ano;
    String descricao;
    Fabricante fabricante;
    Categoria categoria;
    int numEstrelas;
    String img;
    
    private List<Categoria> categorias;
    private List<Fabricante> fabricantes;
    private List<Automovel> automoveis;
    
    Automovel automovelSelAval;
 
    
    public AutomovelBean() {
    }

    public CategoriaServico getCategoriaServico() {
        return categoriaServico;
    }

    public void setCategoriaServico(CategoriaServico categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    public FabricanteServico getFabricanteServico() {
        return fabricanteServico;
    }

    public void setFabricanteServico(FabricanteServico fabricanteServico) {
        this.fabricanteServico = fabricanteServico;
    }

    public AutomovelServico getAutomovelServico() {
        return automovelServico;
    }

    public void setAutomovelServico(AutomovelServico automovelServico) {
        this.automovelServico = automovelServico;
    }

    public OfertaServico getOfertaServico() {
        return ofertaServico;
    }

    public void setOfertaServico(OfertaServico ofertaServico) {
        this.ofertaServico = ofertaServico;
    }
    
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getNumEstrelas() {
        return numEstrelas;
    }

    public void setNumEstrelas(int numEstrelas) {
        this.numEstrelas = numEstrelas;
    }

    
    public void uploadAction(FileUploadEvent event)
    {
        this.img = event.getFile().getFileName();
    }

    public List<Categoria> getCategorias() {
        categorias = this.categoriaServico.getListaCategorias();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Fabricante> getFabricantes() {
        fabricantes = this.fabricanteServico.getListaFabricantes();
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public List<Automovel> getAutomoveis() {
        automoveis = this.automovelServico.getListaAutomoveis();
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    public Automovel getAutomovelSelAval() {
        return automovelSelAval;
    }

    public void setAutomovelSelAval(Automovel automovelSelAval) {
        this.automovelSelAval = automovelSelAval;
    }
    
    public String atualizarCarroSelAval(Integer id)
    {
        automovelSelAval = this.automovelServico.getAutomovel(id);
        
        return "fazerAvaliacao.xhtml?faces-redirect=true";
    }
    

    public String salvar() {

        try 
        {
            Automovel automovel = new Automovel();
            
            automovel.setNomeModelo(modelo);
            automovel.setIdFabricante(fabricante);
            automovel.setIdCategoria(categoria);
            automovel.setAno(ano);
            automovel.setDescricao(descricao);
            automovel.setNumEstrelas(numEstrelas);
            automovel.setImgSrc(img);
            
            System.out.println("modelo = "+modelo);
            System.out.println("fabricante = "+fabricante);
            System.out.println("categoria = "+categoria);
            System.out.println("ano = "+ano);
            System.out.println("numEstrelas = "+numEstrelas);
            System.out.println("descricao = "+descricao);
            System.out.println("imgSrc = "+img);
            
            this.automovelServico.salvar(automovel);
        } 
        catch (EJBException ex) {
            ex.printStackTrace();
        }
        
        return "cadastrarAutomovel.xhtml?faces-redirect=true";
    }
    
    public Automovel getAutomovelPorId(Integer id)
    {
        return this.automovelServico.getAutomovel(id);
    }
    
    
    
}
