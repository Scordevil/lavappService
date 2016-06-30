/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.persistencia.dao.RolDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class RolDAOImpl implements RolDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Rol_TO> consultarRoles() throws Exception {
        List<Rol_TO> roles = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idrol, nombre FROM public.rol";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    roles.add(new Rol_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return roles;
    }

    @Override
    public Rol_TO consultarRol(Rol_TO rol) throws Exception {
        Rol_TO nuevoRol = new Rol_TO();
        try {
            try {
                String sql = "SELECT idrol, nombre FROM public.rol "
                        + "WHERE idrol = '" + rol.getIdRol() + "' or nombre = '" + rol.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return rol;

    }

    @Override
    public Rol_TO registrarRol(Rol_TO rol) throws Exception {
        Rol_TO nuevoRol = new Rol_TO();
        try {
            try {
                String sql = "INSERT INTO public.rol (nombre) "
                        + "VALUES ('" + rol.getNombre() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoRol = new Rol_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoRol;
    }

    @Override
    public Rol_TO editarRol(Rol_TO rol) throws Exception {
        Rol_TO nuevoRol = new Rol_TO();
        try {
            try {
                String sql = "UPDATE public.rol SET nombre = '" + rol.getNombre() + "' "
                        + "WHERE idrol = '" + rol.getIdRol() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoRol = new Rol_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoRol;
    }

    @Override
    public Rol_TO eliminarRol(Rol_TO rol) throws Exception {
        Rol_TO nuevoRol = new Rol_TO();
        try {
            try {
                String sql = "DELETE FROM public.rol "
                        + "WHERE idrol = '" + rol.getIdRol() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoRol;
    }

}
