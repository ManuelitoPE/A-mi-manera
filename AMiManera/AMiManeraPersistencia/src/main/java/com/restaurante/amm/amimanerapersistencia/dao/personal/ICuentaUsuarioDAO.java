package com.restaurante.amm.amimanerapersistencia.dao.personal;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimanerapersistencia.dao.ICrud;

public interface ICuentaUsuarioDAO extends ICrud<CuentaUsuario> {
    CuentaUsuario autenticar(String usuario, String contrasenia);
<<<<<<< HEAD
=======
    int buscarId(CuentaUsuario cuenta);
>>>>>>> main
} 