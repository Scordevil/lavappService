/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.impl.ProductoDAOImpl;
import co.com.lavapp.servicio.ModificarProducto;
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
@Path("/modificarProducto")
public class ModificarProductoImpl implements ModificarProducto{

    @Override
    @GET
    @Produces({"application/json"})
    public Producto_TO modificarProducto(@QueryParam("idProducto")int idProducto,
            @QueryParam("nombre") String nombre,@QueryParam("desc") String desc,
            @QueryParam("idSubServ") int idSubServ , 
            @QueryParam("rutaImagen") String rutaImagen) throws Exception {
        
        Producto_TO produModel = new Producto_TO(idProducto,
                nombre, 
                desc, 
                new SubServicio_TO(idSubServ),
                rutaImagen);
      
        ProductoDAOImpl producDAO = new ProductoDAOImpl();
        return producDAO.modificarProducto(produModel);
    }
    
}
