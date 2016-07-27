/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.persistencia.dao.ColorDAO;
import co.com.lavapp.persistencia.dao.impl.ColorDAOImpl;
import co.com.lavapp.servicio.ConsultarColores;
import java.util.List;
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
@Path("/consultarColores")
public class ConsultarColoresImpl implements ConsultarColores{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Color_TO> consultarColores() throws Exception {
        ColorDAO colorDao = new ColorDAOImpl();
        return colorDao.consultarColores();
    }

}
