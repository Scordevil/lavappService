/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.RegistrarDescPedidos;
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
@Path("/registrarDescPedido")
public class RegistrarDescPedidosImpl implements RegistrarDescPedidos{

    @Override
    @GET
    @Produces({"application/json"})
    public DescripcionPedido_TO registrarDescPedido(@QueryParam("idEstado")int idEstado,
            @QueryParam("desc") String desc, 
            @QueryParam("idColor")int idColor,
            @QueryParam("idPedido") int idPedido,
            @QueryParam("idSubProd")int idSubProd) throws Exception {
        
        DescripcionPedido_TO descModel = new DescripcionPedido_TO(new Estado_TO(idEstado), new SubProducto_TO(idSubProd), desc, new Color_TO(idColor), new Pedido_TO(idPedido) );
        DescripcionPedido_TO desSalida = new DescripcionPedido_TO();
        DescripcionPedidoDAOImpl descDAO = new DescripcionPedidoDAOImpl();
        
        try {
            desSalida = descDAO.registrarPreedidos(descModel);
        } catch (Exception e) {
            throw e;
        }
        return desSalida;
    }
    
}
