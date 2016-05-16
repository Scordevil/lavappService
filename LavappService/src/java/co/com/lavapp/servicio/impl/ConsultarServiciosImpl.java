/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.persistencia.dao.ServicioDAO;
import co.com.lavapp.persistencia.dao.impl.ServicioDAOImpl;
import co.com.lavapp.servicio.ConsultarServicios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarServicios")
public class ConsultarServiciosImpl implements ConsultarServicios{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Servicio_TO> consultarServicios() throws Exception {
        List<Servicio_TO> servicios = new ArrayList<>();
        ServicioDAO servicioDao = new ServicioDAOImpl();
        try {
            servicios = servicioDao.consultarServicios();
        } catch (Exception e) {
            throw  e;
        }
        return servicios;
        
    }
    
}
