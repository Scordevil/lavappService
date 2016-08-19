/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.persistencia.dao.ProveedorDAO;
import co.com.lavapp.persistencia.dao.impl.ProveedorDAOImpl;
import co.com.lavapp.servicio.BuscarProveedores;
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
@Path("/buscarProveedores")
public class BuscarProveedoresImpl implements BuscarProveedores{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Proveedor_TO> buscarProveedores(@QueryParam("valor") String valor) throws Exception {
        ProveedorDAO proveedorDao = new ProveedorDAOImpl();
        return proveedorDao.BuscarProveedores(valor);
    }
    
}
