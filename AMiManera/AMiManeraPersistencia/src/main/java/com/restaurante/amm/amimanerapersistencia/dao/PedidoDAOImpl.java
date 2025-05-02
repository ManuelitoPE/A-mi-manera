package com.restaurante.amm.amimanerapersistencia.dao;

import com.restaurante.amm.amimanerapersistencia.daoimpl.IPedidoDAO;
import com.restaurante.amm.amimaneracapadominiomodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneracapadominiomodel.pedidos.Pedido;
import com.restaurante.amm.amimaneradbmanager.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements IPedidoDAO{

    @Override
    public int insertar(Pedido pedido) {
        String sql = "INSERT PEDIDO(idMesa, idMesero, fecha, estadoPedido, montoTotal) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdTrabajador());
            ps.setDate(3, new java.sql.Date(pedido.getFecha().getTime()));
            ps.setString(4, String.valueOf(pedido.getEstadoPedido()));
            ps.setDouble(5, pedido.getMontoTotal());
            
            if (ps.executeUpdate() == 0) {
                throw new SQLException("La insercion fallo, no se creo ninguna fila.");
            }
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                else {
                    throw new SQLException("La insercion fallo, no se obtuviero ID.");
                }
            }
        }
        catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException("No se pudo insertar el registro.");
        }
    }

    @Override
    public boolean modificar(Pedido pedido) {
        String sql = "UPDATE PEDIDO SET idMesa = ?, idMesero = ?, fecha = ?, estadoPedido = ?, "
                     + "montoTotal = ? WHERE id = ?";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement cs = conn.prepareStatement(sql)) {
            
            cs.setInt(1, pedido.getMesa().getIdMesa());
            cs.setInt(2, pedido.getMesero().getIdTrabajador());
            cs.setDate(3, new java.sql.Date(pedido.getFecha().getTime()));
            cs.setString(4, String.valueOf(pedido.getEstadoPedido()));
            cs.setDouble(5, pedido.getMontoTotal());
            cs.setInt(6, pedido.getIdPedido());
            return cs.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante la modificacion: " + e.getMessage());
            throw new RuntimeException("No se pudo modificar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al modificar el registro.", e);
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM PEDIDO WHERE id = ?";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante la eliminacion: " + e.getMessage());
            throw new RuntimeException("No se pudo eliminar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al eliminar el registro.", e);
        }
    }

    @Override
    public Pedido buscar(int id) {
        return null;
//        String sql = "SELECT * FROM PEDIDO WHERE id = ?";
//        try (Connection conn = DBManager.getInstance().getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql)) {
//            
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            
//            if (!rs.next()) {
//                System.err.println("No se encontro el area con id: " + id);
//                return null;
//            }
//            
//            Pedido pedido = new Pedido();
//            pedido.setIdPedido(rs.getInt("id"));
//            pedido.setMesa(new MesaDAOImpl().buscar(rs.getInt("idMesa")));
//            pedido.setMesero(new TrabajadorDAOImpl().buscar(rs.getInt("idMesero")));
//            pedido.setFecha(rs.getDate("fecha"));
//            pedido.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estadoPedido")));
//            pedido.setMontoTotal(rs.getDouble("montoTotal"));
//            
//            return pedido;
//        }
//        catch (SQLException e) {
//            System.err.println("Error SQL durante la busqueda: " + e.getMessage());
//            throw new RuntimeException("No se pudo buscar el registro.", e);
//        }
//        catch (Exception e) {
//            System.err.println("Error inpesperado: " + e.getMessage());
//            throw new RuntimeException("Error inesperado al buscar el registro.", e);
//        }
    }

    @Override
    public List<Pedido> listar() {
        return null;
    }
//        String sql = "SELECT * FROM PEDIDO";
//        try (Connection conn = DBManager.getInstance().getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            
//            List<Pedido> pedidos = new ArrayList<>();
//            while (rs.next()) {
//                Pedido pedido = new Pedido();
//                
//                pedido.setIdPedido(rs.getInt("id"));
//                pedido.setMesa(new MesaDAOImpl().buscar(rs.getInt("idMesa")));
//                pedido.setMesero(new TrabajadorDAOImpl().buscar(rs.getInt("idMesero")));
//                pedido.setFecha(rs.getDate("fecha"));
//                pedido.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estadoPedido")));
//                pedido.setMontoTotal(rs.getDouble("montoTotal"));
//                pedidos.add(pedido);
//            }
//            
//            return pedidos;
//        }
//        catch (SQLException e) {
//            System.err.println("Error SQL durante el listado: " + e.getMessage());
//            throw new RuntimeException("No se pudo listar el registro.", e);
//        }
//        catch (Exception e) {
//            System.err.println("Error inpesperado: " + e.getMessage());
//            throw new RuntimeException("Error inesperado al listar los registros.", e);
//        }
//    }
}
