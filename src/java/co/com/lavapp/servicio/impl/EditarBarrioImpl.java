/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.BarrioDAO;
import co.com.lavapp.persistencia.dao.impl.BarrioDAOImpl;
import co.com.lavapp.servicio.EditarBarrio;
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
@Path("/editarBarrio")
public class EditarBarrioImpl implements EditarBarrio{

    @GET
    @Produces({"application/json"})
    @Override
    public Barrio_TO modificarBarrio(@QueryParam("idBarrios") int idBarrios, 
            @QueryParam("nombre") String nombre, 
            @QueryParam("idLocalidad") int idLocalidad, 
            @QueryParam("idZona") int idZona, 
            @QueryParam("idEstrato") int idEstrato) throws Exception {
        
        Barrio_TO barrio = new Barrio_TO(idBarrios, nombre, new Localidad_TO(idLocalidad), new Zona_TO(idZona), new Estrato_TO(idEstrato));
        BarrioDAO barrioDao = new BarrioDAOImpl();
        return barrioDao.modificarBarrio(barrio);
    }
    
}
