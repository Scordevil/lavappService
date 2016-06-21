/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.modelo.dto.SubServicio_TO;
import co.com.lavapp.persistencia.dao.SubServicioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubServicioDAOImpl implements SubServicioDAO {

    private final Statement st = ConexionSQL.conexion();

    //Metodo para consultar subservicios segun ID de Servicio
    @Override
    public List<SubServicio_TO> consultarSubServicios(Servicio_TO servicio) throws Exception {
        List<SubServicio_TO> subservicios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT subservicio.idsubservicio, subservicio.nombre, subservicio.idservicio FROM "
                        + "subservicio as subservicio where "
                        + "'" + servicio.getIdServicio() + "' = subservicio.idservicio;";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    subservicios.add(new SubServicio_TO(rs.getInt(1), rs.getString(2), new Servicio_TO(rs.getInt(3))));
                }

            } catch (SQLException e) {
                throw e;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();

        }
        return subservicios;
    }

    @Override
    public List<SubServicio_TO> consultarSubServicios() throws Exception {
        List<SubServicio_TO> subservicios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idsubservicio, nombre, idservicio "
                        + "  FROM public.subservicio;";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    subservicios.add(new SubServicio_TO(rs.getInt(1), rs.getString(2), new Servicio_TO(rs.getInt(3))));
                }

            } catch (SQLException e) {
                throw e;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();

        }
        return subservicios;
    }

    @Override
    public SubServicio_TO registrarSubServicio(SubServicio_TO subServi) throws Exception {
        
        SubServicio_TO subServic = new SubServicio_TO();
        try {
            try {
                String sql = "INSERT INTO public.subservicio( "
                        + "             nombre, idservicio) "
                        + "    VALUES ( '"+ subServi.getNombre() +"', "+ subServi.getServicio().getIdServicio() +");";

                st.executeQuery(sql);
            } catch (Exception e) {
                subServic = new SubServicio_TO();
                throw e;
            }
        } catch (Exception ec) {
           
            throw ec;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return subServic;
    }

}
