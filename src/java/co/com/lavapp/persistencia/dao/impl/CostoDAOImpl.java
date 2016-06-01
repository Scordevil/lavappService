/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Costo_TO;
import co.com.lavapp.persistencia.dao.CostoDAO;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Desarrollo_Planit
 */
public class CostoDAOImpl implements CostoDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Costo_TO RegistrarCosto(Costo_TO costo) throws Exception {
        Costo_TO nuevocosto = new Costo_TO();
        try {
            try {
                String sql = "INSERT INTO public.costo("
                        + " valor, idsubproducto, idzona)"
                        + " VALUES ( " + costo.getValor() + ", " + costo.getSubProducto().getIdSubProducto() + ", " + costo.getZona().getIdZona() + ");";
                st.execute(sql);
            } catch (SQLException e) {
                nuevocosto = new Costo_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevocosto;
    }

}
