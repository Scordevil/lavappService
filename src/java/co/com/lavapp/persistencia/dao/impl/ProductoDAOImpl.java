/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.ProductoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProductoDAOImpl implements ProductoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Producto_TO> consultarProductos() throws Exception {
        List<Producto_TO> productos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idproducto, nombre, descripcion, idsubservicio, rutaimagen "
                        + " FROM public.producto;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    productos.add(new Producto_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new SubServicio_TO(rs.getInt(4)), rs.getString(5)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return productos;
    }

    @Override
    public Producto_TO registrarProducto(Producto_TO produc) throws Exception {
        Producto_TO productModelo = new Producto_TO();
        try {
            try {
                String sql = "INSERT INTO public.producto( "
                        + "             nombre, descripcion, idsubservicio , rutaimagen) "
                        + "    VALUES ( '" + produc.getNombre() + "', '" + produc.getDescripcion() + "', " + produc.getSubServicio().getIdSubServicio() + " , '" + produc.getRutaImagen() + "');";
                st.execute(sql);
                productModelo = new Producto_TO();
            } catch (Exception e) {
                productModelo = new Producto_TO();
                throw e;
            }
        } catch (Exception ex) {
            productModelo = new Producto_TO();
            throw ex;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return productModelo;
    }

    @Override
    public Producto_TO modificarProducto(Producto_TO produc) throws Exception {
        Producto_TO producModelo = new Producto_TO();
        try {
            try {
                String sql = "UPDATE public.producto "
                        + "SET  nombre='" + produc.getNombre() + "', descripcion='" + produc.getDescripcion() + "', idsubservicio=" + produc.getSubServicio().getIdSubServicio() + " , rutaimagen='" + produc.getRutaImagen() + "' "
                        + "WHERE idproducto = " + produc.getIdProducto() + ";";
                st.execute(sql);
                producModelo = new Producto_TO();
            } catch (Exception e) {
                producModelo = new Producto_TO();
                throw e;
            }
        } catch (Exception ed) {
            throw ed;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return producModelo;
    }

    @Override
    public Producto_TO eliminarProducto(Producto_TO produc) throws Exception {
        Producto_TO prodctoModelo = new Producto_TO();
        try {
            try {
                String sql = "DELETE FROM public.producto "
                        + " WHERE idproducto = " + produc.getIdProducto() + ";";
                st.execute(sql);
                prodctoModelo = new Producto_TO();
            } catch (Exception e) {
                prodctoModelo = new Producto_TO();
                throw e;
            }
        } catch (Exception de) {
            prodctoModelo = new Producto_TO();
            throw de;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return prodctoModelo;
    }

    @Override
    public Producto_TO consultarProducto(Producto_TO produc) throws Exception {
        Producto_TO nuevoProducto = new Producto_TO();
        try {
            try {
                String sql = "SELECT idproducto, nombre, descripcion, idsubservicio, rutaimagen "
                        + "FROM public.producto "
                        + "WHERE idproducto  = '" + produc.getIdProducto() + "' or nombre = '" + produc.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevoProducto = new Producto_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new SubServicio_TO(rs.getInt(4)), rs.getString(5));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoProducto;
    }

    @Override
    public List<Producto_TO> buscarProductos(String valor) throws Exception {
        List<Producto_TO> productos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT p.idproducto, p.nombre, p.descripcion, p.idsubservicio, p.rutaimagen "
                        + "FROM public.producto as p, public.subservicio as s "
                        + "WHERE p.idsubservicio = s.idsubservicio and "
                        + "(p.nombre LIKE '%" + valor + "%' or p.descripcion LIKE '%" + valor + "%' or "
                        + "s.nombre LIKE '%" + valor + "%')";

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    productos.add(new Producto_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new SubServicio_TO(rs.getInt(4)), rs.getString(5)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return productos;
    }

}
