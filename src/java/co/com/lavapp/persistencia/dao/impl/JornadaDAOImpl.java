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
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return jornadas;
    }

    @Override
    public Jornada_TO consultarJornada(Jornada_TO jornada) throws Exception {
        Jornada_TO jornadas = new Jornada_TO();
        try {
            try {
                String sql = "SELECT idjornada, nombre FROM public.jornada "
                        + "WHERE idjornada = '" + jornada.getIdJornada() + "' or nombre = '" + jornada.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    jornadas = new Jornada_TO(rs.getInt(1), rs.getString(2));
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

    @Override
    public Jornada_TO registraJornada(Jornada_TO jornada) throws Exception {
        Jornada_TO nuevajornada = new Jornada_TO();
        try {
            try {
                String sql = "INSERT INTO public.jornada(nombre) "
                        + "VALUES('" + jornada.getNombre() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevajornada = new Jornada_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevajornada;
    }

    @Override
    public Jornada_TO modificarJornada(Jornada_TO jornada) throws Exception {
        Jornada_TO nuevajornada = new Jornada_TO();
        try {
            try {
                String sql = " UPDATE public.jornada SET nombre = '" + jornada.getNombre() + "' "
                        + "WHERE idjornada = '" + jornada.getIdJornada() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevajornada = new Jornada_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevajornada;
    }

    @Override
    public Jornada_TO eliminarJornada(Jornada_TO jornada) throws Exception {
        Jornada_TO nuevajornada = new Jornada_TO();
        try {
            try {
                String sql = "DELETE FROM public.jornada "
                        + "WHERE idjornada = '" + jornada.getIdJornada() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevajornada = new Jornada_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevajornada;
    }

    @Override
    public List<Jornada_TO> buscarJornadas(String valor) throws Exception {
        List<Jornada_TO> jornadas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idjornada, nombre FROM public.jornada "
                        + "WHERE idjornada LIKE '%" + valor + "%' or nombre LIKE '%" + valor + "%'";
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
