//Author: MAKO
public class Producto{
    //Atributos
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private TipoProducto tipoProducto;
    
    //Constructores
    public Producto(){}
    public Producto(int idProducto,String nombre,String descripcion,
                    double precioUnitario,TipoProducto tipoProducto){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.tipoProducto = tipoProducto;
    }
    public Producto(Producto producto){
        idProducto = producto.idProducto;
        nombre = producto.nombre;
        descripcion = producto.descripcion;
        precioUnitario = producto.precioUnitario;
        tipoProducto = producto.tipoProducto;
    }

    //Setters
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setPrecioUnitario(double precioUnitario){
        this.precioUnitario = precioUnitario;
    }
    public void setTipoProducto(TipoProducto tipoProducto){
        this.tipoProducto = tipoProducto;
    }
    
    //Getters
    public int getIdProducto(){
        return idProducto;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getPrecioUnitario(){
        return precioUnitario;
    }
    public TipoProducto getTipoProducto(){
        return tipoProducto;
    }
    
}