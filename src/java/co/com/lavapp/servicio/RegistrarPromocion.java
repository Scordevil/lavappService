/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

/**
 *
 * @author VaioDevelopment
 */
public interface RegistrarPromocion {
    
    public void registrarPromocion(String fechaInicio,
            String fechaFinal,
            int porcentaje,
            String horaInicio,
            String horaFinal,
            String nombre) throws Exception;
}
