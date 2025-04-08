//Author: MAKO
public class Producto{
    //Atributos
    private int id_producto;
    private String nombre;
    private String descripcion;
    private double precio_unitario;
    private TipoProducto tipoProducto;
    
    //Setters
    public void setId_producto(int id_producto){
        this.id_producto = id_producto;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void detDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setPrecio_unitario(double precio_unitario){
        this.precio_unitario = precio_unitario;
    }
    public void setTipoProducto(TipoProducto tipoProducto){
        this.tipoProducto = tipoProducto;
    }
    
    //Getters
    public int getId_producto(){
        return id_producto;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getPrecio_unitario(){
        return precio_unitario;
    }
    public TipoProducto getTipoProducto(){
        return tipoProducto;
    }
    

}