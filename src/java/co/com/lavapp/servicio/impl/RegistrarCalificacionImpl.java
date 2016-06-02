/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.CalificacionDAO;
import co.com.lavapp.persistencia.dao.impl.CalificacionDAOImpl;
import co.com.lavapp.servicio.RegistrarCalificacion;
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
@Path("/registrarCalificacion")
public class RegistrarCalificacionImpl implements RegistrarCalificacion{

    @GET
    @Produces({"application/json"})
    @Override
    public Calificacion_TO registrarCalificacion(@QueryParam("calificacion") int calificacion,
            @QueryParam("observacion") String observacion, 
            @QueryParam("idPedido") int idPedido) throws Exception {
        Calificacion_TO nuevacalificacion = new Calificacion_TO(calificacion, observacion, new Pedido_TO(idPedido));
        CalificacionDAO calificacionDao = new CalificacionDAOImpl();
        return calificacionDao.registrarCalificacion(nuevacalificacion);
    }    
}
