/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.ZonaDAO;
import co.com.lavapp.persistencia.dao.impl.ZonaDAOImpl;
import co.com.lavapp.servicio.ConsultarZonas;
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
@Path("/consultarZonas")
public class ConsultarZonasImpl implements ConsultarZonas{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Zona_TO> consultarZonas() throws Exception {
        ZonaDAO zonaDao = new ZonaDAOImpl();
        return zonaDao.consultarZonas();
    }
    
}
