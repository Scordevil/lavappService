/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.EliminarSubServicio;
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
@Path("/eliminarSubServicio")
public class EliminarSubServicioImpl implements EliminarSubServicio{
    
    @GET
    @Produces({"application/json"})
    @Override
    public SubServicio_TO eliminarSubServicio(@QueryParam("idSubServicio")int idSubServicio) throws Exception {
        SubServicio_TO subserviModelo = new SubServicio_TO(idSubServicio);
        SubServicio_TO subserviSalida = new SubServicio_TO();
        SubServicioDAOImpl subDAO = new SubServicioDAOImpl();
        try {
            subserviSalida = subDAO.eliminarSubServicio(subserviModelo);
        } catch (Exception e) {
            throw e;
        }
        return subserviSalida;
    }
    
}
