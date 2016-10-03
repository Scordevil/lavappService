/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarPedidosDiaRecogida;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarPedidosDiaRecogida")
public class ConsultarPedidosDiaRecogidaImpl implements ConsultarPedidosDiaRecogida{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Pedido_TO> ConsultarPedidosDiaRecogida() throws Exception {
        PedidoDAO pedidoDAO = new PedidoDAOImpl();
        return pedidoDAO.consultarPedidosPorDiaRecogida();
    }    
}
