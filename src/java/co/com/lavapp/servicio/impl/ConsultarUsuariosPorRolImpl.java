/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.ConsultarUsuariosPorRol;
import java.util.ArrayList;
import java.util.List;
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
@Path("/consultarUsuariosPorRol")
public class ConsultarUsuariosPorRolImpl implements ConsultarUsuariosPorRol{

    @Override
    @GET
    @Produces({"application/json"})
    public List<Usuario_TO> consultarUsuariosPorRol(@QueryParam("idRol") int idRol) throws Exception {
        Rol_TO rol = new Rol_TO(idRol);
        
        List<Usuario_TO> listaModelo = new ArrayList<>();
        UsuarioDAOImpl usuaDAO = new UsuarioDAOImpl();
        
        listaModelo = usuaDAO.consultarUsuariosPorRol(rol);
        return listaModelo;
        
    }    
    
}
