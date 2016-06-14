/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Pais_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarPais {
    public Pais_TO consultarPais(int idPais) throws Exception;
}
