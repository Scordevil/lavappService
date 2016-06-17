/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.persistencia.dao.impl.ServicioDAOImpl;
import co.com.lavapp.servicio.RegistrarServicios;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/registrarServicio")
public class RegistrarServiciosImpl implements RegistrarServicios {

    @GET
    @Produces({"application/json"})
    public Servicio_TO registrarServicio(@QueryParam("nombre") String nombre) throws Exception {

        Servicio_TO servicio = new Servicio_TO(nombre);
        ServicioDAOImpl servicioDAO = new ServicioDAOImpl();
        return servicioDAO.registrarServicio(servicio);
    }

}
