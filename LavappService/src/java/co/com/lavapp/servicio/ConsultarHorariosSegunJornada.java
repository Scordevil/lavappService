/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Horario_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarHorariosSegunJornada {
    
    public List<Horario_TO> consultarHorariosSegunJornada(int idJornada) throws Exception;
    
}
