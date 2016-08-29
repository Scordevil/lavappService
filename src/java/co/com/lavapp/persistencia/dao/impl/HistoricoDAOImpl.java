/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Historico_TO;
import co.com.lavapp.persistencia.dao.HistoricoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class HistoricoDAOImpl implements HistoricoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Historico_TO registrarHistorico(Historico_TO historico) throws Exception {
        Historico_TO nuevoHistorico = new Historico_TO();
        try {
            try {
                String sql = "INSERT INTO public.historico(idhistorico, iddescripcionpedido, idestado, fecha) "
                        + "VALUES (" + historico.getIdHistorico() + ", " + historico.getDescripcionPedido().getIdDescripcionPedido() + ", " + historico.getEstado().getIdEstado() + ", " + historico.getFecha() + ");";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoHistorico = new Historico_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoHistorico;
    }

    @Override
    public List<Historico_TO> consultarHistoricoDescripcion(DescripcionPedido_TO descripcion) throws Exception {
        List<Historico_TO> historico = new ArrayList<>();
        try {
            try {
                String sql = "SELECT h.idhistorico, h.iddescripcionpedido, h.idestado, h.fecha, e.nombre FROM public.historico as h, public.estado as e "
                        + "WHERE h.iddescripcionpedido = " + descripcion.getIdDescripcionPedido() + " and h.idestado = e.idestado";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    String[] fechaInicio = null;

                    fechaInicio = rs.getDate(4).toString().split("T");

                    String fechaInicioS = fechaInicio[0];

                    historico.add(new Historico_TO(rs.getInt(1), new DescripcionPedido_TO(rs.getInt(2)), new Estado_TO(rs.getInt(3), rs.getString(5)), fechaInicioS));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.conexion();
        }
        return historico;
    }

    @Override
    public Historico_TO consultarHistorico(Historico_TO historico) throws Exception {
        Historico_TO nuevohistorico = new Historico_TO();
        try {
            try {
                String sql = "SELECT idhistorico, iddescripcionpedido, idestado, fecha FROM public.historico "
                        + "WHERE idhistorico = " + historico.getIdHistorico() + "";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevohistorico = new Historico_TO(rs.getInt(1), new DescripcionPedido_TO(rs.getInt(2)), new Estado_TO(rs.getInt(3)), rs.getDate(4));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }
        return nuevohistorico;
    }

    @Override
    public Historico_TO eliminarHistorico(Historico_TO historico) throws Exception {
        Historico_TO nuevoHistorico = new Historico_TO();
        try {
            try {
                String sql = "DELETE FROM public.historico"
                        + " WHERE idhistorico = " + historico.getIdHistorico() + "";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoHistorico = new Historico_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoHistorico;
    }

}
