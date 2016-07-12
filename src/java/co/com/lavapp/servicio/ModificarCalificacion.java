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
public interface ModificarCalificacion {
    public Calificacion_TO modificarCalificacion(int idCalificacion, int calificacion, String oobservacion, int idPedido) throws Exception;
}
