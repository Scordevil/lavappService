/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.EliminarUsuario;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/eliminarUsuario")
public class EliminarUsuarioImpl implements EliminarUsuario{

    @GET
    @Produces({"application/json"})
    @Override
    public Usuario_TO eliminarUsuario(@QueryParam("idUsuario") int idUsuario) throws Exception {
        Usuario_TO usuario = new Usuario_TO(idUsuario);
        UsuarioDAO usuarioDao = new UsuarioDAOImpl();
        return usuarioDao.eliminarUsuario(usuario);
    }    
}
