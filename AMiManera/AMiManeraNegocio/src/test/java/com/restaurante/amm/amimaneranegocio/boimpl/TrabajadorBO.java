/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.personal.Trabajador;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.ITrabajadorBO;
import com.restaurante.amm.amimanerapersistencia.dao.ITrabajadorDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.TrabajadorDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class TrabajadorBO implements ITrabajadorBO{

    private final ITrabajadorDAO trabajadorDAO;
    
    public TrabajadorBO(){
        this.trabajadorDAO = new TrabajadorDAOImpl();
    }
    
    @Override
    public List<Trabajador> listar() {
        return this.trabajadorDAO.listar();
    }

    @Override
    public Trabajador obtener(int id) {
        return this.trabajadorDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.trabajadorDAO.eliminar(id);
    }

    @Override
    public void guardar(Trabajador modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.trabajadorDAO.insertar(modelo);
        else if(estado == Estado.MODIFICAR) this.trabajadorDAO.modificar(modelo);
    }
    
}
