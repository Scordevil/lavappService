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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Pedido_TO registrarPedido(
            @QueryParam("fechaInicio") String fechaInicio,
            @QueryParam("idHorario") int idHorarioInicio,
            @QueryParam("idHorarioFinal") int idHorarioFinal,
            @QueryParam("idEstado") int idEstado) throws Exception {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date f = new Date();
        try {
            f = formatoDeFecha.parse(fechaInicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Pedido_TO pedido = new Pedido_TO();
        pedido.setFechaInicio(f);
        pedido.setHoraInicio(new Horario_TO(idHorarioInicio));
        pedido.setHoraFinal(new Horario_TO(idHorarioFinal));
        pedido.setEstado(new Estado_TO(idEstado));

        PedidoDAO pedidoDao = new PedidoDAOImpl();
        return pedidoDao.registrarPedido(pedido);
    }
}
