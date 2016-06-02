/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.persistencia.dao.CalificacionDAO;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Desarrollo_Planit
 */
public class CalificacionDAOImpl implements CalificacionDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Calificacion_TO registrarCalificacion(Calificacion_TO calificacion) throws Exception {
        Calificacion_TO nuevaCalificacion = new Calificacion_TO();
        try {
            try {
                String sql = "INSERT INTO public.calificacion("
                        + " calificacion, observacion, idpedido)"
                        + " VALUES (" + calificacion.getCalificacion() + ","
                        + "" + calificacion.getObservacion() + ", "
                        + "" + calificacion.getPedido().getIdPedido() + ")";

                st.execute(sql);
            } catch (SQLException e) {
                nuevaCalificacion = new Calificacion_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaCalificacion;
    }

}
