/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Jornada_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface HorarioDAO {

    public List<Horario_TO> consultarHorariosSegunJornada(Jornada_TO jornada) throws Exception;

    public Horario_TO consultarHorario(Horario_TO horario) throws Exception;

    public Horario_TO registrarHorario(Horario_TO horario) throws Exception;

    public Horario_TO modificarHorario(Horario_TO horario) throws Exception;

    public Horario_TO eliminarHorario(Horario_TO horario) throws Exception;
}
