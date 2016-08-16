/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Historico_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface HistoricoDAO {
    
    public Historico_TO registrarHistorico(Historico_TO historico) throws Exception;
    
    public Historico_TO eliminarHistorico(Historico_TO historico) throws Exception;
    
    public Historico_TO consultarHistoricoDescripcion(DescripcionPedido_TO descripcion) throws Exception;
    
    public Historico_TO consultarHistorico(Historico_TO historico) throws Exception;
    
}
