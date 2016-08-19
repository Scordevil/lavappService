/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import java.util.List;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Localidad
 * 
 * @author SISTEMAS
 */
public interface LocalidadDAO {
    
    public List<Localidad_TO> consultarLocalidades() throws Exception;
    
    public List<Localidad_TO> consultarLocalidadesSegunCiudad(Ciudad_TO ciudad) throws Exception;
    
    public List<Localidad_TO> buscarLocalidades(String valor) throws Exception;
    
    public Localidad_TO consultarLocalidad(Localidad_TO localidad) throws Exception;
     
    public Localidad_TO registrarLocalidad(Localidad_TO localidad) throws Exception;
    
    public Localidad_TO modificarLocalidad(Localidad_TO localidad) throws Exception;
    
    public Localidad_TO eliminarLocalidad(Localidad_TO localidad) throws Exception;
        
}
