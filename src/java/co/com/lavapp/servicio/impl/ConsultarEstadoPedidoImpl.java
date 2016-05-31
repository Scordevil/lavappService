/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.EstadoDAO;
import co.com.lavapp.persistencia.dao.impl.EstadoDAOImpl;
import co.com.lavapp.servicio.ConsultarEstadoPedido;
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
@Path("/consultarEstadoPedido")
public class ConsultarEstadoPedidoImpl implements ConsultarEstadoPedido{

    @GET
    @Produces({"application/json"})
    @Override
    public Estado_TO consultarEstadoPedido(@QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        EstadoDAO estadoDao = new EstadoDAOImpl();
        return estadoDao.consultarEstadoPedido(pedido);
    }    
}
