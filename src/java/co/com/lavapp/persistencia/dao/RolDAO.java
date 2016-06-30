/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Rol_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface RolDAO {
    
    public List<Rol_TO> consultarRoles() throws Exception;
    
    public Rol_TO consultarRol(Rol_TO rol) throws Exception;
    
    public Rol_TO registrarRol(Rol_TO rol) throws Exception;
    
    public Rol_TO editarRol(Rol_TO rol) throws Exception;
    
    public Rol_TO eliminarRol(Rol_TO rol) throws Exception;    

}
