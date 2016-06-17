/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.impl.SubServicioDAOImpl;
import co.com.lavapp.servicio.ConsultarSubservicios_SP;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/consultarSubServicios_SP")
public class ConsultarSubservicios_SPImpl implements ConsultarSubservicios_SP{

    @GET
    @Produces({"application/json"})
    @Override
    public List<SubServicio_TO> consultarSubServicios() throws Exception {
        
        List<SubServicio_TO> listaSubServ = new ArrayList<>();
        SubServicioDAOImpl subServDAO = new SubServicioDAOImpl();
        try {
            listaSubServ = subServDAO.consultarSubServicios();
        } catch (Exception e) {
            throw e;
        }
        return listaSubServ;
    }
    
}
