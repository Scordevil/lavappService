/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.impl.CalificacionDAOImpl;
import co.com.lavapp.servicio.ModificarCalificacion;
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
@Path("/modificarCalificacion")
public class ModificarCalificacionImpl implements ModificarCalificacion{

    @Override
    @GET
    @Produces({"application/json"})
    public Calificacion_TO modificarCalificacion(@QueryParam("idCalificacion")int idCalificacion, 
            @QueryParam("calificacion")int calificacion, 
            @QueryParam("oobservacion") String oobservacion, 
            @QueryParam("idPedido") int idPedido) throws Exception {
      
        Calificacion_TO caliModelo = new Calificacion_TO(idCalificacion, calificacion, oobservacion, new Pedido_TO(idPedido));
        CalificacionDAOImpl caliDAO = new CalificacionDAOImpl();
        
        return caliDAO.modificarCalificacion(caliModelo);
    }
    
}
