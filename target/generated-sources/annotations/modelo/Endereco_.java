package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Concessionaria;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T20:51:59")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, String> cidade;
    public static volatile SingularAttribute<Endereco, String> estado;
    public static volatile SingularAttribute<Endereco, String> complemento;
    public static volatile SingularAttribute<Endereco, Integer> numero;
    public static volatile SingularAttribute<Endereco, Integer> idEndereco;
    public static volatile SingularAttribute<Endereco, String> bairro;
    public static volatile SingularAttribute<Endereco, String> logradouro;
    public static volatile SingularAttribute<Endereco, Concessionaria> idConcessionaria;
    public static volatile SingularAttribute<Endereco, Float> latitude;
    public static volatile SingularAttribute<Endereco, Usuario> idUsuario;
    public static volatile SingularAttribute<Endereco, String> cep;
    public static volatile SingularAttribute<Endereco, Float> longitude;

}