/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import co.com.lavapp.persistencia.dao.impl.PedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarPedidos;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ConsultarPedidosImpl implements ConsultarPedidos{

    @Override
    public List<Pedido_TO> consultarPedidos() throws Exception {
        PedidoDAO pedidoDao = new PedidoDAOImpl();
        return pedidoDao.consultarPedidos();        
    }    
}
