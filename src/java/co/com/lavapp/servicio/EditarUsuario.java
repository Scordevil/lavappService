/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Usuario_TO;

/**
 *
 * @author Sistemas
 */
public interface EditarUsuario {
    
        public Usuario_TO editarUsuario (int idUsuario, String nombre, String apellido, String telefono, int idbarrios, String contrasena,
             String movil, String direccion, int idciudad) throws Exception;
    
}
