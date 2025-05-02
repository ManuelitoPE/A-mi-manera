package com.restaurante.amm.amimanerapersistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurante.amm.amimaneracapadominiomodel.clientes.PersonaJuridica;
import com.restaurante.amm.amimanerapersistencia.daoimpl.IPersonaJuridicaDAO;
import com.restaurante.amm.amimaneradbmanager.DBManager;

public class PersonaJuridicaDAOImpl implements IPersonaJuridicaDAO{
    @Override
    public int insertar(PersonaJuridica personaJuridica){
        String sql="INSERT PersonaJuridica(idCliente,nombre,telefono,correo,razonSocial,"
                + "RUC) VALUES (?,?,?,?,?,?)";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            
            ps.setInt(1,personaJuridica.getIdCliente());
            ps.setString(2,personaJuridica.getNombre());
            ps.setInt(3, personaJuridica.getTelefono());
            ps.setString(4, personaJuridica.getCorreo());
            ps.setString(5, personaJuridica.getRazonSocial());
            ps.setString(6, personaJuridica.getRUC());
            
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
    public boolean modificar(PersonaJuridica personaJuridica){
        String sql="UPDATE PersonaJuridica SET nombre=?,telefono=?,correo=?,"
                + "razonSocial=?,RUC=? WHERE idCliente=?";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            
            ps.setInt(1,personaJuridica.getIdCliente());
            ps.setString(2,personaJuridica.getNombre());
            ps.setInt(3, personaJuridica.getTelefono());
            ps.setString(4, personaJuridica.getCorreo());
            ps.setString(5, personaJuridica.getRazonSocial());
            ps.setString(6, personaJuridica.getRUC());
            
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
        String sql="DELETE FROM PersonaJuridica WHERE idCliente=?";
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
    public PersonaJuridica buscar(int id){
        String sql="SELECT * FROM PersonaJuridica WHERE idCliente=?";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.err.println("No se encontro el cliente con id: " + id);
                    return null;
                }

                PersonaJuridica personaJuridica = new PersonaJuridica();
                personaJuridica.setIdCliente(rs.getInt("idCliente"));
                personaJuridica.setNombre(rs.getString("nombre"));
                personaJuridica.setTelefono(rs.getInt("telefono"));
                personaJuridica.setCorreo(rs.getString("correo"));
                personaJuridica.setRazonSocial(rs.getString("razonSocial"));
                personaJuridica.setRUC(rs.getString("RUC"));
                
                return personaJuridica;
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
    public List<PersonaJuridica> listar(){
        String sql="SELECT * FROM PersonaJuridica";
        try (Connection conn = DBManager.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery()) {
            
            List<PersonaJuridica> clientes = new ArrayList<>();
            while (rs.next()) {
                PersonaJuridica cliente = new PersonaJuridica();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setRazonSocial(rs.getString("razonSocial"));
                cliente.setRUC(rs.getString("RUC"));
                
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