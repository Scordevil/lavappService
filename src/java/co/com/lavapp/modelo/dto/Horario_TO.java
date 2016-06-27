/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Horario
 *
 * Tabla Relacionada Horario
 *
 * @author Planit
 */
@XmlRootElement
public class Horario_TO {

    /**
     *
     * Columna idHorario
     */
    private int idHorario;

    /**
     *
     * Columna horaInicio
     */
    private String horaInicio;

    /**
     *
     * Columna horaFinal
     */
    private String horaFinal;

    /**
     *
     * Columna idJornada
     */
    private Jornada_TO jornada;

    //Constructores
    public Horario_TO() {
    }

    //Constructor General

    public Horario_TO(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario_TO(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Horario_TO(String horaFinal, int quemado) {
        this.horaFinal = horaFinal;
    }
    
    
            
    public Horario_TO(int idHorario, String horaInicio, String horaFinal, Jornada_TO jornada) {
        this.idHorario = idHorario;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.jornada = jornada;
    }

    //Getter and Setter
    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Jornada_TO getJornada() {
        return jornada;
    }

    public void setJornada(Jornada_TO jornada) {
        this.jornada = jornada;
    }

    @Override
    public String toString() {
        return "Horario_TO{" + "idHorario=" + idHorario + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", jornada=" + jornada + '}';
    }

}
