//Author: MAKO

import java.sql.Timestamp;
import java.util.List;

public class Pedido{
    //Atributos
    private int id_pedido;
    private Timestamp fecha;
    private EstadoPedido estadoPedido;
    private double monto_total;
    private List<LineaPedido> listaLineaPedido;

    //Contructores
    public Pedido(){}
    public Pedido(int id_pedido, Timestamp fecha, EstadoPedido estadoPedido,
                  double monto_total, List<LineaPedido> listaLineaPedidos){
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.estadoPedido = estadoPedido;
        this.monto_total = monto_total;
        this.listaLineaPedido = listaLineaPedidos;
    }
    public Pedido(Pedido pedido){
        id_pedido = pedido.id_pedido;
        fecha = pedido.fecha;
        estadoPedido = pedido.estadoPedido;
        monto_total = pedido.monto_total;
        listaLineaPedido = pedido.listaLineaPedido;
    }
    
    //Setters
    public void setId_producto(int id_pedido){
        this.id_pedido = id_pedido;
    }
    public void setFecha(Timestamp fecha){
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
    public Timestamp getFecha(){
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