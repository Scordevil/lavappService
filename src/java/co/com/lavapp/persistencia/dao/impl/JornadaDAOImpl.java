/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Jornada_TO;
import co.com.lavapp.persistencia.dao.JornadaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class JornadaDAOImpl implements JornadaDAO {

    private final Statement st = ConexionSQL.conexion();

    //Metodo Consultar jornadas
    @Override
    public List<Jornada_TO> consultarJornadas() throws Exception {
        List<Jornada_TO> jornadas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idjornada, nombre FROM public.jornada";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    jornadas.add(new Jornada_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw  e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return jornadas;
    }

    @Override
    public List<Jornada_TO> consultarJornada(Jornada_TO jornada) throws Exception {
        List<Jornada_TO> jornadas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idjornada, nombre FROM public.jornada as jornada"
                        + "WHERE jornada.idjornada = '" + jornada.getIdJornada() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    jornadas.add(new Jornada_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return jornadas;
    }
}
