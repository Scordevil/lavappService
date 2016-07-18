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
import co.com.lavapp.servicio.ConsultarPedido;
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
@Path("/consultarPedido")
public class ConsultarPedidoImpl implements ConsultarPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public Pedido_TO consultarPedido(@QueryParam("idUsuario") int idUsuario,
            @QueryParam("fechaInicio") String fechaInicio,
            @QueryParam("idHorario") int idHorarioInicio,
            @QueryParam("idHorario") int idHorarioFinal) throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new Date();

        try {
            fecha = formato.parse(fechaInicio);
        } catch (ParseException e) {
            e.getMessage();
        }

        Pedido_TO pedido = new Pedido_TO();
        pedido.setUsuario(new Usuario_TO(idUsuario));
        pedido.setFechaInicio(fecha);        
        pedido.setHoraInicio(new Horario_TO(idHorarioInicio));
        pedido.setHoraFinal(new Horario_TO(idHorarioFinal));
       
        PedidoDAO pedidoDao = new PedidoDAOImpl();
        return pedidoDao.consultarPedido(pedido);
    }

}
