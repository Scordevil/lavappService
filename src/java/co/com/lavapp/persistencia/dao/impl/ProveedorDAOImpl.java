/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Proveedor_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.ProveedorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProveedorDAOImpl implements ProveedorDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Proveedor_TO> consultarProveedores() throws Exception {
        List<Proveedor_TO> proveedores = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idproveedor, razonsocial, nit, telefono, direccion, idusuario, cupo, idzona "
                        + "FROM public.proveedor";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    proveedores.add(new Proveedor_TO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            new Usuario_TO(rs.getInt(6)),
                            rs.getInt(7),
                            new Zona_TO(rs.getInt(8))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return proveedores;
    }

    @Override
    public Proveedor_TO consultarProveedor(Proveedor_TO proveedor) throws Exception {
        Proveedor_TO nuevoProveedor = new Proveedor_TO();
        try {
            try {
                String sql = "SELECT idproveedor, razonsocial, nit, telefono, direccion, idusuario, cupo, idzona "
                        + "FROM public.proveedor "
                        + "WHERE idproveedor = '" + proveedor.getIdProveedor() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevoProveedor = new Proveedor_TO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            new Usuario_TO(rs.getInt(6)),
                            rs.getInt(7),
                            new Zona_TO(rs.getInt(8)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoProveedor;
    }

    @Override
    public Proveedor_TO registrarProveedor(Proveedor_TO proveedor) throws Exception {
        Proveedor_TO nuevoProveedor = new Proveedor_TO();
        try {
            try {
                String sql = "INSERT INTO public.proveedor(razonsocial, nit, telefono, direccion, idusuario, cupo, idzona) "
                        + "VALUES ('" + proveedor.getRazonSocial() + "', "
                        + "'" + proveedor.getNit() + "', "
                        + "'" + proveedor.getTelefono() + "', "
                        + "'" + proveedor.getDireccion() + "', "
                        + "'" + proveedor.getUsuario().getIdUsuario() + "', "
                        + "'" + proveedor.getCupo() + "', "
                        + "'" + proveedor.getZona().getIdZona() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoProveedor = new Proveedor_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoProveedor;
    }

    @Override
    public Proveedor_TO editarProveedor(Proveedor_TO proveedor) throws Exception {
        Proveedor_TO nuevoProveedor = new Proveedor_TO();
        try {
            try {
                String sql = "UPDATE public.proveedor SET "
                        + "razonsocial = '" + proveedor.getRazonSocial() + "', "
                        + "nit = '" + proveedor.getNit() + "', "
                        + "telefono = '" + proveedor.getTelefono() + "', "
                        + "direccion = '" + proveedor.getDireccion() + "', "
                        + "idusuario = '" + proveedor.getUsuario().getIdUsuario() + "', "
                        + "cupo = " + proveedor.getCupo() + ", "
                        + "idzona = " + proveedor.getZona().getIdZona() + " "
                        + "WHERE idproveedor = " + proveedor.getIdProveedor() + "";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoProveedor = new Proveedor_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoProveedor;
    }

    @Override
    public Proveedor_TO eliminarProveedor(Proveedor_TO proveedor) throws Exception {
        Proveedor_TO nuevoProveedor = new Proveedor_TO();
        try {
            try {
                String sql = "DELETE FROM public.proveedor "
                        + "WHERE idproveedor = '" + proveedor.getIdProveedor() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                nuevoProveedor = new Proveedor_TO();
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevoProveedor;
    }

    @Override
    public List<Proveedor_TO> BuscarProveedores(String valor) throws Exception {
        List<Proveedor_TO> proveedores = new ArrayList<>();
        try {
            try {
                String sql = "SELECT p.idproveedor, p.razonsocial, p.nit, p.telefono, p.direccion, p.idusuario, p.cupo, p.idzona "
                        + "FROM public.proveedor as p, public.usuario as us, public.zona as z "
                        + "WHERE p.idusuario = us.idusuario AND p.idzona = z.idzona AND "
                        + "(p.razonsocial LIKE '%" + valor + "%' OR "
                        + "p.nit LIKE '%" + valor + "%' OR p.telefono LIKE '%" + valor + "%' OR "
                        + "p.direccion LIKE '%" + valor + "%' OR z.nombre LIKE '%" + valor + "%' OR "
                        + "us.nombre LIKE '%" + valor + "%' OR us.telefono LIKE '%" + valor + "%' OR "
                        + "us.email LIKE '%" + valor + "%' OR us.apellido LIKE '%" + valor + "%' OR "
                        + "us.movil LIKE '%" + valor + "%')";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    proveedores.add(new Proveedor_TO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            new Usuario_TO(rs.getInt(6)),
                            rs.getInt(7),
                            new Zona_TO(rs.getInt(8))));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return proveedores;
    }
}
