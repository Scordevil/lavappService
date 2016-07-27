/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Estado_TO;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public interface ConsultarEstadosProducto {
    
    public List<Estado_TO> consultarEstadoProducto() throws Exception;
    
}
