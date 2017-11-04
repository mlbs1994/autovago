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
import modelo.AdmConcessionaria;
import modelo.Concessionaria;
import modelo.Endereco;
import servico.AdmConcessionariaServico;
import servico.UsuarioServico;

/**
 *
 * @author marcia
 */
@ManagedBean
@SessionScoped
public class AdmConcessionariaBean implements Serializable {
    
    @EJB
    private UsuarioServico usuarioServico;
    
    @EJB
    private AdmConcessionariaServico AdmConcessionariaServico;

    public AdmConcessionariaBean() {
    }
    
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
    
    //Concessionaria
    private String cnpj;
    private String nomeConcessionaria;
    private String site;
    
    public String salvar() {

        try {
             
             Concessionaria concessionaria = new Concessionaria();
             AdmConcessionaria admConcessionaria = new AdmConcessionaria();
        
        admConcessionaria.setNome(this.getNome());
        admConcessionaria.setEmail(this.getEmail());
        admConcessionaria.setLogin(this.getLogin());
        admConcessionaria.setSenha(this.getSenha());
        
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro(this.getLogradouro());
        endereco.setNumero(this.getNumero());
        endereco.setComplemento(this.getComplemento());
        endereco.setBairro(this.getBairro());
        endereco.setCidade(this.getCidade());
        endereco.setEstado(this.getEstado());
        endereco.setCep(this.getCep());
        endereco.setLatitude(0.0f);
        endereco.setLongitude(0.0f);
        
        concessionaria.setIdEndereco(endereco);
        concessionaria.setCnpj(getCnpj());
        concessionaria.setNome(getNomeConcessionaria());
        concessionaria.setSite(getSite());
        
        admConcessionaria.setConcessionaria(concessionaria);
             
        this.getAdmConcessionariaServico().salvar(admConcessionaria);
        
            
        } 
        catch (EJBException ex) {
            ex.printStackTrace();
        }
        
        return "login.xhtml";
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
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

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the nomeConcessionaria
     */
    public String getNomeConcessionaria() {
        return nomeConcessionaria;
    }

    /**
     * @param nomeConcessionaria the nomeConcessionaria to set
     */
    public void setNomeConcessionaria(String nomeConcessionaria) {
        this.nomeConcessionaria = nomeConcessionaria;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the AdmConcessionariaServico
     */
    public AdmConcessionariaServico getAdmConcessionariaServico() {
        return AdmConcessionariaServico;
    }

    /**
     * @param AdmConcessionariaServico the AdmConcessionariaServico to set
     */
    public void setAdmConcessionariaServico(AdmConcessionariaServico AdmConcessionariaServico) {
        this.AdmConcessionariaServico = AdmConcessionariaServico;
    }
    
}
