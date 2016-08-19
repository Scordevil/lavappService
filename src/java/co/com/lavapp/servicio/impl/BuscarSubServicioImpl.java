/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.SubServicioDAO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.BuscarSubServicios;
import java.util.List;
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
@Path("/buscarSubServicios")
public class BuscarSubServicioImpl implements BuscarSubServicios{

    @GET
    @Produces({"application/json"})
    @Override
    public List<SubServicio_TO> buscarSubServicio(@QueryParam("valor") String valor) throws Exception {
        SubServicioDAO subServicioDao = new SubServicioDAOImpl();
        return subServicioDao.buscarSubServicios(valor);
    }
    
}
