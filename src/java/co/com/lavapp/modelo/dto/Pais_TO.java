/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Pais
 *
 * Tabla Relacionada Pais
 *
 * @author Planit
 */
@XmlRootElement
public class Pais_TO {

    /**
     *
     * Columna idPais
     */
    private int idPais;

    /**
     *
     * Columna nombre
     */
    private String nombre;
    
    @Override
    public String toString() {
        return "Pais_TO{" + "idPais=" + idPais + ", nombre=" + nombre + '}';
    }

}
