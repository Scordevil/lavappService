/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Usuario_TO;

/**
 *
 * @author Planit
 */
public interface RegistrarUsuarios {
    
    public Usuario_TO registrarUsuarios(String nombre, String telefono,int idbarrios,int idrol, int idestado, String login, String contrasena, String apellido, String genero, String movil, String direccion, int idCiudad) throws Exception;
    
}
