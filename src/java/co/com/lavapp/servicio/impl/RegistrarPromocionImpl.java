/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.persistencia.dao.PromocionDAO;
import co.com.lavapp.persistencia.dao.impl.PromocionDAOImpl;
import co.com.lavapp.servicio.RegistrarPromocion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Path("/registrarPromocion")
public class RegistrarPromocionImpl implements RegistrarPromocion {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Promocion_TO registrarPromocion(@QueryParam("fechaInicio") String fechaInicio,
            @QueryParam("fechaFinal") String fechaFinal,
            @QueryParam("porcentaje") int porcentaje,
            @QueryParam("horaInicio") String horaInicio,
            @QueryParam("horaFinal") String horaFinal,
            @QueryParam("nombre") String nombre) throws Exception {

        Date fi = new Date();
        Date ff = new Date();
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fi = formatoDeFecha.parse(fechaInicio);
            ff = formatoDeFecha.parse(fechaFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Promocion_TO promocion = new Promocion_TO(fi, ff, porcentaje, horaInicio, horaFinal, nombre);
        PromocionDAO promocionDAO = new PromocionDAOImpl();
        return promocionDAO.registrarPromocion(promocion);
    }
}
