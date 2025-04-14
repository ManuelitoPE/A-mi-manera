//Auhtor: mako
package amimanera.entidades;

import java.util.List;

public class Mesa {
    //Atributos
    private int idMesa;
    private EstadoMesa estado;
    private List<Pedido> listaPedidos;

    //Constructores
    public Mesa(){}
    public Mesa(int id_mesa,EstadoMesa estado,
                List<Pedido> listaPedidos){
        this.idMesa = id_mesa;
        this.estado = estado;
        this.listaPedidos = listaPedidos;
    }
    public Mesa(Mesa mesa){
        idMesa = mesa.idMesa;
        estado = mesa.estado;
        listaPedidos = mesa.listaPedidos;
    }

    //Setters
    public void setIdMesa(int idMesa){
        this.idMesa = idMesa;
    } 
    public void setEstadoMesa(EstadoMesa estado){
        this.estado = estado;
    }
    public void setListaPedidos(List<Pedido> listaPedidos){
        this.listaPedidos = listaPedidos;
    }
    
    //Getters
    public int getIdMesa(){
        return idMesa;
    } 
    public EstadoMesa getEstadoMesa(){
        return estado;
    }
    public List<Pedido> getListaPedidos(){
        return  listaPedidos;
    }

}
