/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.EstadoPago_TO;

/**
 *
 * @author VaioDevelopment
 */
public interface ConsultarEstadoPago {
    
    public EstadoPago_TO consultarEstadoPago(int idEstadoPago, String nombre) throws Exception;
    
}
