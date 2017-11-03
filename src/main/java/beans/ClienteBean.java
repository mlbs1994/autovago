/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Usuario;
import servico.ClienteServico;
import servico.EnderecoServico;
import servico.UsuarioServico;

/**
 *
 * @author marcia
 */
@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteServico clienteServico;
    
    @EJB
    private UsuarioServico usuarioServico;


    
    public ClienteBean() {
    }
    
    //UsuarioLogado
    Usuario usuarioLogado;
    
    //Usuario
    private String nome;
    private String email;
    private String login;
    private String senha;
    
    //Endereço
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    
    
  
    public String salvar() {

        try {
             Usuario usr = new Usuario();
             Cliente cliente = new Cliente();
        
        usr.setNome(this.nome);
        usr.setEmail(this.email);
        usr.setLogin(this.login);
        usr.setSenha(this.senha);
        
        this.getUsuarioServico().salvar(usr);
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setEstado(this.estado);
        endereco.setCep(this.cep);
        endereco.setLatitude(0.0f);
        endereco.setLongitude(0.0f);
        
        cliente.setIdEndereco(endereco);
        cliente.setIdUsuario(usr);
        this.getClienteServico().salvar(cliente);
        
            
        } 
        catch (EJBException ex) {
            ex.printStackTrace();
        }
        
        return "login.xhtml";
    }
    
    public void alterarDadosCadastrais()
    {
        this.usuarioServico.alterarDadosUsuario(this.usuarioLogado);
    }
    
    public String excluirContaUsuario() throws ServletException
    {
        this.usuarioServico.excluirConta(this.usuarioLogado);
        
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

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the clienteServico
     */
    public ClienteServico getClienteServico() {
        return clienteServico;
    }

    /**
     * @param clienteServico the clienteServico to set
     */
    public void setClienteServico(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    /**
     * @return the usuarioServico
     */
    public UsuarioServico getUsuarioServico() {
        return usuarioServico;
    }

    /**
     * @param usuarioServico the usuarioServico to set
     */
    public void setUsuarioServico(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

}
