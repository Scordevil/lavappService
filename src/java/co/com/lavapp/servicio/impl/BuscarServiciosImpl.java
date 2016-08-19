/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.persistencia.dao.ServicioDAO;
import co.com.lavapp.persistencia.dao.impl.ServicioDAOImpl;
import co.com.lavapp.servicio.BuscarServicios;
import java.util.List;
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
@Path("/buscarServicios")
public class BuscarServiciosImpl implements BuscarServicios{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Servicio_TO> buscarServicios(@QueryParam("valor") String valor) throws Exception {
        ServicioDAO servicioDao = new  ServicioDAOImpl();
        return servicioDao.buscarServicios(valor);
    }
    
}
