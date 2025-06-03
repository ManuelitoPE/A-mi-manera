package com.restaurante.amm.amimanerapersistencia.daoimpl.personal;

import com.restaurante.amm.amimaneradbmanager.DBManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.restaurante.amm.amimanerapersistencia.dao.personal.ICuentaUsuarioDAO;
import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BaseDAOImpl;
import java.sql.PreparedStatement;

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
    
    protected CallableStatement comandoAutenticar(Connection conn,
            String nombreUsuario,String contrasenia) throws SQLException {
        String sql = "{CALL autenticarUsuario(?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        
        cmd.setString("p_nombreUsuario", nombreUsuario);
        cmd.setString("p_contrasenia", contrasenia);
        return cmd;
    }
    
    @Override
    public CuentaUsuario autenticar(String usuario, String contrasenia) {
        try (
            Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = this.comandoAutenticar(conn, usuario, contrasenia);
        ) {
            ResultSet rs = ps.executeQuery();
            
            if (!rs.next()) {
                System.err.println("No se encontro el registro con usuario: " + usuario);
                return null;
            }         
            return this.mapearModelo(rs);
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante la busqueda: " + e.getMessage());
            throw new RuntimeException("No se pudo buscar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al buscar el registro.", e);
        }
    }    
} 