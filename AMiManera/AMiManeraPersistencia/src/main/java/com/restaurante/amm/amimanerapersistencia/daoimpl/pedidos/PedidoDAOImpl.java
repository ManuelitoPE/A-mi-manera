package com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.IPedidoDAO;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.personal.Mesero;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;
import com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas.MesaDAOImpl;

public class PedidoDAOImpl extends BaseDAOImpl<Pedido> implements IPedidoDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Pedido pedido) throws SQLException {
        String sql = "{CALL insertarPedido(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setDate("p_fecha", new Date(pedido.getFecha().getTime()));
        cmd.setString("p_estadoPedido", pedido.getEstadoPedido().name());
        cmd.setDouble("p_montoTotal", pedido.getMontoTotal());
        cmd.setInt("p_idMesa", pedido.getMesa().getIdMesa());
        cmd.setInt("p_idMesero", pedido.getMesero().getIdTrabajador());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Pedido pedido) throws SQLException {
        String sql = "{CALL modificarPedido(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setDate("p_fecha", new Date(pedido.getFecha().getTime()));
        cmd.setString("p_estadoPedido", pedido.getEstadoPedido().name());
        cmd.setDouble("p_montoTotal", pedido.getMontoTotal());
        cmd.setInt("p_idMesa", pedido.getMesa().getIdMesa());
        cmd.setInt("p_idMesero", pedido.getMesero().getIdTrabajador());
        cmd.setInt("p_id", pedido.getIdPedido());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarPedido(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarPedidoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarPedidos()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Pedido mapearModelo(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(rs.getInt("idPedido"));
        pedido.setFecha(rs.getDate("fecha")); 
        pedido.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estadoPedido")));
        pedido.setMontoTotal(rs.getDouble("montoTotal"));
        pedido.setMesa(new MesaDAOImpl().buscar(rs.getInt("idMesa")));
//        pedido.setMesero(new TrabajadorDAOImpl().buscar(rs.getInt("idMesero")));
  
        return pedido;
    }
}