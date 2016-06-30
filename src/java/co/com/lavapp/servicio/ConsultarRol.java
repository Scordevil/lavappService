/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Rol_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarRol {
    
   public Rol_TO consultarRol(int idRol, String nombre) throws Exception;
    
}
