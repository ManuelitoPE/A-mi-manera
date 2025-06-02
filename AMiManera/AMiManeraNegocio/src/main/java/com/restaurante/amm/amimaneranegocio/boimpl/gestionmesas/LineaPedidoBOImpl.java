package com.restaurante.amm.amimaneranegocio.boimpl.gestionmesas;

import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.ILineaPedidoBO;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.ILineaPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.LineaPedidoDAOImpl;
import java.util.List;

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
