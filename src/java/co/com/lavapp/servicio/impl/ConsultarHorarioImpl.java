/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.persistencia.dao.HorarioDAO;
import co.com.lavapp.persistencia.dao.impl.HorarioDaoImpl;
import co.com.lavapp.servicio.ConsultarHorario;
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
@Path("/consultarHorario")
public class ConsultarHorarioImpl implements ConsultarHorario {

    @GET
    @Produces({"application/json"})
    @Override
    public Horario_TO consultarHorario(@QueryParam("idHorario") int idhorario, @QueryParam("horario") String horario) throws Exception {
        Horario_TO nuevohorario = new Horario_TO(idhorario);
        nuevohorario.setHorario(horario);
        HorarioDAO horarioDao = new HorarioDaoImpl();
        return horarioDao.consultarHorario(nuevohorario);
    }
}
