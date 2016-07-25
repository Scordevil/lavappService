/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.CantTemp_TO;
import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface DescripcionPedidoDAO {

    public CantTemp_TO consultarCantidadDescripcionPedido(Pedido_TO pedido) throws Exception;

    public List<DescripcionPedido_TO> consultarDescripcionPedidoSegunPedido(Pedido_TO pedido) throws Exception;
    
    public DescripcionPedido_TO editarEstadoDescripcionPedido(DescripcionPedido_TO descripcion, Estado_TO estado) throws Exception;
   
    public DescripcionPedido_TO consultarDescripcionPedidoSegunProducto(DescripcionPedido_TO descripcion) throws Exception;

    public DescripcionPedido_TO registrarDescripcion(DescripcionPedido_TO descripcion) throws Exception;

    public DescripcionPedido_TO editarDescripcion(DescripcionPedido_TO descripcion) throws Exception;
    
    public DescripcionPedido_TO eliminarDescripcion(DescripcionPedido_TO descripcion) throws Exception;
    
    public DescripcionPedido_TO eliminarDescripcionesSegunPedido(Pedido_TO pedido) throws Exception;

}
