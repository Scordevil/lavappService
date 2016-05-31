/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface PedidoDAO {
    
    public Pedido_TO registrarPedido(Pedido_TO pedido) throws Exception;
    
    public Pedido_TO eliminarPedido(Pedido_TO pedido) throws Exception;
    
    public List<Pedido_TO> consultarPedidosCliente(Usuario_TO usuario) throws Exception;
    
    public Pedido_TO consultarPedido(Pedido_TO pedido) throws Exception;
    
    public Pedido_TO editarEstadoPedido(Pedido_TO pedido, Estado_TO estado) throws Exception;
    
    public List<Pedido_TO> consultarPedidos() throws Exception;
    
   
    
}
