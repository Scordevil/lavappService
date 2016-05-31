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
                String sql = "SELECT idproducto, nombre, descripcion, idsubservicio FROM public.producto";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    productos.add(new Producto_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new SubServicio_TO(rs.getInt(4))));
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
