/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.persistencia.dao.ProductoDAO;
import co.com.lavapp.persistencia.dao.impl.ProductoDAOImpl;
import co.com.lavapp.servicio.ConsultarProducto;
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
@Path("/consultarProducto")
public class ConsultarProductoImpl implements ConsultarProducto{

    @GET
    @Produces({"application/json"})
    @Override
    public Producto_TO consultarProducto(@QueryParam("idProducto") int idProducto, @QueryParam("nombre") String nombre) throws Exception {
        Producto_TO producto = new Producto_TO(idProducto);
        producto.setNombre(nombre);
        ProductoDAO productoDao = new ProductoDAOImpl();
        return productoDao.consultarProducto(producto);
    }
    
}
