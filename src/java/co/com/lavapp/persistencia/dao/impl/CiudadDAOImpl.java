/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.persistencia.dao.CiudadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Ciudad
 *
 * @author SISTEMAS
 */
public class CiudadDAOImpl implements CiudadDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * METODOS PARA CONSULTAR CIUDADES
     *
     * @return @throws Exception
     */
    @Override
    public List<Ciudad_TO> consultarCiudades() throws Exception {

        List<Ciudad_TO> ciudades = new ArrayList<>();
        try {
            try {

                String sql = "SELECT idciudad, nombre, iddepartamento  FROM ciudad; ";

                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    ciudades.add(new Ciudad_TO(rs.getInt(1), rs.getString(2), new Departamento_TO(rs.getInt(3))));

                }

            } catch (SQLException r) {
                throw r;
            }

            ConexionSQL.CerrarConexion();

        } catch (Exception e) {
            throw e;
        }
        return ciudades;
    }

    @Override
    public List<Ciudad_TO> consultarCiudadesPorDepartamento(Departamento_TO departamento) throws Exception {
        List<Ciudad_TO> ciudades = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idciudad, nombre, iddepartamento FROM ciudad as ciudad "
                        + "WHERE ciudad.iddepartamento = '" + departamento.getIdDepartamento() + "'";
                ResultSet rs = null;
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    ciudades.add(new Ciudad_TO(rs.getInt(1), rs.getString(2), new Departamento_TO(rs.getInt(3))));
                }
            } catch (SQLException r) {
                throw r;
            } finally {
                ConexionSQL.CerrarConexion();
            }
        } catch (Exception e) {
            throw e;
        }
        return ciudades;
    }

    @Override
    public Ciudad_TO registrarCiudad(Ciudad_TO ciudad) throws Exception {
        Ciudad_TO nuevaciudad = new Ciudad_TO();
        try {
            try {
                String sql = "INSERT INTO public.ciudad(nombre, iddepartamento)"
                        + " VALUES ('" + ciudad.getNombre() + "', '" + ciudad.getDepartamento().getIdDepartamento() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevaciudad = new Ciudad_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaciudad;
    }

    @Override
    public Ciudad_TO modificarCiudad(Ciudad_TO ciudad) throws Exception {
        Ciudad_TO nuevaciudad = new Ciudad_TO();
        try {
            try {
                String sql = "UPDATE public.ciudad SET nombre = '" + ciudad.getNombre() + "',"
                        + " iddepartamento = '" + ciudad.getDepartamento().getIdDepartamento() + "'"
                        + " WHERE idciudad = '" + ciudad.getIdCiudad() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevaciudad = new Ciudad_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaciudad;
    }

    @Override
    public Ciudad_TO eliminarCiudad(Ciudad_TO ciudad) throws Exception {
        Ciudad_TO nuevaciudad = new Ciudad_TO();
        try {
            try {
                String sql = "DELETE FROM public.ciudad"
                        + " WHERE idciudad = '" + ciudad.getIdCiudad() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevaciudad = new Ciudad_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaciudad;
    }

    @Override
    public Ciudad_TO consultarCiudad(Ciudad_TO ciudad) throws Exception {

        Ciudad_TO ciudades = new Ciudad_TO();
        try {
            try {

                String sql = "SELECT idciudad, nombre, iddepartamento  FROM public.ciudad "
                        + "WHERE idciudad = '" + ciudad.getIdCiudad() + "' or nombre = '" + ciudad.getNombre() + "'";

                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    ciudades = new Ciudad_TO(rs.getInt(1), rs.getString(2), new Departamento_TO(rs.getInt(3)));

                }

            } catch (SQLException r) {
                throw r;
            } finally {
                ConexionSQL.CerrarConexion();
            }

        } catch (Exception e) {
            throw e;
        }
        return ciudades;
    }

    @Override
    public List<Ciudad_TO> buscarCiudades(String valor) throws Exception {
        List<Ciudad_TO> ciudades = new ArrayList<>();
        try {
            try {

                String sql = "SELECT c.idciudad, c.nombre, c.iddepartamento  FROM public.ciudad as c, public.departamento as d "
                        + "WHERE c.iddepartamento = d.iddepartamento and "
                        + "(c.nombre LIKE '%" + valor + "%' or d.nombre LIKE '%" + valor + "%')";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    ciudades.add(new Ciudad_TO(rs.getInt(1), rs.getString(2), new Departamento_TO(rs.getInt(3))));

                }

            } catch (SQLException r) {
                throw r;
            }

            ConexionSQL.CerrarConexion();

        } catch (Exception e) {
            throw e;
        }
        return ciudades;
    }

}
