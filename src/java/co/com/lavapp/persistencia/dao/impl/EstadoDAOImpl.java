/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.EstadoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class EstadoDAOImpl implements EstadoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Estado_TO consultarEstadoPedido(Pedido_TO pedido) throws Exception {
        Estado_TO estado = new Estado_TO();
        try {
            try {
                String sql = "SELECT idestado, nombre FROM public.estado as estado, public.pedido as pedido "
                        + "WHERE pedido.idPedido = '" + pedido.getIdPedido() + "' and pedido.idEstado = estado.idEstado";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    estado = new Estado_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return estado;
    }

    @Override
    public List<Estado_TO> consultarEstados() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
