/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Historico_TO;
import co.com.lavapp.persistencia.dao.HistoricoDAO;
import java.sql.SQLException;
import java.sql.Statement;

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

}
