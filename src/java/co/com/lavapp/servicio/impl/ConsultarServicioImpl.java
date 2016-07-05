/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.persistencia.dao.ServicioDAO;
import co.com.lavapp.persistencia.dao.impl.ServicioDAOImpl;
import co.com.lavapp.servicio.ConsultarServicio;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarServicio")
public class ConsultarServicioImpl implements ConsultarServicio{

    @GET
    @Produces({"application/json"})
    @Override
    public Servicio_TO consultarServicio(@QueryParam("idServicio") int idServicio, @QueryParam("nombre") String nombre) throws Exception {
        Servicio_TO servicio = new Servicio_TO(idServicio, nombre);
        ServicioDAO servicioDao = new ServicioDAOImpl();
        return servicioDao.consultarServicio(servicio);
    }
    
}
