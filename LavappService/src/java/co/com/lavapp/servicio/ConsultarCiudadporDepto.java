/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ConsultarCiudadporDepto {
    
    public List<Ciudad_TO> consultarTodasCiudadesDt(int idDepto)throws Exception;
    
}
