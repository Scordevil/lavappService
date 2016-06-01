/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.EditarEstadoPedido;
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
@Path("/editarEstadoPedido")
public class EditarEstadoPedidoImpl implements EditarEstadoPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public Pedido_TO editarEstadoPedido(@QueryParam("idPedido") int idPedido, 
            @QueryParam("idEstado") int idEstado) throws Exception {
        Estado_TO estado = new Estado_TO(idEstado);
        Pedido_TO pedido = new Pedido_TO(idPedido);
        PedidoDAO pedidoDao = new PedidoDAOImpl();
        return pedidoDao.editarEstadoPedido(pedido, estado);
    }

}
