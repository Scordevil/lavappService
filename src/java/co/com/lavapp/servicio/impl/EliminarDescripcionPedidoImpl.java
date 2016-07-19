/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.EliminarDescripcionPedido;
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
@Path("/eliminarDescripcionPedido")
public class EliminarDescripcionPedidoImpl implements EliminarDescripcionPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public DescripcionPedido_TO eliminarDescripcionPedido(@QueryParam("idDescripcionPedido") int idDescripcionPedido) throws Exception {

        DescripcionPedido_TO descPModelo = new DescripcionPedido_TO(idDescripcionPedido);
        DescripcionPedidoDAOImpl descDAO = new DescripcionPedidoDAOImpl();
        return descDAO.eliminarDescripcion(descPModelo);
    }

}
