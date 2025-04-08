//Author: MAKO
public class Producto{
    //Atributos
    private int id_producto;
    private String nombre;
    private String descripcion;
    private double precio_unitario;
    private TipoProducto tipoProducto;
    
    //Constructores
    public Producto(){}
    public Producto(int id_producto,String nombre,String descripcion,
                    double precio_unitario,TipoProducto tipoProducto){
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.tipoProducto = tipoProducto;
    }
    public Producto(Producto producto){
        id_producto = producto.id_producto;
        nombre = producto.nombre;
        descripcion = producto.descripcion;
        precio_unitario = producto.precio_unitario;
        tipoProducto = producto.tipoProducto;
    }

    //Setters
    public void setId_producto(int id_producto){
        this.id_producto = id_producto;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
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