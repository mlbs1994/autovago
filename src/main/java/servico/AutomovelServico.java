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
import modelo.Automovel;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
@Stateless
public class AutomovelServico {

    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<Automovel> getListaAutomoveis()
    {
        List<Automovel> listaAutomoveis = null;
        
        Query q = em.createQuery("SELECT a FROM Automovel a");
        listaAutomoveis = q.getResultList();
        
        return listaAutomoveis;
    }
    
    public Automovel getAutomovel(int idAutomovel)
    {
        return this.em.find(Automovel.class, idAutomovel);
    }
    
    public void salvar(Automovel automovel)
    {
        this.em.persist(automovel);
    }
}

