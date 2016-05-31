/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.impl.BarrioDAOImpl;
import co.com.lavapp.servicio.ConsultarBarrios;
import java.util.ArrayList;
import java.util.List;
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
@Path("/consultarLugares")
public class ConsultarBarriosImpl implements ConsultarBarrios{

    @GET
    @Produces({"application/json"})
    public List<Barrio_TO> consultarTodosBarrios(@QueryParam("idLocalidad") int idLocalidad) throws Exception {
        
        List<Barrio_TO> barrios = new ArrayList<>();
        Localidad_TO idLoc = new Localidad_TO(idLocalidad);
        BarrioDAOImpl barrioDAO = new BarrioDAOImpl();
        
        try {
            barrios = barrioDAO.consultarBarrios(idLoc);
        } catch (Exception e) {
            throw e;
        }
        
        return barrios;
    }
    
}
