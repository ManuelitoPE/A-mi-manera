package com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas;

import com.restaurante.amm.amimaneramodel.gestionmesas.EstadoReserva;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IReservaDAO;
import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;
import com.restaurante.amm.amimanerapersistencia.daoimpl.clientes.PersonaJuridicaDAOImpl;
import com.restaurante.amm.amimanerapersistencia.daoimpl.clientes.PersonaNaturalDAOImpl;

public class ReservaDAOImpl extends BaseDAOImpl<Reserva> implements IReservaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, Reserva reserva) throws SQLException {
        String sql = "{CALL insertarReserva(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp("p_fechaHoraInicio", Timestamp.valueOf(reserva.getFechaHoraInicio()));
        cmd.setTimestamp("p_fechaHoraFin", Timestamp.valueOf(reserva.getFechaHoraFin()));
        cmd.setInt("p_cantidadPersonas", reserva.getCantidadPersonas());
        cmd.setString("p_estado", reserva.getEstado().name());
        cmd.setDouble("p_montoReserva", reserva.getMontoReserva());
        cmd.setInt("p_idPersonaNatural", reserva.getPersonaNatural().getIdCliente());
        cmd.setInt("p_idPersonaJuridica", reserva.getPersonaJuridica().getIdCliente());
        cmd.setInt("p_idMesa", reserva.getMesa().getIdMesa());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, Reserva reserva) throws SQLException {
        String sql = "{CALL modificarReserva(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp("p_fechaHoraInicio", Timestamp.valueOf(reserva.getFechaHoraInicio()));
        cmd.setTimestamp("p_fechaHoraFin", Timestamp.valueOf(reserva.getFechaHoraFin()));
        cmd.setInt("p_cantidadPersonas", reserva.getCantidadPersonas());
        cmd.setString("p_estado", reserva.getEstado().name());
        cmd.setDouble("p_montoReserva", reserva.getMontoReserva());
        cmd.setInt("p_idPersonaNatural", reserva.getPersonaNatural().getIdCliente());
        cmd.setInt("p_idPersonaJuridica", reserva.getPersonaJuridica().getIdCliente());
        cmd.setInt("p_idMesa", reserva.getMesa().getIdMesa());
        cmd.setInt("p_id", reserva.getIdReserva());
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
        reserva.setIdReserva(rs.getInt("idReserva"));
        reserva.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
        reserva.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
        reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
        reserva.setEstado(EstadoReserva.valueOf(rs.getString("estado")));
        reserva.setMontoReserva(rs.getDouble("montoReserva"));
        reserva.setMesa(new MesaDAOImpl().buscar(rs.getInt("idMesa")));
        if(rs.getInt("idPersonaNatural") != 0)
            reserva.setPersonaNatural(new PersonaNaturalDAOImpl().buscar(rs.getInt("idPersonaNatural")));
        if(rs.getInt("idPersonaJuridica") != 0)
            reserva.setPersonaJuridica(new PersonaJuridicaDAOImpl().buscar(rs.getInt("idPersonaJuridica")));
        return reserva;
    }
}