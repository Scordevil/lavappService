/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Costo_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.CostoDAO;
import co.com.lavapp.persistencia.dao.impl.CostoDAOImpl;
import co.com.lavapp.servicio.ConsultarCostoSubProducto;
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
@Path("/consultarCostoSubProducto")
public class ConsultarCostoSubProductoImpl implements ConsultarCostoSubProducto{

    @GET
    @Produces({"application/json"})
    @Override
    public Costo_TO consultarCostoSubProducto(@QueryParam("idSubProducto") int idSubProducto) throws Exception {
        SubProducto_TO subproducto = new SubProducto_TO(idSubProducto);
        CostoDAO costoDao = new CostoDAOImpl();
        return costoDao.consultarCostoSubProducto(subproducto);
    }
    
}
