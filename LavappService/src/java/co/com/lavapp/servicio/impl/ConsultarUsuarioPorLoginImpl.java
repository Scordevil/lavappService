/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.modelo.dto.Sesion_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
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
@Path("/consultarUsuarioPorLogin")
public class ConsultarUsuarioPorLoginImpl {
    
    @GET
    @Produces({"application/json"})

    public Usuario_TO consultarUsuarioPorLogin(
            @QueryParam("login") String login) throws Exception {

        Usuario_TO user = new Usuario_TO(new Sesion_TO(login,""));

        UsuarioDAOImpl usuario = new UsuarioDAOImpl();

        return usuario.consultarUsuarioPorLogin(user);

    }
    
}
