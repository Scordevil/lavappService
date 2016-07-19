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
public interface RegistrarDescripcionPedido {
    public DescripcionPedido_TO registrarDescripcionPedido(int idEstado, int idPedido, int idSubProducto) throws Exception;
}