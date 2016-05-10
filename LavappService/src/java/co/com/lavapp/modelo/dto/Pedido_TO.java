/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Pedido
 *
 * Tabla Relacionada Pedido
 *
 * @author Planit
 */
@XmlRootElement
public class Pedido_TO {

    /**
     *
     * Columna idPedido
     */
    private int idPedido;

    /**
     *
     * Columna idUsuario
     */
    private Usuario_TO usuario;

    /**
     *
     * Columna fechaInicio
     */
    private Date fechaInicio;

    /**
     *
     * Columna horaInicio_idHorario
     */
    private int idHoraInicio;

    /**
     *
     * Columna horaFinal_idHorario
     */
    private int idHoraFinal;

    //Constructores
    public Pedido_TO() {
    }

    //Constructor General
    public Pedido_TO(int idPedido, Usuario_TO usuario, Date fechaInicio, int idHoraInicio, int idHoraFinal) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.idHoraInicio = idHoraInicio;
        this.idHoraFinal = idHoraFinal;
    }

    //Getter and Setter
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getIdHoraInicio() {
        return idHoraInicio;
    }

    public void setIdHoraInicio(int idHoraInicio) {
        this.idHoraInicio = idHoraInicio;
    }

    public int getIdHoraFinal() {
        return idHoraFinal;
    }

    public void setIdHoraFinal(int idHoraFinal) {
        this.idHoraFinal = idHoraFinal;
    }

    @Override
    public String toString() {
        return "Pedido_TO{" + "idPedido=" + idPedido + ", usuario=" + usuario + ", fechaInicio=" + fechaInicio + ", idHoraInicio=" + idHoraInicio + ", idHoraFinal=" + idHoraFinal + '}';
    }

}
