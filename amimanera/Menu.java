//Author: mako

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    //Atributos
    private List<Producto> listaProductos;

    //Contructores
    public Menu(){
        listaProductos = new ArrayList<>();
    }
    public Menu(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }
    public Menu(Menu menu){
        listaProductos = menu.listaProductos;
    }

    //Setters
    public void setListaProductos(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    //Getters
    public List<Producto> getListaProductos(){
        return listaProductos;
    }

    //Funciones
    public void subirPlatos(Scanner scanner){
        while(scanner.hasNext()){
            Producto producto = new Producto();
            producto.cargar(scanner);
            listaProductos.add(producto);
        }
    }
    public void mostrarPlatos(){
        for(Producto p : listaProductos){
            p.imprimir();
        }
    }
        
}
