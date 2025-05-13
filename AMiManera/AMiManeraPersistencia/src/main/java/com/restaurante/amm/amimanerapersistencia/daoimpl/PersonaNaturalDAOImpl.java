package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.IPersonaNaturalDAO;
import com.restaurante.amm.amimaneramodel.clientes.PersonaNatural;

public class PersonaNaturalDAOImpl extends BaseDAOImpl<PersonaNatural> implements IPersonaNaturalDAO {
    @Override
    protected CallableStatement comandoInsertar(Connection conn, PersonaNatural personaNatural) throws SQLException {
        
        String sql = "{CALL insertarPersonaNatural(?, ?, ?, ?, ?)}";
        
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", personaNatural.getNombre());
        cmd.setInt("p_telefono", personaNatural.getTelefono());
        cmd.setString("p_correo", personaNatural.getCorreo());
        cmd.setString("p_dni", personaNatural.getDNI());  
        
        
        cmd.registerOutParameter("p_id", Types.INTEGER);
        return cmd;
    }

    @Override
    protected CallableStatement comandoModificar(Connection conn, PersonaNatural persona) throws SQLException {
        String sql = "{CALL modificarPersonaNatural(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setString("p_nombre", persona.getNombre());
        cmd.setInt("p_telefono", persona.getTelefono());
        cmd.setString("p_correo", persona.getCorreo());
        cmd.setString("p_dni", persona.getDNI());
        cmd.setInt("p_id", persona.getIdCliente());
        return cmd;
    }

    @Override
    protected CallableStatement comandoEliminar(Connection conn, int id) throws SQLException {
        String sql = "{CALL eliminarPersonaNatural(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoBuscar(Connection conn, int id) throws SQLException {
        String sql = "{CALL buscarPersonaNaturalPorId(?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setInt("p_id", id);
        return cmd;
    }

    @Override
    protected CallableStatement comandoListar(Connection conn) throws SQLException {
        String sql = "{CALL listarPersonasNaturales()}";
        CallableStatement cmd = conn.prepareCall(sql);
        return cmd;
    }

    @Override
    protected PersonaNatural mapearModelo(ResultSet rs) throws SQLException {
        PersonaNatural persona = new PersonaNatural();
        persona.setIdCliente(rs.getInt("idPersonaNatural"));
        persona.setNombre(rs.getString("nombre"));
        persona.setTelefono(rs.getInt("telefono"));
        persona.setCorreo(rs.getString("correo"));
        persona.setDNI(rs.getString("DNI"));
        return persona;
    }
}