/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.EliminarSubProductos;
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
@Path("/eliminarSubProducto")
public class EliminarSubProductosImpl implements EliminarSubProductos{

    @Override
    @GET
    @Produces({"application/json"})
    public SubProducto_TO eliminarSubProductos(@QueryParam("idSubPro")int idSubPro) throws Exception {
        SubProducto_TO subpModel = new SubProducto_TO(idSubPro);
        SubProducto_TO subPSalida = new SubProducto_TO();
        SubProductoDAOImpl subPDAO = new SubProductoDAOImpl();
        try {
            subPSalida = subPDAO.eliminarSubProducto(subpModel);
        } catch (Exception e) {
            throw e;
       }
        return subPSalida;
    }
    
}
