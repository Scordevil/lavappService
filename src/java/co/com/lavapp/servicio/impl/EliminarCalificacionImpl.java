/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.persistencia.dao.impl.CalificacionDAOImpl;
import co.com.lavapp.servicio.EliminarCalificacion;
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
@Path("/eliminarCalificacion")
public class EliminarCalificacionImpl implements EliminarCalificacion{

    @Override
    @GET
    @Produces({"application/json"})
    public Calificacion_TO eliminarCalificacion(@QueryParam("idCalificacion")int idCalificacion) throws Exception {
        Calificacion_TO caliModel = new Calificacion_TO(idCalificacion);
        CalificacionDAOImpl caliDAO = new CalificacionDAOImpl();
        return caliDAO.eliminarCalificacion(caliModel);
    }
    
}
