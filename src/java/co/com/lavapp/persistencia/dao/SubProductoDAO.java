/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface SubProductoDAO {

    public List<SubProducto_TO> consultarSubProductoSegunProducto(Producto_TO producto) throws Exception;

    public List<SubProducto_TO> consultarSubProductos() throws Exception;

    public List<SubProducto_TO> buscarSubProductos(String valor) throws Exception;

    public SubProducto_TO consultarSubProdcuto(SubProducto_TO subProducto) throws Exception;
    
    public SubProducto_TO consultarSubProductoConCosto(SubProducto_TO subProducto) throws Exception;

    public SubProducto_TO registrarSubProducto(SubProducto_TO subProduc) throws Exception;

    public SubProducto_TO modificarSubProducto(SubProducto_TO subProduc) throws Exception;

    public SubProducto_TO eliminarSubProducto(SubProducto_TO subProduc) throws Exception;

    public List<SubProducto_TO> consultarSubProductosMasCosto(Producto_TO producto) throws Exception;
}
