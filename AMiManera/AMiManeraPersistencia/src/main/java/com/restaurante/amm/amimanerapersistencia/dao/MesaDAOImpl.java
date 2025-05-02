package com.restaurante.amm.amimanerapersistencia.dao;

import com.restaurante.amm.amimanerapersistencia.daoimpl.IMesaDAO;
import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.EstadoMesa;
import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneradbmanager.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MesaDAOImpl implements IMesaDAO{

    @Override
    public int insertar(Mesa mesa) {
        String sql="INSERT MESA(cantidadAsientos,estado) VALUES (?,?)";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, mesa.getCantidadAsientos());
            ps.setString(2, String.valueOf(mesa.getEstado()));
            
            if(ps.executeUpdate()==0){
                System.err.println("El registro no se inserto");
                return 0;
            }
            
            try(ResultSet rs=ps.getGeneratedKeys()){
                return rs.next()? rs.getInt(1):-1;
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
    public boolean modificar(Mesa mesa) {
        String sql="UPDATE Mesa SET cantidadAsiento=?,estado=? WHERE idMesa=?";
        try (Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){

            ps.setInt(1, mesa.getCantidadAsientos());
            ps.setString(2, String.valueOf(mesa.getEstado()));
            ps.setInt(3, mesa.getIdMesa());
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
    public boolean eliminar(int id) {
        String sql="DELETE FROM Mesa WHERE idMesa=?";
        try(Connection conn= DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,id);
            return ps.executeUpdate()>0;
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
    public Mesa buscar(int id) {
        String sql="SELECT * FROM Mesa WHERE idMesa=?";
        try (Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps =conn.prepareStatement(sql)){
            
            ps.setInt(1,id);
            
            try(ResultSet rs= ps.executeQuery()){
                if(!rs.next()){
                    System.err.println("No se encontro la mesa con id: "+id);
                    return null;
                }
                Mesa mesa=new Mesa();
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                mesa.setEstado(EstadoMesa.valueOf(rs.getString("estado")));
                
                return mesa;
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
    public List<Mesa> listar() {
        String sql="SELECT * FROM MESA";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            List<Mesa> mesas =new ArrayList<>();
            while(rs.next()){
                Mesa mesa=new Mesa();
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                mesa.setEstado(EstadoMesa.valueOf(rs.getString("estado")));
                mesas.add(mesa);
            }
            
            return mesas;
        }
        catch (SQLException e) {
            System.err.println("Error SQL durante el listado: " + e.getMessage());
            throw new RuntimeException("No se pudo listar el registro.", e);
        }
        catch (Exception e) {
            System.err.println("Error inpesperado: " + e.getMessage());
            throw new RuntimeException("Error inesperado al listar los registros.", e);
        }
    }
}
