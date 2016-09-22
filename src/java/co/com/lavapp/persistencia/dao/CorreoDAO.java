/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Usuario_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface CorreoDAO {

    public int enviarMensajeBienvenido(Usuario_TO usuario);

    public int enviarMensajeNuevaContraseña(Usuario_TO usuario);

    public int enviarMensajeMalaCalificacion(Usuario_TO usuario);

    public int enviarMensajeAgendamiento(Usuario_TO usuario);

    public int enviarMensajeRecibidoAlCliente(Usuario_TO usuario);
    
    public int enviarMensajeRecibidoALaPlanta(Usuario_TO usuario);

    public int enviarMensajeRecibidoDePlanta(Usuario_TO usuario);

    public int enviarMensajeRecibidoDelCliente(Usuario_TO usuario);
    
}
