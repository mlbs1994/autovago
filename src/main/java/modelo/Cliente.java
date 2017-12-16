/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "cliente", catalog = "autovago", schema = "")
@XmlRootElement
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacaoList;
    
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Endereco idEndereco;

    public Cliente() {
    }

    


    @Override
    public int hashCode() {
        
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null)
        {
            if (o instanceof Cliente)
            {
                Cliente outra = (Cliente) o;
                if (this.idUsuario == outra.idUsuario)
                {
                    return true;
                }
            }
        }
        return false;
    }

    

    /**
     * @return the idEndereco
     */
    public Endereco getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the avaliacaoList
     */
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    /**
     * @param avaliacaoList the avaliacaoList to set
     */
    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }
    
}
