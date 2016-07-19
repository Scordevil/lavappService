/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.RegistrarDescripcionPedido;
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
@Path("/registrarDescripcionPedido")
public class RegistrarDescripcionPedidoImpl implements RegistrarDescripcionPedido {

    @Override
    @GET
    @Produces({"application/json"})
    public DescripcionPedido_TO registrarDescripcionPedido(@QueryParam("idEstado") int idEstado,
            @QueryParam("idPedido") int idPedido,
            @QueryParam("idSubProd") int idSubProducto) throws Exception {

        DescripcionPedido_TO descripcion = new DescripcionPedido_TO();
        descripcion.setEstado(new Estado_TO(idEstado));
        descripcion.setPedido(new Pedido_TO(idPedido));
        descripcion.setSubProducto(new SubProducto_TO(idSubProducto));
        DescripcionPedidoDAOImpl descDAO = new DescripcionPedidoDAOImpl();

        return descDAO.registrarDescripcion(descripcion);
    }

}
