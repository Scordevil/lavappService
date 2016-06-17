/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Servicio_TO;

/**
 *
 * @author SISTEMAS
 */
public interface RegistrarServicios {
    
    public Servicio_TO registrarServicio(String nombre) throws Exception;
    
}
