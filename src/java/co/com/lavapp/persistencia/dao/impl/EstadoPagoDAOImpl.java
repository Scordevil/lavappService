/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.EstadoPago_TO;
import co.com.lavapp.persistencia.dao.EstadoPagoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VaioDevelopment
 */
public class EstadoPagoDAOImpl implements EstadoPagoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public EstadoPago_TO consultarEstadoPago(EstadoPago_TO estadoPago) throws Exception {
        EstadoPago_TO nuevoEstadoPago = new EstadoPago_TO();
        try {
            try {
                String sql = "SELECT idestadopago, nombre FROM public.estado_pago "
                        + "WHERE idestadopago = '" + estadoPago.getIdEstadoPago() + "' or nombre = '" + estadoPago.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevoEstadoPago = new EstadoPago_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoEstadoPago;
    }
}
