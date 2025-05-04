package com.restaurante.amm.amimaneramodel.personal;

import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import java.util.ArrayList;


public class Mesero extends Trabajador{
    
    private ArrayList<Pedido> listaPedidos;
    
    //CONSTRUCTOR
    public Mesero(){
        listaPedidos = new ArrayList<>();
    }
    
    public Mesero(ArrayList<Pedido> listaPedidos){
        this.listaPedidos = new ArrayList<>(listaPedidos);
    }
    
    public Mesero(Mesero mesero){
        this.listaPedidos = new ArrayList<>(mesero.listaPedidos);
    }
    
    //GETERS Y SETERS

    /**
     * @return the listaPedidos
     */
    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    /**
     * @param listaPedidos the listaPedidos to set
     */
    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    
    
    
}
