public abstract class Cliente {
    // Atributos
    private int id_cliente;
    private String nombre;
    private int telefono;
    private String correo;

    // Constructor
    public Cliente(int id_cliente, String nombre, int telefono, String correo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters
    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    // Setters
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método toString para mostrar los datos
    @Override
    public String toString() {
        return "Cliente: " +'\n'
               "id_cliente= " + id_cliente +'\n'
               "nombre= " + nombre + '\n' +
               "telefono= " + telefono +
               "correo= " + correo + '\n';
    }
}
