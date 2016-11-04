/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.persistencia.dao.PromocionDAO;
import co.com.lavapp.persistencia.dao.impl.PromocionDAOImpl;
import co.com.lavapp.servicio.EliminarPromocion;
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
@Path("/eliminarPromocion")
public class EliminarPromocionImpl implements EliminarPromocion{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Promocion_TO eliminarPromocion(@QueryParam("idPromocion") int idPromocion) throws Exception {
        Promocion_TO promocion = new Promocion_TO(idPromocion);
        PromocionDAO promocionDAO = new PromocionDAOImpl();
        return promocionDAO.eliminarPromocion(promocion);
    }    
}
