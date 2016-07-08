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
import co.com.lavapp.servicio.RegistrarHorario;
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
@Path("/registrarHorario")
public class RegistrarHorarioImpl implements RegistrarHorario{

    @GET
    @Produces({"application/json"})
    @Override
    public Horario_TO registrarHorario(@QueryParam("horaInicio") String horainicio, 
            @QueryParam("horaFinal") String horafinal,
            @QueryParam("idJornada") int idjornada,
            @QueryParam("horario") String horario) throws Exception {
        
        Horario_TO nuevohorario = new Horario_TO(horainicio, horafinal, new Jornada_TO(idjornada), horario);
        HorarioDAO horarioDao = new HorarioDaoImpl();
        return horarioDao.registrarHorario(nuevohorario);
    }    
}
