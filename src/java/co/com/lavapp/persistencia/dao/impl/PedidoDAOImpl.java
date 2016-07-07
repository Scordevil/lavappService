/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.Horario_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.PedidoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoDAOImpl implements PedidoDAO {

    private final Statement st = ConexionSQL.conexion();

    //Metodo registro de pedido
    @Override
    public Pedido_TO registrarPedido(Pedido_TO pedido) throws Exception {
        Pedido_TO nuevopedido = new Pedido_TO();
        try {
            try {
                String sql = "INSERT INTO public.pedido(fechainicio, horarioinicio_idhorario, horariofinal_idhorario, idestado)"
                        + " VALUES ('" + pedido.getFechaInicio().toString() + "', '" + pedido.getHoraInicio().getIdHorario() + "', '" + pedido.getHoraFinal().getIdHorario() + "', '" + pedido.getEstado().getIdEstado() + "')";

                st.execute(sql);
            } catch (Exception e) {
                nuevopedido = new Pedido_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopedido;
    }

    //Metodo eliminar pedido
    @Override
    public Pedido_TO eliminarPedido(Pedido_TO pedido) throws Exception {
        Pedido_TO nuevopedido = new Pedido_TO();
        try {
            try {
                String sql = "DELETE FROM public.pedido "
                        + "WHERE idpedido = '" + pedido.getIdPedido() + "';";

                st.execute(sql);
            } catch (Exception e) {
                nuevopedido = new Pedido_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopedido;
    }

    //Metodo consultar pedidos cliente
    @Override
    public List<Pedido_TO> consultarPedidosCliente(Usuario_TO usuario) throws Exception {
        List<Pedido_TO> pedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT pedido.idpedido, pedido.idusuario, pedido.fechaInicio, pedido.horarioinicio_idhorario, pedido.horariofinal_idhorario, pedido.idestado, estado.nombre, pedido.idproveedor " +
                   " from public.pedido as pedido, public.estado as estado WHERE " +
                    "   pedido.idusuario = "+usuario.getIdUsuario()+" and estado.idestado = pedido.idestado;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    
                    String[] Fecha = null;                    
                                
                    Fecha = rs.getDate(3).toString().split("T");

                      String fechaInicioS = Fecha[0].toString();
                    
                    pedidos.add(new Pedido_TO(rs.getInt(1), new Usuario_TO(rs.getInt(2)), fechaInicioS,  new Horario_TO(rs.getInt(4)), new Horario_TO(rs.getInt(5)), new Estado_TO(rs.getInt(6),rs.getString(7)), new Proveedor_TO(rs.getInt(8))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return pedidos;
    }

    //Metodo Consultar un pedido
    @Override
    public Pedido_TO consultarPedido(Pedido_TO pedido) throws Exception {
        Pedido_TO nuevopedido = new Pedido_TO();
        try {
            try {
                String sql = "SELECT idpedido, idusuario, fechaInicio, horarioinicio_idhorario, horariofinal_idhorario, idestado, idproveedor "
                        + "from public.pedido as pedido WHERE "
                        + "pedido.idusuario = '" + pedido.getUsuario().getIdUsuario() + "' and "
                        + "pedido.fechaInicio = '" + pedido.getFechaInicio() + "' and "
                        + "pedido.horarioinicio_idhorario = '" + pedido.getHoraInicio().getIdHorario() + "' and "
                        + "pedido.horariofinal_idhorario = '" + pedido.getHoraFinal().getIdHorario() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevopedido = new Pedido_TO(rs.getInt(1), new Usuario_TO(rs.getInt(2)), rs.getDate(3), new Horario_TO(rs.getInt(4)), new Horario_TO(rs.getInt(5)), new Estado_TO(rs.getInt(6)), new Proveedor_TO(rs.getInt(7)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevopedido;
    }

    @Override
    public Pedido_TO editarEstadoPedido(Pedido_TO pedido, Estado_TO estado) throws Exception {
        Pedido_TO nuevopedido = new Pedido_TO();
        try {
            try {
                String sql = "UPDATE public.pedido "
                        + "SET idestado = '" + estado.getIdEstado() + "' "
                        + "WHERE idpedido = '" + pedido.getIdPedido() + "';";

                st.execute(sql);
            } catch (SQLException e) {
                nuevopedido = new Pedido_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }
        return nuevopedido;
    }

    @Override
    public List<Pedido_TO> consultarPedidos() throws Exception {
        List<Pedido_TO> pedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idpedido, idusuario, "
                        + "fechaInicio, horarioinicio_idhorario, "
                        + "horariofinal_idhorario, idestado, idproveedor "
                        + "from public.pedido as pedido";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pedidos.add(new Pedido_TO(rs.getInt(1), new Usuario_TO(rs.getInt(2)), rs.getDate(3), new Horario_TO(rs.getInt(4)), new Horario_TO(rs.getInt(5)), new Estado_TO(rs.getInt(6)), new Proveedor_TO(rs.getInt(7))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return pedidos;
    }

    @Override
    public List<Pedido_TO> consultarPedidosSegunPlanta(Proveedor_TO proveedor) throws Exception {
        List<Pedido_TO> pedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idpedido, idusuario, "
                        + "fechaInicio, horarioinicio_idhorario, "
                        + "horariofinal_idhorario, idestado, idproveedor "
                        + "FROM public.pedido as pedido "
                        + "WHERE pedido.idproveedor = '" + proveedor.getIdProveedor() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pedidos.add(new Pedido_TO(rs.getInt(1),
                            new Usuario_TO(rs.getInt(2)),
                            rs.getDate(3),
                            new Horario_TO(rs.getInt(4)),
                            new Horario_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6)),
                            new Proveedor_TO(rs.getInt(7))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return pedidos;
    }

    @Override
    public Pedido_TO consultarUltimoPedido(Usuario_TO usuario) throws Exception {
        Pedido_TO ultimoPedido = new Pedido_TO();
        try {
            try {
                String sql = " SELECT MAX(idpedido) FROM public.pedido "
                        + "WHERE idusuario = '" + usuario.getIdUsuario() + "'";
                      
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    ultimoPedido = new Pedido_TO(rs.getInt(1));
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception ec) {
            throw ec;
        }
        return ultimoPedido;
    }

}
