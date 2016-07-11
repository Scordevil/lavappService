/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.SubProductoDAO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.ConsultarSubProductos;
import java.util.List;
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
@Path("/consultarSubProductos")
public class ConsultarSubProductosImpl implements ConsultarSubProductos{

    @GET
    @Produces({"application/json"})
    @Override
    public List<SubProducto_TO> consultarSubProductos() throws Exception {
        SubProductoDAO subProductoDao = new SubProductoDAOImpl();
        return subProductoDao.consultarSubProductos();
    }
    
}
