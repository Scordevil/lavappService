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
    
    public SubServicio_TO consultarSubServicio(SubServicio_TO subservicio) throws Exception;
    public List<SubServicio_TO> consultarSubServicios(Servicio_TO servicio) throws Exception;
    public List<SubServicio_TO> consultarSubServicios() throws Exception;
    public SubServicio_TO registrarSubServicio(SubServicio_TO subServi) throws Exception;
    public SubServicio_TO modificarSubServicio(SubServicio_TO subServi) throws Exception;
    public SubServicio_TO eliminarSubServicio(SubServicio_TO subServi) throws Exception;
    
}
