/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Jornada_TO;
import co.com.lavapp.persistencia.dao.HorarioDAO;
import co.com.lavapp.persistencia.dao.impl.HorarioDaoImpl;
import co.com.lavapp.servicio.ConsultarHorariosSegunJornada;
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
@Path("/consultarHorariosSegunJornada")
public class ConsultarHorariosSegunJornadaImpl implements ConsultarHorariosSegunJornada{

    @GET
    @Produces({"application/json"})
    @Override
    public List<Horario_TO> consultarHorariosSegunJornada(@QueryParam("idJornada") int idJornada) throws Exception {
        Jornada_TO jornada = new Jornada_TO(idJornada);
        HorarioDAO horarioDao = new HorarioDaoImpl();
        return horarioDao.consultarHorariosSegunJornada(jornada);
       }
    
}
