/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matheus Levi
 */
public class LogoutBean {

    public LogoutBean() {
    }
    
    public String logout() throws ServletException
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        if(session!=null)
        {
            session.invalidate();
        }
        
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        req.logout();
        
        return "login.xhtml?faces-redirect=true";
    }
    
}
