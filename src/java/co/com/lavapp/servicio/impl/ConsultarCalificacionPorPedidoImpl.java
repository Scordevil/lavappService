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
import co.com.lavapp.servicio.ConsultarCalificacionPorPedido;
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
@Path("/consultarCalificacionPorPedido")
public class ConsultarCalificacionPorPedidoImpl implements ConsultarCalificacionPorPedido{

    @GET
    @Produces({"application/json"})
    @Override
    public Calificacion_TO consultarCalificacionPorPedido(@QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        CalificacionDAO calificacionDao = new CalificacionDAOImpl();
        return calificacionDao.consultarCalificacionPorPedido(pedido);
    }
    
    
    
}
