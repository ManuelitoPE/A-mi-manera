package com.restaurante.amm.amimaneraws;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
<<<<<<< HEAD
=======
import com.restaurante.amm.amimaneranegocio.bo.personal.ICuentaUsuarioBO;
>>>>>>> main
import com.restaurante.amm.amimaneranegocio.boimpl.personal.CuentaUsuarioBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "CuentaUsuarioWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class CuentaUsuarioWS {

<<<<<<< HEAD
=======
    private final ICuentaUsuarioBO cuentaUsuarioBO;
    
    public CuentaUsuarioWS(){
        this.cuentaUsuarioBO = new CuentaUsuarioBOImpl();
    }
>>>>>>> main
    @WebMethod(operationName = "login")
    public CuentaUsuario login(@WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia) {
        return new CuentaUsuarioBOImpl().autenticar(nombreUsuario, contrasenia);
    }
<<<<<<< HEAD
=======
    
    @WebMethod(operationName = "encontrarRolDelUsuario")
    public int encontrarRolDelUsuario(@WebParam(name = "cuenta")CuentaUsuario cuenta){
        
        return cuentaUsuarioBO.obtenerIdUsuario(cuenta);
    }
>>>>>>> main
}
