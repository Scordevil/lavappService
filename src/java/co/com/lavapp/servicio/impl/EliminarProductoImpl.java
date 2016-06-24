/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.persistencia.dao.impl.ProductoDAOImpl;
import co.com.lavapp.servicio.EliminarProducto;
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
@Path("/eliminarProducto")
public class EliminarProductoImpl implements EliminarProducto{

    @Override
    @GET
    @Produces({"application/json"})
    public Producto_TO eliminarProducto(@QueryParam("idProducto")int idProducto) throws Exception {
        
        Producto_TO producModelo = new Producto_TO(idProducto);
        Producto_TO producSalida = new Producto_TO();
        ProductoDAOImpl prodDAO = new ProductoDAOImpl();
        try {
            producSalida = prodDAO.eliminarProducto(producModelo);
        } catch (Exception e) {
            throw e;
        }
        
        return producSalida;
    }
    
}
