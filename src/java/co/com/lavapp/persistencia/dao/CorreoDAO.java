/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

/**
 *
 * @author Desarrollo_Planit
 */
public interface CorreoDAO {
    
    public int enviarMensajeBienvenido();
    
    public void enviarMensajeNuevaContraseña();
    
    public void enviarMensajeMalaCalificacion();
    
}
