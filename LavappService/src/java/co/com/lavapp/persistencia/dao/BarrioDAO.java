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
 * IMPLEMENTACION DEL PATRON DAO DE LA ENTIDAD BARRIO
 * CONTIENE LOS METODOS DE PERSISTENCIA
 * 
 * @author SISTEMAS
 */
public interface BarrioDAO {
    
    public List<Barrio_TO> consultarBarrios(Localidad_TO localidad) throws Exception;
    
}
