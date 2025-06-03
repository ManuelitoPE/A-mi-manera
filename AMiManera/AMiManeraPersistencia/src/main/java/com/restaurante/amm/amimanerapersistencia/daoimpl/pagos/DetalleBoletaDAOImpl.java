package com.restaurante.amm.amimanerapersistencia.daoimpl.pagos;

import com.restaurante.amm.amimanerapersistencia.daoimpl.pagos.BoletaDAOImpl;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.ProductoDAOImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.pagos.IDetalleBoletaDAO;
import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;

public class DetalleBoletaDAOImpl extends BaseDAOImpl<DetalleBoleta> implements IDetalleBoletaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, DetalleBoleta detalleBoleta) throws SQLException {
        String sql = "{CALL insertarDetalleBoleta(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        
        cmd.setInt("p_cantidadProducto", detalleBoleta.getCantidadProducto());
        cmd.setDouble("p_precioUnitario", detalleBoleta.getPrecioUnitario());
        cmd.setDouble("p_subTotal", detalleBoleta.getSubTotal());
        cmd.setInt("p_idProducto", detalleBoleta.getProducto().getIdProducto());
        cmd.setInt("p_idComprobantePago", detalleBoleta.getBoleta().getIdComprobantePago());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, DetalleBoleta detalleBoleta) throws SQLException {
        String sql = "{CALL modificarDetalleBoleta(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_cantidadProducto", detalleBoleta.getCantidadProducto());
        cmd.setDouble("p_precioUnitario", detalleBoleta.getPrecioUnitario());
        cmd.setDouble("p_subTotal", detalleBoleta.getSubTotal());
        cmd.setInt("p_idProducto", detalleBoleta.getProducto().getIdProducto());
        cmd.setInt("p_idComprobantePago", detalleBoleta.getBoleta().getIdComprobantePago());
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
        detalle.setCantidadProducto(rs.getInt("cantidadProducto"));
        detalle.setPrecioUnitario(rs.getDouble("precioUnitario"));
        detalle.setSubTotal(rs.getDouble("subTotal"));
        detalle.setProducto(new ProductoDAOImpl().buscar(rs.getInt("idProducto")));
        detalle.setBoleta(new BoletaDAOImpl().buscar(rs.getInt("idComprobantePago")));
        return detalle;
    }
}
