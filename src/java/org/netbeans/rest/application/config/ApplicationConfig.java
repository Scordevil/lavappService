/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author VaioDevelopment
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.com.lavapp.servicio.impl.ConsultarCantidadDescripcionPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCiudadesImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarDescripcionPedidoSegunPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarEstadoPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarHorariosSegunJornadaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarJornadasImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarLocalidadesImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPedidosClienteImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarProductosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarServiciosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubProductosSegunProducto.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubServiciosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarUsuarioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarUsuarioSesionImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarEstadoDescripcionPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarEstadoPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarUsuarioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarUsuarioSesionImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarUsuariosImpl.class);
    }
    
}