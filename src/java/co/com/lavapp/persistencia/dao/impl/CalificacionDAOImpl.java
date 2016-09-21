/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Calificacion_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.persistencia.dao.CalificacionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class CalificacionDAOImpl implements CalificacionDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public Calificacion_TO registrarCalificacion(Calificacion_TO calificacion) throws Exception {
        Calificacion_TO nuevaCalificacion = new Calificacion_TO();
        try {
            try {
                String sql = "INSERT INTO public.calificacion( "
                        + " calificacion, observacion, idpedido) "
                        + " VALUES (" + calificacion.getCalificacion() + " , "
                        + " '" + calificacion.getObservacion() + "' , "
                        + " " + calificacion.getPedido().getIdPedido() + ") ";

                st.execute(sql);
            } catch (SQLException e) {
                nuevaCalificacion = new Calificacion_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaCalificacion;
    }

    @Override
    public List<Calificacion_TO> consultarCalificaciones() throws Exception {
        List<Calificacion_TO> califications = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idcalificacion, calificacion, observacion, idpedido "
                        + "  FROM public.calificacion;";
                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    califications.add(new Calificacion_TO(rs.getInt(1), rs.getInt(2), rs.getString(3), new Pedido_TO(rs.getInt(4))));
                }

            } catch (Exception e) {
                throw e;
            }
        } catch (Exception es) {
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return califications;
    }

    @Override
    public Calificacion_TO modificarCalificacion(Calificacion_TO cali) throws Exception {
        Calificacion_TO caliModelo = new Calificacion_TO();
        try {
            try {
                String sql = " UPDATE public.calificacion "
                        + "   SET  calificacion = " + cali.getCalificacion() + " , observacion = '" + cali.getObservacion() + "' , idpedido = " + cali.getPedido().getIdPedido() + " "
                        + " WHERE idcalificacion = '" + cali.getIdCalificacion() + "' ;";

                st.execute(sql);

            } catch (Exception e) {
                caliModelo = new Calificacion_TO();
                throw e;
            }
        } catch (Exception es) {
            caliModelo = new Calificacion_TO();
            throw es;
        }
        return caliModelo;
    }

    @Override
    public Calificacion_TO eliminarCalificacion(Calificacion_TO cali) throws Exception {
        Calificacion_TO caliModelo = new Calificacion_TO();
        try {
            try {
                String sql = "DELETE FROM public.calificacion "
                        + " WHERE idcalificacion=" + cali.getIdCalificacion() + ";";
                st.execute(sql);

                caliModelo = new Calificacion_TO();
            } catch (Exception e) {
                caliModelo = new Calificacion_TO();
                throw e;
            }
        } catch (Exception ed) {
            caliModelo = new Calificacion_TO();
            throw ed;
        }
        return caliModelo;
    }

    @Override
    public Calificacion_TO consultarCalificacionPorPedido(Pedido_TO pedido) throws Exception {
        Calificacion_TO nuevaCalificacion = new Calificacion_TO();
        try {
            try {
                String sql = "SELECT idcalificacion, calificacion, observacion, idpedido"
                        + " FROM public.calificacion"
                        + " WHERE idpedido = '" + pedido.getIdPedido() + "';";
                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    nuevaCalificacion = new Calificacion_TO(rs.getInt(1), rs.getInt(2), rs.getString(3), new Pedido_TO(rs.getInt(4)));
                }

            } catch (Exception e) {
                throw e;
            }
        } catch (Exception es) {
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaCalificacion;
    }

    @Override
    public List<Calificacion_TO> consultarCalificacionesSegunPlantaPedidos(Proveedor_TO proveedor) throws Exception {
        List<Calificacion_TO> califications = new ArrayList<>();
        try {
            try {
                String sql = "SELECT c.idcalificacion, c.calificacion, c.observacion, c.idpedido "
                        + " FROM public.calificacion as c, public.proveedor as pr, public.pedido as p "
                        + " WHERE c.idpedido = p.idpedido AND p.idproveedor = pr.idproveedor AND pr.idproveedor = '" + proveedor.getIdProveedor() + "';";

                ResultSet rs = null;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    califications.add(new Calificacion_TO(rs.getInt(1), rs.getInt(2), rs.getString(3), new Pedido_TO(rs.getInt(4))));
                }

            } catch (Exception e) {
                throw e;
            }
        } catch (Exception es) {
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return califications;
    }

}
