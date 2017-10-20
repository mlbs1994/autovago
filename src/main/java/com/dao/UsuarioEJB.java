/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modelo.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matheus Levi
 */
@Stateless
public class UsuarioEJB implements UsuarioDAO{

    @PersistenceContext
    EntityManager manager;
    
    @PostConstruct
    public void aposCriacao()
    {
        System.out.println("UsuarioEJB criado");
    }

    @Override
    public Usuario logar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrarUsuario(Usuario usr) 
    {
        System.out.println("Cadastrando o usuário.....");
        this.manager.persist(usr);
        System.out.println("Usuário Cadastrado");
    }

    @Override
    public void alterarDadosUsuario(Usuario usr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirUsuario(Usuario usr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
