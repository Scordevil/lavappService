/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Ciudad_TO;
import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.LocalidadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implementacion que contiene los metodos de persistencia relacionados con la
 * entidad Localidad
 *
 * @author SISTEMAS
 */
public class LocalidadDAOImpl implements LocalidadDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Localidad_TO> consultarLocalidades(Ciudad_TO ciudad) throws Exception {

        List<Localidad_TO> localidades = new ArrayList<>();
        try {

            try {
                String sql = "SELECT localidad.idlocalidad, localidad.nombre, localidad.idciudad "
                        + "  FROM public.localidad , public.ciudad "
                        + "  WHERE " + ciudad.getIdCiudad() + " = localidad.idciudad and"
                        + "  ciudad.idciudad = localidad.idciudad ;";

                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    localidades.add(new Localidad_TO(rs.getInt(1), rs.getString(2), new Ciudad_TO(rs.getInt(3))));
                }

            } catch (SQLException r) {
                throw r;
            }
        } catch (Exception e) {
            throw e;
        }
        ConexionSQL.CerrarConexion();
        return localidades;
    }

}
