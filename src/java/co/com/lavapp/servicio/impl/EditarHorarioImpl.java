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
import co.com.lavapp.servicio.EditarHorario;
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
@Path("/editarHorario")
public class EditarHorarioImpl implements EditarHorario {

    @GET
    @Produces({"application/json"})
    @Override
    public Horario_TO editarHorario(@QueryParam("idHorario") int idHorario,
            @QueryParam("horaInicio") String horaInicio,
            @QueryParam("horaFinal") String horaFinal,
            @QueryParam("idJornada") int idJornada,
            @QueryParam("horario") String horario) throws Exception {

        Horario_TO nuevoHorario = new Horario_TO(idHorario, horaInicio, horaFinal, new Jornada_TO(idJornada), horario);
        HorarioDAO horarioDao = new HorarioDaoImpl();
        return horarioDao.modificarHorario(nuevoHorario);
    }

}
