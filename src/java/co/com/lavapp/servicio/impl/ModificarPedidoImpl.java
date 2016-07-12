/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ModificarPedido;
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
@Path("/modificarPedidoCompleto")
public class ModificarPedidoImpl implements ModificarPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public Pedido_TO modificarPedido(@QueryParam("idPedido") int idPedido,
            @QueryParam("idUsuario") int idUsuario,
            @QueryParam("fechaInicio") String fechaInicio,
            @QueryParam("horainiIdhorario") int horainiIdhorario,
            @QueryParam("horafinIdHorario") int horafinIdHorario,
            @QueryParam("idEstado") int idEstado,
            @QueryParam("idProveedor") int idProveedor) throws Exception {

        PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();

        Pedido_TO pedidoModelo = new Pedido_TO(idPedido,
                new Usuario_TO(idUsuario),
                fechaInicio,
                new Horario_TO(horainiIdhorario),
                new Horario_TO(horafinIdHorario),
                new Estado_TO(idEstado),
                new Proveedor_TO(idProveedor));

        return pedidoDAO.modificarPedido(pedidoModelo);

    }

}
