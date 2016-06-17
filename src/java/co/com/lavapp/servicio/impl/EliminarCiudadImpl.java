/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.persistencia.dao.CiudadDAO;
import co.com.lavapp.persistencia.dao.impl.CiudadDAOImpl;
import co.com.lavapp.servicio.EliminarCiudad;
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
@Path("/eliminarCiudad")
public class EliminarCiudadImpl implements EliminarCiudad{

    @GET
    @Produces
    @Override
    public Ciudad_TO eliminarCiudad(@QueryParam("idCiudad") int idCiudad) throws Exception {
        Ciudad_TO ciudad = new Ciudad_TO(idCiudad);
        CiudadDAO ciudadDao = new CiudadDAOImpl();
        return ciudadDao.eliminarCiudad(ciudad);
    }
    
}
