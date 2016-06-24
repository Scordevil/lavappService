/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.SubProductoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubProductoDAOImpl implements SubProductoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<SubProducto_TO> consultarSubProductoSegunProducto(Producto_TO producto) throws Exception {
        List<SubProducto_TO> subProductos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idsubproducto, nombre, descripcion, idproducto FROM public.subproducto AS subproducto "
                        + "WHERE subproducto.idproducto = '" + producto.getIdProducto() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    subProductos.add(new SubProducto_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Producto_TO(rs.getInt(4))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return subProductos;
    }

    @Override
    public List<SubProducto_TO> consultarSubProductos() throws Exception {
        List<SubProducto_TO> subProductos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idsubproducto, nombre, descripcion, idproducto\n"
                        + "  FROM public.subproducto;";

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    subProductos.add(new SubProducto_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Producto_TO(rs.getInt(4))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return subProductos;
    }

    @Override
    public SubProducto_TO registrarSubProducto(SubProducto_TO subProduc) throws Exception {
        SubProducto_TO subProModelo = new SubProducto_TO();
        try {
            try {
                String sql = "INSERT INTO public.subproducto( "
                        + "            nombre, descripcion, idproducto) "
                        + "    VALUES ('" + subProduc.getNombre() + "', '" + subProduc.getDescripcion() + "', " + subProduc.getProducto().getIdProducto() + ")";
                st.execute(sql);
                subProModelo = new SubProducto_TO();
            } catch (Exception e) {
                subProModelo = new SubProducto_TO();
                throw e;
            }
        } catch (Exception ex) {
            subProModelo = new SubProducto_TO();
            throw ex;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return subProModelo;
    }

    @Override
    public SubProducto_TO modificarSubProducto(SubProducto_TO subProduc) throws Exception {
        SubProducto_TO subproModel = new SubProducto_TO();
        try {
            try {
                String sql = "UPDATE public.subproducto "
                        + "   SET  nombre='" + subProduc.getNombre() + "', descripcion='" + subProduc.getDescripcion() + "', idproducto=" + subProduc.getProducto().getIdProducto() + " "
                        + " WHERE idsubproducto=" + subProduc.getIdSubProducto() + ";";
                st.execute(sql);
                subproModel = new SubProducto_TO();
            } catch (Exception e) {
                subproModel = new SubProducto_TO();
                throw e;
            }
        } catch (Exception es) {
            subproModel = new SubProducto_TO();
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return subproModel;
    }

    @Override
    public SubProducto_TO eliminarSubProducto(SubProducto_TO subProduc) throws Exception {
        SubProducto_TO subProModel = new SubProducto_TO();
        try {
            try {
                String sql = "DELETE FROM public.subproducto "
                        + " WHERE idsubproducto = "+ subProduc.getIdSubProducto() +";";
                st.execute(sql);
                subProModel = new SubProducto_TO();
            } catch (Exception e) {
                subProModel = new SubProducto_TO();
                throw e;
            }
        } catch (Exception ez) {
            subProModel = new SubProducto_TO();
            throw ez;
        }finally{
            ConexionSQL.CerrarConexion();
        }
        return subProModel;
    }
}
