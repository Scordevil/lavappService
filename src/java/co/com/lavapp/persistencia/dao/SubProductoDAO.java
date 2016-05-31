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
}
