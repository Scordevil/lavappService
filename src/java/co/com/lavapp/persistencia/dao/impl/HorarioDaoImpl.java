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
                String sql = "SELECT idhorario, horaInicio, horaFinal, idjornada, horario from public.horario as horario "
                        + "where horario.idjornada = '" + jornada.getIdJornada() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    horarios.add(new Horario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Jornada_TO(rs.getInt(4)), rs.getString(5)));
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

    @Override
    public Horario_TO consultarHorario(Horario_TO horario) throws Exception {
        Horario_TO nuevoHorario = new Horario_TO();
        try {
            try {
                String sql = "SELECT idhorario, horaInicio, horaFinal, idjornada, horario from public.horario "
                        + "where idhorario = '" + horario.getIdHorario() + "' or horario = '" + horario.getHorario() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevoHorario = new Horario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Jornada_TO(rs.getInt(4)), rs.getString(5));
                }
            } catch (SQLException e) {
                nuevoHorario = new Horario_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoHorario;
    }

    @Override
    public Horario_TO registrarHorario(Horario_TO horario) throws Exception {
        Horario_TO nuevoHorario = new Horario_TO();
        try {
            try {
                String sql = "INSERT INTO public.horario (horainicio, horafinal, idjornada, horario) "
                        + "VALUES('" + horario.getHoraInicio() + "','" + horario.getHoraFinal() + "','" + horario.getJornada().getIdJornada() + "','" + horario.getHorario() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoHorario = new Horario_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoHorario;
    }

    @Override
    public Horario_TO modificarHorario(Horario_TO horario) throws Exception {
        Horario_TO nuevoHorario = new Horario_TO();
        try {
            try {
                String sql = "UPDATE public.horario SET "
                        + "horainicio = '" + horario.getHoraInicio() + "', "
                        + "horafinal = '" + horario.getHoraFinal() + "', "
                        + "idjornada = '" + horario.getJornada().getIdJornada() + "', "
                        + "horario = '" + horario.getHorario() + "' "
                        + "WHERE idhorario = '" + horario.getIdHorario() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoHorario = new Horario_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoHorario;
    }

    @Override
    public Horario_TO eliminarHorario(Horario_TO horario) throws Exception {
        Horario_TO nuevoHorario = new Horario_TO();
        try {
            try {
                String sql = "DELETE FROM public.horario "
                        + "WHERE idhorario = '" + horario.getIdHorario() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoHorario = new Horario_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoHorario;
    }

    @Override
    public List<Horario_TO> consultarHorarios() throws Exception {
        List<Horario_TO> horarios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idhorario, horaInicio, horaFinal, idjornada, horario from public.horario";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    horarios.add(new Horario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Jornada_TO(rs.getInt(4)), rs.getString(5)));
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

    @Override
    public List<Horario_TO> buscarHorarios(String valor) throws Exception {
        List<Horario_TO> horarios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT h.idhorario, h.horaInicio, h.horaFinal, h.idjornada, h.horario "
                        + "FROM public.horario as h, public.jornada as j "
                        + "WHERE h.idjornada = j.idjornada and "
                        + "(h.idhorario LIKE '%" + valor + "%' or h.horarioInicio LIKE '%" + valor + "%' or h.horaFinal LIKE '%" + valor + "%' or "
                        + "h.idjornada LIKE '%" + valor + "%' or h.horario LIKE '%" + valor + "%' or j.nombre LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    horarios.add(new Horario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), new Jornada_TO(rs.getInt(4)), rs.getString(5)));
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
