/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;


import static modelo.Papel.ADMINISTRADOR;
import static modelo.Papel.USUARIO;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.CONTAINER;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import modelo.Grupo;

/**
 *
 * @author marcia
 */
@Stateless
@LocalBean
@TransactionManagement(CONTAINER)
@DeclareRoles({ADMINISTRADOR, USUARIO})
public class GrupoServico {
    
    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    public GrupoServico() {
    }

    
    @TransactionAttribute(SUPPORTS)       
    @PermitAll    
    public Grupo getGrupo(String nomeGrupo) {
        
        Query q = this.em.createQuery("select b from Grupo b where b.nome = ?1", Grupo.class);
        
        q.setParameter(1, nomeGrupo);
        
        Grupo g = (Grupo) q.getSingleResult();
        
        return g;
        
    }
    
}
