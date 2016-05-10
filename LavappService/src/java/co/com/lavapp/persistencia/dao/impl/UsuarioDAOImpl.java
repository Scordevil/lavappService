/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.config.Config;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
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

        Statement st = ConexionSQL.conexion();
        Usuario_TO user = new Usuario_TO();

        try {

            Config md5 = new Config();

            usuario.getSesion().setContrasena(md5.getMD5(usuario.getSesion().getContrasena()));
            try {
                String sql = "INSERT INTO public.usuario( "
                        + "   nombre, telefono, idbarrios, idrol, idestado)"
                        + "    VALUES (" + usuario.getNombre() + "," + usuario.getTelefono() + "," + usuario.getBarrio().getIdBarrios() + ", " + usuario.getRol().getIdRol() + "," + usuario.getEstado().getIdEstado() + ");";

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

}
