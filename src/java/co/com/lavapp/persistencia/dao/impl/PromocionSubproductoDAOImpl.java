/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Producto_TO;
import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.PromocionSubproductoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionSubproductoDAOImpl implements PromocionSubproductoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public int asociarPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subProducto) throws Exception {
        int resultado = 0;
        try {
            try {
                String sql = "INSERT INTO promocion_subproducto (idpromocion, idsubproducto) "
                        + "VALUES('" + promocion.getIdPromocion() + "', '" + subProducto.getIdSubProducto() + "')";
                st.execute(sql);
                resultado = 1;
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

    @Override
    public int eliminarAsociacionPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subproducto) throws Exception {
        int resultado = 0;
        try {
            try {
                String sql = "DELETE FROM promocion_subproducto where idpromocion = '" + promocion.getIdPromocion() + "' "
                        + "AND idsubproducto = '" + subproducto.getIdSubProducto() + "'";
                st.execute(sql);
                resultado = 1;
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

    @Override
    public List<SubProducto_TO> consultarSubProductosSegunPromocion(Promocion_TO promocion) throws Exception {
        List<SubProducto_TO> subproductos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT s.idsubproducto, s.nombre, s.descripcion, s.idproducto, s.rutaimagen FROM public.subproducto AS s, public.promocion_subproducto AS ps"
                        + " WHERE ps.idpromocion = '" + promocion.getIdPromocion() + "' AND ps.idsubproducto = s.idsubproducto";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    subproductos.add(new SubProducto_TO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            new Producto_TO(rs.getInt(4)),
                            rs.getString(5)));
                }                
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return subproductos;
    }
}
