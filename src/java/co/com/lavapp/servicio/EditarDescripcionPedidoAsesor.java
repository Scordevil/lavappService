/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.DescripcionPedido_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface EditarDescripcionPedidoAsesor {
    
    public DescripcionPedido_TO editarDescripcionPedidoAsesor(int idDescripcionPedido, int idEstado, 
            String observacionAsesor,  int idColor, String foto1, String foto2, String foto3) throws Exception;
}
