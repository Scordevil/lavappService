/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.ModificarSubProductos;
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
@Path("/modificarSubProductos")
public class ModificarSubProdcutosImpl implements ModificarSubProductos{

    @Override
    @GET
    @Produces({"application/json"})
    public SubProducto_TO modificarSubProductos(@QueryParam("idSubProductos")int idSubProductos,
            @QueryParam("nombre") String nombre,
            @QueryParam("desc") String desc,
            @QueryParam("idProducto") int idProducto,
            @QueryParam("rutaImagen") String rutaImagen) throws Exception {
        SubProducto_TO subpModel = new SubProducto_TO(idSubProductos, nombre, desc, new Producto_TO(idProducto), rutaImagen);
        SubProducto_TO subPSalida = new SubProducto_TO();
        SubProductoDAOImpl subPDAO = new SubProductoDAOImpl();
        try {
            subPSalida = subPDAO.modificarSubProducto(subpModel);
        } catch (Exception e) {
            throw e;
        }
        return subPSalida;
    }
    
}
