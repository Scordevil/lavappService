/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Sesion_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.RegistrarUsuarioSesion;
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
@Path("/registrarUsuarioSesion")
public class RegistrarUsuarioSesionImpl implements RegistrarUsuarioSesion {

    @GET
    @Produces({"application/json"})

    @Override
    public Sesion_TO registrarUsuarioSesion(
            @QueryParam("login") String login, @QueryParam("contrasena") String contrasena,@QueryParam("idUsuario") int idUsuario ) throws Exception {

        Sesion_TO user = new Sesion_TO(login,contrasena,idUsuario);

        UsuarioDAOImpl usuario = new UsuarioDAOImpl();

        return usuario.registrarUsuarioSesion(user);

    }
}
