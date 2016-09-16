/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.BuscarPedido;
import java.util.List;
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
@Path("/buscarPedido")
public class BuscarPedidoImpl implements BuscarPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public List<Pedido_TO> buscarPedido(@QueryParam("valor") String valor, @QueryParam("idusuario") int idusuario) throws Exception {
        PedidoDAO pedidoDao = new PedidoDAOImpl();
        Usuario_TO usuario = new Usuario_TO(idusuario);
        return pedidoDao.buscarPedido(valor, usuario);
    }
}
