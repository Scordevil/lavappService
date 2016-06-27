/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VaioDevelopment
 */
@XmlRootElement
public class CantTemp_TO {
    
    private int cantDescripPedido;

    public int getCantDescripPedido() {
        return cantDescripPedido;
    }

    public void setCantDescripPedido(int cantDescripPedido) {
        this.cantDescripPedido = cantDescripPedido;
    }

    @Override
    public String toString() {
        return "CantTemp{" + "cantDescripPedido=" + cantDescripPedido + '}';
    }  
    
}
