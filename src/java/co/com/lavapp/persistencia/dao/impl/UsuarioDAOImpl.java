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
import java.util.ArrayList;
import java.util.List;

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
                        + "   nombre, telefono, idbarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad, identificacion, rutaimagen)"
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
                        + "'" + usuario.getCiudad().getIdCiudad() + "', "
                        + "'" + usuario.getIdentificacion() + "',"
                        + "'" + usuario.getRutaImagen() + "');";

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
        try {
            try {
                String sql = "SELECT idusuario, nombre, telefono, idBarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad, identificacion, rutaimagen"
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
                            new Ciudad_TO(rs.getInt(13)),
                            rs.getString(14),
                            rs.getString(15));
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
                String sql = "SELECT idusuario, nombre, telefono, idbarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad, identificacion, rutaimagen "
                        + "  FROM public.usuario where idusuario = '" + usuario.getIdUsuario() + "'; ";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    user = new Usuario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Barrio_TO(rs.getInt(4)), new Rol_TO(rs.getInt(5)), new Estado_TO(rs.getInt(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), new Ciudad_TO(rs.getInt(13)), rs.getString(14), rs.getString(15));
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
                    + "SET nombre='" + usuario.getNombre() + "',apellido='" + usuario.getApellido() + "',"
                    + " telefono='" + usuario.getTelefono() + "', idbarrios= " + usuario.getBarrio().getIdBarrios() + ","
                    + " movil= '" + usuario.getMovil() + "' , direccion= '" + usuario.getDireccion() + "',"
                    + " idciudad= " + usuario.getCiudad().getIdCiudad() + ", identificacion = '" + usuario.getIdentificacion() + "',"
                    + " genero = '" + usuario.getGenero() + "', rutaimagen = '" + usuario.getRutaImagen() + "'"
                    + " WHERE idUsuario = " + usuario.getIdUsuario() + " ;";
            st.executeUpdate(sql);
        } catch (Exception e) {
            user = new Usuario_TO();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return user;
    }

    @Override
    public Usuario_TO eliminarUsuario(Usuario_TO usuario) throws Exception {
        Usuario_TO nuevoUsuario = new Usuario_TO();
        try {
            try {
                String sql = "DELETE FROM public.usuario "
                        + "WHERE idusuario = '" + usuario.getIdUsuario() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoUsuario = new Usuario_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoUsuario;
    }

    @Override
    public Usuario_TO consultarUsuarioPorIdentificacion(Usuario_TO usuario) throws Exception {
        Usuario_TO user = new Usuario_TO();
        try {
            try {
                String sql = "SELECT idusuario, nombre, telefono, idBarrios, idrol, idestado, email, contrasena, apellido, genero, movil, direccion, idciudad, identificacion, rutaimagen"
                        + " FROM public.usuario as usuario where usuario.identificacion = '" + usuario.getIdentificacion() + "'";
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
                            new Ciudad_TO(rs.getInt(13)),
                            rs.getString(14),
                            rs.getString(15));
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

    @Override
    public List<Usuario_TO> consultarUsuariosPorRol(Rol_TO rol) throws Exception {

        List<Usuario_TO> listaCLientesModel = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idusuario, nombre, telefono, idbarrios, idrol, idestado, email,  "
                        + "       contrasena, apellido, genero, movil, direccion, idciudad, identificacion, rutaimagen  "
                        + "  FROM public.usuario "
                        + "  WHERE idrol = '" + rol.getIdRol() + "' ";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    listaCLientesModel.add(new Usuario_TO(rs.getInt(1),
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
                            new Ciudad_TO(rs.getInt(13)),
                            rs.getString(14),
                            rs.getString(15)));

                }

            } catch (Exception e) {
                listaCLientesModel = new ArrayList<>();
                System.out.println("Error en sentencia SQL o en insercion de datos en lista Modelo: " + e.getMessage());
                throw e;
            }
        } catch (Exception ef) {
            listaCLientesModel = new ArrayList<>();
            throw ef;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return listaCLientesModel;
    }

    @Override
    public Usuario_TO editarCorreoSesion(Usuario_TO usuario) throws Exception {
        Usuario_TO user = new Usuario_TO();

        try {
            String sql = "UPDATE public.usuario"
                    + " SET email = '" + usuario.getEmail() + "'"
                    + " WHERE idUsuario = " + usuario.getIdUsuario() + ";";
            st.executeUpdate(sql);
        } catch (Exception e) {
            user = new Usuario_TO();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return user;
    }

    @Override
    public Usuario_TO editarContrasenaSesion(Usuario_TO usuario) throws Exception {
        Usuario_TO user = new Usuario_TO();

        try {
            String sql = "UPDATE public.usuario"
                    + " SET contrasena = md5('" + usuario.getContrasena() + "')"
                    + " WHERE idUsuario = " + usuario.getIdUsuario() + ";";
            st.executeUpdate(sql);
        } catch (Exception e) {
            user = new Usuario_TO();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return user;
    }

    @Override
    public List<Usuario_TO> BuscarAsesores(String valor) throws Exception {
        List<Usuario_TO> listaAsesoresModel = new ArrayList<>();
        try {
            try {
                String sql = "SELECT us.idusuario, us.nombre, us.telefono, us.idbarrios, us.idrol, us.idestado, us.email, "
                        + "us.contrasena, us.apellido, us.genero, us.movil, us.direccion, us.idciudad, us.identificacion, us.rutaimagen "
                        + "FROM public.usuario as us, public.barrio as b, public.ciudad as c "
                        + "WHERE us.idrol = 3 AND us.idbarrios = b.idbarrios AND us.idciudad = c.idciudad AND (us.nombre LIKE '%" + valor + "%' OR us.telefono LIKE '%" + valor + "%' OR "
                        + "b.nombre LIKE '%" + valor + "%' OR us.email LIKE '%" + valor + "%' OR c.nombre LIKE '%" + valor + "%' OR "
                        + "us.apellido LIKE '%" + valor + "%' OR us.movil LIKE '%" + valor + "%' OR us.direccion LIKE '%" + valor + "%' OR "
                        + "us.identificacion LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    listaAsesoresModel.add(new Usuario_TO(rs.getInt(1),
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
                            new Ciudad_TO(rs.getInt(13)),
                            rs.getString(14),
                            rs.getString(15)));
                }

            } catch (Exception e) {
                listaAsesoresModel = new ArrayList<>();
                System.out.println("Error en sentencia SQL o en insercion de datos en lista Modelo: " + e.getMessage());
                throw e;
            }
        } catch (Exception ef) {
            throw ef;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return listaAsesoresModel;
    }

    @Override
    public List<Usuario_TO> BuscarClientes(String valor) throws Exception {
         List<Usuario_TO> listaClientesModel = new ArrayList<>();
        try {
            try {
                String sql = "SELECT us.idusuario, us.nombre, us.telefono, us.idbarrios, us.idrol, us.idestado, us.email, "
                        + "us.contrasena, us.apellido, us.genero, us.movil, us.direccion, us.idciudad, us.identificacion, us.rutaimagen "
                        + "FROM public.usuario as us, public.barrio as b, public.ciudad as c "
                        + "WHERE us.idrol = 4 AND us.idbarrios = b.idbarrios AND us.idciudad = c.idciudad AND (us.nombre LIKE '%" + valor + "%' OR us.telefono LIKE '%" + valor + "%' OR "
                        + "b.nombre LIKE '%" + valor + "%' OR us.email LIKE '%" + valor + "%' OR c.nombre LIKE '%" + valor + "%' OR "
                        + "us.apellido LIKE '%" + valor + "%' OR us.movil LIKE '%" + valor + "%' OR us.direccion LIKE '%" + valor + "%' OR "
                        + "us.identificacion LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    listaClientesModel.add(new Usuario_TO(rs.getInt(1),
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
                            new Ciudad_TO(rs.getInt(13)),
                            rs.getString(14),
                            rs.getString(15)));
                }

            } catch (Exception e) {
                listaClientesModel = new ArrayList<>();
                System.out.println("Error en sentencia SQL o en insercion de datos en lista Modelo: " + e.getMessage());
                throw e;
            }
        } catch (Exception ef) {
            throw ef;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return listaClientesModel;
    }

    @Override
    public List<Usuario_TO> BuscarAdministradores(String valor) throws Exception {
        List<Usuario_TO> listaAdministradoresModel = new ArrayList<>();
        try {
            try {
                String sql = "SELECT us.idusuario, us.nombre, us.telefono, us.idbarrios, us.idrol, us.idestado, us.email, "
                        + "us.contrasena, us.apellido, us.genero, us.movil, us.direccion, us.idciudad, us.identificacion, us.rutaimagen "
                        + "FROM public.usuario as us, public.barrio as b, public.ciudad as c "
                        + "WHERE us.idrol = 1 AND us.idbarrios = b.idbarrios AND us.idciudad = c.idciudad AND (us.nombre LIKE '%" + valor + "%' OR us.telefono LIKE '%" + valor + "%' OR "
                        + "b.nombre LIKE '%" + valor + "%' OR us.email LIKE '%" + valor + "%' OR c.nombre LIKE '%" + valor + "%' OR "
                        + "us.apellido LIKE '%" + valor + "%' OR us.movil LIKE '%" + valor + "%' OR us.direccion LIKE '%" + valor + "%' OR "
                        + "us.identificacion LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    listaAdministradoresModel.add(new Usuario_TO(rs.getInt(1),
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
                            new Ciudad_TO(rs.getInt(13)),
                            rs.getString(14),
                            rs.getString(15)));
                }

            } catch (Exception e) {
                listaAdministradoresModel = new ArrayList<>();
                System.out.println("Error en sentencia SQL o en insercion de datos en lista Modelo: " + e.getMessage());
                throw e;
            }
        } catch (Exception ef) {
            throw ef;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return listaAdministradoresModel;
    }
}
