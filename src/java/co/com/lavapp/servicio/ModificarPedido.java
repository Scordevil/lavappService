/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Pedido_TO;

/**
 *
 * @author SISTEMAS
 */
public interface ModificarPedido {
    
    public Pedido_TO modificarPedido(int idPedido, int idUsuario, String fechaInicio, int horainiIdhorario, 
            int horafinIdHorario, int idEstado, int idProveedor) throws Exception;
    
}
