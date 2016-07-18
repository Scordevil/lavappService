/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Pedido_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface RegistrarPedidoWeb {
    
    public Pedido_TO registrarPedidoWeb(int idUsuario, 
            String fechaInicio, 
            int idHoraInicio,
            int idHoraFinal,
            int idEstado,            
            String fechaEntrega,
            String direccionEntrega,
            String direccionRecogida,
            String fechaRecogida,
            String quienEntrega,
            String quienRecibe,
            int idBarrioRecogida,
            int idBarrioEntrega) throws Exception;
    
}
