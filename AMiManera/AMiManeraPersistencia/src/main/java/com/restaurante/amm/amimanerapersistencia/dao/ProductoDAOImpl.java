package com.restaurante.amm.amimanerapersistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurante.amm.amimanerapersistencia.daoimpl.IProductoDAO;
import com.restaurante.amm.amimaneracapadominiomodel.pedidos.Producto;
import com.restaurante.amm.amimaneracapadominiomodel.pedidos.TipoProducto;
import com.restaurante.amm.amimaneradbmanager.DBManager;


public class ProductoDAOImpl implements IProductoDAO {

    @Override
    public int insertar(Producto producto) {
        String sql = "INSERT Producto(idProducto,nombre,"
                + "descripcion,precioUnitario,TipoProducto) VALUES (?,?,?,?,?)";
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, producto.getIdProducto());
            ps.setString(2,producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecioUnitario());
            ps.setString(5,String.valueOf(producto.getTipoProducto()));
            //falta el tipoProducto
            if(ps.executeUpdate()==0){
                System.err.println("El registro no se inserto.");
                return 0;
            }
            try(ResultSet rs=ps.getGeneratedKeys()){
                return rs.next()? rs.getInt(1):-1;
            }
         
        }
        catch(SQLException e){
            System.err.println("Error SQL durante la insercion "+ e.getMessage());
            throw new RuntimeException("No se pudo insertar el registro.",e);
        }
        catch(Exception e){
            System.err.println("Error inesperado: "+e.getMessage());
            throw new RuntimeException("Error inesperado al insertar el registro.",e);
        }
        
    }
    
    @Override
    public boolean modificar(Producto producto){
        String sql ="UPDATE Producto SET nombre=?,descripcion=?,"
                + "precioUnitario=?,tipo =? WHERE idProducto=?"; 
        try(Connection conn=DBManager.getInstance().getConnection();
                PreparedStatement cs= conn.prepareStatement(sql)){
            cs.setInt(1, producto.getIdProducto());
            cs.setString(2,producto.getNombre());
            cs.setString(3, producto.getDescripcion());
            cs.setDouble(4, producto.getPrecioUnitario());
            cs.setString(5,producto.getTipoProducto().name());
            return cs.executeUpdate()>0;
        }
        catch(SQLException e){
            System.err.println("Error SQL durante la modificacion "+ e.getMessage());
            throw new RuntimeException("No se pudo modificar el registro.",e);
        }
        catch(Exception e){
            System.err.println("Error inesperado: "+e.getMessage());
            throw new RuntimeException("Error inesperado al modificar el registro.",e);
        }        
        
    }
    @Override
    public boolean eliminar(int id){
        String sql="DELETE FROM Producto WHERE idProducto=?";
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
    public Producto buscar(int id){
        String sql="SELECT * FROM Producto WHERE idProducto=?";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (!rs.next()) {
                System.err.println("No se encontro el producto con id: " + id);
                return null;
            }
            
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setTipoProducto(TipoProducto.valueOf(rs.getString("tipoProducto")));
            return producto;
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
    public List<Producto>listar(){
        String sql = "SELECT * FROM Producto";
        try (Connection conn = DBManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            
            List<Producto> productos = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
                producto.setTipoProducto(TipoProducto.valueOf(rs.getString("tipoProducto")));
                productos.add(producto);
            }
            
            return productos;
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