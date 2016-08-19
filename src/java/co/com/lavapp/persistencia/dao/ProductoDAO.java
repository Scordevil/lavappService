/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Producto_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ProductoDAO {
    
    public List<Producto_TO> consultarProductos() throws Exception;
    public List<Producto_TO> buscarProductos(String valor) throws Exception;
    public Producto_TO consultarProducto(Producto_TO produc) throws Exception;
    public Producto_TO registrarProducto(Producto_TO produc) throws Exception;
    public Producto_TO modificarProducto(Producto_TO produc) throws Exception;
    public Producto_TO eliminarProducto(Producto_TO produc) throws Exception;    
}
