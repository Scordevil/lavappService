/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.LocalidadDAO;
import co.com.lavapp.persistencia.dao.impl.LocalidadDAOImpl;
import co.com.lavapp.servicio.BuscarLocalidades;
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
@Path("/buscarLocalidades")
public class BuscarLocalidadesImpl implements BuscarLocalidades{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Localidad_TO> buscarLocalidades(@QueryParam("valor") String valor) throws Exception {
        LocalidadDAO localidadDao = new LocalidadDAOImpl();
        return localidadDao.buscarLocalidades(valor);
    }
    
    
}
