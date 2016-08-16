/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Factura_TO;
import co.com.lavapp.persistencia.dao.FacturaDAO;
import co.com.lavapp.persistencia.dao.impl.FacturaDAOImpl;
import co.com.lavapp.servicio.EliminarFactura;
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
@Path("/eliminarFactura")
public class EliminarFacturaImpl implements EliminarFactura{

    @GET
    @Produces({"application/json"})
    @Override
    public Factura_TO eliminarFactura(@QueryParam("idFactura") int idFactura) throws Exception {
        Factura_TO factura = new Factura_TO(idFactura);
        FacturaDAO facturaDao = new FacturaDAOImpl();
        return facturaDao.eliminarFactura(factura);
    }    
}
