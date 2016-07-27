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
import java.util.ArrayList;
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
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado_TO consultarEstado(Estado_TO estado) throws Exception {
        Estado_TO estadoModelo = new Estado_TO();
        try {
            try {
                String sql = "SELECT idestado, nombre "
                        + "  FROM public.estado "
                        + "  WHERE idestado = " + estado.getIdEstado() + " OR nombre = '" + estado.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    estadoModelo = new Estado_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (Exception e) {
                estadoModelo = new Estado_TO();
                throw e;
            }
        } catch (Exception es) {
            estadoModelo = new Estado_TO();
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return estadoModelo;
    }

    @Override
    public List<Estado_TO> consultarEstadosProducto() throws Exception {
        List<Estado_TO> estadoModelo = new ArrayList<Estado_TO>();
        try {
            try {
                String sql = "SELECT idestado, nombre "
                        + "  FROM public.estado "
                        + "  WHERE idestado >= 3 " ;
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    estadoModelo.add(new Estado_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (Exception e) {
               estadoModelo = new ArrayList<Estado_TO>();
                throw e;
            }
        } catch (Exception es) {
           estadoModelo = new ArrayList<Estado_TO>();
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return estadoModelo;
    }

}
