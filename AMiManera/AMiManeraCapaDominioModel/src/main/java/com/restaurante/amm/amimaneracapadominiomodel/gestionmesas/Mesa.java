package com.restaurante.amm.amimaneracapadominiomodel.gestionmesas;

import com.restaurante.amm.amimaneracapadominiomodel.pedidos.Pedido;
import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.Reserva;
import java.util.ArrayList;

public class Mesa {
    //Atributos
    private int idMesa;
    private EstadoMesa estado;
    private int cantidadAsientos;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Reserva> listaReservas;

    //Constructores
    public Mesa(){
        listaPedidos = new ArrayList<>();
    }
    public Mesa(int idMesa,EstadoMesa estado,int cantidadAsientos,
                ArrayList<Pedido> listaPedidos, ArrayList<Reserva> listaReservas){
        this.idMesa = idMesa;
        this.estado = estado;
        this.cantidadAsientos = cantidadAsientos;
        this.listaPedidos = new ArrayList<>(listaPedidos);
        this.listaReservas = new ArrayList<>(listaReservas);
    }
    public Mesa(Mesa mesa){
        this.idMesa = mesa.idMesa;
        this.estado = mesa.estado;
        this.cantidadAsientos = mesa.cantidadAsientos;
        this.listaPedidos = new ArrayList<>(mesa.getListaPedidos());
        this.listaReservas = new ArrayList<>(mesa.getListaReservas());       
    }
    
    //Getters y setters

    /**
     * @return the idMesa
     */
    public int getIdMesa() {
        return idMesa;
    }

    /**
     * @param idMesa the idMesa to set
     */
    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    /**
     * @return the estado
     */
    public EstadoMesa getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    /**
     * @return the cantidadAsientos
     */
    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    /**
     * @param cantidadAsientos the cantidadAsientos to set
     */
    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

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

    /**
     * @return the listaReservas
     */
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * @param listaReservas the listaReservas to set
     */
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    

    
}
