/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Jornada_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface JornadaDAO {
    
    public List<Jornada_TO> consultarJornadas() throws Exception;
    
    public List<Jornada_TO> consultarJornada(Jornada_TO jornada) throws Exception;
    
    public Jornada_TO registraJornada(Jornada_TO jornada) throws Exception;
    
    public Jornada_TO modificarJornada(Jornada_TO jornada) throws Exception;
    
    public Jornada_TO eliminarJornada(Jornada_TO jornada) throws Exception;
}
