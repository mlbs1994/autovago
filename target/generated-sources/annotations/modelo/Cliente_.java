package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Avaliacao;
import modelo.Endereco;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T12:33:53")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Usuario_ {

    public static volatile SingularAttribute<Cliente, Endereco> idEndereco;
    public static volatile ListAttribute<Cliente, Avaliacao> avaliacaoList;

}