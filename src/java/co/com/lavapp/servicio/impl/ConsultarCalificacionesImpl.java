/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.persistencia.dao.impl.CalificacionDAOImpl;
import co.com.lavapp.servicio.ConsultarCalificaciones;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/consultarCalificaciones")
public class ConsultarCalificacionesImpl implements ConsultarCalificaciones{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Calificacion_TO> consultarCalificaciones() throws Exception {
        
        List<Calificacion_TO> caliModelo = new ArrayList<>();
        CalificacionDAOImpl caliDAO = new CalificacionDAOImpl();
        
        
        return caliModelo = caliDAO.consultarCalificacion();
    }
    
}
