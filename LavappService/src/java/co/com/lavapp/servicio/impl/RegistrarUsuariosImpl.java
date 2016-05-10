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
import co.com.lavapp.servicio.RegistrarUsuarios;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/registrarUsuarios")
public class RegistrarUsuariosImpl implements RegistrarUsuarios {

    @GET
    @Produces({"application/json"})

    @Override
    public Usuario_TO registrarUsuarios(@QueryParam("nombre") String nombre,
            @QueryParam("telefono") String telefono, @QueryParam("idbarrios") int idbarrios,
            @QueryParam("idrol") int idrol, @QueryParam("idestado") int idestado, @QueryParam("usuario") String login,
            @QueryParam("contrasena") String contrasena) throws Exception {

        Usuario_TO cliente = new Usuario_TO(nombre, telefono, new Barrio_TO(idbarrios), new Rol_TO(idrol),
                new Estado_TO(idestado), new Sesion_TO(login, contrasena));

        UsuarioDAOImpl usuario = new UsuarioDAOImpl();

        return usuario.registrarUsuarios(cliente);

    }

}
