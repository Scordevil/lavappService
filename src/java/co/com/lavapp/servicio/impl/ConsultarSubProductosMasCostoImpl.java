/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.SubProductoDAO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.ConsultarSubProductosMasCosto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarSubProductosMasCosto")
public class ConsultarSubProductosMasCostoImpl implements ConsultarSubProductosMasCosto{

    @GET
    @Produces({"application/json"})
    @Override
     public List<SubProducto_TO> consultarSubProductosMasCosto(@QueryParam("idProducto") int idProducto) throws Exception {
        SubProductoDAO subProductoDao = new SubProductoDAOImpl();
            Producto_TO producto = new Producto_TO(idProducto);
        return subProductoDao.consultarSubProductosMasCosto(producto);
    }

}
