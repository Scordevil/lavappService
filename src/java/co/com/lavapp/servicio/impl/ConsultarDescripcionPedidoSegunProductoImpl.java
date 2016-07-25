/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarDescripcionPedidoSegunProducto;
import co.com.lavapp.servicio.ConsultarPedidosSegunPlanta;
import java.util.List;
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
@Path("/consultarDescripcionPedidoSegunProducto")
public class ConsultarDescripcionPedidoSegunProductoImpl implements ConsultarDescripcionPedidoSegunProducto{

    @GET
    @Produces({"application/json"})
    @Override
    public DescripcionPedido_TO consultarDescripcionPedidoSegunProducto(@QueryParam("idDescripcionPedido") int idDescripcionPedido) throws Exception {
        DescripcionPedido_TO descripcion = new DescripcionPedido_TO(idDescripcionPedido);
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        return descripcionDao.consultarDescripcionPedidoSegunProducto(descripcion);
    }  
        
}
