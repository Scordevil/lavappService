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

    public String editarDescripcionPedidoAsesor(int idDescripcionPedido, int idEstado,
            String observacionAsesor, int idColor, String foto1, String foto2, String foto3, String codigo, String nombrefoto1, String nombrefoto2, String nombrefoto3) throws Exception;
}
