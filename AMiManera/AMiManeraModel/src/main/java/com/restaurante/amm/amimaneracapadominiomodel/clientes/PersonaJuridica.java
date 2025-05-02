package com.restaurante.amm.amimaneracapadominiomodel.clientes;

import com.restaurante.amm.amimaneracapadominiomodel.gestionmesas.Reserva;
import java.util.ArrayList;

public class PersonaJuridica extends Cliente{
    private String razonSocial;
    private String RUC;
    
    //Constructor
    
    public PersonaJuridica(){
        super();
    }
    
    public PersonaJuridica(int idCliente, String nombre, int telefono, String correo,
            ArrayList<Reserva> listaReservas, String razonSocial, String RUC) {
        super(idCliente, nombre, telefono, correo, listaReservas);
        this.razonSocial = razonSocial;
        this.RUC = RUC;
    }
    
    public PersonaJuridica(PersonaJuridica personaJuridica){
        super(personaJuridica);
        this.razonSocial = personaJuridica.razonSocial;
        this.RUC = personaJuridica.RUC;
    }
    
    //GETERS Y SETERS

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @param RUC the RUC to set
     */
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
    
    
}
