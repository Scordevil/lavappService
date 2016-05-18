/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoDAOImpl implements DescripcionPedidoDAO{
 
    private final Statement st = ConexionSQL.conexion();

    //Metodo consultar Cantidad de descripciones(productos) agregadas segun pedido
    @Override
    public int consultarCantidadDescripcionPedido(Pedido_TO pedido) throws Exception {
        int cantidad = 0;
        try {
            try {
                String sql = "SELECT COUNT(iddescripcionpedido) "
                        + "from public.descripcionpedido as descripcionpedido WHERE "
                        + "descripcionpedido.idpedido = '" + pedido.getIdPedido() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    cantidad = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return cantidad;
    }
}
