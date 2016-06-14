/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pais_TO;
import co.com.lavapp.persistencia.dao.PaisDAO;
import co.com.lavapp.persistencia.dao.impl.PaisDAOImpl;
import co.com.lavapp.servicio.ConsultarPais;
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
@Path("/consultarPais")
public class ConsultarPaisImpl implements ConsultarPais {

    @GET
    @Produces({"application/json"})
    @Override
    public Pais_TO consultarPais(@QueryParam("idPais") int idPais) throws Exception {
        Pais_TO pais = new Pais_TO(idPais);
        PaisDAO paisDAO = new PaisDAOImpl();
        return paisDAO.consultarPais(pais);
    }
}
