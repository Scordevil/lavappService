/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.ProveedorDAO;
import co.com.lavapp.persistencia.dao.impl.ProveedorDAOImpl;
import co.com.lavapp.servicio.RegistrarProveedor;
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
@Path("/registrarProveedor")
public class RegistrarProveedorImpl implements RegistrarProveedor{

    @GET
    @Produces({"application/json"})
    @Override
    public Proveedor_TO registrarProveedor(@QueryParam("razonSocial") String razonSocial, 
            @QueryParam("nit") String nit, 
            @QueryParam("telefono") String telefono, 
            @QueryParam("direccion") String direccion, 
            @QueryParam("idUsuario") int idUsuario, 
            @QueryParam("cupo") int cupo, 
            @QueryParam("idZona") int idZona) throws Exception {
        
        Proveedor_TO proveedor = new Proveedor_TO(razonSocial, nit, telefono, direccion, new Usuario_TO(idUsuario), cupo, new Zona_TO(idZona));
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        
        return proveedorDAO.registrarProveedor(proveedor);
    }
    
}
