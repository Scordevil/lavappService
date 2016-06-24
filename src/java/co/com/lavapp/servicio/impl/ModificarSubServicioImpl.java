/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.ModificarSubServicio;
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
@Path("/modificarSubServicio")
public class ModificarSubServicioImpl implements ModificarSubServicio {

    @GET
    @Produces({"application/json"})
    @Override
    public SubServicio_TO modificarSubServicio(@QueryParam("idSubServicio") int idSubServicio,
            @QueryParam("nombre") String nombre,
            @QueryParam("idServicio") int idServicio) throws Exception {

        SubServicio_TO subServiModelo = new SubServicio_TO(idSubServicio, nombre, new Servicio_TO(idServicio));
        SubServicio_TO subServiSalida = new SubServicio_TO();
        SubServicioDAOImpl subserviDAO = new SubServicioDAOImpl();

        try {
            subServiSalida = subserviDAO.modificarSubServicio(subServiModelo);
        } catch (Exception e) {
            throw e;
        }
        return subServiSalida;
    }

}
