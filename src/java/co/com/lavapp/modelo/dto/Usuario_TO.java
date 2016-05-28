/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import java.util.logging.Logger;
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
     * Columna apellido
     */
    private String apellido;
    /**
     *
     * Columna genero
     */
    private String genero;
    /**
     *
     * Columna movil
     */
    private String movil;
    /**
     *
     * Columna descripcion
     */
    private String direccion;
    /**
     *
     * Columna idCiudad
     */
    private Ciudad_TO ciudad;

    //Constructores
    public Usuario_TO() {
    }

    public Usuario_TO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario_TO(int idUsuario, String nombre, String telefono, Barrio_TO barrio, Rol_TO rol, Estado_TO estado, String login, String contrasena, String apellido, String genero, String movil, String direccion, Ciudad_TO ciudad) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.barrio = barrio;
        this.rol = rol;
        this.estado = estado;
        this.login = login;
        this.contrasena = contrasena;
        this.apellido = apellido;
        this.genero = genero;
        this.movil = movil;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    //Registrar Usuarios

    public Usuario_TO(String nombre, String telefono, Barrio_TO barrio, Rol_TO rol, Estado_TO estado, String login, String contrasena, String apellido, String genero, String movil, String direccion, Ciudad_TO ciudad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.barrio = barrio;
        this.rol = rol;
        this.estado = estado;
        this.login = login;
        this.contrasena = contrasena;
        this.apellido = apellido;
        this.genero = genero;
        this.movil = movil;
        this.direccion = direccion;
        this.ciudad = ciudad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public Ciudad_TO getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad_TO ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Usuario_TO{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", barrio=" + barrio + ", rol=" + rol + ", estado=" + estado + ", usuario=" + login + ", contrasena = " + contrasena + ", apellido = " + apellido + ", genero = " + genero + ", movil = " + movil + ", direccion = " + direccion + ", ciudad = " + ciudad + "}";
    }

}
