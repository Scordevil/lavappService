/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Factura_TO;
import co.com.lavapp.persistencia.dao.FacturaDAO;
import co.com.lavapp.persistencia.dao.impl.FacturaDAOImpl;
import co.com.lavapp.servicio.ConsultarFacturas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarFacturas")
public class ConsultarFacturasImpl implements ConsultarFacturas{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Factura_TO> consultarFacturas() throws Exception {
        FacturaDAO facturaDao = new FacturaDAOImpl();
        return facturaDao.consultarFacturas();
    }
    
}
