/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.CONTAINER;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import modelo.Endereco;

/**
 *
 * @author marcia
 */
@Stateless
@TransactionManagement(CONTAINER)
public class EnderecoServico {

    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    
    public EnderecoServico(){
    }
    
    public void salvar(Endereco endereco) {
        em.persist(endereco);
        
    }
    
    public Endereco getEndereco(Integer id)
    {
        return this.em.find(Endereco.class, id);
    }
}
