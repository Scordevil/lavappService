/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import java.util.List;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Usuario
 *
 * @author Planit
 */
public interface UsuarioDAO {

    public Usuario_TO consultarUsuario(Usuario_TO usuario) throws Exception;

    public Usuario_TO registrarUsuarios(Usuario_TO usuario) throws Exception;

    public Usuario_TO editarUsuario(Usuario_TO usuario) throws Exception;
    
    public Usuario_TO editarCorreoSesion(Usuario_TO usuario) throws Exception;

    public Usuario_TO editarContrasenaSesion(Usuario_TO usuario) throws Exception;
    
    public Usuario_TO eliminarUsuario(Usuario_TO usuario) throws Exception;
    
    public Usuario_TO consultarUsuarioPorLogin(Usuario_TO usuario) throws Exception;
    
    public Usuario_TO consultarUsuarioPorIdentificacion(Usuario_TO usuario) throws Exception;   
    
    public List<Usuario_TO> consultarUsuariosPorRol(Rol_TO rol) throws Exception;
    
    public List<Usuario_TO> BuscarAsesores(String valor) throws Exception;
    
    public List<Usuario_TO> BuscarClientes(String valor) throws Exception;
    
    public List<Usuario_TO> BuscarAdministradores(String valor) throws Exception;   
    
    public Usuario_TO AsociarAsesorZona(Usuario_TO usuario, Zona_TO zona) throws Exception;
    
    public Usuario_TO ConsultarAsesorZona(Zona_TO zona) throws Exception;

}
