/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.BarrioDAO;
import co.com.lavapp.persistencia.dao.impl.BarrioDAOImpl;
import co.com.lavapp.servicio.ConsultarBarriosSegunLocalidad;
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
@Path("/consultarBarriosSegunLocalidad")
public class ConsultarBarriosSegunLocalidadImpl implements ConsultarBarriosSegunLocalidad {

    @GET
    @Produces({"application/json"})
    @Override
    public List<Barrio_TO> consultarBarriosSegunLocalidad(@QueryParam("idLocalidad") int idLocalidad) throws Exception {
        Localidad_TO localidad = new Localidad_TO(idLocalidad);
        BarrioDAO barrioDao = new BarrioDAOImpl();
        return barrioDao.consultarBarriosSegunLocalidad(localidad);
    }

}
