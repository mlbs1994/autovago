/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import modelo.Categoria;
import modelo.Fabricante;
import servico.CategoriaServico;
import servico.FabricanteServico;

/**
 *
 * @author Matheus Levi
 */
public class FiltroBean {

    @EJB
    private CategoriaServico categoriaServico;
    
    @EJB
    private FabricanteServico fabricanteServico;
   
    private Categoria categoria;
    private Fabricante fabricante;
    
    private List<Categoria> categorias;
    private List<Fabricante> fabricantes;
    
    public FiltroBean()
    {
        

        categoria = new Categoria();
        fabricante = new Fabricante();
        
        categorias = new ArrayList();
        fabricantes = new ArrayList();
        

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<Categoria> getCategorias() {
        categorias = categoriaServico.getListaCategorias();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Fabricante> getFabricantes() {
        fabricantes = fabricanteServico.getListaFabricantes();
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

   
    
    
    
    
    
    
}
