/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.EliminarPedido;
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
@Path("/eliminarPedido")
public class EliminarPedidoImpl implements EliminarPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public Pedido_TO eliminarPedido(@QueryParam("idPedido") int idPedido) throws Exception {
        
        Pedido_TO pedido = new Pedido_TO(idPedido);
        PedidoDAO pedidoDao = new PedidoDAOImpl();
        
        return pedidoDao.eliminarPedido(pedido);
    }

}
