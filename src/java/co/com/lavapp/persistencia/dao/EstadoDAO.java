/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface EstadoDAO {
    
    public Estado_TO consultarEstadoPedido(Pedido_TO pedido) throws Exception;
    
    public List<Estado_TO> consultarEstados() throws Exception;
    
}
