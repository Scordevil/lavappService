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
import co.com.lavapp.servicio.EditarDescripcionPedidoAsesor;
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
@Path("/editarDescripcionPedidoAsesor")
public class EditarDescripcionPedidoAsesorImpl implements EditarDescripcionPedidoAsesor{

    @GET
    @Produces({"application/json"})
    @Override
    public DescripcionPedido_TO editarDescripcionPedidoAsesor(
            @QueryParam("idDescripcionPedido") int idDescripcionPedido,
            @QueryParam("idEstado") int idEstado, 
            @QueryParam("observacionAsesor") String observacionAsesor,       
            @QueryParam("idColor") int idColor,
            @QueryParam("foto1") String foto1,
            @QueryParam("foto2") String foto2,
            @QueryParam("foto3") String foto3) throws Exception {
        
        DescripcionPedido_TO descripcionPedido = new DescripcionPedido_TO(idDescripcionPedido, new Estado_TO(idEstado),observacionAsesor,foto1, foto2, foto3, new Color_TO(idColor));
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        return descripcionDao.editarDescripcionAsesor(descripcionPedido);
    }
    
}
