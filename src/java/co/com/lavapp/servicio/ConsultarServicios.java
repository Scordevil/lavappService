/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Servicio_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarServicios {
    
    public List<Servicio_TO> consultarServicios() throws Exception;
}
