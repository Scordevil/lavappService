/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.AsociarAsesorZona;
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
@Path("/asociarAsesorZona")
public class AsociarAsesorZonaImpl implements AsociarAsesorZona{

    @GET
    @Produces({"application/json"})
    @Override
    public Usuario_TO AsociarAsesorZona(@QueryParam("idUsuario") int idUsuario, @QueryParam("idZona") int idZona) throws Exception {
        Usuario_TO usuario = new Usuario_TO(idUsuario);
        Zona_TO zona = new Zona_TO(idZona);
        UsuarioDAO usuarioDao = new UsuarioDAOImpl();
        return usuarioDao.AsociarAsesorZona(usuario, zona);
    }
    
}
