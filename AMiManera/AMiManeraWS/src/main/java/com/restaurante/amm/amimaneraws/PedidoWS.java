/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.restaurante.amm.amimaneraws;

import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IPedidoBO;
import com.restaurante.amm.amimaneranegocio.boimpl.PedidoBOImpl;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "PedidoWS")
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
    public void buscarPedidoPorId(@WebParam(name = "id")int id){
        this.pedidoBO.obtener(id);
    }
    
    @WebMethod(operationName = "eliminarPedido")
    public void eliminarPedido(@WebParam(name = "id")int id){
        this.pedidoBO.eliminar(id);
    }   
    
    @WebMethod(operationName = "listarPedidosPorMesa")
    public void listarPedidosPorMesa(@WebParam(name = "idMesa") int id){
        this.pedidoBO.listarPedidoPorMesa(id);
    }
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
}
