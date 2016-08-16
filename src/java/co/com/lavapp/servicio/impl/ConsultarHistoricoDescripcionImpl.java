/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Historico_TO;
import co.com.lavapp.persistencia.dao.HistoricoDAO;
import co.com.lavapp.persistencia.dao.impl.HistoricoDAOImpl;
import co.com.lavapp.servicio.ConsultarHistoricoDescripcion;
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
@Path("/consultarHistoricoDescripcion")
public class ConsultarHistoricoDescripcionImpl implements ConsultarHistoricoDescripcion {

    @GET
    @Produces({"application/json"})
    @Override
    public Historico_TO consultarHistoricoDescripcion(@QueryParam("idDescripcionPedido") int idDescripcionPedido) throws Exception {
        DescripcionPedido_TO descripcion = new DescripcionPedido_TO(idDescripcionPedido);
        HistoricoDAO historicoDao = new HistoricoDAOImpl();
        return historicoDao.consultarHistoricoDescripcion(descripcion);
    }
}
