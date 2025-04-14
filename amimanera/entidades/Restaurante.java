//Author: Mako

package amimanera.entidades;

//El restaurante ofrece una lista de mesas
//El restaurante permite abrir una mesa
//El restaurante

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Restaurante {
    //Atributos
    private final Menu menu;

    //Constructores
    public Restaurante(){
        menu = new Menu();
    }


    //El restaurante debe permitir subir una carta
    public void subirMenu(final String archivo)throws FileNotFoundException{
        Scanner arch = new Scanner(new File(archivo));    
        arch.useDelimiter(",|\\n");
        menu.subirPlatos(arch);
    }
    //El restaurante debe agregar un plato
    public void agregarPlato(String nombre,String descripcion,
                             double precioUnitario, TipoProducto tipoProducto){
        menu.subirPlato(nombre, descripcion, precioUnitario, tipoProducto);
    }
    
    //El restaurante debe modificar un plato
    //Para modificar un plato se necesita el id/nombre
    //Ingresar que se quiere modificar 'N','D','P','T'
    
    //Por ID
    // public void modificarPlato(String idProducto, char opcion,
    //                            ){
    
    // }
    //Por nombre
    public void modificarPlato(){
        //Se pone el nombre del plato/id y se pone 
    }

    //El restaurante debe mostrar un plato
    public void mostrarPlato(){

    }
    //El restaurante debe eliminar un plaot
    public void eliminarPlato(){

    }
    //El restaurante debe mostrar una carta
    public void mostrarMenu(){
        menu.mostrarPlatos();
    }
}