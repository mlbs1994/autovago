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
import modelo.AdmConcessionaria;
import modelo.Cliente;
import modelo.Usuario;
import servico.AdmConcessionariaServico;
import servico.ClienteServico;
import servico.ConcessionariaServico;
import servico.EnderecoServico;
import servico.UsuarioServico;

@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {

    @EJB
    private UsuarioServico UsuarioServico;
    
    @EJB
    private ClienteServico ClienteServico;
    
    @EJB
    private AdmConcessionariaServico AdmConcessionariaServico;
    
    @EJB
    private EnderecoServico EnderecoServico;
    
    @EJB
    private ConcessionariaServico ConcessionariaServico;
    

    private String username;
    private String senha;
    
    private Usuario usuarioLogado;
    private Cliente clienteLogado;
    private AdmConcessionaria admConcessionariaLogado;
    
    String discUsuario;

    public LoginBean(UsuarioServico UsuarioServico, String username, String senha, Usuario usuarioLogado, Cliente clienteLogado) {
        this.UsuarioServico = UsuarioServico;
        this.username = username;
        this.senha = senha;
        this.usuarioLogado = usuarioLogado;
        this.clienteLogado = clienteLogado;
    }
    
    public LoginBean() {
    }

    public String efetuarLogin() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        
        try {
            
            request.login(username, senha);
            facesContext.getExternalContext().getSession(true);
            
            Usuario usuario = UsuarioServico.buscarPessoa(username);
            this.usuarioLogado = usuario;
            
            String homepage="";
            
            if(this.usuarioLogado.getDecriminatorValue().equals("C")) {
                homepage =  "/faces/home.xhtml";
                clienteLogado = this.ClienteServico.getClientePorUsuario(usuario);
                
            } if(this.usuarioLogado.getDecriminatorValue().equals("A")) {
                 homepage =  "/faces/cadastrarOferta.xhtml";
                 admConcessionariaLogado = this.AdmConcessionariaServico.getAdmConcessionariaPorUsuario(usuario);
            }
               
            System.out.println("homepage = "+homepage);
            return homepage;
            
            
        } catch (ServletException ex) {
           setUsername(null);
           return "/login";
        }
   }
    
    public String alterarDadosCadastrais() throws ServletException
    {
        if(clienteLogado!=null)
        {
            this.EnderecoServico.alterarDadosEndereco(clienteLogado.getIdEndereco());
            this.UsuarioServico.alterarDadosUsuario(clienteLogado);
        }
        else
        {
            this.EnderecoServico.alterarDadosEndereco(admConcessionariaLogado.getConcessionaria().getIdEndereco());
            this.ConcessionariaServico.alterarDadosConcessionaria(admConcessionariaLogado.getConcessionaria());
            this.UsuarioServico.alterarDadosUsuario(admConcessionariaLogado);
        }
        
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
    
    public String excluirUsuario() throws ServletException
    {
        this.UsuarioServico.excluirConta(usuarioLogado);
        
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

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public AdmConcessionaria getAdmConcessionariaLogado() {
        return admConcessionariaLogado;
    }

    public void setAdmConcessionariaLogado(AdmConcessionaria admConcessionariaLogado) {
        this.admConcessionariaLogado = admConcessionariaLogado;
    }

    public ClienteServico getClienteServico() {
        return ClienteServico;
    }

    public void setClienteServico(ClienteServico ClienteServico) {
        this.ClienteServico = ClienteServico;
    }

    public AdmConcessionariaServico getAdmConcessionariaServico() {
        return AdmConcessionariaServico;
    }

    public void setAdmConcessionariaServico(AdmConcessionariaServico AdmConcessionariaServico) {
        this.AdmConcessionariaServico = AdmConcessionariaServico;
    }

    public EnderecoServico getEnderecoServico() {
        return EnderecoServico;
    }

    public void setEnderecoServico(EnderecoServico EnderecoServico) {
        this.EnderecoServico = EnderecoServico;
    }

    public ConcessionariaServico getConcessionariaServico() {
        return ConcessionariaServico;
    }

    public void setConcessionariaServico(ConcessionariaServico ConcessionariaServico) {
        this.ConcessionariaServico = ConcessionariaServico;
    }

    
    
    public String getDiscUsuario() {
        return discUsuario;
    }

    public void setDiscUsuario(String discUsuario) {
        this.discUsuario = discUsuario;
    }
    
    
    
    
    
    

}