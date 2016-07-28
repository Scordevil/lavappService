/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.SubProductoDAO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.ConsultarSubProducto;
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
@Path("/consultarSubProducto")
public class ConsultarSubProductoImpl implements ConsultarSubProducto{

    @GET
    @Produces({"application/json"})
    @Override
    public SubProducto_TO consultarSubProducto(@QueryParam("idSubProducto") int idSubProducto,@QueryParam("nombre") String nombre) throws Exception {
        SubProducto_TO subproducto = new SubProducto_TO(idSubProducto, nombre);
        SubProductoDAO subProductoDao = new SubProductoDAOImpl();
        return  subProductoDao.consultarSubProdcuto(subproducto);
    }
    
}
