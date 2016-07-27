/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.persistencia.dao.ColorDAO;
import co.com.lavapp.persistencia.dao.impl.ColorDAOImpl;
import co.com.lavapp.servicio.ConsultarColor;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author VaioDevelopment
 */

@Stateless
@Path("/consultarColor")
public class ConsultarColorImpl implements ConsultarColor{

    @GET
    @Produces({"application/json"})
    @Override
    public Color_TO consultarColor(@QueryParam("idColor") int idColor) throws Exception {
        Color_TO color = new Color_TO(idColor);
        ColorDAO colorDao = new ColorDAOImpl();
        return colorDao.consultarColor(color);
    }

}
