package com.restaurante.amm.amimaneraws.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IProductoBO;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.ProductoBOImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "ProductoWS")
public class ProductoWS {
        private final IProductoBO productoBO;
    
    public ProductoWS(){
        this.productoBO = new ProductoBOImpl();
    }
    
    @WebMethod(operationName = "listarProductos")
    public List<Producto> listarProductos(){
        try {
            return this.productoBO.listar();
        } catch (Exception e) {
            throw new WebServiceException("Error al listar prodcutos: "+e.getMessage());
        }
    }
    
}
