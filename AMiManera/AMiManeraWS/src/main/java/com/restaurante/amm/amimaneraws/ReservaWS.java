package com.restaurante.amm.amimaneraws;

import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.gestionmesas.IReservaBO;
import com.restaurante.amm.amimaneranegocio.boimpl.gestionmesas.ReservaBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "ReservaWS")
public class ReservaWS {

    private final IReservaBO reservaBO;
    
    public ReservaWS(){
        this.reservaBO = new ReservaBOImpl();
    }
    
    //AGREGAR Y MODIFICAR UNA RESERVA
    @WebMethod(operationName = "GuardarReserva")
    public void guardarReserva(@WebParam(name = "reserva") Reserva reserva,
            @WebParam(name = "estado") Estado estado) {
        this.reservaBO.guardar(reserva, estado);
    }
    
    //MOSTRAR TODAS LAS RESERVAS
    @WebMethod(operationName = "ListarReservas")
    public List<Reserva> listarReservas() {
        try{
            return this.reservaBO.listar();
        } catch (Exception e){
            throw new WebServiceException("Error al listar reservas: "+ e.getMessage());
        }  
    }
    
}
