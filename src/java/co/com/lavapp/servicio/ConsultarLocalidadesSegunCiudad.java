/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Localidad_TO;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ConsultarLocalidadesSegunCiudad {
    
    public List<Localidad_TO> consultarTodasLocalidadesSegunCiudad(int idCiudad)throws Exception;
    
}
