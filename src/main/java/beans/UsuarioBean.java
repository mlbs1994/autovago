
package beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import modelo.Endereco;
import modelo.Usuario;
import servico.EnderecoServico;
import servico.UsuarioServico;

/**
 *
 * @author marcia
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioServico usuarioServico;

    @EJB
    private EnderecoServico enderecoServico;

    
    
    //Usuario usuario;
    //private Endereco endereco;

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
    
    
    public UsuarioBean() {
        
        
    }

    public void salvar() {

        try {
             Usuario usr = new Usuario();
        
        usr.setNome(this.nome);
        usr.setEmail(this.email);
        usr.setLogin(this.login);
        usr.setSenha(this.senha);
        
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
        usr.setIdEndereco(endereco);
        
        this.usuarioServico.salvar(usr);
            
        } 
        catch (EJBException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the usuario
     */
    
    /*
    public Usuario getUsuario() {
        return usuario;
    }

   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }*/

    public UsuarioServico getUsuarioServico() {
        return usuarioServico;
    }

    public void setUsuarioServico(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    public EnderecoServico getEnderecoServico() {
        return enderecoServico;
    }

    public void setEnderecoServico(EnderecoServico enderecoServico) {
        this.enderecoServico = enderecoServico;
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
    
    

}
