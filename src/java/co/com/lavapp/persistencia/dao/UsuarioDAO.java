/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Sesion_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Usuario
 *
 * @author Planit
 */
public interface UsuarioDAO {

    public Usuario_TO registrarUsuarios(Usuario_TO usuario) throws Exception;
    
     public Usuario_TO consultarUsuario(Usuario_TO usuario) throws Exception;

  //  public Usuario_TO consultarUsuarioPorLogin(Usuario_TO usuario) throws Exception;

    public Sesion_TO consultarUsuarioSesion(Sesion_TO sesion) throws Exception;

    public Sesion_TO registrarUsuarioSesion(Sesion_TO sesion) throws Exception;

}
