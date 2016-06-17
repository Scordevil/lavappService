/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.persistencia.dao.BarrioDAO;
import co.com.lavapp.persistencia.dao.impl.BarrioDAOImpl;
import co.com.lavapp.servicio.ConsultarBarrios;
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
@Path("/consultarBarrios")
public class ConsultarBarriosImpl implements ConsultarBarrios{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Barrio_TO> consultarBarrios() throws Exception {
        BarrioDAO barrioDao = new BarrioDAOImpl();
        return barrioDao.consultarBarrios();
    }    
}
