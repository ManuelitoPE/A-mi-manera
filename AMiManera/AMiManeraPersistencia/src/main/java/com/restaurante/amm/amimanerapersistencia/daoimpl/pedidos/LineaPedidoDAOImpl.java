package com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos;

import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.ProductoDAOImpl;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.PedidoDAOImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.ILineaPedidoDAO;
import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;

public class LineaPedidoDAOImpl extends BaseDAOImpl<LineaPedido> implements ILineaPedidoDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, LineaPedido lineaPedido) throws SQLException {
        String sql = "{CALL insertarLineaPedido(?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_cantidadProducto", lineaPedido.getCantidadProducto());
        cmd.setInt("p_idPedido", lineaPedido.getPedido().getIdPedido());
        cmd.setInt("p_idProducto", lineaPedido.getProducto().getIdProducto());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, LineaPedido lineaPedido) throws SQLException {
        String sql = "{CALL modificarLineaPedido(?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_cantidadProducto", lineaPedido.getCantidadProducto());
        cmd.setInt("p_idPedido", lineaPedido.getPedido().getIdPedido());
        cmd.setInt("p_idProducto", lineaPedido.getProducto().getIdProducto());
        cmd.setInt("p_id", lineaPedido.getIdLineaPedido());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarLineaPedido(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarLineaPedidoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarLineasPedido()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected LineaPedido mapearModelo(ResultSet rs) throws SQLException {
        LineaPedido linea = new LineaPedido();
        linea.setIdLineaPedido(rs.getInt("idLineaPedido"));
        linea.setCantidadProducto(rs.getInt("cantidadProducto"));
        linea.setPedido(new PedidoDAOImpl().buscar(rs.getInt("idPedido")));
        linea.setProducto(new ProductoDAOImpl().buscar(rs.getInt("idProducto")));
        
        return linea;
    }
} 