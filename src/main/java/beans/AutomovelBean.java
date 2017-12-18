/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
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
import servico.AvaliacaoServico;
import servico.CategoriaServico;
import servico.FabricanteServico;
import servico.OfertaServico;
import util.Filtro;

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
    
    @EJB
    private AvaliacaoServico avaliacaoServico;            
    
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
    Oferta ofertaSel;
    
    List<Oferta> ofertasAutomovel;
    Oferta melhorOferta;
    
    String zeroKmImg="icon1.png";
    String cambioAutomaticoImg="icon2.png";
    String eh4PortasImg="icon3.png";
    String ehDirecaoHidraulicaImg="icon4.png";
    String temComputadorBordoImg="icon5.png";
    String temSistemaAntirouboImg="icon6.png";
    
    String zeroPCor="red";
    String setentaPCor="greenyellow";
    String setentaCincoPCor="#0b0";
    String oitentaPCor="#0a0";
    String oitentaCincoPCor="green";
    
    Filtro filtro=new Filtro();
 
    
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

    public AvaliacaoServico getAvaliacaoServico() {
        return avaliacaoServico;
    }

    public void setAvaliacaoServico(AvaliacaoServico avaliacaoServico) {
        this.avaliacaoServico = avaliacaoServico;
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
       if(filtro.verificarSeVazio())
       {
            automoveis = this.automovelServico.getListaAutomoveis();
       } 
        
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

    public Oferta getOfertaSel() {
        return ofertaSel;
    }

    public void setOfertaSel(Oferta ofertaSel) {
        this.ofertaSel = ofertaSel;
    }
    
    public List<Oferta> getOfertasAutomovel(Automovel automovel) {
        ofertasAutomovel = this.ofertaServico.getMelhoresOfertas(automovel);
        return ofertasAutomovel;
    }

    public void setOfertasAutomovel(List<Oferta> ofertasAutomovel) {
        this.ofertasAutomovel = ofertasAutomovel;
    }
    
    

    public String getZeroKmImg() {
        return zeroKmImg;
    }

    public void setZeroKmImg(String zeroKmImg) {
        this.zeroKmImg = zeroKmImg;
    }

    public String getCambioAutomaticoImg() {
        return cambioAutomaticoImg;
    }

    public void setCambioAutomaticoImg(String cambioAutomaticoImg) {
        this.cambioAutomaticoImg = cambioAutomaticoImg;
    }

    public String getEh4PortasImg() {
        return eh4PortasImg;
    }

    public void setEh4PortasImg(String eh4PortasImg) {
        this.eh4PortasImg = eh4PortasImg;
    }

    public String getEhDirecaoHidraulicaImg() {
        return ehDirecaoHidraulicaImg;
    }

    public void setEhDirecaoHidraulicaImg(String ehDirecaoHidraulicaImg) {
        this.ehDirecaoHidraulicaImg = ehDirecaoHidraulicaImg;
    }

    public String getTemComputadorBordoImg() {
        return temComputadorBordoImg;
    }

    public void setTemComputadorBordoImg(String temComputadorBordoImg) {
        this.temComputadorBordoImg = temComputadorBordoImg;
    }

    public String getTemSistemaAntirouboImg() {
        return temSistemaAntirouboImg;
    }

    public void setTemSistemaAntirouboImg(String temSistemaAntirouboImg) {
        this.temSistemaAntirouboImg = temSistemaAntirouboImg;
    }

    public String getZeroPCor() {
        return zeroPCor;
    }

    public void setZeroPCor(String zeroPCor) {
        this.zeroPCor = zeroPCor;
    }

    public String getSetentaPCor() {
        return setentaPCor;
    }

    public void setSetentaPCor(String setentaPCor) {
        this.setentaPCor = setentaPCor;
    }

    public String getSetentaCincoPCor() {
        return setentaCincoPCor;
    }

    public void setSetentaCincoPCor(String setentaCincoPCor) {
        this.setentaCincoPCor = setentaCincoPCor;
    }

    public String getOitentaPCor() {
        return oitentaPCor;
    }

    public void setOitentaPCor(String oitentaPCor) {
        this.oitentaPCor = oitentaPCor;
    }

    public String getOitentaCincoPCor() {
        return oitentaCincoPCor;
    }

    public void setOitentaCincoPCor(String oitentaCincoPCor) {
        this.oitentaCincoPCor = oitentaCincoPCor;
    }
    
    public Oferta getMelhorOferta() {
        return melhorOferta;
    }

    public void setMelhorOferta(Oferta melhorOferta) {
        this.melhorOferta = melhorOferta;
    }
    
    
    
    public void ativarEspecificacoesFiltro(Integer esp)
    {
       if(esp==1)
       {
           filtro.zeroKmFiltro = filtro.zeroKmFiltro==false;
           if(filtro.zeroKmFiltro)
           {
               zeroKmImg="icon1A.png";
           }
           else
           {
               zeroKmImg="icon1.png";
           }
       }
       else if(esp==2)
       {
           filtro.cambioAutomaticoFiltro = filtro.cambioAutomaticoFiltro==false;
           if(filtro.cambioAutomaticoFiltro)
           {
               cambioAutomaticoImg="icon2A.png";
           }
           else
           {
               cambioAutomaticoImg="icon2.png";
           }
       }
       else if(esp==3)
       {
           filtro.eh4PortasFiltro = filtro.eh4PortasFiltro==false;
           if(filtro.eh4PortasFiltro)
           {
               eh4PortasImg="icon3A.png";
           }
           else
           {
               eh4PortasImg="icon3.png";
           }
       }
       else if(esp==4)
       {
           filtro.ehDirecaoHidraulicaFiltro = filtro.ehDirecaoHidraulicaFiltro==false;
           if(filtro.ehDirecaoHidraulicaFiltro)
           {
               ehDirecaoHidraulicaImg="icon4A.png";
           }
           else
           {
               ehDirecaoHidraulicaImg="icon4.png";
           }
       }
       else if(esp==5)
       {
           filtro.temComputadorBordoFiltro = filtro.temComputadorBordoFiltro==false;
           if(filtro.temComputadorBordoFiltro)
           {
               temComputadorBordoImg="icon5A.png";
           }
           else
           {
               temComputadorBordoImg="icon5.png";
           }
       }
       else if(esp==6)
       {
           filtro.temSistemaAntirouboFiltro = filtro.temSistemaAntirouboFiltro==false;
           if(filtro.temSistemaAntirouboFiltro)
           {
               temSistemaAntirouboImg="icon6A.png";
           }
           else
           {
               temSistemaAntirouboImg="icon6.png";
           }
       }
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

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
    
    
    
    public void filtrarListaOfertas(Integer especificacao, String notaInterval)
    {
        if(especificacao!=0)
        {
            this.ativarEspecificacoesFiltro(especificacao);
        }
         
        this.automoveis = this.automovelServico.getListaAutomoveisFiltro(filtro);   
        
         if(!notaInterval.isEmpty())
        {
            filtro.notaIntervalFiltro = notaInterval;
            filtrarPorAvaliacao();
        }
    
    }
    
    public Automovel getAutomovelPorId(Integer id)
    {
        return this.automovelServico.getAutomovel(id);
    }
    
    public Oferta getMelhorOferta(Automovel automovel)
    {
        melhorOferta = this.ofertaServico.getMelhorOfertaAutomovel(automovel);
        return melhorOferta;
    }
    
    public void resetarFiltro()
    {
        filtro.resetarFiltro();
        zeroKmImg = "icon1.png";
        cambioAutomaticoImg="icon2.png";
        eh4PortasImg="icon3.png";
        ehDirecaoHidraulicaImg="icon4.png";
        temComputadorBordoImg="icon5.png";
        temSistemaAntirouboImg="icon6.png";
        
        zeroPCor="red";
        setentaPCor="greenyellow";
        setentaCincoPCor="#0b0";
        oitentaPCor="#0a0";
        oitentaCincoPCor="green";
        
        
        automoveis = this.getAutomoveis();
    }

    private void filtrarPorAvaliacao() {
       
        List<Automovel> listaAutomoveisAvaliacao = new ArrayList();
        
        switch(filtro.notaIntervalFiltro)
        {
            case "0+": // nota >= 0 
            for (Automovel automovel : automoveis)
            {
                Double avgAutomovel = this.avaliacaoServico.getAvgAvaliacaoAutomovel(automovel);
                if(avgAutomovel >=0)
                {
                    listaAutomoveisAvaliacao.add(automovel);
                }
            }
            destacarAvalSel(filtro.notaIntervalFiltro);
            break;  
                
            case "70+": // nota >= 70 
            for (Automovel automovel : automoveis)
            {
                Double avgAutomovel = this.avaliacaoServico.getAvgAvaliacaoAutomovel(automovel);
                if(avgAutomovel >=70)
                {
                    listaAutomoveisAvaliacao.add(automovel);
                }
            } 
            destacarAvalSel(filtro.notaIntervalFiltro);
            break;
                
            case "75+": // nota >= 75 
            for (Automovel automovel : automoveis)
            {
                Double avgAutomovel = this.avaliacaoServico.getAvgAvaliacaoAutomovel(automovel);
                if(avgAutomovel >=75)
                {
                    listaAutomoveisAvaliacao.add(automovel);
                }
            }    
            destacarAvalSel(filtro.notaIntervalFiltro);
            break;
                
            case "80+": // nota >= 80 
            for (Automovel automovel : automoveis)
            {
                Double avgAutomovel = this.avaliacaoServico.getAvgAvaliacaoAutomovel(automovel);
                if(avgAutomovel >=80)
                {
                    listaAutomoveisAvaliacao.add(automovel);
                }
            }
            destacarAvalSel(filtro.notaIntervalFiltro);
            break;
                
            case "85+": // nota >= 85 
            for (Automovel automovel : automoveis)
            {
                Double avgAutomovel = this.avaliacaoServico.getAvgAvaliacaoAutomovel(automovel);
                if(avgAutomovel >=85)
                {
                    listaAutomoveisAvaliacao.add(automovel);
                }
            }
            destacarAvalSel(filtro.notaIntervalFiltro);
            break;    
        }
        
        automoveis = listaAutomoveisAvaliacao;
        
    }

    private void destacarAvalSel(String notaIntervalFiltro)
    {
        switch(notaIntervalFiltro)
        {
            case "0+":
            zeroPCor="darkblue";
            setentaPCor="greenyellow";
            setentaCincoPCor="#0b0";
            oitentaPCor="#0a0";
            oitentaCincoPCor="green";    
            break;
                
            case "70+":
            zeroPCor="red";
            setentaPCor="darkblue";
            setentaCincoPCor="#0b0";
            oitentaPCor="#0a0";
            oitentaCincoPCor="green";     
            break;
                
            case "75+":
            zeroPCor="red";
            setentaPCor="greenyellow";
            setentaCincoPCor="darkblue";
            oitentaPCor="#0a0";
            oitentaCincoPCor="green";     
            break;
                
            case "80+":
            zeroPCor="red";
            setentaPCor="greenyellow";
            setentaCincoPCor="#0b0";
            oitentaPCor="darkblue";
            oitentaCincoPCor="green";    
            break;
                
            case "85+":
            zeroPCor="red";
            setentaPCor="greenyellow";
            setentaCincoPCor="#0b0";
            oitentaPCor="#0a0";
            oitentaCincoPCor="darkblue";    
            break;    
        }
    }
    
    public String redirect(Oferta of)
    {
        ofertaSel = of;
        
        return "paginaConcessionaria.xhtml?faces-redirect=true";
    }
    
}
