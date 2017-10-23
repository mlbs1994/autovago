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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "adm_concessionaria", catalog = "autovago", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmConcessionaria.findAll", query = "SELECT a FROM AdmConcessionaria a"),
    @NamedQuery(name = "AdmConcessionaria.findByIdAdmConcessionaria", query = "SELECT a FROM AdmConcessionaria a WHERE a.idAdmConcessionaria = :idAdmConcessionaria")})
public class AdmConcessionaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAdmConcessionaria")
    private Integer idAdmConcessionaria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdmConcessionaria")
    private List<Concessionaria> concessionariaList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public AdmConcessionaria() {
    }

    public AdmConcessionaria(Integer idAdmConcessionaria) {
        this.idAdmConcessionaria = idAdmConcessionaria;
    }

    public Integer getIdAdmConcessionaria() {
        return idAdmConcessionaria;
    }

    public void setIdAdmConcessionaria(Integer idAdmConcessionaria) {
        this.idAdmConcessionaria = idAdmConcessionaria;
    }

    @XmlTransient
    public List<Concessionaria> getConcessionariaList() {
        return concessionariaList;
    }

    public void setConcessionariaList(List<Concessionaria> concessionariaList) {
        this.concessionariaList = concessionariaList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmConcessionaria != null ? idAdmConcessionaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmConcessionaria)) {
            return false;
        }
        AdmConcessionaria other = (AdmConcessionaria) object;
        if ((this.idAdmConcessionaria == null && other.idAdmConcessionaria != null) || (this.idAdmConcessionaria != null && !this.idAdmConcessionaria.equals(other.idAdmConcessionaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AdmConcessionaria[ idAdmConcessionaria=" + idAdmConcessionaria + " ]";
    }
    
}
