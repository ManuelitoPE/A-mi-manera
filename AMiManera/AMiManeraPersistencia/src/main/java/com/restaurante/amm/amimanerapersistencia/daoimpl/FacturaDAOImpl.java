package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import com.restaurante.amm.amimanerapersistencia.dao.IFacturaDAO;
import com.restaurante.amm.amimaneramodel.pagos.Factura;
import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.pagos.DetalleFactura;

public class FacturaDAOImpl extends BaseDAOImpl<Factura> implements IFacturaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Factura factura) throws SQLException {
        String sql = "{CALL insertarFactura(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp("p_fechaEmision", new Timestamp(factura.getFechaEmision().getTime()));
        cmd.setString("p_metodoPago", factura.getMetodoPago().name());
        cmd.setDouble("p_montoTotal", factura.getMontoTotal());
        cmd.setDouble("p_montoPropina", factura.getMontoPropina());
        cmd.setDouble("p_montoSinIGV", factura.getMontoSinIGV());
        cmd.setDouble("p_montoIGV", factura.getMontoIGV());
        cmd.setString("p_ruc", factura.getRUC());
        cmd.setString("p_razonSocial", factura.getRazonSocial());
        cmd.setInt("p_idPedido", factura.getPedido().getIdPedido());
        cmd.setInt("p_idReserva", factura.getReserva().getIdReserva());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Factura factura) throws SQLException {
        String sql = "{CALL modificarFactura(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp("p_fechaEmision", new Timestamp(factura.getFechaEmision().getTime()));
        cmd.setString("p_metodoPago", factura.getMetodoPago().name());
        cmd.setDouble("p_montoTotal", factura.getMontoTotal());
        cmd.setDouble("p_montoPropina", factura.getMontoPropina());
        cmd.setDouble("p_montoSinIGV", factura.getMontoSinIGV());
        cmd.setDouble("p_montoIGV", factura.getMontoIGV());
        cmd.setString("p_ruc", factura.getRUC());
        cmd.setString("p_razonSocial", factura.getRazonSocial());
        cmd.setInt("p_idPedido", factura.getPedido().getIdPedido());
        cmd.setInt("p_idReserva", factura.getReserva().getIdReserva());
        cmd.setInt("p_id", factura.getIdComprobantePago());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarFactura(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarFacturaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarFacturas()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Factura mapearModelo(ResultSet rs) throws SQLException {
        Factura factura = new Factura();
        factura.setIdComprobantePago(rs.getInt("idFactura"));
        factura.setFechaEmision(rs.getTimestamp("fechaEmision"));
        factura.setMetodoPago(com.restaurante.amm.amimaneramodel.pagos.MetodoPago.valueOf(rs.getString("metodoPago")));
        factura.setMontoTotal(rs.getDouble("montoTotal"));
        factura.setMontoPropina(rs.getDouble("montoPropina"));
        factura.setMontoSinIGV(rs.getDouble("montoSinIGV"));
        factura.setMontoIGV(rs.getDouble("montoIGV"));
        factura.setRUC(rs.getString("RUC"));
        factura.setRazonSocial(rs.getString("razonSocial"));
        factura.setPedido(new PedidoDAOImpl().buscar(rs.getInt("idPedido")));
        factura.setReserva(new ReservaDAOImpl().buscar(rs.getInt("idReserva")));
        
        return factura;
    }
} 