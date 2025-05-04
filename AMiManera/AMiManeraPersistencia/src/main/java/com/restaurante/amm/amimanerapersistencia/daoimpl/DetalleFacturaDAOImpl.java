package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import com.restaurante.amm.amimanerapersistencia.dao.IDetalleFacturaDAO;
import com.restaurante.amm.amimaneramodel.pagos.DetalleFactura;

public class DetalleFacturaDAOImpl extends BaseDAOImpl<DetalleFactura> implements IDetalleFacturaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, DetalleFactura detalleFactura) throws SQLException {
        String sql = "{CALL insertarDetalleFactura(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombreProducto", detalleFactura.getNombreProducto());
        cmd.setDouble("p_subtotalSinIGV", detalleFactura.getSubtotalSinIGV());
        cmd.setDouble("p_subtotalFinal", detalleFactura.getSubtotalFinal());
        cmd.setInt("p_idComprobante", detalleFactura.getIdComprobante());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, DetalleFactura detalleFactura) throws SQLException {
        String sql = "{CALL modificarDetalleFactura(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombreProducto", detalleFactura.getNombreProducto());
        cmd.setDouble("p_subtotalSinIGV", detalleFactura.getSubtotalSinIGV());
        cmd.setDouble("p_subtotalFinal", detalleFactura.getSubtotalFinal());
        cmd.setInt("p_idComprobante", detalleFactura.getIdComprobante());
        cmd.setInt("p_id", detalleFactura.getIdDetalleFactura());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarDetalleFactura(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarDetalleFacturaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarDetallesFactura()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected DetalleFactura mapearModelo(ResultSet rs) throws SQLException {
        DetalleFactura detalle = new DetalleFactura();
        detalle.setIdDetalleFactura(rs.getInt("idDetalleFactura"));
        detalle.setNombreProducto(rs.getString("nombreProducto"));
        detalle.setSubtotalSinIGV(rs.getDouble("subtotalSinIGV"));
        detalle.setSubtotalFinal(rs.getDouble("subtotalFinal"));
        detalle.setIdComprobante(rs.getInt("idComprobante"));
        return detalle;
    }
} 