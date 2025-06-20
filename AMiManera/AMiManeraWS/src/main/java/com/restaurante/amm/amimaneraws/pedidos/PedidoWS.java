package com.restaurante.amm.amimaneraws.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IPedidoBO;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.PedidoBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "PedidoWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class PedidoWS {

    private final IPedidoBO pedidoBO;
    
    public PedidoWS(){
        this.pedidoBO = new PedidoBOImpl();
    }
    
    @WebMethod(operationName = "guardarPedido")
    public void guardarPedido(@WebParam(name = "pedido") Pedido pedido,
            @WebParam(name = "estado") Estado estado){
        this.pedidoBO.guardar(pedido, estado);
    }
    
    @WebMethod(operationName = "buscarPedidoPorId")
    public Pedido buscarPedidoPorId(@WebParam(name = "id")int id){
        try {
            return this.pedidoBO.obtener(id);
        } catch (Exception e) {
            throw new WebServiceException("Error al buscar el pedido: "+e.getMessage());
        }
    }
    
    @WebMethod(operationName = "eliminarPedido")
    public void eliminarPedido(@WebParam(name = "id")int id){
        this.pedidoBO.eliminar(id);
    }   
    
    @WebMethod(operationName = "listarPedidos")
    public List<Pedido> listarPedidos(){
        try {
            return this.pedidoBO.listar();
        } catch (Exception e) {
            throw new WebServiceException("Error al listar pedidos: "+e.getMessage());
        }
    }
    
    @WebMethod(operationName = "listarPedidosPorMesa")
    public List<Pedido> listarPedidosPorMesa(@WebParam(name = "idMesa") int id){
        try {
            return this.pedidoBO.listarPedidosPorMesa(id);
        } catch (Exception e) {
            throw new WebServiceException("Error al listar pedido de la mesa "
                    +id+" : "+e.getMessage());
        }
    }
    
    @WebMethod(operationName = "listarPedidosPorEstado")
    public List<Pedido> listarPedidosPorEstado(@WebParam(name = "estado") EstadoPedido estado){
        try {
            return this.pedidoBO.listarPedidosPorEstado(estado);
        } catch (Exception e) {
            throw new WebServiceException("Error al listar pedido de la mesa "
                    +estado.toString()+" : "+e.getMessage());
        }
    }
}