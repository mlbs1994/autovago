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
import modelo.Automovel;
import modelo.Concessionaria;
import modelo.Oferta;

/**
 *
 * @author Matheus Levi
 */
@Stateless
@TransactionManagement(CONTAINER)
public class OfertaServico 
{

    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<Oferta> getListaOfertas()
    {
        List<Oferta> listaOfertas = null;
        
        Query q = em.createQuery("SELECT o FROM Oferta o ORDER BY o.idAutomovel");
        listaOfertas = q.getResultList();
        
        return listaOfertas;
    }
    
    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<Oferta> getListaOfertasConcessionaria(Concessionaria c)
    {
        List<Oferta> listaOfertas = null;
        
        Query q = em.createQuery("SELECT o FROM Oferta o WHERE o.idConcessionaria = :idConcessionaria");
        q.setParameter("idConcessionaria", c);
        listaOfertas = q.getResultList();
        
        return listaOfertas;
    }

    public void salvar(Oferta oferta)
    {
        this.em.persist(oferta);
    }

    public List<Oferta> getMelhoresOfertas(Automovel automovel) {
        
        Query q = this.em.createQuery("SELECT o FROM Oferta o WHERE o.idAutomovel = :idAutomovel ORDER BY o.preco ASC");
        q.setParameter("idAutomovel", automovel);
        
        List<Oferta> listaMelhoresOfertas = q.getResultList();
        
        return listaMelhoresOfertas;
        
    }

    public List<List<Oferta>> getListaOfertasPorAutomovel(List<Automovel> listaAutomoveis)
    {
        Query q = this.em.createQuery("SELECT o FROM Oferta o ORDER BY o.idAutomovel ASC");
        
        List<Oferta> listaOfertas = q.getResultList();
        
        List<List<Oferta>> listaOfertasPorAutomovel = new ArrayList();
        
        int contOferta=0;
        
        for(int i=0;i<listaAutomoveis.size();i++)
        {
            
           List<Oferta> listaOfertaAutomovel = new ArrayList(); 
           boolean terminou = false;
           
           while(terminou==false)
           {
               
               if(listaOfertas.get(contOferta).getIdAutomovel().getIdAutomovel().
                       equals(listaAutomoveis.get(i).getIdAutomovel()))
                       
               {
                   listaOfertaAutomovel.add(listaOfertas.get(contOferta));
                   contOferta++;
               }
               else
               {
                   terminou=true;
               }
           }
           
           listaOfertasPorAutomovel.add(listaOfertaAutomovel);
        }
        
        return listaOfertasPorAutomovel;
    }

    public Oferta getMelhorOfertaAutomovel(Automovel automovel) {
        
        Query q = em.createQuery("SELECT o FROM Oferta o WHERE o.idAutomovel = :idAutomovel ORDER BY o.preco ASC");
        
        q.setParameter("idAutomovel", automovel);
        
        List<Oferta> ofertas = q.getResultList();
        
        Oferta melhorOferta = ofertas.get(0);
        
        return melhorOferta;
        
    }

    

    
    
}
