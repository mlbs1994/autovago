/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import servico.UsuarioServico;

@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {

    @EJB
    private UsuarioServico UsuarioServico;

    private String username;
    private String senha;
    
    private Usuario usuarioLogado;

    public LoginBean() {
    }

    public String efetuarLogin() {
        Usuario usuario = UsuarioServico.buscarPessoa(username, senha);
        String homepage="";
        if (usuario == null) {
            return "/login";

        } else {
            this.usuarioLogado = usuario;
            
            /*if(this.usuarioLogado.getDecriminatorValue()=="C")
            {
                homepage =  "/home?faces-redirect=true";
            }
            if(this.usuarioLogado.getDecriminatorValue()=="A")
            {
                 homepage =  "/homeConcessionaria?faces-redirect=true";
            }*/
            
        }
       
        System.out.println("homepage = "+homepage);
        return "/home?faces-redirect=true";

    }
    
    public UsuarioServico getUsuarioServico() {
        return UsuarioServico;
    }
    
    public void setUsuarioServico(UsuarioServico UsuarioServico) {
        this.UsuarioServico = UsuarioServico;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    

}