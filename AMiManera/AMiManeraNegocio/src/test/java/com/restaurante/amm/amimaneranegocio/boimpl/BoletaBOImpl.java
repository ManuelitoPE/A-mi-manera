/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.pagos.Boleta;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IBoletaBO;
import com.restaurante.amm.amimanerapersistencia.dao.IBoletaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BoletaDAOImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class BoletaBOImpl implements IBoletaBO{
    private final IBoletaDAO boletaDAO;
    
    public BoletaBOImpl(){
        this.boletaDAO = new BoletaDAOImpl();
    }
    
    
    @Override
    public void eliminar(int id){
        if(!this.boletaDAO.eliminar(id))    
            throw new RuntimeException("No se pudo eliminar la boleta");       
    }
    
    @Override
    public void guardar(Boleta boleta,Estado estado){
        if(estado == Estado.NUEVO) this.boletaDAO.insertar(boleta);
        else if (estado == Estado.MODIFICAR) this.boletaDAO.modificar(boleta);
    }
    
    @Override
    public List<Boleta> listar(){
        return this.boletaDAO.listar();
    }
    
    @Override
    public Boleta obtener(int id){
        return this.boletaDAO.buscar(id);
    }
}
