/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.SubServicioDAO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.ConsultarSubServicios;
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
@Path("/consultarSubServicios")
public class ConsultarSubServiciosImpl implements ConsultarSubServicios {

    @GET
    @Produces({"application/json"})
    @Override
    public List<SubServicio_TO> consultarSubServicios() throws Exception {
        SubServicioDAO subServicioDao = new SubServicioDAOImpl();
        return subServicioDao.consultarSubServicios();
    }
}
