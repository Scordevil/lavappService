/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.ZonaDAO;
import co.com.lavapp.persistencia.dao.impl.ZonaDAOImpl;
import co.com.lavapp.servicio.RegistrarZona;
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
@Path("/registrarZona")
public class RegistrarZonaImpl implements RegistrarZona {

    @GET
    @Produces({"application/json"})
    @Override
    public Zona_TO registrarZona(@QueryParam("nombre") String nombre, 
            @QueryParam("descripcion") String descripcion) throws Exception {
        Zona_TO zona = new Zona_TO(nombre, descripcion);
        ZonaDAO zonaDao = new ZonaDAOImpl();
        return zonaDao.registraZona(zona);
    }
}
