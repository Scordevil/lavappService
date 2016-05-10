/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Costo
 *
 * Tabla Relacionada Costo
 *
 * @author Planit
 */
@XmlRootElement
public class Costo_TO {

    /**
     *
     * Columna idCosto
     */
    private int idCosto;

    /**
     *
     * Columna valor
     */
    private int valor;

    /**
     *
     * Columna idCosto
     */
    private Producto_TO producto;

    /**
     *
     * Columna idCosto
     */
    private Estrato_TO estrato;

    //Constructores
    public Costo_TO() {
    }

    //Constructor General
    public Costo_TO(int idCosto, int valor, Producto_TO producto, Estrato_TO estrato) {
        this.idCosto = idCosto;
        this.valor = valor;
        this.producto = producto;
        this.estrato = estrato;
    }

    //Getter and Setter
    public int getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(int idCosto) {
        this.idCosto = idCosto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Producto_TO getProducto() {
        return producto;
    }

    public void setProducto(Producto_TO producto) {
        this.producto = producto;
    }

    public Estrato_TO getEstrato() {
        return estrato;
    }

    public void setEstrato(Estrato_TO estrato) {
        this.estrato = estrato;
    }

    @Override
    public String toString() {
        return "Costo_TO{" + "idCosto=" + idCosto + ", valor=" + valor + ", producto=" + producto + ", estrato=" + estrato + '}';
    }

}
