//Author: MAKO

public class LineaPedido {
    //Atributos
    private int id_lineaPedido;
    private Producto producto;
    private int cantidad;
    private double monto_parcial;

    //Constructores
    public LineaPedido(){}
    public LineaPedido(int id_lineaPedido, Producto producto,
                       int cantidad, double monto_parcial){
        this.id_lineaPedido = id_lineaPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto_parcial = monto_parcial;
    }
    public LineaPedido(LineaPedido lineaPedido){
        id_lineaPedido = lineaPedido.id_lineaPedido;
        producto = lineaPedido.producto;
        cantidad = lineaPedido.cantidad;
        monto_parcial = lineaPedido.monto_parcial;
    }
    
    //Setters
    public void setId_lineaPedido(int id_lineaPedido){
        this.id_lineaPedido = id_lineaPedido;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setMonto_parcial(double monto_parcial){
        this.monto_parcial = monto_parcial;
    }
    
    //Getters
    public int id_lineaPedido(){
        return id_lineaPedido;
    }
    public int cantidad(){
        return cantidad;
    }
    public double monto_parcial(){
        return monto_parcial;
    }

    //Funciones
    public void guardarDetalle(){
        
    }
}
