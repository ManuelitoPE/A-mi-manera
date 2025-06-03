package com.restaurante.amm.amimaneranegocio.boimpl.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IProductoBO;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.IProductoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.ProductoDAOImpl;
import java.util.List;

public class ProductoBOImpl implements IProductoBO{

    private final IProductoDAO productoDAO;
    
    public ProductoBOImpl(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    @Override
    public List<Producto> listar() {
        return this.productoDAO.listar();
    }

    @Override
    public Producto obtener(int id) {
        return this.productoDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.productoDAO.eliminar(id);
    }

    @Override
    public void guardar(Producto modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.productoDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.productoDAO.modificar(modelo);
    }
    
}
