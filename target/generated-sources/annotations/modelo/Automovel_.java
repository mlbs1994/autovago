package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Avaliacao;
import modelo.Categoria;
import modelo.Fabricante;
import modelo.Imagem;
import modelo.Oferta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T19:05:34")
@StaticMetamodel(Automovel.class)
public class Automovel_ { 

    public static volatile SingularAttribute<Automovel, Fabricante> idFabricante;
    public static volatile SingularAttribute<Automovel, Integer> ano;
    public static volatile ListAttribute<Automovel, Imagem> imagemList;
    public static volatile SingularAttribute<Automovel, Integer> numEstrelas;
    public static volatile SingularAttribute<Automovel, Integer> idAutomovel;
    public static volatile ListAttribute<Automovel, Oferta> ofertaList;
    public static volatile ListAttribute<Automovel, Avaliacao> avaliacaoList;
    public static volatile SingularAttribute<Automovel, Categoria> idCategoria;
    public static volatile SingularAttribute<Automovel, String> imgSrc;
    public static volatile SingularAttribute<Automovel, String> nomeModelo;
    public static volatile SingularAttribute<Automovel, String> descricao;

}