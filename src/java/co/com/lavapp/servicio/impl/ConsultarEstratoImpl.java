/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.persistencia.dao.EstratoDAO;
import co.com.lavapp.persistencia.dao.impl.EstratoDAOImpl;
import co.com.lavapp.servicio.ConsultarEstrato;
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
@Path("/consultarEstrato")
public class ConsultarEstratoImpl implements ConsultarEstrato{

    @GET
    @Produces({"application/json"})
    @Override
    public Estrato_TO consultarEstrato(@QueryParam("idEstrato") int idEstrato, @QueryParam("nombre") String nombre) throws Exception {
        Estrato_TO estrato = new Estrato_TO(idEstrato);
        estrato.setNombre(nombre);
        EstratoDAO estratoDao = new EstratoDAOImpl();
        return estratoDao.consultarEstrato(estrato);
    }    
}
