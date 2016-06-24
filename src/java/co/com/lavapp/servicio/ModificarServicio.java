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
public interface ModificarServicio {
    public Servicio_TO modificarServicio(int idServicio, String nombre) throws Exception;
}
