//Author: MAKO

public class LineaPedido {
    //Atributos
    private int id_lineaPedido;
    private int cantidad;
    private double monto_parcial;

    //Constructores
    
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
