/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;

/**
 *
 * @author SISTEMAS
 */
public interface EliminarDescPedido {
    public DescripcionPedido_TO eliminarDescPedido (int idPedido, int idDescPedido) throws Exception;
}
