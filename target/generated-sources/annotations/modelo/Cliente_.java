package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Avaliacao;
import modelo.Endereco;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-31T10:50:45")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Endereco> idEndereco;
    public static volatile SingularAttribute<Cliente, Usuario> idUsuario;
    public static volatile ListAttribute<Cliente, Avaliacao> avaliacaoList;

}