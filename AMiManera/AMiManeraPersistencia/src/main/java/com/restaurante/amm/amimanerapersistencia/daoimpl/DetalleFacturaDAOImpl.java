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
        String sql = "{CALL insertarDetalleFactura(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        
        cmd.setInt("p_cantidadProducto", detalleFactura.getCantidadProducto());
        cmd.setDouble("p_precioUnitario", detalleFactura.getPrecioUnitario());
        cmd.setDouble("p_subTotal", detalleFactura.getSubTotal());
        cmd.setInt("p_idProducto", detalleFactura.getProducto().getIdProducto());
        cmd.setInt("p_idComprobantePago", detalleFactura.getFactura().getIdComprobantePago());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, DetalleFactura detalleFactura) throws SQLException {
        String sql = "{CALL modificarDetalleFactura(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_cantidadProducto", detalleFactura.getCantidadProducto());
        cmd.setDouble("p_precioUnitario", detalleFactura.getPrecioUnitario());
        cmd.setDouble("p_subTotal", detalleFactura.getSubTotal());
        cmd.setInt("p_idProducto", detalleFactura.getProducto().getIdProducto());
        cmd.setInt("p_idComprobantePago", detalleFactura.getFactura().getIdComprobantePago());
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
        detalle.setCantidadProducto(rs.getInt("cantidadProducto"));
        detalle.setPrecioUnitario(rs.getDouble("precioUnitario"));
        detalle.setSubTotal(rs.getDouble("subTotal"));
        detalle.setProducto(new ProductoDAOImpl().buscar(rs.getInt("idProducto")));
        detalle.setFactura(new FacturaDAOImpl().buscar(rs.getInt("idComprobantePago")));
        return detalle;
    }
}