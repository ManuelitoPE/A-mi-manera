<<<<<<< HEAD
package com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.IProductoDAO;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;

public class ProductoDAOImpl extends BaseDAOImpl<Producto> implements IProductoDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Producto producto) throws SQLException {
        String sql = "{CALL insertarProducto(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", producto.getNombre());
        cmd.setString("p_descripcion", producto.getDescripcion());
        cmd.setDouble("p_precioUnitario", producto.getPrecioUnitario());
        cmd.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Producto producto) throws SQLException {
        String sql = "{CALL modificarProducto(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", producto.getNombre());
        cmd.setString("p_descripcion", producto.getDescripcion());
        cmd.setDouble("p_precioUnitario", producto.getPrecioUnitario());
        cmd.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
        cmd.setInt("p_id", producto.getIdProducto());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarProducto(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarProductoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarProductos()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Producto mapearModelo(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("idProducto"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
        producto.setTipoProducto(new TipoProductoDAOImpl().buscar(rs.getInt("idTipoProducto")));
        return producto;
    }
=======
package com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos;

import com.restaurante.amm.amimaneradbmanager.DBManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.IProductoDAO;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl extends BaseDAOImpl<Producto> implements IProductoDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Producto producto) throws SQLException {
        String sql = "{CALL insertarProducto(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", producto.getNombre());
        cmd.setString("p_descripcion", producto.getDescripcion());
        cmd.setDouble("p_precioUnitario", producto.getPrecioUnitario());
        cmd.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Producto producto) throws SQLException {
        String sql = "{CALL modificarProducto(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", producto.getNombre());
        cmd.setString("p_descripcion", producto.getDescripcion());
        cmd.setDouble("p_precioUnitario", producto.getPrecioUnitario());
        cmd.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
        cmd.setInt("p_id", producto.getIdProducto());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarProducto(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarProductoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarProductos()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Producto mapearModelo(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("idProducto"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
        producto.setTipoProducto(new TipoProductoDAOImpl().buscar(rs.getInt("idTipoProducto")));
        return producto;
    }
    
    protected CallableStatement comandoListarPorNombre(Connection conn,
            String nombre) throws SQLException {
        String sql = "{CALL listarProductosPorNombre(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", nombre);
        return cmd;
    }

    @Override 
    public List<Producto> buscarPorNombre(String nombre){
        try (
            Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = this.comandoListarPorNombre(conn,nombre);
        ) {
            ResultSet rs = ps.executeQuery();

            List<Producto> modelos = new ArrayList<>();
            while (rs.next()) {
                modelos.add(this.mapearModelo(rs));
            }

            return modelos;
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante el listado por nombre: " + e.getMessage());
            throw new RuntimeException("No se pudo listar los productos por nombre.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al listar los productos por nombre.", e);
        }
    }
>>>>>>> main
}