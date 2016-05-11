/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import java.util.List;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Ciudad
 * 
 * @author SISTEMAS
 */
public interface CiudadDAO {
    
    public List<Ciudad_TO> consultarCiudades() throws Exception;
    
}
