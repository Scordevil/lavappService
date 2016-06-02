/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Costo_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.CostoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Desarrollo_Planit
 */
public class CostoDAOImpl implements CostoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Costo_TO RegistrarCosto(Costo_TO costo) throws Exception {
        Costo_TO nuevocosto = new Costo_TO();
        try {
            try {
                String sql = "INSERT INTO public.costo("
                        + " valor, idsubproducto, idzona)"
                        + " VALUES ( " + costo.getValor() + ", " + costo.getSubProducto().getIdSubProducto() + ", " + costo.getZona().getIdZona() + ");";
                st.execute(sql);
            } catch (SQLException e) {
                nuevocosto = new Costo_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevocosto;
    }

    @Override
    public int consultarCostoPedido(Pedido_TO pedido) throws Exception {
        int costo = 0;
        try {
            try {
                String sql = "SELECT sum(costo.valor) from public.costo as costo, "
                        + "public.pedido as pedido, "
                        + "public.descripcionpedido as descripcion, "
                        + "public.subproducto as subproducto "
                        + "WHERE pedido.idPedido = " + pedido.getIdPedido() + " and "
                        + "descripcion.idPedido = pedido.idPedido and "
                        + "descripcion.idsubproducto = subproducto.idsubproducto and "
                        + "costo.idsubproducto = subproducto.idsubproducto";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    costo = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return costo;
    }

    @Override
    public Costo_TO consultarCostoSubProducto(SubProducto_TO subproducto) throws Exception {
        Costo_TO costo = new Costo_TO();
        try {
            try {
                String sql = "SELECT idcosto, valor, idsubproducto, idzona FROM public.costo as costo"
                        + " WHERE costo.idsubproducto = " + subproducto.getIdSubProducto() + "";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    costo = new Costo_TO(rs.getInt(1), rs.getInt(2), new SubProducto_TO(rs.getInt(3)), new Zona_TO(rs.getInt(4)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return costo;
    }

}
