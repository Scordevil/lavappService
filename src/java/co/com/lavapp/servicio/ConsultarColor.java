/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Color_TO;

/**
 *
 * @author VaioDevelopment
 */
public interface ConsultarColor {
    
    public Color_TO consultarColor(int idColor) throws Exception;
    
}