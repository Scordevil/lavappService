/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.persistencia.dao.RolDAO;
import co.com.lavapp.persistencia.dao.impl.RolDAOImpl;
import co.com.lavapp.servicio.EditarRol;
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
@Path("/editarRol")
public class EditarRolImpl implements EditarRol{

    @GET
    @Produces({"application/json"})
    @Override
    public Rol_TO editarRol(@QueryParam("idRol") int idRol,@QueryParam("nombre") String nombre) throws Exception {
        Rol_TO rol = new Rol_TO(idRol, nombre);
        RolDAO rolDao = new RolDAOImpl();
        return rolDao.editarRol(rol);
    }
    
}
