/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Factura_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.FacturaDAO;
import co.com.lavapp.persistencia.dao.impl.FacturaDAOImpl;
import co.com.lavapp.servicio.ConsultarFacturaPedido;
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
@Path("/consultarFacturaPedido")
public class ConsultarFacturaPedidoImpl implements ConsultarFacturaPedido{

    @GET
    @Produces({"application/json"})
    @Override
    public Factura_TO consultarFacturaPedido(@QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        FacturaDAO facturaDao = new FacturaDAOImpl();
        return facturaDao.consultarFacturaPedido(pedido);
    }
    
}
