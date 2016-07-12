/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.persistencia.dao.impl.EstadoDAOImpl;
import co.com.lavapp.servicio.ConsultarEstado;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author SISTEMAS
 */
@Path("/consultarEstadoID")
@Stateless
public class ConsultarEstadoImpl implements ConsultarEstado {

    @Override
    @GET
    @Produces({"application/json"})
    public Estado_TO consultarEstado(@QueryParam("idEstado") int idEstado,
            @QueryParam("nombre") String nombre) throws Exception {

        EstadoDAOImpl estadoDAO = new EstadoDAOImpl();
        Estado_TO estadoModelo = new Estado_TO(idEstado, nombre);

        return estadoDAO.consultarEstado(estadoModelo);

    }

}
