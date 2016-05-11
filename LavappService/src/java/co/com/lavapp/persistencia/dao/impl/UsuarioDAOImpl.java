/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.config.Config;
import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Rol_TO;
import co.com.lavapp.modelo.dto.Sesion_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
import java.sql.ResultSet;
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

            usuario.getSesion().setContrasena(md5.getMD5(usuario.getSesion().getContrasena()));
            try {
                String sql = "INSERT INTO public.usuario( "
                        + "   nombre, telefono, idbarrios, idrol, idestado)"
                        + "    VALUES ('" + usuario.getNombre() + "','" + usuario.getTelefono() + "'," + usuario.getBarrio().getIdBarrios() + ", " + usuario.getRol().getIdRol() + "," + usuario.getEstado().getIdEstado() + ");";

                st.execute(sql);

            } catch (Exception e) {
                user = new Usuario_TO();
                throw e;

            }
            ConexionSQL.CerrarConexion();

        } catch (Exception e) {

            throw e;

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

        try {

            try {
                String sql = "SELECT idsesion, usuario, contrasena, idusuario "
                        + "  FROM public.sesion where usuario = '" + usuario.getSesion().getLogin() + "'; ";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    user = new Usuario_TO(new Sesion_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                }

            } catch (Exception e) {
                user = new Usuario_TO();
                throw e;

            }
            ConexionSQL.CerrarConexion();

        } catch (Exception e) {

            throw e;

        }
        return user;
    }

    /**
     *
     * METODOS PARA CONSULTAR USUARIO SESION
     *
     * @param usuario
     * @return @throws Exception
     */
    @Override
    public Sesion_TO consultarUsuarioSesion(Sesion_TO usuario) throws Exception {

        Sesion_TO user = new Sesion_TO();

        try {

            try {
                String sql = "SELECT idsesion, usuario, contrasena, idusuario "
                        + "  FROM public.sesion where idusuario = '" + usuario.getIdUsuario() + "'; ";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    user = new Sesion_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                }

            } catch (Exception e) {
                user = new Sesion_TO();
                throw e;

            }
            ConexionSQL.CerrarConexion();

        } catch (Exception e) {

            throw e;

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
                String sql = "SELECT idusuario, nombre, telefono, idbarrios, idrol, idestado " +
                "  FROM public.usuario where idusuario = '" + usuario.getIdUsuario() + "'; ";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    user = new Usuario_TO(rs.getInt(1),rs.getString(2),rs.getString(3),new Barrio_TO(rs.getInt(4)),new Rol_TO(rs.getInt(5)), new Estado_TO(rs.getInt(6)));
                }

            } catch (Exception e) {
                user = new Usuario_TO();
                throw e;

            }
            ConexionSQL.CerrarConexion();

        } catch (Exception e) {

            throw e;

        }
        return user;
    }

    /**
     *
     * METODOS PARA REGISTRAR USUARIOS SESION
     *
     * @param sesion
     * @return @throws Exception
     */
    @Override
    public Sesion_TO registrarUsuarioSesion(Sesion_TO sesion) throws Exception {

        Sesion_TO user = new Sesion_TO();

        try {

            try {
                String sql = "INSERT INTO public.sesion( "
                        + "   usuario, contrasena, idusuario) "
                        + "    VALUES ('" + sesion.getLogin() + "','" + sesion.getContrasena() + "', 1 ); ";

                st.executeQuery(sql);

            } catch (Exception e) {
                user = new Sesion_TO();
                throw e;

            }
            ConexionSQL.CerrarConexion();

        } catch (Exception e) {

            throw e;

        }
        return user;
    }

}
