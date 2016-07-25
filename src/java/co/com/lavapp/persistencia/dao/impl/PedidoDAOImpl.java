/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Barrio_TO;
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
                String sql = "INSERT INTO public.pedido(fechainicio,"
                        + " horarioinicio_idhorario,"
                        + " horariofinal_idhorario,"
                        + " idestado)"
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
                String sql = "SELECT idpedido, idusuario, "
                        + "fechaInicio, horarioinicio_idhorario, "
                        + "horariofinal_idhorario, p.idestado, idproveedor, "
                        + "fechaentrega, direccionrecogida, direccionentrega, "
                        + "fecharecogida, quienentrega, quienrecibe, "
                        + "idbarrios_recogida, idbarrios_entrega, e.nombre "
                        + "from public.pedido as p, public.estado as e WHERE "
                        + "p.idusuario = " + usuario.getIdUsuario() + " and e.idestado = p.idestado;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    String[] fechaInicio = null, fechaEntrega = null, fechaRecogida = null;

                    fechaInicio = rs.getDate(3).toString().split("T");

                    String fechaInicioS = fechaInicio[0];


                    fechaEntrega = rs.getDate(3).toString().split("T");

                    String fechaEntregaS = fechaEntrega[0];


                    fechaRecogida = rs.getDate(3).toString().split("T");

                    String fechaRecogidaS = fechaRecogida[0];

                    pedidos.add(new Pedido_TO(rs.getInt(1),
                            new Usuario_TO(rs.getInt(2)),
                            fechaInicioS,
                            new Horario_TO(rs.getInt(4)),
                            new Horario_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6),rs.getString(16)),
                            new Proveedor_TO(rs.getInt(7)),
                            fechaEntregaS,
                            rs.getString(9),
                            rs.getString(10),
                            fechaRecogidaS,
                            rs.getString(12),
                            rs.getString(13),
                            new Barrio_TO(rs.getInt(14)),
                            new Barrio_TO(rs.getInt(15))));
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
    
     //Metodo consultar pedidos Asesor
    @Override
    public List<Pedido_TO> consultarPedidosAsesor(Usuario_TO usuario) throws Exception {
        List<Pedido_TO> pedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idpedido, idusuario, "
                        + "fechaInicio, horarioinicio_idhorario, "
                        + "horariofinal_idhorario, p.idestado, idproveedor, "
                        + "fechaentrega, direccionrecogida, direccionentrega, "
                        + "fecharecogida, quienentrega, quienrecibe, "
                        + "idbarrios_recogida, idbarrios_entrega, e.nombre "
                        + "from public.pedido as p, public.estado as e WHERE "
                        + "p.idasesor = " + usuario.getIdUsuario() + " and e.idestado = p.idestado;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    String[] fechaInicio = null, fechaEntrega = null, fechaRecogida = null;

                    fechaInicio = rs.getDate(3).toString().split("T");

                    String fechaInicioS = fechaInicio[0];


                    fechaEntrega = rs.getDate(3).toString().split("T");

                    String fechaEntregaS = fechaEntrega[0];


                    fechaRecogida = rs.getDate(3).toString().split("T");

                    String fechaRecogidaS = fechaRecogida[0];

                    pedidos.add(new Pedido_TO(rs.getInt(1),
                            new Usuario_TO(rs.getInt(2)),
                            fechaInicioS,
                            new Horario_TO(rs.getInt(4)),
                            new Horario_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6),rs.getString(16)),
                            new Proveedor_TO(rs.getInt(7)),
                            fechaEntregaS,
                            rs.getString(9),
                            rs.getString(10),
                            fechaRecogidaS,
                            rs.getString(12),
                            rs.getString(13),
                            new Barrio_TO(rs.getInt(14)),
                            new Barrio_TO(rs.getInt(15))));
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
    
    //Metodo consultar pedidos Asesor Entrega
    @Override
    public List<Pedido_TO> consultarPedidosAsesorEntrega(Usuario_TO usuario) throws Exception {
        List<Pedido_TO> pedidos = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idpedido, idusuario, "
                        + "fechaInicio, horarioinicio_idhorario, "
                        + "horariofinal_idhorario, p.idestado, idproveedor, "
                        + "fechaentrega, direccionrecogida, direccionentrega, "
                        + "fecharecogida, quienentrega, quienrecibe, "
                        + "idbarrios_recogida, idbarrios_entrega, e.nombre "
                        + "from public.pedido as p, public.estado as e WHERE "
                        + "p.idasesor = " + usuario.getIdUsuario() + " and p.idestado = 7 and e.idestado = p.idestado;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    String[] fechaInicio = null, fechaEntrega = null, fechaRecogida = null;

                    fechaInicio = rs.getDate(3).toString().split("T");

                    String fechaInicioS = fechaInicio[0];


                    fechaEntrega = rs.getDate(3).toString().split("T");

                    String fechaEntregaS = fechaEntrega[0];


                    fechaRecogida = rs.getDate(3).toString().split("T");

                    String fechaRecogidaS = fechaRecogida[0];

                    pedidos.add(new Pedido_TO(rs.getInt(1),
                            new Usuario_TO(rs.getInt(2)),
                            fechaInicioS,
                            new Horario_TO(rs.getInt(4)),
                            new Horario_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6),rs.getString(16)),
                            new Proveedor_TO(rs.getInt(7)),
                            fechaEntregaS,
                            rs.getString(9),
                            rs.getString(10),
                            fechaRecogidaS,
                            rs.getString(12),
                            rs.getString(13),
                            new Barrio_TO(rs.getInt(14)),
                            new Barrio_TO(rs.getInt(15))));
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
                String sql = "SELECT idpedido, idusuario, "
                        + "fechaInicio, horarioinicio_idhorario, "
                        + "horariofinal_idhorario, idestado, idproveedor, "
                        + "fechaentrega, direccionrecogida, direccionentrega, "
                        + "fecharecogida, quienentrega, quienrecibe, "
                        + "idbarrios_recogida, idbarrios_entrega "
                        + "from public.pedido as pedido WHERE "
                        + "pedido.idpedido = '" + pedido.getIdPedido() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevopedido = new Pedido_TO(rs.getInt(1),
                            new Usuario_TO(rs.getInt(2)),
                            rs.getDate(3),
                            new Horario_TO(rs.getInt(4)),
                            new Horario_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6)),
                            new Proveedor_TO(rs.getInt(7)),
                            rs.getDate(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getDate(11),
                            rs.getString(12),
                            rs.getString(13),
                            new Barrio_TO(rs.getInt(14)),
                            new Barrio_TO(rs.getInt(15)));
                }
            } catch (SQLException e) {
                System.out.println("error en sentencia de SQL y en insercion de datos del SQL al objeto List: " + e.getMessage());
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
                        + "horariofinal_idhorario, idestado, idproveedor, "
                        + "fechaentrega, direccionrecogida, direccionentrega, "
                        + "fecharecogida, quienentrega, quienrecibe, "
                        + "idbarrios_recogida, idbarrios_entrega "
                        + "FROM public.pedido";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pedidos.add(new Pedido_TO(rs.getInt(1),
                            new Usuario_TO(rs.getInt(2)),
                            rs.getDate(3),
                            new Horario_TO(rs.getInt(4)),
                            new Horario_TO(rs.getInt(5)),
                            new Estado_TO(rs.getInt(6)),
                            new Proveedor_TO(rs.getInt(7)),
                            rs.getDate(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getDate(11),
                            rs.getString(12),
                            rs.getString(13),
                            new Barrio_TO(rs.getInt(14)),
                            new Barrio_TO(rs.getInt(15))));
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
                        + "horariofinal_idhorario, idestado, idproveedor, "
                        + "fechaentrega, direccionrecogida, direccionentrega, "
                        + "fecharecogida, quienentrega, quienrecibe, "
                        + "idbarrios_recogida, idbarrios_entrega "
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
                            new Proveedor_TO(rs.getInt(7)),
                            rs.getDate(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getDate(11),
                            rs.getString(12),
                            rs.getString(13),
                            new Barrio_TO(rs.getInt(14)),
                            new Barrio_TO(rs.getInt(15))));
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

    @Override
    public Pedido_TO modificarPedido(Pedido_TO pedido) throws Exception {
        Pedido_TO pedidoModelo = new Pedido_TO();
        try {
            try {
                String sql = "UPDATE public.pedido "
                        + " SET  idusuario= " + pedido.getUsuario().getIdUsuario() + ", "
                        + " fechainicio= '" + pedido.getFechaInicio() + "', "
                        + " horarioinicio_idhorario = " + pedido.getHoraInicio().getIdHorario() + " ,  "
                        + " horariofinal_idhorario = " + pedido.getHoraFinal().getIdHorario() + ", "
                        + " idestado = " + pedido.getEstado().getIdEstado() + ", "
                        + " idproveedor = " + pedido.getProveedor().getIdProveedor() + ","
                        + " fechaentrega =  '" + pedido.getFechaEntrega() + "',"
                        + " direccionrecogida = '" + pedido.getDireccionRecogida() + "',"
                        + " direccionentrega = '" + pedido.getDireccionEntrega() + "',"
                        + " fecharecogida = '" + pedido.getFechaRecogida() + ","
                        + " quienentrega = '" + pedido.getQuienEntrega() + "',"
                        + " quienrecibe = '" + pedido.getQuienRecibe() + "',"
                        + " idbarrios_recogida = '" + pedido.getBarrioRecogida().getIdBarrios() + "',"
                        + " idbarrios_entrega = '" + pedido.getBarrioEntrega().getIdBarrios() + "' "
                        + " WHERE idpedido = " + pedido.getIdPedido() + " ;";
                st.execute(sql);
            } catch (Exception e) {
                pedidoModelo = new Pedido_TO();
                throw e;
            }
        } catch (Exception es) {
            pedidoModelo = new Pedido_TO();
            throw es;
        } finally {
            ConexionSQL.CerrarConexion();
        }

        return pedidoModelo;
    }

    @Override
    public Pedido_TO registrarPedidoWeb(Pedido_TO pedido) throws Exception {
        Pedido_TO nuevopedido = new Pedido_TO();
        try {
            try {
                String sql = "INSERT INTO public.pedido(idusuario,"
                        + " fechainicio,"
                        + " horarioinicio_idhorario,"
                        + " horariofinal_idhorario,"
                        + " idestado,"
                        + " fechaentrega,"
                        + " direccionrecogida,"
                        + " direccionentrega,"
                        + " fecharecogida,"
                        + " quienentrega,"
                        + " quienrecibe,"
                        + " idbarrios_recogida, "
                        + " idbarrios_entrega)"
                        + " VALUES ('" + pedido.getUsuario().getIdUsuario() + "',"
                        + " '" + pedido.getFechaInicio() + "',"
                        + " '" + pedido.getHoraInicio().getIdHorario() + "',"
                        + " '" + pedido.getHoraFinal().getIdHorario() + "',"
                        + " '" + pedido.getEstado().getIdEstado() + "',"
                        + " '" + pedido.getFechaEntrega() + "',"
                        + " '" + pedido.getDireccionRecogida() + "',"
                        + " '" + pedido.getDireccionEntrega() + "',"
                        + " '" + pedido.getFechaRecogida() + "',"
                        + " '" + pedido.getQuienEntrega() + "',"
                        + " '" + pedido.getQuienRecibe() + "',"
                        + " '" + pedido.getBarrioRecogida().getIdBarrios() + "',"
                        + " '" + pedido.getBarrioEntrega().getIdBarrios() + "')";

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

}
