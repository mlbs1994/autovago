package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Automovel;
import modelo.Cliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-29T17:22:25")
@StaticMetamodel(Avaliacao.class)
public class Avaliacao_ { 

    public static volatile SingularAttribute<Avaliacao, Cliente> idCliente;
    public static volatile SingularAttribute<Avaliacao, Automovel> idAutomovel;
    public static volatile SingularAttribute<Avaliacao, Integer> idAvaliacao;
    public static volatile SingularAttribute<Avaliacao, String> comentario;
    public static volatile SingularAttribute<Avaliacao, Integer> nota;

}