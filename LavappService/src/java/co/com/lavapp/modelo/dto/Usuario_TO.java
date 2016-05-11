/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Usuario
 *
 * Tabla Relacionada Usuario
 *
 * @author Planit
 */
@XmlRootElement
public class Usuario_TO {

    /**
     *
     * Columna idUsuario
     */
    private int idUsuario;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna telefono
     */
    private String telefono;

    /**
     *
     * Columna idBarrios
     */
    private Barrio_TO barrio;

    /**
     *
     * Columna idRol
     */
    private Rol_TO rol;

    /**
     *
     * Columna idEstado
     */
    private Estado_TO estado;

    /**
     *
     * Extra idSesion
     */
    private Sesion_TO sesion;

    //Constructores
    public Usuario_TO() {
    }

    //Constructo General
    public Usuario_TO(int idUsuario, String nombre, String telefono, Barrio_TO barrio, Rol_TO rol, Estado_TO estado, Sesion_TO sesion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.barrio = barrio;
        this.rol = rol;
        this.estado = estado;
        this.sesion = sesion;
    }
    
    //Registrar Usuarios

    public Usuario_TO(String nombre, String telefono, Barrio_TO barrio, Rol_TO rol, Estado_TO estado, Sesion_TO sesion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.barrio = barrio;
        this.rol = rol;
        this.estado = estado;
        this.sesion = sesion;
    }

    public Usuario_TO(Sesion_TO sesion) {
        this.sesion = sesion;
    }

    public Usuario_TO(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
      

    //Getter and Setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Barrio_TO getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio_TO barrio) {
        this.barrio = barrio;
    }

    public Rol_TO getRol() {
        return rol;
    }

    public void setRol(Rol_TO rol) {
        this.rol = rol;
    }

    public Estado_TO getEstado() {
        return estado;
    }

    public void setEstado(Estado_TO estado) {
        this.estado = estado;
    }

    public Sesion_TO getSesion() {
        return sesion;
    }

    public void setSesion(Sesion_TO sesion) {
        this.sesion = sesion;
    }

    @Override
    public String toString() {
        return "Usuario_TO{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", barrio=" + barrio + ", rol=" + rol + ", estado=" + estado + ", sesion=" + sesion + '}';
    }

}
