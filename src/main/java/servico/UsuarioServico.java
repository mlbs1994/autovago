/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.CONTAINER;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author marcia
 */
@Stateless
@TransactionManagement(CONTAINER)
public class UsuarioServico {

    @PersistenceContext(unitName = "autovago", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;

    public UsuarioServico() {
    }

    public void salvar(Usuario usuario) {
        em.persist(usuario);
    }

    public Usuario buscarPessoa(String login, String senha) {
        Usuario usuario = null;
        Query q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        List<Usuario> usr = q.getResultList();

        if (!(usr.isEmpty())) {
            usuario = usr.get(0);
        }

        if (usuario == null) {
            System.out.print("FALSE");

        } else {
            System.out.print("TRUE");
        }

        return usuario;
    }
    
    public void alterarDadosUsuario(Usuario usr)
    {
        this.em.merge(usr);
    }
    
    public void excluirConta(Usuario usr)
    {
        this.em.remove(usr);
    }
}
