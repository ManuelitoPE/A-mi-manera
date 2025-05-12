package com.restaurante.amm.amimaneramodel.pedidos;

import java.util.Scanner;

public class Producto {
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

    //Funciones
    public void cargar(Scanner scanner){
        idProducto = scanner.nextInt();   
        nombre = scanner.next();   
        descripcion = scanner.next();   
        precioUnitario = scanner.nextDouble();
        tipoProducto = TipoProducto.valueOf(scanner.next());   
    }
    public void imprimir(){
        System.out.println(String.format("%-15s\t%-10s\t%10.2f\t%-10s",
                            nombre,descripcion,precioUnitario,tipoProducto));
    }
}
