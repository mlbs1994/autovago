/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import modelo.Categoria;
import servico.CategoriaServico;


/**
 *
 * @author Matheus Levi
 */
public class CategoriaBean {

    String nomeCategoria;
    List<Categoria> categorias;
    
    @EJB
    private CategoriaServico categoriaServico;
    
    
    public CategoriaBean() 
    {
        
        
    }
    
    
    public String salvar()
    {
        try
        {
            Categoria categoria = new Categoria();
            categoria.setNome(nomeCategoria);

            this.categoriaServico.salvar(categoria);
        }
        catch (EJBException ex) {
            ex.printStackTrace();
        }
        
        return "cadastrarCategoria.xhtml?faces-redirect=true";
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Categoria> getCategorias() {
        categorias = this.categoriaServico.getListaCategorias();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public CategoriaServico getCategoriaServico() {
        return categoriaServico;
    }

    public void setCategoriaServico(CategoriaServico categoriaServico) {
        this.categoriaServico = categoriaServico;
    }
    
    

}
