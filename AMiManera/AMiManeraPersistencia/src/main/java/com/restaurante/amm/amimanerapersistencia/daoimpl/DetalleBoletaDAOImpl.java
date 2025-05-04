package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import com.restaurante.amm.amimanerapersistencia.dao.IDetalleBoletaDAO;
import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;

public class DetalleBoletaDAOImpl extends BaseDAOImpl<DetalleBoleta> implements IDetalleBoletaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, DetalleBoleta detalleBoleta) throws SQLException {
        String sql = "{CALL insertarDetalleBoleta(?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombreProducto", detalleBoleta.getNombreProducto());
        cmd.setDouble("p_montoProducto", detalleBoleta.getMontoProducto());
        cmd.setInt("p_idComprobante", detalleBoleta.getIdComprobante());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, DetalleBoleta detalleBoleta) throws SQLException {
        String sql = "{CALL modificarDetalleBoleta(?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombreProducto", detalleBoleta.getNombreProducto());
        cmd.setDouble("p_montoProducto", detalleBoleta.getMontoProducto());
        cmd.setInt("p_idComprobante", detalleBoleta.getIdComprobante());
        cmd.setInt("p_id", detalleBoleta.getIdDetalleBoleta());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarDetalleBoleta(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarDetalleBoletaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarDetallesBoleta()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected DetalleBoleta mapearModelo(ResultSet rs) throws SQLException {
        DetalleBoleta detalle = new DetalleBoleta();
        detalle.setIdDetalleBoleta(rs.getInt("idDetalleBoleta"));
        detalle.setNombreProducto(rs.getString("nombreProducto"));
        detalle.setMontoProducto(rs.getDouble("montoProducto"));
        detalle.setIdComprobante(rs.getInt("idComprobante"));
        return detalle;
    }
}
