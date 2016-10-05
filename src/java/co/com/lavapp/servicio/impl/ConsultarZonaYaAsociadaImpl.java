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
import co.com.lavapp.servicio.ConsultarZonaYaAsociada;
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
@Path("/consultarZonaYaAsociada")
public class ConsultarZonaYaAsociadaImpl implements ConsultarZonaYaAsociada{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int ConsultarZonaYaAsociada(@QueryParam("idUsuario") int idUsuario,@QueryParam("idZona") int idzona) throws Exception {
        Usuario_TO usuario = new Usuario_TO(idUsuario);
        Zona_TO zona = new Zona_TO(idzona);
        ZonaDAO zonaDAO = new ZonaDAOImpl();
        return zonaDAO.consultarZonaYaAsociada(usuario, zona);
    }
    
}
