//Author: MAKO
package amimanera.entidades;

public class LineaPedido {
    //Atributos
    private int idLineaPedido;
    private Producto producto;
    private int cantidad;
    private double montoParcial;

    //Constructores
    public LineaPedido(){}
    public LineaPedido(int idLineaPedido, Producto producto,
                       int cantidad, double montoParcial){
        this.idLineaPedido = idLineaPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoParcial = montoParcial;
    }
    public LineaPedido(LineaPedido lineaPedido){
        idLineaPedido = lineaPedido.idLineaPedido;
        producto = lineaPedido.producto;
        cantidad = lineaPedido.cantidad;
        montoParcial = lineaPedido.montoParcial;
    }
    
    //Setters
    public void setIdLineaPedido(int idLineaPedido){
        this.idLineaPedido = idLineaPedido;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setMontoParcial(double montoParcial){
        this.montoParcial = montoParcial;
    }
    
    //Getters
    public int getIdLineaPedido(){
        return idLineaPedido;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getMontoParcial(){
        return montoParcial;
    }

    //Funciones
    public void guardarDetalle(){
        
    }
}
