/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.persistencia.dao.CalificacionDAO;
import co.com.lavapp.persistencia.dao.impl.CalificacionDAOImpl;
import co.com.lavapp.servicio.ConsultarCalificacionesSegunPlantaPedidos;
import java.util.List;
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
@Path("/consultarCalificacionesSegunPlanta")
public class ConsultarCalificacionesSegunPlantaPedidosImpl implements ConsultarCalificacionesSegunPlantaPedidos{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Calificacion_TO> consultarCalificacioneSegunPlantaPedidos(@QueryParam("idProveedor") int idProveedor) throws Exception {
        Proveedor_TO proveedor = new Proveedor_TO(idProveedor);
        CalificacionDAO calificacionDAO = new CalificacionDAOImpl();
        return calificacionDAO.consultarCalificacionesSegunPlantaPedidos(proveedor);
        
    }
    
}
