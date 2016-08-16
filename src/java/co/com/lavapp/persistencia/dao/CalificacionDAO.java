/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public interface CalificacionDAO {
    
    public Calificacion_TO registrarCalificacion(Calificacion_TO calificacion) throws Exception;
    public List<Calificacion_TO> consultarCalificaciones() throws Exception;
    public Calificacion_TO consultarCalificacionPorPedido(Pedido_TO pedido) throws Exception;
    public Calificacion_TO modificarCalificacion(Calificacion_TO cali) throws Exception;
    public Calificacion_TO eliminarCalificacion(Calificacion_TO cali) throws Exception;
    
    
}
