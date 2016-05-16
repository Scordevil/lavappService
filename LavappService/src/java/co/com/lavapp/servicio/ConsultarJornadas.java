/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Jornada_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarJornadas {

    public List<Jornada_TO> consultarJornadas() throws Exception;
    
}
