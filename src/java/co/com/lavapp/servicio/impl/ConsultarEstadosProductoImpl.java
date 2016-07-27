/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.persistencia.dao.EstadoDAO;
import co.com.lavapp.persistencia.dao.impl.EstadoDAOImpl;
import co.com.lavapp.servicio.ConsultarEstadosProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/consultarEstadosProducto")
public class ConsultarEstadosProductoImpl implements ConsultarEstadosProducto{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Estado_TO> consultarEstadoProducto() throws Exception {
        EstadoDAO estadoDao = new EstadoDAOImpl();
        return estadoDao.consultarEstadosProducto();
    }

}
