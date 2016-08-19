/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Proveedor_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface ProveedorDAO {
    
    public List<Proveedor_TO> consultarProveedores() throws Exception;
    
    public List<Proveedor_TO> BuscarProveedores(String valor) throws Exception;
    
    public Proveedor_TO consultarProveedor(Proveedor_TO proveedor) throws Exception;
    
    public Proveedor_TO registrarProveedor(Proveedor_TO proveedor_TO) throws Exception;
    
    public Proveedor_TO editarProveedor(Proveedor_TO proveedor_TO) throws Exception;
    
    public Proveedor_TO eliminarProveedor(Proveedor_TO proveedor_TO) throws Exception;
        
}
