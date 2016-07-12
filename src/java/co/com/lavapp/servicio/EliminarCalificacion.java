/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Calificacion_TO;

/**
 *
 * @author SISTEMAS
 */
public interface EliminarCalificacion {
    
    public Calificacion_TO eliminarCalificacion(int idCalificacion) throws Exception;
    
}
