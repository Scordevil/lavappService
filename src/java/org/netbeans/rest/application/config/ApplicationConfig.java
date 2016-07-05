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
        resources.add(co.com.lavapp.servicio.impl.ConsultarBarrioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarBarriosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarBarriosSegunLocalidadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCantidadDescripcionPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCiudadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCiudadesImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCiudadesPorDepartamentoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCostoPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarCostoSubProductoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarDepartamentoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarDepartamentosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarDescripcionPedidoSegunPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarEstadoPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarEstratoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarEstratosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarHorariosSegunJornadaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarJornadaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarJornadasImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarLocalidadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarLocalidadesImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarLocalidadesSegunCiudadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPaisImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPaisesImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPedidosClienteImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPedidosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarPedidosSegunPlantaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarProductosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarProveedorImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarProveedoresImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarRolImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarRolesImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarServiciosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubProductosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubProductosSegunProductoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubServiciosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarSubServiciosSegunServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarUltimoPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarUsuarioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarUsuarioPorLoginImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarUsuarioSegunIdentificacionImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarZonaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ConsultarZonasImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarBarrioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarCiudadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarDepartamentoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarEstadoDescripcionPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarEstadoPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarEstratoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarJornadaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarLocalidadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarPaisImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarProveedorImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarRolImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarUsuarioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EditarZonaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarBarrioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarCiudadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarDepartamentoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarDescPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarEstratoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarJornadaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarLocalidadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarPaisImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarProductoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarProveedorImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarRolImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarSubProductosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarSubServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarUsuarioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.EliminarZonaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ModificarProductoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ModificarServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ModificarSubProdcutosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.ModificarSubServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarBarrioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarCalificacionImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarCiudadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarCostoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarDepartamentoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarDescPedidosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarEstratoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarHistoricoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarJornadaImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarLocalidadImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarPaisImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarPedidoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarProductoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarProveedorImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarRolImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarServiciosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarSubProductoImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarSubServicioImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarUsuariosImpl.class);
        resources.add(co.com.lavapp.servicio.impl.RegistrarZonaImpl.class);
    }
    
}
