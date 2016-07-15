/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Costo_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface EditarCosto {
    
    public Costo_TO editarCosto(int idCosto, int valor, int idSubProducto, int idZona) throws Exception;
    
}
