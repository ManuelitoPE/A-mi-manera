//Author: MAKO

import java.util.Date;
import java.util.List;

public class Pedido{
    //Atributos
    private int id_pedido;
    private Date fecha;
    private EstadoPedido estadoPedido;
    private double monto_total;
    private List<LineaPedido> listaLineaPedido;

    //Contructores

    
    //Setters
    public void setId_producto(int id_pedido){
        this.id_pedido = id_pedido;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido){
        this.estadoPedido = estadoPedido;
    }
    public void setMonto_total(double monto_total){
        this.monto_total = monto_total;
    }
    public void setListLineaPedidop(List<LineaPedido> listaLineaPedido){
        this.listaLineaPedido = listaLineaPedido;
    }
    
    //Getters
    public int getId_producto(){
        return id_pedido;
    }
    public Date getFecha(){
        return fecha;
    }
    public EstadoPedido getEstadoPedido(){
        return estadoPedido;
    }
    public double getMonto_total(){
        return monto_total;
    }
    public List<LineaPedido> getListLineaPedidop(){
        return listaLineaPedido;
    }
    
}