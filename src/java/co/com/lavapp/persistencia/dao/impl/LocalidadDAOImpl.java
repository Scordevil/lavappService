/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.LocalidadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implementacion que contiene los metodos de persistencia relacionados con la
 * entidad Localidad
 *
 * @author SISTEMAS
 */
public class LocalidadDAOImpl implements LocalidadDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Localidad_TO> consultarLocalidadesSegunCiudad(Ciudad_TO ciudad) throws Exception {

        List<Localidad_TO> localidades = new ArrayList<>();
        try {
            try {
                String sql = "SELECT localidad.idlocalidad, localidad.nombre, localidad.idciudad "
                        + "  FROM public.localidad , public.ciudad "
                        + "  WHERE " + ciudad.getIdCiudad() + " = localidad.idciudad and"
                        + "  ciudad.idciudad = localidad.idciudad ;";

                ResultSet rs = null;
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    localidades.add(new Localidad_TO(rs.getInt(1), rs.getString(2), new Ciudad_TO(rs.getInt(3))));
                }
            } catch (SQLException r) {
                throw r;
            }
        } catch (Exception e) {
            throw e;
        }
        ConexionSQL.CerrarConexion();
        return localidades;
    }

    @Override
    public Localidad_TO consultarLocalidad(Localidad_TO localidad) throws Exception {
        Localidad_TO nuevalocalidad = new Localidad_TO();
        try {
            try {
                String sql = "SELECT idlocalidad, nombre, idciudad FROM public.localidad as localidad "
                        + "WHERE localidad.idlocalidad = '" + localidad.getIdLocalidad() + "' or localidad.nombre = '" + localidad.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevalocalidad = new Localidad_TO(rs.getInt(1), rs.getString(2), new Ciudad_TO(rs.getInt(3)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevalocalidad;
    }

    @Override
    public Localidad_TO registrarLocalidad(Localidad_TO localidad) throws Exception {
        Localidad_TO nuevalocalidad = new Localidad_TO();
        try {
            try {
                String sql = "INSERT INTO public.localidad (nombre, idciudad)"
                        + " VALUES ('" + localidad.getNombre() + "','" + localidad.getCiudad().getIdCiudad() + "')";
                st.execute(sql);
            } catch (Exception e) {
                nuevalocalidad = new Localidad_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevalocalidad;
    }

    @Override
    public Localidad_TO modificarLocalidad(Localidad_TO localidad) throws Exception {
        Localidad_TO nuevalocalidad = new Localidad_TO();
        try {
            try {
                String sql = "UPDATE public.localidad SET nombre = '" + localidad.getNombre() + "',"
                        + " idciudad = '" + localidad.getCiudad().getIdCiudad() + "'"
                        + " WHERE idlocalidad = '" + localidad.getIdLocalidad() + "'";

                st.execute(sql);
            } catch (Exception e) {
                nuevalocalidad = new Localidad_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevalocalidad;
    }

    @Override
    public Localidad_TO eliminarLocalidad(Localidad_TO localidad) throws Exception {
        Localidad_TO nuevalocalidad = new Localidad_TO();
        try {
            try {
                String sql = "DELETE FROM public.localidad"
                        + " WHERE idlocalidad = '" + localidad.getIdLocalidad() + "'";

                st.execute(sql);
            } catch (Exception e) {
                nuevalocalidad = new Localidad_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevalocalidad;
    }

    @Override
    public List<Localidad_TO> consultarLocalidades() throws Exception {
        List<Localidad_TO> localidades = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idlocalidad, nombre, idciudad"
                        + " FROM public.localidad";
                ResultSet rs = null;
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    localidades.add(new Localidad_TO(rs.getInt(1), rs.getString(2), new Ciudad_TO(rs.getInt(3))));
                }
            } catch (SQLException r) {
                throw r;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return localidades;
    }

    @Override
    public List<Localidad_TO> buscarLocalidades(String valor) throws Exception {
        List<Localidad_TO> localidades = new ArrayList<>();
        try {
            try {
                String sql = "SELECT l.idlocalidad, l.nombre, l.idciudad "
                        + "FROM public.localidad as l, public.ciudad as c "
                        + "WHERE l.idciudad = c.idciudad and "
                        + "(l.idlocalidad LIKE '%" + valor + "%' or l.nombre LIKE '%" + valor + "%' or "
                        + "l.idciudad LIKE '%" + valor + "%' or c.nombre LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    localidades.add(new Localidad_TO(rs.getInt(1), rs.getString(2), new Ciudad_TO(rs.getInt(3))));
                }
            } catch (SQLException r) {
                throw r;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return localidades;
    }
}
