/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.EliminarDescPedido;
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
@Path("/eliminardescPedido")
public class EliminarDescPedidoImpl implements EliminarDescPedido{

    @Override
    @GET
    @Produces({"application/json"})
    public DescripcionPedido_TO eliminarDescPedido(@QueryParam("idPedido")int idPedido, 
            @QueryParam("idDescPedido")int idDescPedido) throws Exception {
        
        DescripcionPedido_TO descPModelo = new DescripcionPedido_TO(idDescPedido, new Pedido_TO(idPedido));
        DescripcionPedido_TO descSalida = new DescripcionPedido_TO();
        DescripcionPedidoDAOImpl descDAO = new DescripcionPedidoDAOImpl();
        try {
            descSalida = descDAO.elimnarDescPedidos(descPModelo);
            
        } catch (Exception e) {
            throw e;
        }
            
        return descSalida;
    }
    
}
