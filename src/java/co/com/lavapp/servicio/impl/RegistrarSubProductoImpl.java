/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.RegistrarSubProducto;
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
@Path("/registrarSubProducto")
public class RegistrarSubProductoImpl implements RegistrarSubProducto {

    @GET
    @Produces({"application/json"})
    @Override
    public SubProducto_TO registrarSubProducto(@QueryParam("nombre") String nombre,
            @QueryParam("descripcion") String desc, 
            @QueryParam("idProducto") int idProduc ,
            @QueryParam("rutaImagen") String rutaImagen) throws Exception {

        Producto_TO idProd = new Producto_TO(idProduc);
        SubProducto_TO subProductModel = new SubProducto_TO(nombre, desc, idProd, rutaImagen);
        SubProductoDAOImpl subProDAO = new SubProductoDAOImpl();

        return subProDAO.registrarSubProducto(subProductModel);

    }

}
