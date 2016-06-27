/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarPedidosASC;
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
@Path("/consultarPedidosASC")
public class ConsultarPedidosASCImpl implements ConsultarPedidosASC {

    @Override
    @GET
    @Produces({"application/json"})
    public List<Pedido_TO> consultarPedidosASC() throws Exception {
        List<Pedido_TO> listaModelo = new ArrayList<>();
        PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();

        try {
            listaModelo = pedidoDAO.consultarPedidosASC();
        } catch (Exception e) {
            throw e;
        }
        return listaModelo;
    }

}
