/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.config.Config;
import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Usuario
 *
 * @author Planit
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * METODOS PARA REGISTRAR USUARIOS
     *
     * @param usuario
     * @return @throws Exception
     */
    @Override
    public Usuario_TO registrarUsuarios(Usuario_TO usuario) throws Exception {

        Usuario_TO user = new Usuario_TO();

        try {

            Config md5 = new Config();

            usuario.setContrasena(md5.getMD5(usuario.getContrasena()));
            try {
                String sql = "INSERT INTO public.usuario( "
                        + "   nombre, telefono, idbarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad)"
                        + "    VALUES ('" + usuario.getNombre() + "', "
                        + "'" + usuario.getTelefono() + "', "
                        + "" + usuario.getBarrio().getIdBarrios() + ", "
                        + "" + usuario.getRol().getIdRol() + ", "
                        + "" + usuario.getEstado().getIdEstado() + ", "
                        + "'" + usuario.getEmail() + "', "
                        + "'" + usuario.getContrasena() + "', "
                        + "'" + usuario.getApellido() + "', "
                        + "'" + usuario.getGenero() + "', "
                        + "'" + usuario.getMovil() + "', "
                        + "'" + usuario.getDireccion() + "', "
                        + "'" + usuario.getCiudad().getIdCiudad() + "');";

                st.execute(sql);

            } catch (Exception e) {
                user = new Usuario_TO();
                throw e;

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();

        }
        return user;
    }

    /**
     *
     * METODOS PARA CONSULTAR USUARIOS POR LOGIN
     *
     * @param usuario
     * @return @throws Exception
     */
    @Override
    public Usuario_TO consultarUsuarioPorLogin(Usuario_TO usuario) throws Exception {

        Usuario_TO user = new Usuario_TO();
        Config funciones = new Config();
        try {
            try {
                String sql = "SELECT idusuario, nombre, telefono, idBarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad"
                        + " FROM public.usuario as usuario where usuario.email = '" + usuario.getEmail() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    user = new Usuario_TO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            new Barrio_TO(rs.getInt(4)),
                            new Rol_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6)),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12),
                            new Ciudad_TO(rs.getInt(13)));
                }
            } catch (SQLException e) {
                user = new Usuario_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return user;
    }

    /**
     *
     * METODOS PARA CONSULTAR USUARIO
     *
     * @param usuario
     * @return @throws Exception
     */
    @Override
    public Usuario_TO consultarUsuario(Usuario_TO usuario) throws Exception {

        Usuario_TO user = new Usuario_TO();

        try {
            try {
                String sql = "SELECT idusuario, nombre, telefono, idbarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad "
                        + "  FROM public.usuario where idusuario = '" + usuario.getIdUsuario() + "'; ";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    user = new Usuario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Barrio_TO(rs.getInt(4)), new Rol_TO(rs.getInt(5)), new Estado_TO(rs.getInt(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), new Ciudad_TO(rs.getInt(13)));
                }
            } catch (Exception e) {
                user = new Usuario_TO();
                throw e;

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();

        }
        return user;
    }

    /**
     *
     * @param usuario
     * @return @throws Exception
     */
    @Override
    public Usuario_TO editarUsuario(Usuario_TO usuario) throws Exception {

        Usuario_TO user = new Usuario_TO();

        try {
            String sql = "UPDATE public.usuario  "
                    + "SET nombre='" + usuario.getNombre() + "',apellido='" + usuario.getApellido() + "' ,telefono='" + usuario.getTelefono() + "' , idbarrios= " + usuario.getBarrio().getIdBarrios() + " , contrasena= '" + usuario.getContrasena() + "' , movil= '" + usuario.getMovil() + "' , direccion= '" + usuario.getDireccion() + "' , idciudad= " + usuario.getCiudad().getIdCiudad() + " "
                    + "  WHERE idUsuario = " + usuario.getIdUsuario() + " ;";
            st.executeUpdate(sql);
        } catch (Exception e) {
            user = new Usuario_TO();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return user;
    }

}
