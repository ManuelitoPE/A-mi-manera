package com.restaurante.amm.amimaneranegocio.bo.personal;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimaneranegocio.bo.IBaseBO;

public interface ICuentaUsuarioBO extends IBaseBO<CuentaUsuario>{
    CuentaUsuario autenticar(String nombreUsuario,String contrasenia);
    int obtenerIdUsuario(CuentaUsuario cuenta);
}
