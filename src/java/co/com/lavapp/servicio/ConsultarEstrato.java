/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Estrato_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarEstrato {
    
    public Estrato_TO consultarEstrato(int idEstrato) throws Exception;
}
