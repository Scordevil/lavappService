/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.persistencia.dao.EstadoDAO;
import co.com.lavapp.persistencia.dao.impl.EstadoDAOImpl;
import co.com.lavapp.servicio.ConsultarEstadosPlanta;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarEstadosPlanta")
public class ConsultarEstadosPlantaImpl implements ConsultarEstadosPlanta {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Estado_TO> consultarEstadosPlanta() throws Exception {
        EstadoDAO estadoDAO = new EstadoDAOImpl();
        return estadoDAO.consultarEstadosPlanta();
    }
}
