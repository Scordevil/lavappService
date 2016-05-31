/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.persistencia.dao.impl.CiudadDAOImpl;
import co.com.lavapp.servicio.ConsultarCiudadporDepto;
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
@Path("consultarCiudadesDTO")
public class ConsultarCiudadporDeptoImpl implements ConsultarCiudadporDepto {

    @GET
    @Produces({"application/json"})
    public List<Ciudad_TO> consultarTodasCiudadesDt(@QueryParam("idDepto") int idDepto) throws Exception {

        Departamento_TO depto = new Departamento_TO(idDepto);
        List<Ciudad_TO> ciudades = new ArrayList<>();
        CiudadDAOImpl ciudadDAO = new CiudadDAOImpl();

        try {
            ciudades = ciudadDAO.consultarCiudadesDepto(depto);
        } catch (Exception e) {
            throw e;
        }
        return ciudades;
    }

}
