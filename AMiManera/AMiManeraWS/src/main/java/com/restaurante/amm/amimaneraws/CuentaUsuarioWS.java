package com.restaurante.amm.amimaneraws;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimaneranegocio.boimpl.personal.CuentaUsuarioBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "CuentaUsuarioWS")
public class CuentaUsuarioWS {

    @WebMethod(operationName = "login")
    public CuentaUsuario login(@WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia) {
        return new CuentaUsuarioBOImpl().autenticar(nombreUsuario, contrasenia);
    }
}
