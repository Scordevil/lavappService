/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.FormaPago_TO;
import co.com.lavapp.persistencia.dao.FormaPagoDAO;
import co.com.lavapp.persistencia.dao.impl.FormaPagoDAOImpl;
import co.com.lavapp.servicio.ConsultarFormaPago;
import javax.ejb.Stateless;
import javax.inject.Qualifier;
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
@Path("/consultarFormaPago")
public class ConsultarFormaPagoImpl implements ConsultarFormaPago {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public FormaPago_TO consultarFormaPago(@QueryParam("idFormaPago") int idFormaPago, @QueryParam("nombre") String nombre) throws Exception {
        FormaPago_TO formapago = new FormaPago_TO(idFormaPago, nombre);
        FormaPagoDAO formaPagoDAO = new FormaPagoDAOImpl();
        return formaPagoDAO.consultarFormaPago(formapago);
    }

}
