/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.pedidos.TipoProducto;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.ITipoProductoBO;
import com.restaurante.amm.amimanerapersistencia.dao.ITipoProductoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.TipoProductoDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class TipoProductoBOImpl implements ITipoProductoBO{

    private final ITipoProductoDAO tipoProductoDAO;
    
    public TipoProductoBOImpl(){
        this.tipoProductoDAO = new TipoProductoDAOImpl();
    }
    
    @Override
    public List<TipoProducto> listar() {
        return this.tipoProductoDAO.listar();
    }

    @Override
    public TipoProducto obtener(int id) {
        return this.tipoProductoDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.tipoProductoDAO.eliminar(id);
    }

    @Override
    public void guardar(TipoProducto modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.tipoProductoDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.tipoProductoDAO.modificar(modelo);
    }
    
}
