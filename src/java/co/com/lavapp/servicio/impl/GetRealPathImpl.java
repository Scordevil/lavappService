/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.metodos.Ruta;
import co.com.lavapp.servicio.GetRealPath;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/getRealPath")
public class GetRealPathImpl implements GetRealPath {

    @GET
    @Produces({"application/json"})
    @Override
    public String getRealPath() throws Exception {
        Ruta ruta = new Ruta();
        return ruta.getRealPath();
    }

}
