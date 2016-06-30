/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.persistencia.dao.RolDAO;
import co.com.lavapp.persistencia.dao.impl.RolDAOImpl;
import co.com.lavapp.servicio.ConsultarRoles;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarRoles")
public class ConsultarRolesImpl implements ConsultarRoles{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Rol_TO> consultarRoles() throws Exception {
        RolDAO rolDao = new RolDAOImpl();
        return rolDao.consultarRoles();
    }    
}
