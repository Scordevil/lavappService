/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.ConsultarUsuarioSegunIdentificacion;
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
@Path("/consultarUsuarioSegunIdentificacion")
public class ConsultarUsuarioSegunIdentificacionImpl implements ConsultarUsuarioSegunIdentificacion{

    @GET
    @Produces({"application/json"})
    @Override
    public Usuario_TO consultarUsuarioSegunIdentificacion(@QueryParam("identificacion") String identificacion) throws Exception {
        Usuario_TO usuario = new Usuario_TO();
        usuario.setIdentificacion(identificacion);
        UsuarioDAO usuarioDao = new UsuarioDAOImpl();
        return usuarioDao.consultarUsuarioPorIdentificacion(usuario);
    }    
}
