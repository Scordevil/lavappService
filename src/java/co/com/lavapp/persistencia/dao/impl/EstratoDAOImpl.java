/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.persistencia.dao.EstratoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class EstratoDAOImpl implements EstratoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Estrato_TO consultarEstrato(Estrato_TO estrato) throws Exception {
        Estrato_TO nuevoEstrato = new Estrato_TO();
        try {
            try {
                String sql = "SELECT idestrato, nombre FROM public.estrato "
                        + "WHERE idestrato = '" + estrato.getIdEstrato() + "' or nombre = '" + estrato.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevoEstrato = new Estrato_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoEstrato;
    }

    @Override
    public List<Estrato_TO> consultarEstratos() throws Exception {
        List<Estrato_TO> estratos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idestrato, nombre FROM public.estrato";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    estratos.add(new Estrato_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return estratos;
    }

    @Override
    public Estrato_TO registrarEstrato(Estrato_TO estrato) throws Exception {
        Estrato_TO nuevoEstrato = new Estrato_TO();
        try {
            try {
                String sql = "INSERT INTO public.estrato(nombre) "
                        + "VALUES('" + estrato.getNombre() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoEstrato = new Estrato_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoEstrato;
    }

    @Override
    public Estrato_TO editarEstrato(Estrato_TO estrato) throws Exception {
        Estrato_TO nuevoEstrato = new Estrato_TO();
        try {
            try {
                String sql = "UPDATE public.estrato SET nombre = '" + estrato.getNombre() + "' "
                        + "WHERE idestrato = '" + estrato.getIdEstrato() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoEstrato = new Estrato_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoEstrato;
    }

    @Override
    public Estrato_TO eliminarEstrato(Estrato_TO estrato) throws Exception {
        Estrato_TO nuevoEstrato = new Estrato_TO();
        try {
            try {
                String sql = "DELETE FROM public.estrato "
                        + "WHERE idestrato = '" + estrato.getIdEstrato() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoEstrato = new Estrato_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoEstrato;
    }

}
