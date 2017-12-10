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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "automovel", catalog = "autovago", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automovel.findAll", query = "SELECT a FROM Automovel a"),
    @NamedQuery(name = "Automovel.findByIdAutomovel", query = "SELECT a FROM Automovel a WHERE a.idAutomovel = :idAutomovel"),
    @NamedQuery(name = "Automovel.findByNomeModelo", query = "SELECT a FROM Automovel a WHERE a.nomeModelo = :nomeModelo"),
    @NamedQuery(name = "Automovel.findByAno", query = "SELECT a FROM Automovel a WHERE a.ano = :ano"),
    @NamedQuery(name = "Automovel.findByNumEstrelas", query = "SELECT a FROM Automovel a WHERE a.numEstrelas = :numEstrelas")})
public class Automovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAutomovel")
    private Integer idAutomovel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomeModelo")
    private String nomeModelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numEstrelas")
    private int numEstrelas;
    @Basic(optional = false)
    @Size(min = 1, max = 400)
    @Column(name = "imgSrc")
    private String imgSrc;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante")
    @ManyToOne(optional = false)
    private Fabricante idFabricante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutomovel")
    private List<Oferta> ofertaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutomovel")
    private List<Imagem> imagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutomovel")
    private List<Avaliacao> avaliacaoList;

    public Automovel() {
    }

    public Automovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public Automovel(Integer idAutomovel, String nomeModelo, int ano, int numEstrelas) {
        this.idAutomovel = idAutomovel;
        this.nomeModelo = nomeModelo;
        this.ano = ano;
        this.numEstrelas = numEstrelas;
    }

    public Integer getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

    public int getNumEstrelas() {
        return numEstrelas;
    }

    public void setNumEstrelas(int numEstrelas) {
        this.numEstrelas = numEstrelas;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    @XmlTransient
    public List<Imagem> getImagemList() {
        return imagemList;
    }

    public void setImagemList(List<Imagem> imagemList) {
        this.imagemList = imagemList;
    }

    @XmlTransient
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutomovel != null ? idAutomovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovel)) {
            return false;
        }
        Automovel other = (Automovel) object;
        if ((this.idAutomovel == null && other.idAutomovel != null) || (this.idAutomovel != null && !this.idAutomovel.equals(other.idAutomovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Automovel[ idAutomovel=" + idAutomovel + " ]";
    }
    
}
