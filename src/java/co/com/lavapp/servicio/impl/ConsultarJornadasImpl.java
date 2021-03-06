/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Jornada_TO;
import co.com.lavapp.persistencia.dao.JornadaDAO;
import co.com.lavapp.persistencia.dao.impl.JornadaDAOImpl;
import co.com.lavapp.servicio.ConsultarJornadas;
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
@Path("/consultarJornadas")
public class ConsultarJornadasImpl implements ConsultarJornadas{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Jornada_TO> consultarJornadas() throws Exception {
       JornadaDAO jornadaDao = new JornadaDAOImpl();
       return jornadaDao.consultarJornadas();
    }
    
}
