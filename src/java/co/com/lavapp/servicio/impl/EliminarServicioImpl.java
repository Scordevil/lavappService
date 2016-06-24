/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.persistencia.dao.impl.ServicioDAOImpl;
import co.com.lavapp.servicio.EliminarServicio;
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
@Path("/eliminarServicio")
public class EliminarServicioImpl implements EliminarServicio{

    @GET
    @Produces({"application/json"})
    @Override
    public Servicio_TO eliminarServicio(@QueryParam("idServicio")int idServicio) throws Exception {
        Servicio_TO serviModelo = new Servicio_TO(idServicio);
        Servicio_TO serviSalida = new Servicio_TO();
        ServicioDAOImpl servicioDAO = new ServicioDAOImpl();
        try {
            serviSalida = servicioDAO.eliminarServicio(serviModelo);
        } catch (Exception e) {
            throw e;
        }
        return serviSalida;
    }
    
}
