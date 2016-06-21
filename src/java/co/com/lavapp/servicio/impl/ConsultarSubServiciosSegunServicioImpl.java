/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.SubServicioDAO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.ConsultarSubServiciosSegunServicio;
import java.util.ArrayList;
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
@Path("/consultarSubServiciosSegunServicio")
public class ConsultarSubServiciosSegunServicioImpl implements ConsultarSubServiciosSegunServicio{

    @GET
    @Produces({"application/json"})
    @Override
    public List<SubServicio_TO> consultarSubServicios(
            @QueryParam("idServicio") int idServicio) throws Exception {
        
        Servicio_TO servicio = new Servicio_TO(idServicio);
        List<SubServicio_TO> servicios = new ArrayList<>();
        SubServicioDAO subservicioDao = new SubServicioDAOImpl();
        try {
            servicios = subservicioDao.consultarSubServicios(servicio);
        } catch (Exception e) {
            throw e;
        }
        return servicios;
    }    
}
