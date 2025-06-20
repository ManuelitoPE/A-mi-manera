package com.restaurante.amm.amimaneraws;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimaneranegocio.bo.personal.ICuentaUsuarioBO;
import com.restaurante.amm.amimaneranegocio.boimpl.personal.CuentaUsuarioBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "CuentaUsuarioWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class CuentaUsuarioWS {

    private final ICuentaUsuarioBO cuentaUsuarioBO;
    
    public CuentaUsuarioWS(){
        this.cuentaUsuarioBO = new CuentaUsuarioBOImpl();
    }
    @WebMethod(operationName = "login")
    public CuentaUsuario login(@WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia) {
        return new CuentaUsuarioBOImpl().autenticar(nombreUsuario, contrasenia);
    }
    
    @WebMethod(operationName = "encontrarRolDelUsuario")
    public int encontrarRolDelUsuario(@WebParam(name = "cuenta")CuentaUsuario cuenta){
        
        return cuentaUsuarioBO.obtenerIdUsuario(cuenta);
    }
}
