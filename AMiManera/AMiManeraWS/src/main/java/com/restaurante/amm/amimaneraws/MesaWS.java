/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.restaurante.amm.amimaneraws;

import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneranegocio.bo.IMesaBO;
import com.restaurante.amm.amimaneranegocio.boimpl.MesaBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

/**
 *
 * @author USER
 */
@WebService(serviceName = "MesaWS")
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
