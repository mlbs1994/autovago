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
import modelo.Fabricante;
import servico.FabricanteServico;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean
@SessionScoped
public class FabricanteBean implements Serializable{

    String nomeFabricante;
    List<Fabricante> fabricantes;
    
    @EJB
    private FabricanteServico fabricanteServico;
    
    
    public FabricanteBean() 
    {
        
        
    }

    public String getNomeFabricante() {
        return nomeFabricante;
    }

    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }

    public List<Fabricante> getFabricantes() {
        fabricantes = fabricanteServico.getListaFabricantes();
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public FabricanteServico getFabricanteServico() {
        return fabricanteServico;
    }

    public void setFabricanteServico(FabricanteServico fabricanteServico) {
        this.fabricanteServico = fabricanteServico;
    }
    
    public String salvar()
    {
        try
        {
            Fabricante fabricante = new Fabricante();
            fabricante.setNome(nomeFabricante);

            this.fabricanteServico.salvar(fabricante);
        }
        catch (EJBException ex) {
            ex.printStackTrace();
        }
        
        return "cadastrarFabricante.xhtml?faces-redirect=true";
    }
    
}
