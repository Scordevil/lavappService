/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo una Sesion
 *
 * Tabla Relacionada Sesion
 *
 * @author Planit
 */
@XmlRootElement
public class Sesion_TO {

    /**
     *
     * Columna idSesion
     */
    private int idSesion;

    /**
     *
     * Columna usuario
     */
    private String login;

    /**
     *
     * Columna contrasena
     */
    private String contrasena;

    /**
     *
     * Columna contrasena
     */
    private int idUsuario;

    //Constructores
    public Sesion_TO() {
    }

    //Constructor General
    public Sesion_TO(int idSesion, String login, String contrasena, int idUsuario) {
        this.idSesion = idSesion;
        this.login = login;
        this.contrasena = contrasena;
        this.idUsuario = idUsuario;
    }

    //Registrar Usuario Sesion
    public Sesion_TO(String login, String contrasena, int idUsuario) {
        this.login = login;
        this.contrasena = contrasena;
        this.idUsuario = idUsuario;
    }

    public Sesion_TO(String login, String contrasena) {
        this.login = login;
        this.contrasena = contrasena;
    }
    
    

    //Getter and Setter
    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Sesion_TO{" + "idSesion=" + idSesion + ", login=" + login + ", contrasena=" + contrasena + ", idUsuario=" + idUsuario + '}';
    }

}
