/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Factura_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.FacturaDAO;
import co.com.lavapp.persistencia.dao.impl.FacturaDAOImpl;
import co.com.lavapp.servicio.RegistrarFactura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Path("/registrarFactura")
public class RegistrarFacturaImpl implements RegistrarFactura {

    @GET
    @Produces({"application/json"})
    @Override
    public Factura_TO registrarFactura(@QueryParam("total") double total,
            @QueryParam("subTotal") double subTotal,
            @QueryParam("neto") double neto,
            @QueryParam("iva") double iva,
            @QueryParam("descuento") double descuento,
            @QueryParam("fecha") String fecha,
            @QueryParam("idPedido") int idPedido) throws Exception {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date f = new Date();
        try {
            f = formatoDeFecha.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Factura_TO factura = new Factura_TO(total, subTotal, neto, iva, descuento, f, new Pedido_TO(idPedido));
        FacturaDAO facturaDao = new FacturaDAOImpl();
        return facturaDao.registrarFactura(factura);
    }

}
