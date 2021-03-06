/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.CantTemp_TO;
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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoDAOImpl implements DescripcionPedidoDAO {

    private final Statement st = ConexionSQL.conexion();

    //Metodo consultar Cantidad de descripciones(productos) agregadas segun pedido
    @Override
    public CantTemp_TO consultarCantidadDescripcionPedido(Pedido_TO pedido) throws Exception {
        CantTemp_TO cantTemp = new CantTemp_TO();
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

                cantTemp.setCantDescripPedido(cantidad);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return cantTemp;
    }

    @Override
    public List<DescripcionPedido_TO> consultarDescripcionPedidoSegunPedido(Pedido_TO pedido) throws Exception {
        List<DescripcionPedido_TO> descripcionPedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT dp.iddescripcionpedido, "
                        + " dp.idestado, dp.idsubproducto, dp.descripcion, "
                        + " dp.observacionasesor, dp.observacionadministrador, dp.foto1, "
                        + " dp.foto2, dp.foto3, dp.idcolor, dp.idpedido, dp.codigo, e.nombre, sp.nombre"
                        + " from public.descripcionpedido as dp, public.subproducto as sp, public.estado as e WHERE "
                        + " dp.idpedido = " + pedido.getIdPedido() + " and sp.idsubproducto = dp.idsubproducto and dp.idestado = e.idestado ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    descripcionPedidos.add(new DescripcionPedido_TO(rs.getInt(1),
                            new Estado_TO(rs.getInt(2), rs.getString(13)),
                            new SubProducto_TO(rs.getInt(3), rs.getString(14)),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            new Color_TO(rs.getInt(10)),
                            new Pedido_TO(rs.getInt(11)),
                            rs.getString(12)));
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
    public DescripcionPedido_TO consultarDescripcionPedidoSegunProducto(DescripcionPedido_TO descripcion) throws Exception {
        DescripcionPedido_TO descripcionPedido = new DescripcionPedido_TO();
        try {
            try {
                String sql = "SELECT dp.iddescripcionpedido, "
                        + " dp.idestado, dp.idsubproducto, dp.descripcion, "
                        + " dp.observacionasesor, dp.observacionadministrador, dp.foto1, "
                        + " dp.foto2, dp.foto3, dp.idcolor, dp.idpedido, dp.codigo, e.nombre, sp.nombre "
                        + " from public.descripcionpedido as dp, public.subproducto as sp, public.estado as e WHERE "
                        + " dp.iddescripcionpedido = " + descripcion.getIdDescripcionPedido() + " and sp.idsubproducto = dp.idsubproducto and dp.idestado = e.idestado ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    descripcionPedido = new DescripcionPedido_TO(rs.getInt(1),
                            new Estado_TO(rs.getInt(2), rs.getString(13)),
                            new SubProducto_TO(rs.getInt(3), rs.getString(14)),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            new Color_TO(rs.getInt(10)),
                            new Pedido_TO(rs.getInt(11)),
                            rs.getString(12));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return descripcionPedido;
    }

    @Override
    public DescripcionPedido_TO editarEstadoDescripcionPedido(DescripcionPedido_TO descripcion) throws Exception {
        DescripcionPedido_TO nuevaDescripcion = new DescripcionPedido_TO();
        try {
            try {
                String sql = "UPDATE public.descripcionpedido as descripcion"
                        + " SET idestado = '" + descripcion.getEstado().getIdEstado() + "'"
                        + " WHERE descripcion.iddescripcionpedido = '" + descripcion.getIdDescripcionPedido() + "';";
                st.execute(sql);
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
    public DescripcionPedido_TO registrarDescripcion(DescripcionPedido_TO descP) throws Exception {
        DescripcionPedido_TO descModelo = new DescripcionPedido_TO();
        try {
            try {
                String sql = "INSERT INTO public.descripcionpedido(idestado, idpedido, idsubproducto) "
                        + " VALUES ( " + descP.getEstado().getIdEstado() + ", "
                        + "" + descP.getPedido().getIdPedido() + ", "
                        + "" + descP.getSubProducto().getIdSubProducto() + ") ";

                st.execute(sql);
                descModelo = new DescripcionPedido_TO();
            } catch (SQLException e) {
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
    public DescripcionPedido_TO eliminarDescripcion(DescripcionPedido_TO descP) throws SQLException, Exception {
        DescripcionPedido_TO descPedi = new DescripcionPedido_TO();
        try {
            try {
                String sql = " DELETE FROM public.descripcionpedido "
                        + " WHERE iddescripcionpedido = " + descP.getIdDescripcionPedido() + "";
                st.execute(sql);
                descPedi = new DescripcionPedido_TO();

            } catch (SQLException e) {

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

    @Override
    public DescripcionPedido_TO editarDescripcion(DescripcionPedido_TO descripcion) throws Exception {
        DescripcionPedido_TO nuevaDescripcion = new DescripcionPedido_TO();
        try {
            try {
                String sql = "UPDATE public.descripcionpedido "
                        + " SET idestado= '" + descripcion.getEstado().getIdEstado() + "',"
                        + " descripcion = '" + descripcion.getDescripcion() + "',"
                        + " observacionasesor = '" + descripcion.getObservacionAsesor() + "',"
                        + " observacionadministrador = '" + descripcion.getObservacionAdministrador() + "',"
                        + " idcolor = '" + descripcion.getColor().getIdColor() + "',"
                        + " idpedido = '" + descripcion.getPedido().getIdPedido() + "',"
                        + " idsubproducto = '" + descripcion.getSubProducto().getIdSubProducto() + "',"
                        + " codigo = '" + descripcion.getCodigo() + "'"
                        + " WHERE iddescripcionpedido = '" + descripcion.getIdDescripcionPedido() + "'";
                st.execute(sql);
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
    public DescripcionPedido_TO editarDescripcionAsesor(DescripcionPedido_TO descripcion) throws Exception {
        DescripcionPedido_TO nuevaDescripcion = new DescripcionPedido_TO();
        try {
            try {
                String sql = "UPDATE public.descripcionpedido "
                        + " SET idestado= " + descripcion.getEstado().getIdEstado() + ","
                        + " observacionasesor = '" + descripcion.getObservacionAsesor() + "',"
                        + " idcolor = " + descripcion.getColor().getIdColor() + ","
                        + " foto1 = '" + descripcion.getFoto1() + "',"
                        + " foto2 = '" + descripcion.getFoto2() + "',"
                        + " foto3 = '" + descripcion.getFoto3() + "',"
                        + " codigo = '" + descripcion.getCodigo() + "',"
                        + " nombrefoto1 = '" + descripcion.getNombrefoto1()+ "',"
                        + " nombrefoto2 = '" + descripcion.getNombrefoto2()+ "',"
                        + " nombrefoto3 = '" + descripcion.getNombrefoto3()+ "'"
                        + " WHERE iddescripcionpedido = " + descripcion.getIdDescripcionPedido() + "";
                st.execute(sql);
            } catch (SQLException e) {
                nuevaDescripcion = new DescripcionPedido_TO();
                throw e;
            }
        } catch (Exception e) {
            nuevaDescripcion = new DescripcionPedido_TO();
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaDescripcion;
    }

    @Override
    public DescripcionPedido_TO eliminarDescripcionesSegunPedido(Pedido_TO pedido) throws Exception {
        DescripcionPedido_TO descPedi = new DescripcionPedido_TO();
        try {
            try {
                String sql = " DELETE FROM public.descripcionpedido "
                        + " WHERE idpedido = " + pedido.getIdPedido() + "";
                st.execute(sql);
                descPedi = new DescripcionPedido_TO();

            } catch (SQLException e) {

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

    @Override
    public DescripcionPedido_TO consultarDescripcionPedido(DescripcionPedido_TO descripcion) throws Exception {
        DescripcionPedido_TO nuevaDescripcion = new DescripcionPedido_TO();
        try {
            try {
                String sql = "SELECT dp.iddescripcionpedido, "
                        + " dp.idestado, dp.idsubproducto, dp.descripcion, "
                        + " dp.observacionasesor, dp.observacionadministrador, dp.foto1, "
                        + " dp.foto2, dp.foto3, dp.idcolor, dp.idpedido, dp.codigo"
                        + " from public.descripcionpedido as dp"
                        + " WHERE dp.iddescripcionpedido = " + descripcion.getIdDescripcionPedido() + "";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevaDescripcion = new DescripcionPedido_TO(rs.getInt(1),
                            new Estado_TO(rs.getInt(2)),
                            new SubProducto_TO(rs.getInt(3)),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            new Color_TO(rs.getInt(10)),
                            new Pedido_TO(rs.getInt(11)),
                            rs.getString(12));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaDescripcion;
    }
}
