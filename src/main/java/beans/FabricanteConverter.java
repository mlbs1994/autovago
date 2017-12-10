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
import modelo.Fabricante;
import servico.FabricanteServico;

/**
 *
 * @author Matheus Levi
 */
	
@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter{
    
    @EJB
    FabricanteServico fabricanteServico;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
        System.out.println("value = "+value);
        
        int idFabricante = Integer.parseInt(value);
        
        Fabricante f = this.fabricanteServico.getFabricante(idFabricante);
        
        System.out.println("nomeFabricante = "+f.getNome()+" - "+f.getIdFabricante());
        
        return f;
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value instanceof Fabricante && value != null)
        {  
          Fabricante fabricante = (Fabricante) value;
          return fabricante.getIdFabricante().toString();
        }  
        
        return null;
    }
    
}
