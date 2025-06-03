/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IPedidoBO;
import com.restaurante.amm.amimanerapersistencia.dao.ILineaPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.dao.IPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.LineaPedidoDAOImpl;
import com.restaurante.amm.amimanerapersistencia.daoimpl.PedidoDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class PedidoBOImpl implements IPedidoBO{

    private final IPedidoDAO pedidoDAO;
    private final ILineaPedidoDAO lineaPedidoDAO;
    
    public PedidoBOImpl(){
        this.pedidoDAO = new PedidoDAOImpl();
        this.lineaPedidoDAO = new LineaPedidoDAOImpl();
    }
    
    @Override
    public List<Pedido> listar() {
        return this.pedidoDAO.listar();
    }

    @Override
    public Pedido obtener(int id) {
        return this.pedidoDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.pedidoDAO.eliminar(id);
    }

    @Override
    public void guardar(Pedido modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.pedidoDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.pedidoDAO.modificar(modelo);
    }
     
    @Override
    public List<Pedido> listarPedidoPorMesa(int idMesa){
        return pedidoDAO.listarPorMesa(idMesa);
    }
}
