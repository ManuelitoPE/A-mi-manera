//Author: Mako
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
    //El restaurante debe modificar un plato
    //El restaurante debe mostrar un plato
    //El restaurante debe eliminar un plaot
    //El restaurante debe mostrar una carta
    public void mostrarMenu(){
        menu.mostrarPlatos();
    }
}