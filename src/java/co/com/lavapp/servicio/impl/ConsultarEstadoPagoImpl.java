/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.EstadoPago_TO;
import co.com.lavapp.persistencia.dao.EstadoPagoDAO;
import co.com.lavapp.persistencia.dao.impl.EstadoPagoDAOImpl;
import co.com.lavapp.servicio.ConsultarEstadoPago;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarEstadoPago")
public class ConsultarEstadoPagoImpl implements ConsultarEstadoPago{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public EstadoPago_TO consultarEstadoPago(@QueryParam("idEstadoPago") int idEstadoPago, @QueryParam("nombre") String nombre) throws Exception {
        EstadoPago_TO estadoPago = new EstadoPago_TO(idEstadoPago, nombre);
        EstadoPagoDAO estadoPagoDAO = new EstadoPagoDAOImpl();
        return estadoPagoDAO.consultarEstadoPago(estadoPago);
    }    
}
