/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Factura_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.FacturaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class FacturaDAOImpl implements FacturaDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Factura_TO registrarFactura(Factura_TO factura) throws Exception {
        Factura_TO nuevafactura = new Factura_TO();
        try {
            try {
                String sql = "INSERT INTO public.factura(total, subtotal, neto, iva, descuento, fecha, idpedido) "
                        + "VALUES('" + factura.getTotal() + "', "
                        + "'" + factura.getSubTotal() + "', "
                        + "'" + factura.getNeto() + "', "
                        + "'" + factura.getIva() + "', "
                        + "'" + factura.getDescuento() + "',"
                        + "'" + factura.getFecha().toString() + "', "
                        + "'" + factura.getPedido().getIdPedido() + "')";

                st.execute(sql);
            } catch (SQLException e) {
                nuevafactura = new Factura_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevafactura;
    }

    @Override
    public Factura_TO eliminarFactura(Factura_TO factura) throws Exception {
        Factura_TO nuevafactura = new Factura_TO();
        try {
            try {
                String sql = "DELETE FROM public.factura"
                        + " WHERE idfactura = '" + factura.getIdFactura() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevafactura = new Factura_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevafactura;
    }

    @Override
    public Factura_TO consultarFacturaPedido(Pedido_TO pedido) throws Exception {
        Factura_TO factura = new Factura_TO();
        try {
            try {
                String sql = "SELECT idfactura, total, subtotal, neto, iva, descuento, fecha, idpedido"
                        + " FROM public.factura"
                        + " WHERE idpedido = '" + pedido.getIdPedido() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    factura = new Factura_TO(rs.getInt(1),
                            rs.getDouble(2),
                            rs.getDouble(3),
                            rs.getDouble(4),
                            rs.getDouble(5),
                            rs.getDouble(6),
                            rs.getDate(7),
                            new Pedido_TO(rs.getInt(8)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return factura;
    }

    @Override
    public List<Factura_TO> consultarFacturas() throws Exception {
        List<Factura_TO> facturas = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idfactura, total, subtotal, neto, iva, descuento, fecha, idpedido"
                        + " FROM public.factura";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    facturas.add(new Factura_TO(rs.getInt(1),
                            rs.getDouble(2),
                            rs.getDouble(3),
                            rs.getDouble(4),
                            rs.getDouble(5),
                            rs.getDouble(6),
                            rs.getDate(7),
                            new Pedido_TO(rs.getInt(8))));
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return facturas;
    }

}
