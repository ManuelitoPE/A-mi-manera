package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;
import com.restaurante.amm.amimaneramodel.pagos.DetalleFactura;

public class ComprobanteDAOImpl {
    public void insertarDetalleBoleta(Connection conn, int idBoleta, DetalleBoleta detalle) throws SQLException {
        String sql = "{CALL insertarDetalleBoleta(?, ?, ?)}";
        try (CallableStatement cmd = conn.prepareCall(sql)) {
            cmd.setString(1, detalle.getNombreProducto());
            cmd.setDouble(2, detalle.getMontoProducto());
            cmd.setInt(3, idBoleta);
            cmd.executeUpdate();
        }
    }

    public void insertarDetalleFactura(Connection conn, int idFactura, DetalleFactura detalle) throws SQLException {
        String sql = "{CALL insertarDetalleFactura(?, ?, ?, ?)}";
        try (CallableStatement cmd = conn.prepareCall(sql)) {
            cmd.setString(1, detalle.getNombreProducto());
            cmd.setDouble(2, detalle.getSubtotalSinIGV());
            cmd.setDouble(3, detalle.getSubtotalFinal());
            cmd.setInt(4, idFactura);
            cmd.executeUpdate();
        }
    }
} 