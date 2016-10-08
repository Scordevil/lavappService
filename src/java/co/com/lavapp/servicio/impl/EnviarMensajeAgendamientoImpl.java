/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.CorreoDAO;
import co.com.lavapp.persistencia.dao.impl.CorreoDAOImpl;
import co.com.lavapp.servicio.EnviarMensajeAgendamiento;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/enviarMensajeAgendamiento")
public class EnviarMensajeAgendamientoImpl implements EnviarMensajeAgendamiento{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int enviarMensajeAgendamiento(@QueryParam("email") String email) throws Exception {
        Usuario_TO usuario = new Usuario_TO();
        usuario.setEmail(email);
        CorreoDAO correoDAO = new CorreoDAOImpl();
        return correoDAO.enviarMensajeAgendamiento(usuario);
    }
    
}
