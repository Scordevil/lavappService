/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.persistencia.dao.PromocionDAO;
import co.com.lavapp.persistencia.dao.impl.PromocionDAOImpl;
import co.com.lavapp.servicio.ConsultarPromocion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarPromocion")
public class ConsultarPromocionImpl implements ConsultarPromocion{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Promocion_TO consultarPromocion(@QueryParam("idPromocion") int idPromocion, 
            @QueryParam("nombre") String nombre) throws Exception {
        
        Promocion_TO promocion = new Promocion_TO(idPromocion, nombre);
        PromocionDAO promocionDAO = new PromocionDAOImpl();
        return promocionDAO.consultarPromocion(promocion);
        
    }    
}
