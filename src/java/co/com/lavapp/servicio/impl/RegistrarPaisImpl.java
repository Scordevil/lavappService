/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pais_TO;
import co.com.lavapp.persistencia.dao.PaisDAO;
import co.com.lavapp.persistencia.dao.impl.PaisDAOImpl;
import co.com.lavapp.servicio.RegistrarPais;
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
@Path("/registrarPais")
public class RegistrarPaisImpl implements RegistrarPais{

    @GET
    @Produces({"application/json"})
    @Override
    public Pais_TO registrarPais(@QueryParam("nombre") String nombre) throws Exception {
        Pais_TO pais = new Pais_TO();
        pais.setNombre(nombre);
        PaisDAO paisDao = new PaisDAOImpl();
        return paisDao.registrarPais(pais);
    }
    
}
