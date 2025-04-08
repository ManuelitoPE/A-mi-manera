public class MetodoPago {
    // Atributos
    private int id_Metodo_Pago;
    private String descripcion;
    private String moneda;

    // Constructor
    public MetodoPago(int id_Metodo_Pago, String descripcion, String moneda) {
        this.id_Metodo_Pago = id_Metodo_Pago;
        this.descripcion = descripcion;
        this.moneda = moneda;
    }

    // Getters
    public int getId_Metodo_Pago() {
        return id_Metodo_Pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMoneda() {
        return moneda;
    }

    // Setters
    public void setId_Metodo_Pago(int id_Metodo_Pago) {
        this.id_Metodo_Pago = id_Metodo_Pago;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    // Método toString para mostrar los datos
    @Override
    public String toString() {
        return "MetodoPago: " + '\n'
               + "id_Metodo_Pago= " + id_Metodo_Pago +'\n'
               + "descripcion= " + descripcion + '\n' +
               "moneda= " + moneda + '\n';
    }
}
