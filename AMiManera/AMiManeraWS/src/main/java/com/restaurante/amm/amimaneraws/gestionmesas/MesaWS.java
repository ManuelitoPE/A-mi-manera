package com.restaurante.amm.amimaneraws.gestionmesas;

import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneranegocio.bo.gestionmesas.IMesaBO;
import com.restaurante.amm.amimaneranegocio.boimpl.gestionmesas.MesaBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "MesaWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class MesaWS {
    
    private final IMesaBO mesaBO;
    
    public MesaWS(){
        mesaBO = new MesaBOImpl();
    }
    
    @WebMethod(operationName = "listarMesas")
    public List<Mesa> listarMesas() {
        try{
            return this.mesaBO.listar();
        }catch (Exception e){
            throw new WebServiceException("Error al listar mesas: "+e.getMessage());
        }
    }
    
//    @WebMethod(operationName = "AsignarReservaAMesa")
//    public void asignarReservaAMesa(@WebParam(name = "idMesa") int id){
//        
//    }
//    @WebMethod(operationName = "mostrarDisponibilidad")
//   public List<Mesa> mostrarDisponibilidad(String fecha){
//       
//   }
}
