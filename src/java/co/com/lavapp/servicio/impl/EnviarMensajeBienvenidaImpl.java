/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.CorreoDAOImpl;
import co.com.lavapp.servicio.EnviarMensajeBienvenida;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/enviarMensajeBienvenida")
public class EnviarMensajeBienvenidaImpl implements EnviarMensajeBienvenida {

    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int enviarMensajeBienvenido(@QueryParam("email") String email) throws Exception {
        Usuario_TO usuario = new Usuario_TO();
        usuario.setEmail(email);
        CorreoDAOImpl correoDAO = new CorreoDAOImpl();
        return correoDAO.enviarMensajeBienvenido(usuario);
    }
}
