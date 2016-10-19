/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.metodos.GenerarReportes;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.CorreoDAO;
import co.com.lavapp.persistencia.dao.impl.CorreoDAOImpl;
import co.com.lavapp.servicio.EnviarOrdenServicioAsesor;
import javax.ejb.Stateless;
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
@Path("/enviarOrdenServicio")
public class EnviarOrdenServicioAsesorImpl implements EnviarOrdenServicioAsesor {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int enviarOrdenServicioAsesor(@QueryParam("email") String email, @QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        Usuario_TO usuario = new Usuario_TO();
        usuario.setEmail(email);
        
        GenerarReportes gr = new GenerarReportes();
        gr.generarOrdenTrabajoEnContexto(pedido);
        CorreoDAO correoDao = new CorreoDAOImpl();
        return correoDao.enviarOrdenServicioAsesor(usuario, pedido, gr.rutaDocumento);
    }

}
