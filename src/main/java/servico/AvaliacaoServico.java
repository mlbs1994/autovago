/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import modelo.Automovel;
import modelo.Avaliacao;

/**
 *
 * @author Matheus Levi
 */
@Stateless
public class AvaliacaoServico
{
    
    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    public void salvar(Avaliacao avaliacao)
    {
        this.em.persist(avaliacao);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<Avaliacao> getAvaliacoesAutomovel(Automovel automovel) {
        
        Query q = this.em.createQuery("SELECT a FROM Avaliacao a WHERE a.idAutomovel = :idAutomovel");
        
        q.setParameter("idAutomovel", automovel);
        
        List<Avaliacao> avaliacoesAutomovel = q.getResultList();
        
        return avaliacoesAutomovel;
    }

    public Double getAvgAvaliacaoAutomovel(Automovel automovel) {
        
        Query q = this.em.createQuery("SELECT avg(a.nota) FROM Avaliacao a WHERE a.idAutomovel = :idAutomovel");
        
        q.setParameter("idAutomovel", automovel);
        
        Double media = (Double) q.getSingleResult();
        
        if(media==null)
        {
            media=0.0;
        }
        
        return media;
    }
    
    

    public Long getCountAvaliacoesAutomovel(Automovel automovel) {
       
        Query q = this.em.createQuery("SELECT count(a) FROM Avaliacao a WHERE a.idAutomovel = :idAutomovel");
        
        q.setParameter("idAutomovel", automovel);
        

        Long quant = (Long) q.getSingleResult();
        
        return quant;
    }
}
