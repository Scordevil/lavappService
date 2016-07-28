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
     * Columna fechaInicio
     */
    private String fechaInicioString;

    /**
     *
     * Columna horaInicio_idHorario
     */
    private Horario_TO horaInicio;

    /**
     *
     * Columna horaFinal_idHorario
     */
    private Horario_TO horaFinal;

    /**
     *
     * Columna horaFinal_idHorario
     */
    private Estado_TO estado;

    /**
     *
     * Columna idProveedor
     */
    private Proveedor_TO proveedor;

    /**
     *
     * Columna fechaentrega
     */
    private Date fechaEntrega;

    /**
     *
     * Columna fechaEntrega
     */
    private String fechaEntregaString;

    /**
     *
     * Columna direccionrecogida
     */
    private String direccionEntrega;

    /**
     *
     * Columna direccionentrega
     */
    private String direccionRecogida;

    /**
     *
     * Columna fechaRecogida
     */
    private String fechaRecogidaString;

    /**
     *
     * Columna fechaRecogida
     */
    private Date fechaRecogida;

    /**
     *
     * Columna quienentrega
     */
    private String quienEntrega;

    /**
     *
     * Columna quienrecibe
     */
    private String quienRecibe;

    /**
     *
     * Columna idbarrios_recogida
     */
    private Barrio_TO barrioRecogida;

    /**
     *
     * Columna idbarrios_entrega
     */
    private Barrio_TO barrioEntrega;

    /**
     *
     * Columna idasesor
     */
    private Usuario_TO asesor;
    //Constructores
    public Pedido_TO() {
    }

    //Constructor General
    public Pedido_TO(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido_TO(int idPedido, Usuario_TO usuario, Date fechaInicio, Horario_TO horaInicio, Horario_TO horaFinal, Estado_TO estado, Proveedor_TO proveedor, Date fechaEntrega, String direccionEntrega, String direccionRecogida, Date fechaRecogida, String quienEntrega, String quienRecibe, Barrio_TO barrioRecogida, Barrio_TO barrioEntrega) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.proveedor = proveedor;
        this.fechaEntrega = fechaEntrega;
        this.direccionEntrega = direccionEntrega;
        this.direccionRecogida = direccionRecogida;
        this.fechaRecogida = fechaRecogida;
        this.quienEntrega = quienEntrega;
        this.quienRecibe = quienRecibe;
        this.barrioRecogida = barrioRecogida;
        this.barrioEntrega = barrioEntrega;
    }
    
    // Constructor con fecha en String
        public Pedido_TO(int idPedido, Usuario_TO usuario, String fechaInicioString, Horario_TO horaInicio, Horario_TO horaFinal, Estado_TO estado, Proveedor_TO proveedor, String fechaEntregaString, String direccionEntrega, String direccionRecogida, String fechaRecogidaString, String quienEntrega, String quienRecibe, Barrio_TO barrioRecogida, Barrio_TO barrioEntrega) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.fechaInicioString = fechaInicioString;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.proveedor = proveedor;
        this.fechaEntregaString = fechaEntregaString;
        this.direccionEntrega = direccionEntrega;
        this.direccionRecogida = direccionRecogida;
        this.fechaRecogidaString = fechaRecogidaString;
        this.quienEntrega = quienEntrega;
        this.quienRecibe = quienRecibe;
        this.barrioRecogida = barrioRecogida;
        this.barrioEntrega = barrioEntrega;
    }
               
    public Pedido_TO(Usuario_TO usuario, Date fechaInicio, Horario_TO horaInicio, Horario_TO horaFinal, Estado_TO estado, Proveedor_TO proveedor, Date fechaEntrega, String direccionEntrega, String direccionRecogida, Date fechaRecogida, String quienEntrega, String quienRecibe, Barrio_TO barrioRecogida, Barrio_TO barrioEntrega) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.proveedor = proveedor;
        this.fechaEntrega = fechaEntrega;
        this.direccionEntrega = direccionEntrega;
        this.direccionRecogida = direccionRecogida;
        this.fechaRecogida = fechaRecogida;
        this.quienEntrega = quienEntrega;
        this.quienRecibe = quienRecibe;
        this.barrioRecogida = barrioRecogida;
        this.barrioEntrega = barrioEntrega;
    }

    public Pedido_TO(Usuario_TO usuario, Date fechaInicio, Horario_TO horaInicio, Horario_TO horaFinal, Estado_TO estado, Date fechaEntrega, String direccionEntrega, String direccionRecogida, Date fechaRecogida, String quienEntrega, String quienRecibe, Barrio_TO barrioRecogida, Barrio_TO barrioEntrega) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.direccionEntrega = direccionEntrega;
        this.direccionRecogida = direccionRecogida;
        this.fechaRecogida = fechaRecogida;
        this.quienEntrega = quienEntrega;
        this.quienRecibe = quienRecibe;
        this.barrioRecogida = barrioRecogida;
        this.barrioEntrega = barrioEntrega;
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

    public Horario_TO getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Horario_TO horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Horario_TO getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Horario_TO horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Estado_TO getEstado() {
        return estado;
    }

    public void setEstado(Estado_TO estado) {
        this.estado = estado;
    }

    public Proveedor_TO getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor_TO proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getDireccionRecogida() {
        return direccionRecogida;
    }

    public void setDireccionRecogida(String direccionRecogida) {
        this.direccionRecogida = direccionRecogida;
    }

    public Date getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(Date fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public String getQuienEntrega() {
        return quienEntrega;
    }

    public void setQuienEntrega(String quienEntrega) {
        this.quienEntrega = quienEntrega;
    }

    public String getQuienRecibe() {
        return quienRecibe;
    }

    public void setQuienRecibe(String quienRecibe) {
        this.quienRecibe = quienRecibe;
    }

    public Barrio_TO getBarrioRecogida() {
        return barrioRecogida;
    }

    public void setBarrioRecogida(Barrio_TO barrioRecogida) {
        this.barrioRecogida = barrioRecogida;
    }

    public Barrio_TO getBarrioEntrega() {
        return barrioEntrega;
    }

    public void setBarrioEntrega(Barrio_TO barrioEntrega) {
        this.barrioEntrega = barrioEntrega;
    }

    public String getFechaInicioString() {
        return fechaInicioString;
    }

    public void setFechaInicioString(String fechaInicioString) {
        this.fechaInicioString = fechaInicioString;
    }

    public String getFechaEntregaString() {
        return fechaEntregaString;
    }

    public void setFechaEntregaString(String fechaEntregaString) {
        this.fechaEntregaString = fechaEntregaString;
    }

    public String getFechaRecogidaString() {
        return fechaRecogidaString;
    }

    public void setFechaRecogidaString(String fechaRecogidaString) {
        this.fechaRecogidaString = fechaRecogidaString;
    }
    
    

    @Override
    public String toString() {
        return "Pedido_TO{" + "idPedido=" + idPedido + ", usuario=" + usuario + ", fechaInicio=" + fechaInicio + ", fechaInicioString=" + fechaInicioString + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", estado=" + estado + ", proveedor=" + proveedor + ", fechaEntrega=" + fechaEntrega + ", fechaEntregaString=" + fechaEntregaString + ", direccionEntrega=" + direccionEntrega + ", direccionRecogida=" + direccionRecogida + ", fechaRecogidaString=" + fechaRecogidaString + ", fechaRecogida=" + fechaRecogida + ", quienEntrega=" + quienEntrega + ", quienRecibe=" + quienRecibe + ", barrioRecogida=" + barrioRecogida + ", barrioEntrega=" + barrioEntrega + '}';
    }
    
    



}
