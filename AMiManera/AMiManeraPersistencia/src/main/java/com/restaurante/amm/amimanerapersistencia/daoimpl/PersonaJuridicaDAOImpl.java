package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.IPersonaJuridicaDAO;
import com.restaurante.amm.amimaneramodel.clientes.PersonaJuridica;

public class PersonaJuridicaDAOImpl extends BaseDAOImpl<PersonaJuridica> implements IPersonaJuridicaDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, PersonaJuridica persona) throws SQLException {
        String sql = "{CALL insertarPersonaJuridica(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", persona.getNombre());
        cmd.setInt("p_telefono", persona.getTelefono());
        cmd.setString("p_correo", persona.getCorreo());
        cmd.setString("p_ruc", persona.getRUC());
        cmd.setString("p_razonSocial", persona.getRazonSocial());
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, PersonaJuridica persona) throws SQLException {
        String sql = "{CALL modificarPersonaJuridica(?, ?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", persona.getNombre());
        cmd.setInt("p_telefono", persona.getTelefono());
        cmd.setString("p_correo", persona.getCorreo());
        cmd.setString("p_ruc", persona.getRUC());
        cmd.setString("p_razonSocial", persona.getRazonSocial());
        cmd.setInt("p_id", persona.getIdCliente());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarPersonaJuridica(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarPersonaJuridicaPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarPersonasJuridicas()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected PersonaJuridica mapearModelo(ResultSet rs) throws SQLException {
        PersonaJuridica persona = new PersonaJuridica();
        persona.setIdCliente(rs.getInt("idPersonaJuridica"));
        persona.setNombre(rs.getString("nombre"));
        persona.setTelefono(rs.getInt("telefono"));
        persona.setCorreo(rs.getString("correo"));
        persona.setRUC(rs.getString("RUC"));
        persona.setRazonSocial(rs.getString("razonSocial"));
        return persona;
    }
}