/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Pais_TO;
import co.com.lavapp.persistencia.dao.PaisDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class PaisDAOImpl implements PaisDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Pais_TO consultarPais(Pais_TO pais) throws Exception {
        Pais_TO nuevopais = new Pais_TO();
        try {
            try {
                String sql = "SELECT idPais, nombre FROM public.pais"
                        + " WHERE idPais = '" + pais.getIdPais() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevopais = new Pais_TO(rs.getInt(1), rs.getString(2));
                }
            } catch (SQLException e) {
                nuevopais = new Pais_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopais;
    }

    @Override
    public List<Pais_TO> consultarPaises() throws Exception {
        List<Pais_TO> paises = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idPais, nombre FROM public.pais";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    paises.add(new Pais_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return paises;
    }

    @Override
    public Pais_TO registrarPais(Pais_TO pais) throws Exception {
        Pais_TO nuevopais = new Pais_TO();
        try {
            try {
                String sql = "INSERT INTO public.pais(nombre)"
                        + " VALUES ('" + pais.getNombre() + "')";
                st.execute(sql);
            } catch (Exception e) {
                nuevopais = new Pais_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopais;
    }

    @Override
    public Pais_TO modificarPais(Pais_TO pais) throws Exception {
        Pais_TO nuevopais = new Pais_TO();
        try {
            try {
                String sql = "UPDATE public.pais"
                        + " SET nombre = '" + pais.getNombre() + "'"
                        + " WHERE idPais = '" + pais.getIdPais() + "'";
                st.execute(sql);
            } catch (Exception e) {
                nuevopais = new Pais_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopais;
    }

    @Override
    public Pais_TO eliminarPais(Pais_TO pais) throws Exception {
        Pais_TO nuevopais = new Pais_TO();
        try {
            try {
                String sql = "DELETE FROM public.pais as pais"
                        + " WHERE pais.idPais = '" + pais.getIdPais() + "'";
                st.execute(sql);
            } catch (Exception e) {
                nuevopais = new Pais_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopais;
    }

}
