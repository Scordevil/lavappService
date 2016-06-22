/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Estrato_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface EstratoDAO {
    
    public Estrato_TO consultarEstrato(Estrato_TO estrato) throws Exception;
    
    public List<Estrato_TO> consultarEstratos() throws Exception;
    
    public Estrato_TO registrarEstrato(Estrato_TO estrato) throws Exception;
    
    public Estrato_TO editarEstrato(Estrato_TO estrato) throws Exception;
    
    public Estrato_TO eliminarEstrato(Estrato_TO estrato) throws Exception;
}
