/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.persistencia.dao.EstratoDAO;
import co.com.lavapp.persistencia.dao.impl.EstratoDAOImpl;
import co.com.lavapp.servicio.RegistrarEstrato;
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
@Path("/registrarEstrato")
public class RegistrarEstratoImpl implements RegistrarEstrato{

    @GET
    @Produces({"application/json"})
    @Override
    public Estrato_TO registrarEstrato(@QueryParam("nombre") String nombre) throws Exception {
        Estrato_TO estrato = new Estrato_TO();
        estrato.setNombre(nombre);
        EstratoDAO estratoDao = new EstratoDAOImpl();
        return estratoDao.registrarEstrato(estrato);
    }
    
}
