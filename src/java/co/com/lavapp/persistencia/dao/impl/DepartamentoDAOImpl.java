/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.modelo.dto.Pais_TO;
import co.com.lavapp.persistencia.dao.DepartamentoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class DepartamentoDAOImpl implements DepartamentoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Departamento_TO> consultarDepartamentos() throws Exception {
        List<Departamento_TO> departamentos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT iddepartamento, nombre, idpais FROM public.departamento";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    departamentos.add(new Departamento_TO(rs.getInt(1), rs.getString(2), new Pais_TO(rs.getInt(3))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return departamentos;
    }

    @Override
    public Departamento_TO consultarDepartamento(Departamento_TO departamento) throws Exception {
        Departamento_TO nuevodepartamento = new Departamento_TO();
        try {
            try {
                String sql = "SELECT iddepartamento, nombre, idpais FROM public.departamento"
                        + " WHERE iddepartamento = '" + departamento.getIdDepartamento() + "' or nombre = '" + departamento.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevodepartamento = new Departamento_TO(rs.getInt(1), rs.getString(2), new Pais_TO(rs.getInt(3)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevodepartamento;
    }

    @Override
    public Departamento_TO registrarDepartamento(Departamento_TO departamento) throws Exception {
        Departamento_TO nuevodepartamento = new Departamento_TO();
        try {
            try {
                String sql = "INSERT INTO public.departamento (nombre, idpais)"
                        + " VALUES ('" + departamento.getNombre() + "','" + departamento.getPais().getIdPais() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevodepartamento = new Departamento_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevodepartamento;
    }

    @Override
    public Departamento_TO modificarDepartamento(Departamento_TO departamento) throws Exception {
        Departamento_TO nuevodepartamento = new Departamento_TO();
        try {
            try {
                String sql = "UPDATE public.departamento SET nombre = '" + departamento.getNombre() + "', idpais = '" + departamento.getPais().getIdPais() + "'"
                        + " WHERE iddepartamento = '" + departamento.getIdDepartamento() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevodepartamento = new Departamento_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevodepartamento;
    }

    @Override
    public Departamento_TO eliminarDepartamento(Departamento_TO departamento) throws Exception {
        Departamento_TO nuevodepartamento = new Departamento_TO();
        try {
            try {
                String sql = "DELETE FROM public.departamento"
                        + " WHERE iddepartamento = '" + departamento.getIdDepartamento() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevodepartamento = new Departamento_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevodepartamento;
    }

    @Override
    public List<Departamento_TO> buscarDepartamentos(String valor) throws Exception {
        List<Departamento_TO> departamentos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT d.iddepartamento, d.nombre, d.idpais FROM public.departamento as d, public.pais as p "
                        + "WHERE d.idpais = p.idpais and (d.iddepartamento LIKE '%" + valor + "%' or "
                        + "d.nombre LIKE '%" + valor + "%' or idpais LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    departamentos.add(new Departamento_TO(rs.getInt(1), rs.getString(2), new Pais_TO(rs.getInt(3))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return departamentos;
    }

}
