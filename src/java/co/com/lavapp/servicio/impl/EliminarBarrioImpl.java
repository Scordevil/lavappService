/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.persistencia.dao.BarrioDAO;
import co.com.lavapp.persistencia.dao.impl.BarrioDAOImpl;
import co.com.lavapp.servicio.EliminarBarrio;
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
@Path("/eliminarBarrio")
public class EliminarBarrioImpl implements  EliminarBarrio{

    @GET
    @Produces({"application/json"})
    @Override
    public Barrio_TO eliminarBarrio(@QueryParam("idBarrios") int idBarrios) throws Exception {
        Barrio_TO barrio = new Barrio_TO(idBarrios);
        BarrioDAO barrioDao = new BarrioDAOImpl();
        return barrioDao.eliminarBarrio(barrio);
    }
    
}
