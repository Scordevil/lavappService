/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.persistencia.dao.EstratoDAO;
import co.com.lavapp.persistencia.dao.impl.EstratoDAOImpl;
import co.com.lavapp.servicio.EliminarEstrato;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/eliminarEstrato")
public class EliminarEstratoImpl implements EliminarEstrato {

    @GET
    @Produces({"application/json"})
    @Override
    public Estrato_TO eliminarEstrato(int idEstrato) throws Exception {
        Estrato_TO estrato = new Estrato_TO(idEstrato);
        EstratoDAO estratoDao = new EstratoDAOImpl();
        return estratoDao.eliminarEstrato(estrato);
    }
}
