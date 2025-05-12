package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import com.restaurante.amm.amimanerapersistencia.dao.IBoletaDAO;
import com.restaurante.amm.amimaneramodel.pagos.Boleta;
import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;

public class BoletaDAOImpl extends BaseDAOImpl<Boleta> implements IBoletaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Boleta boleta) throws SQLException {
        String sql = "{CALL insertarBoleta(?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp("p_fechaEmision", new Timestamp(boleta.getFechaEmision().getTime()));
        cmd.setString("p_metodoPago", boleta.getMetodoPago().name());
        cmd.setDouble("p_montoTotal", boleta.getMontoTotal());
        cmd.setDouble("p_montoPropina", boleta.getMontoPropina());
        cmd.setDouble("p_montoSinIGV", boleta.getMontoSinIGV());
        cmd.setDouble("p_montoIGV", boleta.getMontoIGV());
        cmd.setInt("p_idPedido", boleta.getPedido().getIdPedido());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Boleta boleta) throws SQLException {
        String sql = "{CALL modificarBoleta(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp("p_fechaEmision", new Timestamp(boleta.getFechaEmision().getTime()));
        cmd.setString("p_metodoPago", boleta.getMetodoPago().name());
        cmd.setDouble("p_montoTotal", boleta.getMontoTotal());
        cmd.setDouble("p_montoPropina", boleta.getMontoPropina());
        cmd.setDouble("p_montoSinIGV", boleta.getMontoSinIGV());
        cmd.setDouble("p_montoIGV", boleta.getMontoIGV());
        cmd.setInt("p_idPedido", boleta.getPedido().getIdPedido());
        cmd.setInt("p_id", boleta.getIdComprobantePago());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarBoleta(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarBoletaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarBoletas()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Boleta mapearModelo(ResultSet rs) throws SQLException {
        Boleta boleta = new Boleta();
        boleta.setIdComprobantePago(rs.getInt("idBoleta"));
        boleta.setFechaEmision(rs.getTimestamp("fechaEmision"));
        boleta.setMetodoPago(com.restaurante.amm.amimaneramodel.pagos.MetodoPago.valueOf(rs.getString("metodoPago")));
        boleta.setMontoTotal(rs.getDouble("montoTotal"));
        boleta.setMontoPropina(rs.getDouble("montoPropina"));
        boleta.setMontoSinIGV(rs.getDouble("montoSinIGV"));
        boleta.setMontoIGV(rs.getDouble("montoIGV"));
        // boleta.setPedido(...) // Puedes mapear el pedido si lo necesitas
        // boleta.setListaDetalleBoleta(...) // Puedes mapear los detalles si lo necesitas
        return boleta;
    }
} 