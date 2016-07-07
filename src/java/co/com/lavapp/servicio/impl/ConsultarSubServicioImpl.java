/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.SubServicioDAO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.ConsultarSubServicio;
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
@Path("/consultarSubServicio")
public class ConsultarSubServicioImpl implements ConsultarSubServicio{

    
    @GET
    @Produces({"application/json"})
    @Override
    public SubServicio_TO consultarSubServicio(@QueryParam("idSubServicio") int idSubServicio,@QueryParam("nombre") String nombre) throws Exception {
        SubServicio_TO subservicio = new SubServicio_TO();
        subservicio.setIdSubServicio(idSubServicio);
        subservicio.setNombre(nombre);
        SubServicioDAO subservicioDao = new SubServicioDAOImpl();
        return subservicioDao.consultarSubServicio(subservicio);
                
    }
    
}
