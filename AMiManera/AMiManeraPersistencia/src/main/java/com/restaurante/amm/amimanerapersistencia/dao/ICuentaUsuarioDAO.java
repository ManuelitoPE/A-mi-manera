package com.restaurante.amm.amimanerapersistencia.dao;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;

public interface ICuentaUsuarioDAO extends ICrud<CuentaUsuario> {
    CuentaUsuario autenticar(String usuario, String contrasenia);
} 