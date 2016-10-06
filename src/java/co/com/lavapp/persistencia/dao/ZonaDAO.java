/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ZonaDAO {

    public List<Zona_TO> consultarZonas() throws Exception;

    public List<Zona_TO> buscarZonas(String valor) throws Exception;
    
    public Zona_TO consultarZona(Zona_TO zona) throws Exception;
    
    public List<Zona_TO> consultarZonasAsesor(Usuario_TO asesor) throws Exception;
    
    public int consultarZonaYaAsociada(Usuario_TO asesor, Zona_TO zona) throws Exception;

    public Zona_TO registraZona(Zona_TO zona) throws Exception;

    public Zona_TO editarZona(Zona_TO zona) throws Exception;

    public Zona_TO eliminarZona(Zona_TO zona) throws Exception;

    public int eliminarAsociacionZona(Usuario_TO usuario, Zona_TO zona) throws Exception;
}
