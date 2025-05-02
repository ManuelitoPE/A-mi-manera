package com.restaurante.amm.amimanerapersistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.Reserva;
import com.restaurante.amm.amimanerapersistencia.daoimpl.IReservaDAO;
import com.restaurante.amm.amimaneradbmanager.DBManager;
import java.sql.Timestamp;

public class ReservaDAOImpl implements IReservaDAO{
    @Override
    public int insertar(Reserva reserva){
        String sql="INSERT Reserva(idReserva,horaInicio,horaFin,cantidadPersonas,estado,"
                + "horaMaximaCancelacion,montoReserva,fecha) VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            
            ps.setInt(1,reserva.getIdReserva());
            ps.setTimestamp(2, Timestamp.valueOf(reserva.getHoraInicio()));
            ps.setTimestamp(3, Timestamp.valueOf(reserva.getHoraFin()));
            ps.setInt(4, reserva.getCantidadPersonas());
            ps.setString(5, reserva.getEstado());
            ps.setTimestamp(6, Timestamp.valueOf(reserva.getHoraMaximaCancelacion()));
            ps.setDouble(7, reserva.getMontoReserva());
            ps.setDate(8, new Date(reserva.getFecha().getTime()));
            ps.setInt(9, reserva.getCliente().getIdCliente());
            ps.setInt(10, reserva.getMesa().getIdMesa());
            
            if(ps.executeUpdate()==0){
                System.err.println("El registro no se inserto");
                return 0;
            }
            try(ResultSet rs=ps.getGeneratedKeys()){
                return rs.next()?rs.getInt(1):-1;
            }
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante la insercion: " + e.getMessage());
            throw new RuntimeException("No se pudo insertar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al insertar el registro.", e);
        }        
    }
    
    @Override
    public boolean modificar(Reserva reserva){
        String sql="UPDATE Reserva SET horaInicio=?,horaFin=?,"
                + "cantidadPersonas=?,estado=?,horaMaximaCancelacion=?,"
                + "montoReserva=?,fecha=? WHERE idReserva=?";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            
            ps.setInt(1,reserva.getIdReserva());
            ps.setTimestamp(2, Timestamp.valueOf(reserva.getHoraInicio()));
            ps.setTimestamp(3, Timestamp.valueOf(reserva.getHoraFin()));
            ps.setInt(4, reserva.getCantidadPersonas());
            ps.setString(5, reserva.getEstado());
            ps.setTimestamp(6, Timestamp.valueOf(reserva.getHoraMaximaCancelacion()));
            ps.setDouble(7, reserva.getMontoReserva());
            ps.setDate(8, new Date(reserva.getFecha().getTime()));
            ps.setInt(9, reserva.getCliente().getIdCliente());
            ps.setInt(10, reserva.getMesa().getIdMesa());
            
            return ps.executeUpdate()>0;
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante la modificacion: " + e.getMessage());
            throw new RuntimeException("No se pudo modificar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al modificar el registro.", e);
        }        
    }
    
    @Override
    public boolean eliminar(int id){
        String sql="DELETE FROM Reserva WHERE idReserva=?";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante la eliminacion: " + e.getMessage());
            throw new RuntimeException("No se pudo eliminar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al eliminar el registro.", e);
        }        
    }
    
    @Override
    public Reserva buscar(int id){
        return null;
//        String sql="SELECT * FROM Reserva WHERE idReserva=?";
//        try (Connection conn=DBManager.getInstance().getConnection();
//                PreparedStatement ps=conn.prepareStatement(sql)){
//            ps.setInt(1, id);
//            
//            try (ResultSet rs=ps.executeQuery()){
//                if(!rs.next()){
//                    System.err.println("No se encontro la reserva con id: "+id);
//                    return null;
//                }
//                
//                Reserva reserva =new Reserva();
//                reserva.setIdReserva(rs.getInt("idReserva"));
//                reserva.setHoraInicio(rs.getTimestamp("horaInicio").toLocalDateTime());
//                reserva.setHoraFin(rs.getTimestamp("horaFin").toLocalDateTime());
//                reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
//                reserva.setEstado(rs.getString("estado"));
//                reserva.setHoraMaximaCancelacion(rs.getTimestamp("horaMaximaCancelaccion").toLocalDateTime());
//                reserva.setMontoReserva(rs.getDouble("montoReserva"));
//                reserva.setFecha(rs.getDate("fecha"));
//                reserva.setCliente(new ClienteDAOImpl().buscar(rs.getInt("idCliente")));
//                reserva.setMesa(new MesaDAOImpl().buscar(rs.getInt("idMesa")));
//                
//                return reserva;
//            }
//        }
//        catch (SQLException e) {
//            System.err.println("Error SQL durante la busqueda: " + e.getMessage());
//            throw new RuntimeException("No se pudo buscar el registro.", e);
//        }
//        catch (Exception e) {
//            System.err.println("Error inpesperado: " + e.getMessage());
//            throw new RuntimeException("Error inesperado al buscar el registro.", e);
//        }
    }
    
    @Override
    public List<Reserva> listar(){
        return null;
//        String sql="SELECT * FROM Reserva";
//        try (Connection conn= DBManager.getInstance().getConnection();
//                PreparedStatement ps=conn.prepareStatement(sql);
//                ResultSet rs=ps.executeQuery()) {
//            
//            List<Reserva> reservas = new ArrayList<>();
//            while (rs.next()) {
//                Reserva reserva = new Reserva();
//                reserva.setIdReserva(rs.getInt("idReserva"));
//                reserva.setHoraInicio(rs.getTimestamp("horaInicio").toLocalDateTime());
//                reserva.setHoraFin(rs.getTimestamp("horaFin").toLocalDateTime());
//                reserva.setCantidadPersonas(rs.getInt("cantidadPersonas"));
//                reserva.setEstado(rs.getString("estado"));
//                reserva.setHoraMaximaCancelacion(rs.getTimestamp("horaMaximaCancelaccion").toLocalDateTime());
//                reserva.setMontoReserva(rs.getDouble("montoReserva"));
//                reserva.setFecha(rs.getDate("fecha"));
//                reserva.setCliente(new ClienteDAOImpl().buscar(rs.getInt("idCliente")));
//                reserva.setMesa(new MesaDAOImpl().buscar(rs.getInt("idMesa")));
//                
//                reservas.add(reserva);
//            }
//            
//            return reservas;
//        }        
    }
}