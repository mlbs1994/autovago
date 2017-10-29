
package servico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import modelo.AdmConcessionaria;

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
}
