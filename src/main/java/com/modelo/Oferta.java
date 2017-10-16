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
@Table(name = "oferta", catalog = "autovago", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "Oferta.findByDescricao", query = "SELECT o FROM Oferta o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Oferta.findByCor", query = "SELECT o FROM Oferta o WHERE o.cor = :cor"),
    @NamedQuery(name = "Oferta.findByPreco", query = "SELECT o FROM Oferta o WHERE o.preco = :preco"),
    @NamedQuery(name = "Oferta.findByEhZeroKm", query = "SELECT o FROM Oferta o WHERE o.ehZeroKm = :ehZeroKm"),
    @NamedQuery(name = "Oferta.findByEhAutomatico", query = "SELECT o FROM Oferta o WHERE o.ehAutomatico = :ehAutomatico"),
    @NamedQuery(name = "Oferta.findByEh4Portas", query = "SELECT o FROM Oferta o WHERE o.eh4Portas = :eh4Portas"),
    @NamedQuery(name = "Oferta.findByEhDirecaoHidraulica", query = "SELECT o FROM Oferta o WHERE o.ehDirecaoHidraulica = :ehDirecaoHidraulica"),
    @NamedQuery(name = "Oferta.findByTemComputadorBordo", query = "SELECT o FROM Oferta o WHERE o.temComputadorBordo = :temComputadorBordo"),
    @NamedQuery(name = "Oferta.findByTemSistemaAntiRoubo", query = "SELECT o FROM Oferta o WHERE o.temSistemaAntiRoubo = :temSistemaAntiRoubo")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOferta")
    private Integer idOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private float preco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ehZeroKm")
    private boolean ehZeroKm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ehAutomatico")
    private boolean ehAutomatico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eh4Portas")
    private boolean eh4Portas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ehDirecaoHidraulica")
    private boolean ehDirecaoHidraulica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temComputadorBordo")
    private boolean temComputadorBordo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temSistemaAntiRoubo")
    private boolean temSistemaAntiRoubo;
    @JoinColumn(name = "idAutomovel", referencedColumnName = "idAutomovel")
    @ManyToOne(optional = false)
    private Automovel idAutomovel;
    @JoinColumn(name = "idConcessionaria", referencedColumnName = "idConcessionaria")
    @ManyToOne(optional = false)
    private Concessionaria idConcessionaria;

    public Oferta() {
    }

    public Oferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(Integer idOferta, String descricao, String cor, float preco, boolean ehZeroKm, boolean ehAutomatico, boolean eh4Portas, boolean ehDirecaoHidraulica, boolean temComputadorBordo, boolean temSistemaAntiRoubo) {
        this.idOferta = idOferta;
        this.descricao = descricao;
        this.cor = cor;
        this.preco = preco;
        this.ehZeroKm = ehZeroKm;
        this.ehAutomatico = ehAutomatico;
        this.eh4Portas = eh4Portas;
        this.ehDirecaoHidraulica = ehDirecaoHidraulica;
        this.temComputadorBordo = temComputadorBordo;
        this.temSistemaAntiRoubo = temSistemaAntiRoubo;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean getEhZeroKm() {
        return ehZeroKm;
    }

    public void setEhZeroKm(boolean ehZeroKm) {
        this.ehZeroKm = ehZeroKm;
    }

    public boolean getEhAutomatico() {
        return ehAutomatico;
    }

    public void setEhAutomatico(boolean ehAutomatico) {
        this.ehAutomatico = ehAutomatico;
    }

    public boolean getEh4Portas() {
        return eh4Portas;
    }

    public void setEh4Portas(boolean eh4Portas) {
        this.eh4Portas = eh4Portas;
    }

    public boolean getEhDirecaoHidraulica() {
        return ehDirecaoHidraulica;
    }

    public void setEhDirecaoHidraulica(boolean ehDirecaoHidraulica) {
        this.ehDirecaoHidraulica = ehDirecaoHidraulica;
    }

    public boolean getTemComputadorBordo() {
        return temComputadorBordo;
    }

    public void setTemComputadorBordo(boolean temComputadorBordo) {
        this.temComputadorBordo = temComputadorBordo;
    }

    public boolean getTemSistemaAntiRoubo() {
        return temSistemaAntiRoubo;
    }

    public void setTemSistemaAntiRoubo(boolean temSistemaAntiRoubo) {
        this.temSistemaAntiRoubo = temSistemaAntiRoubo;
    }

    public Automovel getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Automovel idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public Concessionaria getIdConcessionaria() {
        return idConcessionaria;
    }

    public void setIdConcessionaria(Concessionaria idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
