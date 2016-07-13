/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.BarrioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class BarrioDAOImpl implements BarrioDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Barrio_TO> consultarBarriosSegunLocalidad(Localidad_TO localidad) throws Exception {
        List<Barrio_TO> barrios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idbarrios, nombre, idlocalidad, idzona, idestrato FROM public.barrio as barrio "
                        + "WHERE  barrio.idlocalidad = '" + localidad.getIdLocalidad() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    barrios.add(new Barrio_TO(rs.getInt(1), rs.getString(2), new Localidad_TO(rs.getInt(3)), new Zona_TO(rs.getInt(4)), new Estrato_TO(rs.getInt(5))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return barrios;
    }

    @Override
    public List<Barrio_TO> consultarBarrios() throws Exception {
        List<Barrio_TO> barrios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idbarrios, nombre, idlocalidad, idzona, idestrato FROM public.barrio as barrio ORDER BY nombre ASC";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    barrios.add(new Barrio_TO(rs.getInt(1), rs.getString(2), new Localidad_TO(rs.getInt(3)), new Zona_TO(rs.getInt(4)), new Estrato_TO(rs.getInt(5))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return barrios;
    }

    @Override
    public Barrio_TO consultarBarrio(Barrio_TO barrio) throws Exception {
        Barrio_TO nuevoBarrio = new Barrio_TO();
        try {
            try {
                String sql = "SELECT idbarrios, nombre, idlocalidad, idzona, idestrato FROM public.barrio as barrio"
                        + " WHERE idbarrios = '" + barrio.getIdBarrios() + "' or nombre = '" + barrio.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevoBarrio = new Barrio_TO(rs.getInt(1), rs.getString(2), new Localidad_TO(rs.getInt(3)), new Zona_TO(rs.getInt(4)), new Estrato_TO(rs.getInt(5)));
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoBarrio;
    }

    @Override
    public Barrio_TO registrarBarrio(Barrio_TO barrio) throws Exception {
        Barrio_TO nuevoBarrio = new Barrio_TO();
        try {
            try {
                String sql = "INSERT INTO public.barrio(nombre, idlocalidad, idzona, idestrato) "
                        + "VALUES ('" + barrio.getNombre() + "', "
                        + "'" + barrio.getLocalidad().getIdLocalidad() + "', "
                        + "'" + barrio.getZona().getIdZona() + "', "
                        + "'" + barrio.getEstrato().getIdEstrato() + "')";
                st.execute(sql);
            } catch (Exception e) {
                nuevoBarrio = new Barrio_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoBarrio;
    }

    @Override
    public Barrio_TO modificarBarrio(Barrio_TO barrio) throws Exception {
        Barrio_TO nuevoBarrio = new Barrio_TO();
        try {
            try {
                String sql = "UPDATE public.barrio SET "
                        + "nombre = '" + barrio.getNombre() + "', "
                        + "idlocalidad = '" + barrio.getLocalidad().getIdLocalidad() + "', "
                        + "idzona = '" + barrio.getZona().getIdZona() + "', "
                        + "idestrato = '" + barrio.getEstrato().getIdEstrato() + "' "
                        + "WHERE idbarrios = '" + barrio.getIdBarrios() + "'";
                st.execute(sql);
            } catch (Exception e) {
                nuevoBarrio = new Barrio_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoBarrio;
    }

    @Override
    public Barrio_TO eliminarBarrio(Barrio_TO barrio) throws Exception {
        Barrio_TO nuevoBarrio = new Barrio_TO();
        try {
            try {
                String sql = "DELETE FROM public.barrio"
                        + " WHERE idbarrios = '" + barrio.getIdBarrios() + "'";
                st.execute(sql);
            } catch (Exception e) {
                nuevoBarrio = new Barrio_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoBarrio;
    }
}
