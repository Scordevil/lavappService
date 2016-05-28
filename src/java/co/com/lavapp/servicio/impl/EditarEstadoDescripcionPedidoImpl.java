/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.EditarEstadoDescripcionPedido;
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
@Path("editarEstadoDescripcionPedido")
public class EditarEstadoDescripcionPedidoImpl implements EditarEstadoDescripcionPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public DescripcionPedido_TO EditarEstadoDescripcionPedido(@QueryParam("idDescripcionPedido") int idDescripcionPedido, @QueryParam("idEstado") int idEstado) throws Exception {
        DescripcionPedido_TO descripcionPedido = new DescripcionPedido_TO(idDescripcionPedido);
        Estado_TO estado = new Estado_TO(idEstado);
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        return descripcionDao.EditarEstadoDescripcionPedido(descripcionPedido, estado);
    }

}
