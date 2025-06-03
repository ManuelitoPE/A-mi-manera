package com.restaurante.amm.amimaneranegocio.boimpl.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.TipoProducto;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.ITipoProductoBO;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.ITipoProductoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.TipoProductoDAOImpl;
import java.util.List;

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
