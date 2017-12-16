/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus Levi
 */
@Entity
@DiscriminatorValue(value = "A")
@PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
@Table(name = "adm_concessionaria", catalog = "autovago", schema = "")
@XmlRootElement
public class AdmConcessionaria extends Usuario implements Serializable {
    
    @JoinColumn(name = "idConcessionaria", referencedColumnName = "idConcessionaria")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Concessionaria Concessionaria;

    public AdmConcessionaria() {
    }

   
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
       
        if (o != null)
        {
            if (o instanceof AdmConcessionaria)
            {
                AdmConcessionaria outra = (AdmConcessionaria) o;
                if (this.idUsuario == outra.idUsuario)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return the Concessionaria
     */
    public Concessionaria getConcessionaria() {
        return Concessionaria;
    }

    /**
     * @param Concessionaria the Concessionaria to set
     */
    public void setConcessionaria(Concessionaria Concessionaria) {
        this.Concessionaria = Concessionaria;
    }

   
}