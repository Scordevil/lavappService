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
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.EditarDescripcionPedido;
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
@Path("/editarDescripcionPedido")
public class EditarDescripcionPedidoImpl implements EditarDescripcionPedido{

    @GET
    @Produces({"application/json"})
    @Override
    public DescripcionPedido_TO editarDescripcionPedido(@QueryParam("idDescripcionPedido") int idDescripcionPedido,
            @QueryParam("idEstado") int idEstado, 
            @QueryParam("descripcion") String descripcion, 
            @QueryParam("observacionAsesor") String observacionAsesor,
            @QueryParam("observaciobn") String observacionAdministrador,           
            @QueryParam("idColor") int idColor,
            @QueryParam("idPedido") int idPedido,
            @QueryParam("idSubProducto") int idSubProducto,
            @QueryParam("codigo") String codigo) throws Exception {
        
        DescripcionPedido_TO descripcionPedido = new DescripcionPedido_TO(idDescripcionPedido, new Estado_TO(idEstado), new SubProducto_TO(idSubProducto), descripcion, observacionAsesor, observacionAdministrador, new Color_TO(idColor), new Pedido_TO(idPedido), codigo);
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        return descripcionDao.editarDescripcion(descripcionPedido);
    }
    
}
