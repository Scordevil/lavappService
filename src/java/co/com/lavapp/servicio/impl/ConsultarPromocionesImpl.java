/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.persistencia.dao.PromocionDAO;
import co.com.lavapp.persistencia.dao.impl.PromocionDAOImpl;
import co.com.lavapp.servicio.ConsultarPromociones;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarPromociones")
public class ConsultarPromocionesImpl implements ConsultarPromociones {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Promocion_TO> consultarPromociones() throws Exception {
        PromocionDAO promocionDAO = new PromocionDAOImpl();
        return promocionDAO.consultarPromociones();
    }
}
