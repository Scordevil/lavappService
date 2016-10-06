/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.ZonaDAO;
import co.com.lavapp.persistencia.dao.impl.ZonaDAOImpl;
import co.com.lavapp.servicio.EliminarAsociacionZona;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/eliminarAsociacionZona")
public class EliminarAsociacionZonaImpl implements EliminarAsociacionZona {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int EliminarAsociacionZona(@QueryParam("idUsuario") int idUsuario, @QueryParam("idZona") int idZona) throws Exception {
        Usuario_TO asesor = new Usuario_TO(idUsuario);
        Zona_TO zona = new Zona_TO(idZona);
        ZonaDAO zonaDAO = new ZonaDAOImpl();
        return zonaDAO.eliminarAsociacionZona(asesor, zona);
    }

}
