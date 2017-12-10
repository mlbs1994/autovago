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
import modelo.Automovel;
import servico.AutomovelServico;

/**
 *
 * @author Matheus Levi
 */
@FacesConverter("automovelConverter")
public class AutomovelConverter implements Converter{

    @EJB
    AutomovelServico automovelServico;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        System.out.println("value = "+value);
        
        int idAutomovel = Integer.parseInt(value);
        
        Automovel a = this.automovelServico.getAutomovel(idAutomovel);
        
        System.out.println("nomeAutomovel = "+a.getNomeModelo()+" - "+a.getIdAutomovel());
        
        return a;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
         if(value instanceof Automovel && value != null)
        {  
          Automovel automovel = (Automovel) value;
          return automovel.getIdAutomovel().toString();
        }  
        
        return null;
        
    }
    
}

