package com.restaurante.amm.amimaneranegocio.boimpl.personal;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.personal.ICuentaUsuarioBO;
import com.restaurante.amm.amimanerapersistencia.dao.personal.ICuentaUsuarioDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.personal.CuentaUsuarioDAOImpl;
import java.util.List;

public class CuentaUsuarioBOImpl implements ICuentaUsuarioBO{
    private final ICuentaUsuarioDAO cuentaUsuarioDAO;
    
    public CuentaUsuarioBOImpl(){
        this.cuentaUsuarioDAO = new CuentaUsuarioDAOImpl();
    }
    
    @Override
    public void guardar(CuentaUsuario cuenta,Estado estado){
        if (estado == Estado.NUEVO) this.cuentaUsuarioDAO.insertar(cuenta);
        else if (estado == Estado.MODIFICAR) this.cuentaUsuarioDAO.modificar(cuenta);
    }
    
    @Override
    public void eliminar(int id){
        this.cuentaUsuarioDAO.eliminar(id);
    }
    
    @Override
    public CuentaUsuario obtener(int id){
        return this.cuentaUsuarioDAO.buscar(id);
    }
    
    @Override
    public List<CuentaUsuario> listar(){
        return this.cuentaUsuarioDAO.listar();
    }
    
    @Override
    public CuentaUsuario autenticar(String nombreUsuario,String contrasenia){
        return this.cuentaUsuarioDAO.autenticar(nombreUsuario, contrasenia);
    }
    
    @Override
    public int obtenerIdUsuario(CuentaUsuario cuenta){
        return this.cuentaUsuarioDAO.buscarId(cuenta);
    }
}
