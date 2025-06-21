package com.restaurante.amm.amimaneraws.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.TipoProducto;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.ITipoProductoBO;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.TipoProductoBOImpl;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.ITipoProductoDAO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "TipoProductoWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class TipoProductoWS {
    private final ITipoProductoBO tipoProductoBO;
    
    public TipoProductoWS(){
        this.tipoProductoBO = new TipoProductoBOImpl();
    }
    
    @WebMethod(operationName = "listarTipoProductos")
    public List<TipoProducto> listarTipoProductos(){
        try {
            return this.tipoProductoBO.listar();
        } catch (Exception e) {
            throw new WebServiceException("Error al listar prodcutos: "+e.getMessage());
        }
    }
}
