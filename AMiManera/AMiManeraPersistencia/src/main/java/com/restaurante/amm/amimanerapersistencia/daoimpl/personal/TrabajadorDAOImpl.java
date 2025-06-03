package com.restaurante.amm.amimanerapersistencia.daoimpl.personal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.personal.ITrabajadorDAO;
import com.restaurante.amm.amimaneramodel.personal.Trabajador;
import com.restaurante.amm.amimaneramodel.personal.Mesero;
import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;

public class TrabajadorDAOImpl extends BaseDAOImpl<Trabajador> implements ITrabajadorDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Trabajador trabajador) throws SQLException {
        String sql = "{CALL insertarTrabajador(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", trabajador.getNombre());
        cmd.setString("p_apellidoPaterno", trabajador.getApellidoPaterno());
        cmd.setString("p_apellidoMaterno", trabajador.getApellidoMaterno());
        cmd.setString("p_rol", trabajador.getRol());
        cmd.setInt("p_idCuentaUsuario", trabajador.getCuentaUsuario().getIdCuentaUsuario());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Trabajador trabajador) throws SQLException {
        String sql = "{CALL modificarTrabajador(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", trabajador.getNombre());
        cmd.setString("p_apellidoPaterno", trabajador.getApellidoPaterno());
        cmd.setString("p_apellidoMaterno", trabajador.getApellidoMaterno());
        cmd.setString("p_rol", trabajador.getRol());
        cmd.setInt("p_idCuentaUsuario", trabajador.getCuentaUsuario().getIdCuentaUsuario());
        cmd.setInt("p_id", trabajador.getIdTrabajador());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarTrabajador(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarTrabajadorPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarTrabajadores()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Trabajador mapearModelo(ResultSet rs) throws SQLException {
        Mesero trabajador = new Mesero();
        trabajador.setIdTrabajador(rs.getInt("idTrabajador"));
        trabajador.setNombre(rs.getString("nombre"));
        trabajador.setApellidoPaterno(rs.getString("apellidoPaterno"));
        trabajador.setApellidoMaterno(rs.getString("apellidoMaterno"));
        trabajador.setRol(rs.getString("rol"));
        // Aquí deberías mapear la cuenta de usuario si es necesario
        return trabajador;
    }
} 