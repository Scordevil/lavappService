/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Departamento_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface DepartamentoDAO {
    
    public List<Departamento_TO> consultarDepartamentos() throws Exception;
    
    public List<Departamento_TO> buscarDepartamentos(String valor) throws Exception;
    
    public Departamento_TO consultarDepartamento(Departamento_TO departamento) throws Exception;
    
    public Departamento_TO registrarDepartamento(Departamento_TO departamento) throws Exception;
    
    public Departamento_TO modificarDepartamento(Departamento_TO departamento) throws Exception;
    
    public Departamento_TO eliminarDepartamento(Departamento_TO departamento) throws Exception;
}
