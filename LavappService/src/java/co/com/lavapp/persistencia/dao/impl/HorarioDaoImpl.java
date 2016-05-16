/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Jornada_TO;
import co.com.lavapp.persistencia.dao.HorarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class HorarioDaoImpl implements HorarioDAO {

    private final Statement st = ConexionSQL.conexion();

    
    //Metodo Consulta horarios
    @Override
    public List<Horario_TO> consultarHorariosSegunJornada(Jornada_TO jornada) throws Exception {
        List<Horario_TO> horarios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idhorario, horaInicio, horaFinal, idjornada from public.horario as horario "
                        + "where horario.idjornada = '" + jornada.getIdJornada() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    horarios.add(new Horario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Jornada_TO(rs.getInt(4))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return horarios;
    }

}
