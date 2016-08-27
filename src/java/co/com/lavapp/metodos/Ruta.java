/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.metodos;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desarrollo_Planit
 */
public class Ruta {

    private String ruta;

    public Ruta() {
    }

    public String getRealPath() {

        try {
            ExternalContext tmpEC;
            tmpEC = FacesContext.getCurrentInstance().getExternalContext();
            ruta = tmpEC.getRealPath("/");
            return ruta;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
