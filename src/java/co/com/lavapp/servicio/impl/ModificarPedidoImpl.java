/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.FormaPago_TO;
import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ModificarPedido;
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
            @QueryParam("idProveedor") int idProveedor,
            @QueryParam("fechaEntrega") String fechaEntrega,
            @QueryParam("direccionRecogida") String direccionRecogida,
            @QueryParam("direccionEntrega") String direccionEntrega,
            @QueryParam("fechaRecogida") String fechaRecogida,
            @QueryParam("quienEntrega") String quienEntrega,
            @QueryParam("quienRecibe") String quienRecibe,
            @QueryParam("idBarrios_recogida") int idBarriosRecogida,
            @QueryParam("idBarrios_entrega") int idBarriosEntrega,
            @QueryParam("idAsesor") int idAsesor,
            @QueryParam("idFormaPago") int idFormaPago
    ) throws Exception {
        
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
        
        Pedido_TO pedidoModelo = new Pedido_TO(idPedido,
                new Usuario_TO(idUsuario),
                fecha,
                new Horario_TO(horainiIdhorario),
                new Horario_TO(horafinIdHorario),
                new Estado_TO(idEstado),
                new Proveedor_TO(idProveedor),
                fechaentrega,
                direccionEntrega,
                direccionRecogida,
                fecharecogida,
                quienEntrega,
                quienRecibe,
                new Barrio_TO(idBarriosRecogida),
                new Barrio_TO(idBarriosEntrega),
                new Usuario_TO(idAsesor),
                new FormaPago_TO(idFormaPago));
        
        return pedidoDAO.modificarPedido(pedidoModelo);
        
    }
    
}
