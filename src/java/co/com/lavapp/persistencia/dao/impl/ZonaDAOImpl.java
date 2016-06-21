/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.ZonaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ZonaDAOImpl implements ZonaDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Zona_TO> consultarZonas() throws Exception {
        List<Zona_TO> zonas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idzona, nombre, descripcion FROM public.zona";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    zonas.add(new Zona_TO(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return zonas;
    }

    @Override
    public Zona_TO consultarZona(Zona_TO zona) throws Exception {
        Zona_TO nuevaZona = new Zona_TO();
        try {
            try {
                String sql = "SELECT idzona, nombre, descripcion FROM public.zona "
                        + "WHERE idzona = '" + zona.getIdZona() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevaZona = new Zona_TO(rs.getInt(1), rs.getString(2), rs.getString(3));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaZona;
    }

    @Override
    public Zona_TO registraZona(Zona_TO zona) throws Exception {
        Zona_TO nuevaZona = new Zona_TO();
        try {
            try {
                String sql = "INSERT INTO public.zona (nombre, descripcion) "
                        + "VALUES ('" + zona.getNombre() + "','" + zona.getDescripcion() + "')";
                st.execute(sql);
            } catch (Exception e) {
                nuevaZona = new Zona_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaZona;
    }

    @Override
    public Zona_TO editarZona(Zona_TO zona) throws Exception {
        Zona_TO nuevaZona = new Zona_TO();
        try {
            try {
                String sql = "UPDATE public.zona SET nombre = '" + zona.getNombre() + "', descripcion = '" + zona.getDescripcion() + "' "
                        + "WHERE idzona = '" + zona.getIdZona() + "'";
                st.execute(sql);
            } catch (Exception e) {
                nuevaZona = new Zona_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaZona;
    }

    @Override
    public Zona_TO eliminarZona(Zona_TO zona) throws Exception {
        Zona_TO nuevaZona = new Zona_TO();
        try {
            try {
                String sql = "DELETE FROM public.zona "
                        + "WHERE idzona = '" + zona.getIdZona() + "'";              
                st.execute(sql);
            } catch (Exception e) {
                nuevaZona = new Zona_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaZona;
    }
}
