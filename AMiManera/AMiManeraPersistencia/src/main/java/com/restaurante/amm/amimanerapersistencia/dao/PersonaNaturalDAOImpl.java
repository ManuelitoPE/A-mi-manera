package com.restaurante.amm.amimanerapersistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurante.amm.amimaneracapadominiomodel.clientes.PersonaNatural;
import com.restaurante.amm.amimanerapersistencia.daoimpl.IPersonaNaturalDAO;
import com.restaurante.amm.amimaneradbmanager.DBManager;

public class PersonaNaturalDAOImpl implements IPersonaNaturalDAO{
    @Override
    public int insertar(PersonaNatural personaNatural){
        String sql="INSERT PersonaNatural (idCliente,nombre,telefono,correo,"
                + "DNI) VALUES (?,?,?,?,?)";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1,personaNatural.getIdCliente());
            ps.setString(2,personaNatural.getNombre());
            ps.setInt(3, personaNatural.getTelefono());
            ps.setString(4, personaNatural.getCorreo());
            ps.setString(5, personaNatural.getDNI());
            
            if(ps.executeUpdate()==0){
                System.err.println("El registro no se inserto.");
                return 0;
            }
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : -1;
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
    public boolean modificar(PersonaNatural personaNatural){
        String sql="UPDATE PersonaNatural SET nombre=?,telefono=?,correo=?,"
                + "DNI=? WHERE idCliente=?";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,personaNatural.getIdCliente());
            ps.setString(2,personaNatural.getNombre());
            ps.setInt(3, personaNatural.getTelefono());
            ps.setString(4, personaNatural.getCorreo());
            ps.setString(5, personaNatural.getDNI());
            
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
        String sql="DELETE FROM PersonaNatural WHERE idCliente=?";
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
    public PersonaNatural buscar(int id){
        String sql="SELECT * FROM PersonaNatural WHERE idCliente=?";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.err.println("No se encontro el cliente con id: " + id);
                    return null;
                }

                PersonaNatural personaNatural = new PersonaNatural();
                personaNatural.setIdCliente(rs.getInt("idCliente"));
                personaNatural.setNombre(rs.getString("nombre"));
                personaNatural.setTelefono(rs.getInt("telefono"));
                personaNatural.setCorreo(rs.getString("correo"));
                personaNatural.setDNI(rs.getString("DNI"));
                return personaNatural;
            }     
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
    
    @Override
    public List<PersonaNatural> listar(){
        String sql="SELECT * FROM PersonaNatural";
        try (Connection conn = DBManager.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery()) {
            
            List<PersonaNatural> clientes = new ArrayList<>();
            while (rs.next()) {
                PersonaNatural cliente = new PersonaNatural();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDNI(rs.getString("DNI"));
                clientes.add(cliente);
            }
            return clientes;
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