/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.personal.CuentaUsuario;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.ICuentaUsuarioBO;
import com.restaurante.amm.amimanerapersistencia.dao.ICuentaUsuarioDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.CuentaUsuarioDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
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
}
