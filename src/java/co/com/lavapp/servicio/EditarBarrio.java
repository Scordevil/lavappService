/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Barrio_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface EditarBarrio {
    
    public Barrio_TO modificarBarrio(int idBarrios, String nombre, int idLocalidad, int idZona, int idEstrato) throws Exception;
}
