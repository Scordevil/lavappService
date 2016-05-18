/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Pedido_TO;
import java.util.Date;

/**
 *
 * @author Desarrollo_Planit
 */
public interface RegistrarPedido {
    
    public Pedido_TO registrarPedido(int idUsuario, Date fechaInicio, int idHorarioInicio, int idHorarioFinal, int idEstado) throws Exception;
}
