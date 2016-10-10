/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.FormaPago_TO;
import co.com.lavapp.persistencia.dao.FormaPagoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VaioDevelopment
 */
public class FormaPagoDAOImpl implements FormaPagoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public FormaPago_TO consultarFormaPago(FormaPago_TO formaPago) throws Exception {
        FormaPago_TO formapago = new FormaPago_TO();
        try {
            try {
                String sql = "SELECT idformapago, nombre "
                        + "FROM public.forma_pago "
                        + "WHERE idformapago = '" + formaPago.getIdFormaPago() + "' OR nombre = '" + formaPago.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    formaPago = new FormaPago_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally{
            ConexionSQL.CerrarConexion();
        }
     return formaPago;
    }
}
