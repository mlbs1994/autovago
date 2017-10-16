/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "imagem", catalog = "autovago", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagem.findAll", query = "SELECT i FROM Imagem i"),
    @NamedQuery(name = "Imagem.findByIdImagem", query = "SELECT i FROM Imagem i WHERE i.idImagem = :idImagem"),
    @NamedQuery(name = "Imagem.findByUrl", query = "SELECT i FROM Imagem i WHERE i.url = :url")})
public class Imagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImagem")
    private Integer idImagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "idAutomovel", referencedColumnName = "idAutomovel")
    @ManyToOne(optional = false)
    private Automovel idAutomovel;

    public Imagem() {
    }

    public Imagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public Imagem(Integer idImagem, String url) {
        this.idImagem = idImagem;
        this.url = url;
    }

    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Automovel getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Automovel idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagem != null ? idImagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagem)) {
            return false;
        }
        Imagem other = (Imagem) object;
        if ((this.idImagem == null && other.idImagem != null) || (this.idImagem != null && !this.idImagem.equals(other.idImagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Imagem[ idImagem=" + idImagem + " ]";
    }
    
}
