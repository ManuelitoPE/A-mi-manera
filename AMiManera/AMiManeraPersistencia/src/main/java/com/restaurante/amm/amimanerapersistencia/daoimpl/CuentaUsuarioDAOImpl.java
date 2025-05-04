package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.ICuentaUsuarioDAO;
import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;

public class CuentaUsuarioDAOImpl extends BaseDAOImpl<CuentaUsuario> implements ICuentaUsuarioDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, CuentaUsuario cuentaUsuario) throws SQLException {
        String sql = "{CALL insertarCuentaUsuario(?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombreUsuario", cuentaUsuario.getNombreUsuario());
        cmd.setString("p_contrasenia", cuentaUsuario.getConstrasenia());
        cmd.setString("p_tipoUsuario", cuentaUsuario.getTipoUsuario());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, CuentaUsuario cuentaUsuario) throws SQLException {
        String sql = "{CALL modificarCuentaUsuario(?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombreUsuario", cuentaUsuario.getNombreUsuario());
        cmd.setString("p_contrasenia", cuentaUsuario.getConstrasenia());
        cmd.setString("p_tipoUsuario", cuentaUsuario.getTipoUsuario());
        cmd.setInt("p_id", cuentaUsuario.getIdCuentaUsuario());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarCuentaUsuario(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarCuentaUsuarioPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarCuentasUsuario()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected CuentaUsuario mapearModelo(ResultSet rs) throws SQLException {
        CuentaUsuario cuentaUsuario = new CuentaUsuario();
        cuentaUsuario.setIdCuentaUsuario(rs.getInt("idCuentaUsuario"));
        cuentaUsuario.setNombreUsuario(rs.getString("nombreUsuario"));
        cuentaUsuario.setConstrasenia(rs.getString("contrasenia"));
        cuentaUsuario.setTipoUsuario(rs.getString("tipoUsuario"));
        return cuentaUsuario;
    }
} 