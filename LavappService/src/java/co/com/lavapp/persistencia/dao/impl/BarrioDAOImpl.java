/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Barrio_TO;
import co.com.lavapp.modelo.dto.Estrato_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.BarrioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class BarrioDAOImpl implements BarrioDAO {

    private final Statement st = ConexionSQL.conexion();

    /*
     *METODO DE CONSULTA DE BARRIOS SEGUN LA LOCALIDAD
     */
    @Override
    public List<Barrio_TO> consultarBarrios(Localidad_TO localidad) throws Exception {

        List<Barrio_TO> barrios = new ArrayList<>();

        try {
            try {
                String sql = "SELECT barrio.idbarrios, barrio.nombre, barrio.idlocalidad, barrio.idzona, barrio.idestrato "
                        + "  FROM public.barrio , public.localidad "
                        + "  WHERE barrio.idlocalidad = localidad.idlocalidad "
                        + "  AND barrio.idlocalidad =  " + localidad.getIdLocalidad() + " ; ";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    barrios.add(new Barrio_TO(rs.getInt(1),
                            rs.getString(2),
                            new Localidad_TO(rs.getInt(3)),
                            new Zona_TO(rs.getInt(4)),
                            new Estrato_TO(rs.getInt(5))));
                }
                
                
            } catch (SQLException er) {
                throw er;
            }

        } catch (Exception e) {
            throw e;
        }
        ConexionSQL.CerrarConexion();
        return barrios;
    }

}
