package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Automovel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-31T10:50:45")
@StaticMetamodel(Fabricante.class)
public class Fabricante_ { 

    public static volatile SingularAttribute<Fabricante, Integer> idFabricante;
    public static volatile ListAttribute<Fabricante, Automovel> automovelList;
    public static volatile SingularAttribute<Fabricante, String> nome;

}