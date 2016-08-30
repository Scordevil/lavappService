/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.CostoDAO;
import co.com.lavapp.persistencia.dao.impl.CostoDAOImpl;
import co.com.lavapp.servicio.ConsultarCostoPedido;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarCostoPedido")
public class ConsultarCostoPedidoImpl implements ConsultarCostoPedido{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int consultarCostoPedido(@QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        CostoDAO costoDao = new CostoDAOImpl();
        return costoDao.consultarCostoPedido(pedido);
    }
    
}
