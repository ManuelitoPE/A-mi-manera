package com.restaurante.amm.amimaneranegocio.boimpl.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IPedidoBO;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.IPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.PedidoDAOImpl;
import java.util.List;

public class PedidoBOImpl implements IPedidoBO{

    private final IPedidoDAO pedidoDAO;
    
    public PedidoBOImpl(){
        this.pedidoDAO = new PedidoDAOImpl();
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
    public int crear(Pedido modelo){
        return this.pedidoDAO.insertar(modelo);
    }
    
    @Override
    public List<Pedido> listarPedidosPorMesa(int idMesa) {
        return pedidoDAO.listarPorMesa(idMesa);
    }
    
    @Override
    public List<Pedido> listarPedidosPorEstado(EstadoPedido estado) {
        return pedidoDAO.listarPorEstado(estado);
    }
}
