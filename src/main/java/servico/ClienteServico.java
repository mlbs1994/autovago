/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.CONTAINER;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import modelo.Cliente;
import static modelo.Grupo.USUARIO;
import modelo.Usuario;

/**
 *
 * @author marcia
 */
@Stateless
@TransactionManagement(CONTAINER)
public class ClienteServico {

    @EJB
    private GrupoServico grupoServico;
    
    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    public ClienteServico() {
    }

    public void salvar(Cliente cliente) {
        
        cliente.adicionarGrupo(grupoServico.getGrupo(USUARIO));
        em.persist(cliente);
    }
    
    public Cliente getClientePorUsuario(Usuario idUsuario)
    {
        Query q = this.em.createQuery("SELECT c FROM Cliente c WHERE c.idUsuario = :idUsuario");
        
        q.setParameter("idUsuario", idUsuario.getIdUsuario());
        
        Cliente c = (Cliente) q.getSingleResult();
        
        return c;
    }
}
