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
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.RegistrarPedido;
import java.util.Date;
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
@Path("/registrarPedido")
public class RegistrarPedidoImpl implements RegistrarPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public Pedido_TO registrarPedido(@QueryParam("idUsuario") int idUsuario,
            @QueryParam("fechaInicio") Date fechaInicio,
            @QueryParam("idHorario") int idHorarioInicio,
            @QueryParam("idHorario") int idHorarioFinal,
            @QueryParam("idEstado") int idEstado,
            @QueryParam("idProveedor") int idProveedor) throws Exception {

        Pedido_TO pedido = new Pedido_TO(new Usuario_TO(idUsuario), fechaInicio, new Horario_TO(idHorarioInicio), new Horario_TO(idHorarioFinal), new Estado_TO(idEstado), new Proveedor_TO(idProveedor));
        PedidoDAO pedidoDao = new PedidoDAOImpl();

        return pedidoDao.registrarPedido(pedido);
    }
}
