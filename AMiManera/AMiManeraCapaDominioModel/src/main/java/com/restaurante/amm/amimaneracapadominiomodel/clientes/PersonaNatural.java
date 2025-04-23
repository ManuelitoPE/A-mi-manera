package com.restaurante.amm.amimaneracapadominiomodel.clientes;

import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.Reserva;
import java.util.ArrayList;

public class PersonaNatural extends Cliente {
    private String DNI;
    
    //Constructor
    
    public PersonaNatural(){}
    
    public PersonaNatural(int idCliente, String nombre, int telefono, String correo,
            ArrayList<Reserva> listaReservas, String DNI) {
        super(idCliente, nombre, telefono, correo,listaReservas);
        this.DNI = DNI;
    }
    
    public PersonaNatural(PersonaNatural personaNatural){
        super(personaNatural);
        this.DNI = personaNatural.DNI;
    }
    
    //GETERS Y SETERS

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
}
