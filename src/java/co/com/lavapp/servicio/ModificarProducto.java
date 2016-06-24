/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Producto_TO;

/**
 *
 * @author SISTEMAS
 */
public interface ModificarProducto {
    public Producto_TO modificarProducto(int idProducto, String nombre, String desc, int idSubServ)throws Exception;
}
