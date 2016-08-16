/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarDescripcionPedido;
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
@Path("/consultarDescripcionPedido")
public class ConsultarDescripcionPedidoImpl implements ConsultarDescripcionPedido{

    @GET
    @Produces({"application/json"})    
    @Override
    public DescripcionPedido_TO consultarDescripcionPedido(@QueryParam("idDescripcionPedido") int idDescripcionPedido) throws Exception {
        DescripcionPedido_TO descripcion = new DescripcionPedido_TO(idDescripcionPedido);
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        return descripcionDao.consultarDescripcionPedido(descripcion);
    }
    
}
