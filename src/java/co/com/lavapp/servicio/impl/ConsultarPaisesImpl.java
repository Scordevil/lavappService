/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pais_TO;
import co.com.lavapp.persistencia.dao.PaisDAO;
import co.com.lavapp.persistencia.dao.impl.PaisDAOImpl;
import co.com.lavapp.servicio.ConsultarPaises;
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
@Path("/consultarPaises")
public class ConsultarPaisesImpl implements ConsultarPaises{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Pais_TO> consultarPaises() throws Exception {
        PaisDAO paisDao = new PaisDAOImpl();
        return paisDao.consultarPaises();
    }    
}
