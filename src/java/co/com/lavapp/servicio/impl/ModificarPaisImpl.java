/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pais_TO;
import co.com.lavapp.persistencia.dao.PaisDAO;
import co.com.lavapp.persistencia.dao.impl.PaisDAOImpl;
import co.com.lavapp.servicio.ModificarPais;
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
@Path("/modificarPais")
public class ModificarPaisImpl implements ModificarPais {

    @GET
    @Produces({"application/json"})
    @Override
    public Pais_TO modificarPais(@QueryParam("idPais") int idPais, @QueryParam("nombre") String nombre) throws Exception {
        Pais_TO pais = new Pais_TO(idPais, nombre);
        PaisDAO paisDao = new PaisDAOImpl();
        return paisDao.modificarPais(pais);
    }

}
