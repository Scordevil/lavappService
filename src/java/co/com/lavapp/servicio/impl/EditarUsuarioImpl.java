/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.EditarUsuario;
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
@Path("/editarUsuario")
public class EditarUsuarioImpl implements EditarUsuario {

    @GET
    @Produces({"application/json"})
    @Override
    public Usuario_TO editarUsuario(@QueryParam("idUsuario") int idUsuario, 
            @QueryParam("nombre") String nombre, 
            @QueryParam("apellido") String apellido,
            @QueryParam("genero") String genero,
            @QueryParam("telefono") String telefono, 
            @QueryParam("idbarrios") int idbarrios,
            @QueryParam("movil") String movil,
            @QueryParam("direccion") String direccion, 
            @QueryParam("idciudad") int idciudad, 
            @QueryParam("identificacion") String identificacion) throws Exception {

        Usuario_TO usuario = new Usuario_TO(idUsuario, nombre, telefono, new Barrio_TO(idbarrios), apellido, genero, movil, direccion, new Ciudad_TO(idciudad), identificacion);
        UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();
        return usuarioDao.editarUsuario(usuario);
    }

}
