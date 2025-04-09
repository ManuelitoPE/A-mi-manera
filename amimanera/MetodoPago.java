public class MetodoPago {
    // Atributos
    private int idMetodoPago;
    private String descripcion;
    private String moneda;

    // Constructor
    public MetodoPago(int idMetodoPago, String descripcion, String moneda) {
        this.idMetodoPago = idMetodoPago;
        this.descripcion = descripcion;
        this.moneda = moneda;
    }

    // Getters
    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMoneda() {
        return moneda;
    }

    // Setters
    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
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
               + "idMetodoPago= " + idMetodoPago +'\n'
               + "descripcion= " + descripcion + '\n' +
               "moneda= " + moneda + '\n';
    }
}
