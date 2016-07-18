/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.RegistrarPedidoWeb;
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
@Path("/registrarPedidoCompleto")
public class RegistrarPedidoWebImpl implements RegistrarPedidoWeb {

    @GET
    @Produces({"application/json"})
    @Override
    public Pedido_TO registrarPedidoWeb(@QueryParam("idUsuario") int idUsuario,
            @QueryParam("fechaInicio") String fechaInicio,
            @QueryParam("idHoraInicio") int idHoraInicio,
            @QueryParam("idHoraFinal") int idHoraFinal,
            @QueryParam("idEstado") int idEstado,            
            @QueryParam("fechaEntrega") String fechaEntrega,
            @QueryParam("direccionEntrega") String direccionEntrega,
            @QueryParam("direccionRecogida") String direccionRecogida,
            @QueryParam("fechaRecogida") String fechaRecogida,
            @QueryParam("quienEntrega") String quienEntrega,
            @QueryParam("quienRecibe") String quienRecibe,
            @QueryParam("idBarrioRecogida") int idBarrioRecogida,
            @QueryParam("idBarrioEntrega") int idBarrioEntrega) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
        Date fecha = new Date();
        Date fecharecogida = new Date();
        Date fechaentrega = new Date();
        try {
            fecha = formato.parse(fechaInicio);
            fecharecogida = formato.parse(fechaRecogida);
            fechaentrega = formato.parse(fechaEntrega);
        } catch (ParseException e) {
            e.getMessage();
        }

        Pedido_TO pedido = new Pedido_TO(new Usuario_TO(idUsuario),
                fecha,
                new Horario_TO(idHoraInicio),
                new Horario_TO(idHoraFinal),
                new Estado_TO(idEstado),               
                fechaentrega,
                direccionEntrega,
                direccionRecogida,
                fecharecogida,
                quienEntrega,
                quienRecibe,
                new Barrio_TO(idBarrioRecogida),
                new Barrio_TO(idBarrioEntrega));
        return pedidoDAO.registrarPedidoWeb(pedido);
    }
}
