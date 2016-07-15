/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Costo_TO;
import co.com.lavapp.persistencia.dao.CostoDAO;
import co.com.lavapp.persistencia.dao.impl.CostoDAOImpl;
import co.com.lavapp.servicio.EliminarCosto;
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
@Path("/eliminarCosto")
public class EliminarCostoImpl implements EliminarCosto{

    @GET
    @Produces({"application/json"})
    @Override
    public Costo_TO eliminarCosto(@QueryParam("idCosto") int idCosto) throws Exception {
        Costo_TO costo = new Costo_TO(idCosto);
        CostoDAO costoDao = new CostoDAOImpl();
        return costoDao.eliminarCosto(costo);
    }
    
}
