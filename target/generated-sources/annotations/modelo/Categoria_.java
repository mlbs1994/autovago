package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Automovel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T22:34:06")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, Automovel> automovelList;
    public static volatile SingularAttribute<Categoria, String> nome;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;

}