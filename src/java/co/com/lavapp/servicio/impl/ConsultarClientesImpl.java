/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.ConsultarClientes;
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
@Path("/consultarClientes")
public class ConsultarClientesImpl implements ConsultarClientes{

    @Override
    @GET
    @Produces({"application/json"})
    public List<Usuario_TO> consultarClientes() throws Exception {
        
        List<Usuario_TO> listaModelo = new ArrayList<>();
        UsuarioDAOImpl usuaDAO = new UsuarioDAOImpl();
        
        listaModelo = usuaDAO.consultarUsuarioClientes();
        return listaModelo;
        
    }
    
}
