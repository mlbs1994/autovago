/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
@Stateless
public class FabricanteServico
{
    
    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<Fabricante> getListaFabricantes()
    {
        List<Fabricante> listaFabricantes = null;
        
        Query q = em.createQuery("SELECT f FROM Fabricante f");
        listaFabricantes = q.getResultList();
        
        return listaFabricantes;
    }
    
}
