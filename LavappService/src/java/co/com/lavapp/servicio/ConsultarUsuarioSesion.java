/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Sesion_TO;

/**
 *
 * @author Planit
 */
public interface ConsultarUsuarioSesion {
    
    public Sesion_TO consultarUsuarioSesion(int idUsuario) throws Exception;
    
}
