//Auhtor: Mako
package amimanera;
import amimanera.entidades.*;

public class Principal {
    public static void main(String[] args)throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.subirMenu("amimanera/docs/Menu.csv");
        restaurante.mostrarMenu();
    }
}
