/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface SubServicioDAO {
    
    public List<SubServicio_TO> consultarSubServicios(Servicio_TO servicio) throws Exception;
    
}
