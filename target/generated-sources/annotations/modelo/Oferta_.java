package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Automovel;
import modelo.Concessionaria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T22:34:06")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, Float> preco;
    public static volatile SingularAttribute<Oferta, Boolean> ehAutomatico;
    public static volatile SingularAttribute<Oferta, Boolean> temComputadorBordo;
    public static volatile SingularAttribute<Oferta, Concessionaria> idConcessionaria;
    public static volatile SingularAttribute<Oferta, String> cor;
    public static volatile SingularAttribute<Oferta, Boolean> eh4Portas;
    public static volatile SingularAttribute<Oferta, Automovel> idAutomovel;
    public static volatile SingularAttribute<Oferta, Integer> idOferta;
    public static volatile SingularAttribute<Oferta, Boolean> ehZeroKm;
    public static volatile SingularAttribute<Oferta, Boolean> ehDirecaoHidraulica;
    public static volatile SingularAttribute<Oferta, Boolean> temSistemaAntiRoubo;
    public static volatile SingularAttribute<Oferta, String> descricao;

}