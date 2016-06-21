/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.impl.ProductoDAOImpl;
import co.com.lavapp.servicio.RegistrarProducto;
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
@Path("/registrarProducto")

public class RegistrarProductoImpl implements RegistrarProducto{

    @GET
    @Produces({"application/json"})
    @Override
    
    public Producto_TO registrarProducto(@QueryParam("nombre") String nombre, @QueryParam("descripcion") String descripcion, 
            @QueryParam("idSubServicio") int idSubServicio) throws Exception {
        
        SubServicio_TO idSubServ = new SubServicio_TO(idSubServicio);
        Producto_TO productModel = new Producto_TO(nombre, descripcion, idSubServ);
        ProductoDAOImpl productoDAO = new ProductoDAOImpl();
        
        return productoDAO.registrarProducto(productModel);
    }
    
}
