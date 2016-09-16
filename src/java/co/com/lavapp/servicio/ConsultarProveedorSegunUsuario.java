/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Proveedor_TO;

/**
 *
 * @author VaioDevelopment
 */
public interface ConsultarProveedorSegunUsuario {
    
    public Proveedor_TO consultarProveedorSegunUsuario(int idUsuario) throws Exception;

}
