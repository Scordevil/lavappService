/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.persistencia.dao.ProductoDAO;
import co.com.lavapp.persistencia.dao.impl.ProductoDAOImpl;
import co.com.lavapp.servicio.ConsultarProductos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarProductos")
public class ConsultarProductosImpl implements ConsultarProductos{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Producto_TO> consultarProductos() throws Exception {
        ProductoDAO productoDao = new ProductoDAOImpl();
        return productoDao.consultarProductos();
    }
    
}
