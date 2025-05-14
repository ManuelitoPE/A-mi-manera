package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import com.restaurante.amm.amimanerapersistencia.dao.IPedidoDAO;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.personal.Mesero;

public class PedidoDAOImpl extends BaseDAOImpl<Pedido> implements IPedidoDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Pedido pedido) throws SQLException {
        String sql = "{CALL insertarPedido(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setDate("p_fecha", new Date(pedido.getFecha().getTime()));
        cmd.setString("p_estado", pedido.getEstadoPedido().name());
        cmd.setDouble("p_montoTotal", pedido.getMontoTotal());
        cmd.setInt("p_idMesa", pedido.getMesa().getIdMesa());
        cmd.setInt("p_idMesero", pedido.getMesero().getIdTrabajador());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Pedido pedido) throws SQLException {
        String sql = "{CALL modificarPedido(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setDate("p_fecha", new Date(pedido.getFecha().getTime()));
        cmd.setString("p_estado", pedido.getEstadoPedido().name());
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
        pedido.setFecha(rs.getDate("fechaHora")); // O "fecha" según tu tabla
        pedido.setEstadoPedido(EstadoPedido.valueOf(rs.getString("estado")));
        pedido.setMontoTotal(rs.getDouble("montoTotal"));
        
        
        // Mapeo de mesa y mesero solo con el ID, puedes expandirlo si necesitas más datos
        Mesa mesa = new Mesa();
        mesa.setIdMesa(rs.getInt("idMesa"));
        pedido.setMesa(mesa);

        Mesero mesero = new Mesero();
        mesero.setIdTrabajador(rs.getInt("idMesero"));
        pedido.setMesero(mesero);

        return pedido;
    }
}