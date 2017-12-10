/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Categoria;
import servico.CategoriaServico;

/**
 *
 * @author Matheus Levi
 */
@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter{

    @EJB
    CategoriaServico categoriaServico;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        System.out.println("value = "+value);
        
        int idCategoria = Integer.parseInt(value);
        
        Categoria c = this.categoriaServico.getCategoria(idCategoria);
        
        System.out.println("nomeCategoria = "+c.getNome()+" - "+c.getIdCategoria());
        
        return c;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
         if(value instanceof Categoria && value != null)
        {  
          Categoria categoria = (Categoria) value;
          return categoria.getIdCategoria().toString();
        }  
        
        return null;
        
    }
    
}
