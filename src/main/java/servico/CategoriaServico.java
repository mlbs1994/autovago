/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.CONTAINER;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import modelo.Categoria;

/**
 *
 * @author Matheus Levi
 */
@Stateless
@TransactionManagement(CONTAINER)
public class CategoriaServico 
{

    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<Categoria> getListaCategorias()
    {
        List<Categoria> listaCategorias = null;
        
        Query q = em.createQuery("SELECT c FROM Categoria c");
        listaCategorias = q.getResultList();
        
        return listaCategorias;
    }

    public void salvar(Categoria categoria)
    {
        this.em.persist(categoria);
    }

    public Categoria getCategoria(int idCategoria) {
        return this.em.find(Categoria.class, idCategoria);
    }
 
}
