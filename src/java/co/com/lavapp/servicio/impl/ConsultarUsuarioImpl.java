/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Sesion_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.ConsultarUsuario;
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
@Path("/consultarUsuario")
public class ConsultarUsuarioImpl implements ConsultarUsuario{

    @GET
    @Produces({"application/json"})

    @Override
    public Usuario_TO consultarUsuario(
            @QueryParam("idUsuario") int idUsuario) throws Exception {

        Usuario_TO user = new Usuario_TO(idUsuario);

        UsuarioDAOImpl usuario = new UsuarioDAOImpl();

       return usuario.consultarUsuario(user);
        
       }

}
