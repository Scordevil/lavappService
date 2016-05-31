/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Historico_TO;
import co.com.lavapp.persistencia.dao.HistoricoDAO;
import co.com.lavapp.persistencia.dao.impl.HistoricoDAOImpl;
import co.com.lavapp.servicio.RegistrarHistorico;
import java.util.Date;
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
@Path("/registrarHistorico")
public class RegistrarHistoricoImpl implements RegistrarHistorico {

    @GET
    @Produces({"application/json"})
    @Override
    public Historico_TO registrarHistorico(@QueryParam("idDescripcionPedido") int idDescripcionPedido,
            @QueryParam("idEstado") int idEstado) throws Exception {
        Date fechaActual = new Date();
        Historico_TO historico = new Historico_TO(new DescripcionPedido_TO(idDescripcionPedido), new Estado_TO(idEstado), fechaActual);
        HistoricoDAO historicoDao = new HistoricoDAOImpl();
        return historicoDao.registrarHistorico(historico);
    }

}
