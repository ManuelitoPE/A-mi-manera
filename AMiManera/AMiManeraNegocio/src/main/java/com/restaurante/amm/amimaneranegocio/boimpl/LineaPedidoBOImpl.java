/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.ILineaPedidoBO;
import com.restaurante.amm.amimanerapersistencia.dao.ILineaPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.LineaPedidoDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class LineaPedidoBOImpl implements ILineaPedidoBO{
    private final ILineaPedidoDAO lineaPedidoDAO;
    
    public LineaPedidoBOImpl(){
        this.lineaPedidoDAO = new LineaPedidoDAOImpl();
    }
    
    @Override
    public void guardar(LineaPedido lineaPedido,Estado estado){
        if(estado == Estado.NUEVO) this.lineaPedidoDAO.insertar(lineaPedido);
        else if(estado == Estado.MODIFICAR) this.lineaPedidoDAO.modificar(lineaPedido);
    }
    
    @Override
    public void eliminar(int id){
        this.lineaPedidoDAO.eliminar(id);
    }
    
    @Override
    public LineaPedido obtener(int id){
        return this.lineaPedidoDAO.buscar(id);
    }
    
    @Override
    public List<LineaPedido> listar(){
        return this.lineaPedidoDAO.listar();
    }
}
