/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "concessionaria", catalog = "autovago", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concessionaria.findAll", query = "SELECT c FROM Concessionaria c")
    ,
    @NamedQuery(name = "Concessionaria.findByIdConcessionaria", query = "SELECT c FROM Concessionaria c WHERE c.idConcessionaria = :idConcessionaria")
    ,
    @NamedQuery(name = "Concessionaria.findByNome", query = "SELECT c FROM Concessionaria c WHERE c.nome = :nome")
    ,
    @NamedQuery(name = "Concessionaria.findBySite", query = "SELECT c FROM Concessionaria c WHERE c.site = :site")
    ,
    @NamedQuery(name = "Concessionaria.findByCnpj", query = "SELECT c FROM Concessionaria c WHERE c.cnpj = :cnpj")})
public class Concessionaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConcessionaria")
    private Integer idConcessionaria;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "site")
    private String site;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    
    
    
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    private Endereco idEndereco;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcessionaria")
    private List<Oferta> ofertaList;

    public Concessionaria() {
    }

    public Concessionaria(Integer idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    public Concessionaria(Integer idConcessionaria, String nome, String site, String cnpj) {
        this.idConcessionaria = idConcessionaria;
        this.nome = nome;
        this.site = site;
        this.cnpj = cnpj;
    }

    public Integer getIdConcessionaria() {
        return idConcessionaria;
    }

    public void setIdConcessionaria(Integer idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcessionaria != null ? idConcessionaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concessionaria)) {
            return false;
        }
        Concessionaria other = (Concessionaria) object;
        if ((this.idConcessionaria == null && other.idConcessionaria != null) || (this.idConcessionaria != null && !this.idConcessionaria.equals(other.idConcessionaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Concessionaria[ idConcessionaria=" + idConcessionaria + " ]";
    }

}
