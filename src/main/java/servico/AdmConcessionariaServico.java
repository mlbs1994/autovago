
package servico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import modelo.AdmConcessionaria;
import modelo.Concessionaria;
import modelo.Usuario;

/**
 *
 * @author marcia
 */
@Stateless
public class AdmConcessionariaServico {
@PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    public AdmConcessionariaServico() {
    }

    public void salvar(AdmConcessionaria admConcessionaria) {
        em.persist(admConcessionaria);
    }
    
    public Concessionaria getConcessionariaUsuario(Integer idUsuario)
    {
        Concessionaria c = null;
        
        System.out.println("Usr = "+idUsuario);
        
        Query q = this.em.createQuery("SELECT a.Concessionaria FROM AdmConcessionaria a WHERE a.idUsuario = :idUsuario");
        
        q.setParameter("idUsuario", idUsuario);
        c = (Concessionaria) q.getSingleResult();
        
        return c;
        
    }

    public AdmConcessionaria getAdmConcessionariaPorUsuario(Usuario usuario)
    {
       Query q = this.em.createQuery("SELECT a FROM AdmConcessionaria a WHERE a.idUsuario = :idUsuario");
        
       q.setParameter("idUsuario", usuario.getIdUsuario());
        
       AdmConcessionaria a = (AdmConcessionaria) q.getSingleResult();
        
       return a;
    }
}
