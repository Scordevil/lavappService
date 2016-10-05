/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public interface ConsultarZonasAsesor {
    
    public List<Zona_TO> consultarZonasAsesor(int idUsuario) throws Exception;
    
}
