/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.persistencia.dao.RolDAO;
import co.com.lavapp.persistencia.dao.impl.RolDAOImpl;
import co.com.lavapp.servicio.RegistrarRol;
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
@Path("/registrarRol")
public class RegistrarRolImpl implements RegistrarRol{

    @GET
    @Produces({"application/json"})
    @Override
    public Rol_TO registrarRol(@QueryParam("nombre") String nombre) throws Exception {
        Rol_TO rol = new Rol_TO();
        rol.setNombre(nombre);
        RolDAO rolDao = new RolDAOImpl();
        return rolDao.registrarRol(rol);
    }    
}
