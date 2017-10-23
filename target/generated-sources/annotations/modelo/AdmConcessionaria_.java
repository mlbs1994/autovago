package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Concessionaria;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T17:10:18")
@StaticMetamodel(AdmConcessionaria.class)
public class AdmConcessionaria_ { 

    public static volatile SingularAttribute<AdmConcessionaria, Integer> idAdmConcessionaria;
    public static volatile SingularAttribute<AdmConcessionaria, Usuario> idUsuario;
    public static volatile ListAttribute<AdmConcessionaria, Concessionaria> concessionariaList;

}