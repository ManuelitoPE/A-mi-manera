
package com.restaurante.amm.amimaneraws.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.ILineaPedidoBO;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.LineaPedidoBOImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "LineaPedidoWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class LineaPedidoWS {
    private final ILineaPedidoBO lineaPedidoBO;
    
    public LineaPedidoWS(){
        lineaPedidoBO = new LineaPedidoBOImpl();
    }
    
    @WebMethod(operationName = "listarLineaPedidoPorIdPedido")
    public List<LineaPedido> listarLineaPedidoPorIdPedido(@WebParam(name = "idPedido")int idPedido){
        try {
            return this.lineaPedidoBO.listarPorIdPedido(idPedido);
        } catch (Exception e) {
            throw new WebServiceException("Error al listar pedidos: "+e.getMessage());
        }
    }
    
}
