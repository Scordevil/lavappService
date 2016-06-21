/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.impl.SubProductoDAOImpl;
import co.com.lavapp.servicio.ConsultarSubProducto;
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
@Path("/consultarSubProductos")
public class ConsultarSubProductoImpl implements ConsultarSubProducto{

    @GET
    @Produces({"application/json"})
    @Override
    public List<SubProducto_TO> consultarSubProducto() throws Exception {
        
        List<SubProducto_TO> listaModelo = new ArrayList<>();
        SubProductoDAOImpl subProDAO = new SubProductoDAOImpl();
        
        listaModelo = subProDAO.consultarSubProducto();
        return listaModelo;
    }
    
}
