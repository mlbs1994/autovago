package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Endereco;
import modelo.Oferta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T12:33:53")
@StaticMetamodel(Concessionaria.class)
public class Concessionaria_ { 

    public static volatile SingularAttribute<Concessionaria, String> site;
    public static volatile SingularAttribute<Concessionaria, Integer> idConcessionaria;
    public static volatile SingularAttribute<Concessionaria, Endereco> idEndereco;
    public static volatile ListAttribute<Concessionaria, Oferta> ofertaList;
    public static volatile SingularAttribute<Concessionaria, String> nome;
    public static volatile SingularAttribute<Concessionaria, String> cnpj;

}