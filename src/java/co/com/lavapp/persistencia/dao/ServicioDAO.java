/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Servicio_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ServicioDAO {
    
    public List<Servicio_TO> consultarServicios() throws  Exception;
    public Servicio_TO consultarServicio(Servicio_TO servicio) throws Exception;
    public Servicio_TO registrarServicio(Servicio_TO serv) throws Exception;
    public Servicio_TO modificarServicio(Servicio_TO serv)throws Exception;
    public Servicio_TO eliminarServicio(Servicio_TO serv)throws Exception;
}
