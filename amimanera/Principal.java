//Auhtor: Mako

public class Principal {
    public static void main(String[] args)throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.subirMenu("Menu.csv");
        restaurante.mostrarMenu();
    }
}
