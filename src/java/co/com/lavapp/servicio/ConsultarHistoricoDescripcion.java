/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Historico_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarHistoricoDescripcion {
 
    public Historico_TO consultarHistoricoDescripcion(int idDescripcionPedido) throws Exception;
}
