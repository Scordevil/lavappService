/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Sesion_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.ConsultarUsuarioSesion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Planit
 */
@Stateless
@Path("/consultarUsuarioSesion")
public class ConsultarUsuarioSesionImpl implements ConsultarUsuarioSesion{

    @GET
    @Produces({"application/json"})

    @Override
    public Sesion_TO consultarUsuarioSesion(
            @QueryParam("idUsuario") int idUsuario) throws Exception {

        Sesion_TO user = new Sesion_TO(0,idUsuario);

        UsuarioDAOImpl usuario = new UsuarioDAOImpl();

        return usuario.consultarUsuarioSesion(user);

    }

}
