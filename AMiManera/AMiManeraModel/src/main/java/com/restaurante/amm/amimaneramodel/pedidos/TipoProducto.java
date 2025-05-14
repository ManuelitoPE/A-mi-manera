/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneramodel.pedidos;

/**
 *
 * @author USER
 */
public class TipoProducto {
    private int idTipoProducto;
    private String descripcion;
    
    public TipoProducto(){}
    
    public TipoProducto(int idTipoProducto,String descripcion){
        this.idTipoProducto = idTipoProducto;
        this.descripcion = descripcion;
    }
    
    public TipoProducto(TipoProducto tipo){
        this.idTipoProducto = tipo.idTipoProducto;
        this.descripcion = tipo.descripcion;
    }

    /**
     * @return the idTipoProducto
     */
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
