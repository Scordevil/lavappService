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
import co.com.lavapp.servicio.ConsultarZonasAsesor;
import java.util.List;
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
@Path("/consultarZonasAsesor")
public class ConsultarZonasAsesorImpl implements ConsultarZonasAsesor{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Zona_TO> consultarZonasAsesor(@QueryParam("idUsuario") int idUsuario) throws Exception {
        Usuario_TO asesor = new Usuario_TO(idUsuario);
        ZonaDAO zonaDAO = new ZonaDAOImpl();
        return zonaDAO.consultarZonasAsesor(asesor);
    }
    
}
