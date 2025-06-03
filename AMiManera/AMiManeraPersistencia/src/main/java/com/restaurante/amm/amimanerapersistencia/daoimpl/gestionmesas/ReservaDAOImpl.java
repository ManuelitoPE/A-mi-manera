package com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.sql.Timestamp;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IReservaDAO;
import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;

public class ReservaDAOImpl extends BaseDAOImpl<Reserva> implements IReservaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Reserva reserva) throws SQLException {
        String sql = "{CALL insertarReserva(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
//        cmd.setTimestamp("p_fechaHoraInicio", Timestamp.valueOf(reserva.getFechaHoraFin()));
//        cmd.setTimestamp("p_fechaHoraFin", Timestamp.valueOf(reserva.getFechaHoraFin()));
//        cmd.setInt("p_cantidadPersonas", reserva.getCantidadPersonas());
//        cmd.setString("p_estado", reserva.getEstado().name());
//        cmd.setDouble("p_montoReserva", reserva.getMontoReserva());
//        cmd.setInt("p_idCliente", reserva.getCliente().getIdCliente());
//        cmd.setInt("p_idMesa", reserva.getMesa().getIdMesa());
//        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Reserva reserva) throws SQLException {
        String sql = "{CALL modificarReserva(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
//        cmd.setDate("p_fecha", new Date(reserva.getFecha().getTime()));
//        cmd.setTimestamp("p_horaInicio", Timestamp.valueOf(reserva.getHoraInicio()));
//        cmd.setTimestamp("p_horaFin", Timestamp.valueOf(reserva.getHoraFin()));
//        cmd.setInt("p_cantidadPersonas", reserva.getCantidadPersonas());
//        cmd.setString("p_estado", reserva.getEstado());
//        cmd.setTimestamp("p_horaMaximaCancelacion", Timestamp.valueOf(reserva.getHoraMaximaCancelacion()));
//        cmd.setDouble("p_montoReserva", reserva.getMontoReserva());
//        cmd.setInt("p_idCliente", reserva.getCliente().getIdCliente());
//        cmd.setInt("p_idMesa", reserva.getMesa().getIdMesa());
//        cmd.setInt("p_id", reserva.getIdReserva());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarReserva(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarReservaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarReservas()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected Reserva mapearModelo(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();
//        reserva.setIdReserva(rs.getInt("idReserva"));
//        reserva.setHoraInicio(rs.getTimestamp("horaInicio").toLocalDateTime());
//        reserva.setHoraFin(rs.getTimestamp("horaFin").toLocalDateTime());
//        reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
//        reserva.setEstado(rs.getString("estado"));
//        reserva.setHoraMaximaCancelacion(rs.getTimestamp("horaMaximaCancelacion").toLocalDateTime());
//        reserva.setMontoReserva(rs.getDouble("montoReserva"));
//        reserva.setFecha(rs.getDate("fecha"));
//        // Mapeo de cliente y mesa solo con el ID
//        // Puedes expandirlo si necesitas más datos
//        // reserva.setCliente(...);
//        Mesa mesa = new Mesa();
//        mesa.setIdMesa(rs.getInt("idMesa"));
//        reserva.setMesa(mesa);
        return reserva;
    }
}