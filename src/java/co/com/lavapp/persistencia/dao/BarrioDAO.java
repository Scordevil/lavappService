/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface BarrioDAO {
   
    public List<Barrio_TO> consultarBarriosSegunLocalidad(Localidad_TO localidad) throws Exception;
    
    public List<Barrio_TO> consultarBarrios() throws Exception;
    
    public Barrio_TO consultarBarrio(Barrio_TO barrio) throws Exception;
    
    public Barrio_TO registrarBarrio(Barrio_TO barrio) throws Exception;
    
    public Barrio_TO modificarBarrio(Barrio_TO barrio) throws Exception;
    
    public Barrio_TO eliminarBarrio(Barrio_TO barrio) throws Exception;
           
}
