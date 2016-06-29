/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarUltimoPedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author SISTEMAS
 */
@Stateless
@Path("/consultarUltimoPedido")
public class ConsultarUltimoPedidoImpl implements ConsultarUltimoPedido {

    @Override
    @GET
    @Produces({"application/json"})
    public Pedido_TO consultarUltimoPedido(@QueryParam("idUsuario") int idUsuario) throws Exception {
        Usuario_TO usuario = new Usuario_TO(idUsuario);
        PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
        return pedidoDAO.consultarUltimoPedido(usuario);        
    }

}
