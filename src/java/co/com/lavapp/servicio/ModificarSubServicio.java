/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.SubServicio_TO;

/**
 *
 * @author SISTEMAS
 */
public interface ModificarSubServicio {
    
    public SubServicio_TO modificarSubServicio(int idSubServicio ,String nombre , int idServicio)throws Exception;
    
}
