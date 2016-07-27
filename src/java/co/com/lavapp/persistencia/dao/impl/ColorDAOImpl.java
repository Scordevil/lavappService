/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.persistencia.dao.ColorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public class ColorDAOImpl implements ColorDAO{
    
        private final Statement st = ConexionSQL.conexion();

    @Override
    public Color_TO consultarColor(Color_TO color) throws Exception {
       
        Color_TO col = new Color_TO();
        
        try {
             
            try {
                String sql = "SELECT idcolor, nombre " +
                            "  FROM public.color as c "
                        + "WHERE c.idcolor = " + color.getIdColor()+ " ;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    col = new Color_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return col;
    }
    
    @Override
    public List<Color_TO> consultarColores() throws Exception {
       
        List<Color_TO> colores = new ArrayList<>();
        
        try {
             
            try {
                String sql = "SELECT idcolor, nombre " +
                            "  FROM public.color as c ;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    colores.add(new Color_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return colores;
    }
    
    
    
}
