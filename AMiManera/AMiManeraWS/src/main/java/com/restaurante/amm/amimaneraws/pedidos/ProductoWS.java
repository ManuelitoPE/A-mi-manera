package com.restaurante.amm.amimaneraws.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IProductoBO;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.ProductoBOImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "ProductoWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class ProductoWS {
        private final IProductoBO productoBO;
    
    public ProductoWS(){
        this.productoBO = new ProductoBOImpl();
    }
    
    @WebMethod(operationName = "guardarProducto")
    public void guardarProducto(@WebParam(name = "producto") Producto producto,
            @WebParam(name = "estado") Estado estado){
        this.productoBO.guardar(producto, estado);
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
