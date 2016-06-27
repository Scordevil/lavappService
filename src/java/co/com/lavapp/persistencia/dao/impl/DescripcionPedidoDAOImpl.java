/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoDAOImpl implements DescripcionPedidoDAO {

    private final Statement st = ConexionSQL.conexion();

    //Metodo consultar Cantidad de descripciones(productos) agregadas segun pedido
    @Override
    public int consultarCantidadDescripcionPedido(Pedido_TO pedido) throws Exception {
        int cantidad = 0;
        try {
            try {
                String sql = "SELECT COUNT(iddescripcionpedido) "
                        + "from public.descripcionpedido as descripcionpedido WHERE "
                        + "descripcionpedido.idpedido = '" + pedido.getIdPedido() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    cantidad = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return cantidad;
    }

    @Override
    public List<DescripcionPedido_TO> consultarDescripcionPedidoSegunPedido(Pedido_TO pedido) throws Exception {
        List<DescripcionPedido_TO> descripcionPedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT iddescripcionpedido, "
                        + "idestado, idsubproducto, descripcion, "
                        + "observacionasesor, observacionadministrador, foto1, "
                        + "foto2, foto3, idcolor, idpedido FROM "
                        + "from public.descripcionpedido as descripcionpedido WHERE "
                        + "descripcionpedido.idpedido = '" + pedido.getIdPedido() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    descripcionPedidos.add(new DescripcionPedido_TO(rs.getInt(1),
                            new Estado_TO(rs.getInt(2)),
                            new SubProducto_TO(rs.getInt(3)),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getByte(7),
                            rs.getByte(8),
                            rs.getByte(9),
                            new Color_TO(rs.getInt(10)),
                            new Pedido_TO(rs.getInt(11))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return descripcionPedidos;
    }

    @Override
    public DescripcionPedido_TO EditarEstadoDescripcionPedido(DescripcionPedido_TO descripcion, Estado_TO estado) throws Exception {
        DescripcionPedido_TO nuevaDescripcion = new DescripcionPedido_TO();
        try {
            try {
                String sql = "UPDATE public.descripcionpedido as descripcion"
                        + " SET idestado= '" + estado.getIdEstado() + "'"
                        + " WHERE descripcion.iddescripcion = '" + descripcion.getIdDescripcionPedido() + "';";
                ResultSet rs = st.executeQuery(sql);
            } catch (SQLException e) {
                nuevaDescripcion = new DescripcionPedido_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaDescripcion;
    }

    @Override
    public DescripcionPedido_TO registrarPreedidos(DescripcionPedido_TO descP) throws Exception {
        DescripcionPedido_TO descModelo = new DescripcionPedido_TO();
        try {
            try {
                String sql = "INSERT INTO public.descripcionpedido( "
                        + "            idestado, descripcion,  idcolor, idpedido,  "
                        + "            idsubproducto) "
                        + "    VALUES ( " + descP.getEstado().getIdEstado() + ", '" + descP.getDescripcion() + "', " + descP.getColor().getIdColor() + ", " + descP.getPedido().getIdPedido() + ", " + descP.getSubProducto().getIdSubProducto() + ") ";

                st.execute(sql);
                descModelo = new DescripcionPedido_TO();
            } catch (Exception e) {
                descModelo = new DescripcionPedido_TO();
                throw e;
            }
        } catch (Exception ec) {
            descModelo = new DescripcionPedido_TO();
            throw ec;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return descModelo;
    }

    @Override
    public DescripcionPedido_TO elimnarPedidos(DescripcionPedido_TO descP) throws Exception {
        DescripcionPedido_TO descPedi = new DescripcionPedido_TO();
        try {
            try {
                String sql = "DELETE FROM public.descripcionpedido "
                        + " WHERE idpedido = "+ descP.getPedido() +";";
                st.execute(sql);
                descPedi = new DescripcionPedido_TO();
            } catch (Exception e) {
                descPedi = new DescripcionPedido_TO();
                throw e;
            }
        } catch (Exception ec) {
            descPedi = new DescripcionPedido_TO();
            throw ec;

        } finally {
            ConexionSQL.CerrarConexion();
        }
        return descPedi;
    }
}
