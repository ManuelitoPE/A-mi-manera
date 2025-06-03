package com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IMesaDAO;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.gestionmesas.EstadoMesa;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;

public class MesaDAOImpl extends BaseDAOImpl<Mesa> implements IMesaDAO {

    @Override
    protected CallableStatement comandoInsertar(Connection conn, Mesa mesa) throws SQLException {
        String sql = "{CALL insertarMesa(?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_cantidadAsientos", mesa.getCantidadAsientos());
        cmd.setString("p_estado", mesa.getEstado().name());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Mesa mesa) throws SQLException {
        String sql = "{CALL modificarMesa(?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_cantidadAsientos", mesa.getCantidadAsientos());
        cmd.setString("p_estado", mesa.getEstado().name());
        cmd.setInt("p_id", mesa.getIdMesa());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarMesa(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarMesaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarMesas()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Mesa mapearModelo(ResultSet rs) throws SQLException {
        Mesa mesa = new Mesa();
        mesa.setIdMesa(rs.getInt("idMesa"));
        mesa.setCantidadAsientos(rs.getInt("cantidadAsientos"));
        mesa.setEstado(EstadoMesa.valueOf(rs.getString("estado")));
        return mesa;
    }
}