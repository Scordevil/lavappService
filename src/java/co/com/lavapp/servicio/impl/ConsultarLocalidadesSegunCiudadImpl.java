/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.impl.LocalidadDAOImpl;
import co.com.lavapp.servicio.ConsultarLocalidadesSegunCiudad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/consultarLocalidadesSegunCiudad")
public class ConsultarLocalidadesSegunCiudadImpl implements ConsultarLocalidadesSegunCiudad {

    @GET
    @Produces({"application/json"})
    @Override
    public List<Localidad_TO> consultarTodasLocalidadesSegunCiudad(
            @QueryParam("idCiudad") int idCiudad) throws Exception {

        Ciudad_TO ciudad = new Ciudad_TO(idCiudad);
        LocalidadDAOImpl locDAO = new LocalidadDAOImpl();
        List<Localidad_TO> localidades = new ArrayList<>();
        localidades = locDAO.consultarLocalidadesSegunCiudad(ciudad);

        return localidades;
    }

}
