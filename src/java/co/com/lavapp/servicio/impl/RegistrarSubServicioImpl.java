/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.RegistrarSubServicio;
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
@Path("/registrarSubServicio")
public class RegistrarSubServicioImpl implements RegistrarSubServicio {

    @GET
    @Produces({"application/json"})
    @Override
    public SubServicio_TO registrarSubServicio(@QueryParam("nombre") String nombre,
            @QueryParam("idServicio") int idServicio) throws Exception {

        Servicio_TO paramServicio = new Servicio_TO(idServicio);
        SubServicio_TO subServiModel = new SubServicio_TO(nombre, paramServicio);

        SubServicioDAOImpl subserviDAO = new SubServicioDAOImpl();

        return subserviDAO.registrarSubServicio(subServiModel);
    }

}
