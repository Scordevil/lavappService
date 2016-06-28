/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Pais_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface PaisDAO {

    public Pais_TO consultarPais(Pais_TO pais) throws Exception;
    
    public List<Pais_TO> consultarPaises() throws Exception;

    public Pais_TO registrarPais(Pais_TO pais) throws Exception;

    public Pais_TO modificarPais(Pais_TO pais) throws Exception;

    public Pais_TO eliminarPais(Pais_TO pais) throws Exception;    
    
}
