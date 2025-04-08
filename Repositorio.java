public class Reserva {
    // Variables (atributos)
    private int idReserva;
    private String informacionAlergias;
    private Timestamp horaInicio;
    private Timestamp horaFin;
    private String direccionClientes;
    private int cantidadPersonas;
    private String estado;
    private Timestamp horaMaximaCancelacion;
    private double montoReserva;
    private Date fecha;

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getInformacionAlergias() {
        return informacionAlergias;
    }

    public void setInformacionAlergias(String informacionAlergias) {
        this.informacionAlergias = informacionAlergias;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    public String getDireccionClientes() {
        return direccionClientes;
    }

    public void setDireccionClientes(String direccionClientes) {
        this.direccionClientes = direccionClientes;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getHoraMaximaCancelacion() {
        return horaMaximaCancelacion;
    }

    public void setHoraMaximaCancelacion(Timestamp horaMaximaCancelacion) {
        this.horaMaximaCancelacion = horaMaximaCancelacion;
    }

    public double getMontoReserva() {
        return montoReserva;
    }

    public void setMontoReserva(double montoReserva) {
        this.montoReserva = montoReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}