/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimanerapersistencia.daoimpl;

/**
 *
 * @author USER
 */
import com.restaurante.amm.amimaneramodel.pedidos.TipoProducto;
import com.restaurante.amm.amimanerapersistencia.dao.ITipoProductoDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author USER
 */
public class TipoProductoDAOImpl extends BaseDAOImpl<TipoProducto> implements ITipoProductoDAO{
    
    @Override
    protected CallableStatement comandoInsertar(Connection conn, TipoProducto tipoProducto) throws SQLException {
        String sql = "{CALL insertarTipoProducto(?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_descripcion", tipoProducto.getDescripcion());

        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }
    
    @Override
    protected CallableStatement comandoModificar(Connection conn, TipoProducto tipoProducto) throws SQLException {
        String sql = "{CALL modificarTipoProducto(?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_descripcion", tipoProducto.getDescripcion());

        cmd.setInt("p_id", tipoProducto.getIdTipoProducto());
        return cmd;
    }  

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarTipoProducto(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarTipoProductoPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarTipoProductos()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected TipoProducto mapearModelo(ResultSet rs) throws SQLException {
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setIdTipoProducto(rs.getInt("idTipoProducto"));
        tipoProducto.setDescripcion(rs.getString("descripcion"));

        return tipoProducto;
    }    
}
