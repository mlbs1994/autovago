/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modelo.Usuario;

/**
 *
 * @author Matheus Levi
 */
public interface UsuarioDAO
{
    public Usuario logar();
    public void cadastrarUsuario(Usuario usr);
    public void alterarDadosUsuario(Usuario usr);
    public void excluirUsuario(Usuario usr);
    
}
