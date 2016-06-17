/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Servicio_TO;
import co.com.lavapp.persistencia.dao.ServicioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServicioDAOImpl implements ServicioDAO {

    private final Statement st = ConexionSQL.conexion();

    //Metodo para consultar servicios
    @Override
    public List<Servicio_TO> consultarServicios() throws Exception {
        List<Servicio_TO> servicios = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idservicio, nombre FROM servicio;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    servicios.add(new Servicio_TO(rs.getInt(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                throw e;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();

        }
        return servicios;
    }

    @Override
    public Servicio_TO registrarServicio(Servicio_TO serv) throws Exception {

        Servicio_TO servicio = new Servicio_TO();
        try {
            try {

                String sql = "INSERT INTO public.servicio( nombre ) "
                        + "    VALUES ('"+ serv.getNombre() +"')";
                st.execute(sql);

            } catch (Exception e) {
                servicio = new Servicio_TO();
                throw e;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return servicio;
    }

}
