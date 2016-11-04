/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.PromocionSubproductoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionSubproductoDAOImpl implements PromocionSubproductoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public void asociarPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subProducto) throws Exception {
        try {
            try {
                String sql = "INSERT INTO promocion_subproducto (idpromocion, idsubproducto) "
                        + "VALUES('" + promocion.getIdPromocion() + "', '" + subProducto.getIdSubProducto() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
    }

    @Override
    public void eliminarAsociacionPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subproducto) throws Exception {
        try {
            try {
                String sql = "DELETE FROM promocion_subproducto where idpromocion = '" + promocion.getIdPromocion() + "' "
                        + "AND idsubproducto = '" + subproducto.getIdSubProducto() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
    }

    @Override
    public int consultarPromocionSubProductoYaAsociada(Promocion_TO promocion, SubProducto_TO subproducto) throws Exception {
        int resultado = 0;
        try {
            try {
                String sql = "SELECT idpromocion, idsubproducto FROM promocion_subproducto"
                        + " WHERE idpromocion = '" + promocion.getIdPromocion() + "' AND idsubproducto = '" + subproducto.getIdSubProducto() + "'";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    resultado = 1 ;
                    break;
                }                
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return resultado;
    }
}
