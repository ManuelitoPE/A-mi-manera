/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IMesaBO;
import com.restaurante.amm.amimanerapersistencia.dao.IMesaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.MesaDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class MesaBOImpl implements IMesaBO{
    
    private final IMesaDAO mesaDAO;
    
    public MesaBOImpl(){
        this.mesaDAO = new MesaDAOImpl();
    }
    
    @Override
    public List<Mesa> listar() {
        return this.mesaDAO.listar();
    }

    @Override
    public Mesa obtener(int id) {
        return this.mesaDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.mesaDAO.eliminar(id);
    }

    @Override
    public void guardar(Mesa modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.mesaDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.mesaDAO.modificar(modelo);
    }
    
}
