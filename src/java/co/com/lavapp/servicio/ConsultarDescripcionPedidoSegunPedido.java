/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ConsultarDescripcionPedidoSegunPedido {
    
    public List<DescripcionPedido_TO> consultarDescripcionPedidoSegunPedido(int idPedido) throws Exception;
    
}
