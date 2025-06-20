package com.restaurante.amm.amimaneraws.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneramodel.personal.Trabajador;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.gestionmesas.IMesaBO;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.ILineaPedidoBO;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IPedidoBO;
import com.restaurante.amm.amimaneranegocio.bo.pedidos.IProductoBO;
import com.restaurante.amm.amimaneranegocio.bo.personal.ITrabajadorBO;
import com.restaurante.amm.amimaneranegocio.boimpl.gestionmesas.MesaBOImpl;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.LineaPedidoBOImpl;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.PedidoBOImpl;
import com.restaurante.amm.amimaneranegocio.boimpl.pedidos.ProductoBOImpl;
import com.restaurante.amm.amimaneranegocio.boimpl.personal.TrabajadorBO;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.WebServiceException;
import java.util.List;

@WebService(serviceName = "PedidoWS",
        targetNamespace = "https://servicios.amimaneraws.amm.restaurante.com")
public class PedidoWS {
    
    private final IPedidoBO pedidoBO;
    private final IProductoBO productoBO;
    private final IMesaBO mesaBO;
    private final ITrabajadorBO trabajadorBO;
    private final ILineaPedidoBO lineaPedidoBO;
    public PedidoWS(){
        this.pedidoBO = new PedidoBOImpl();
        this.productoBO = new ProductoBOImpl();
        this.mesaBO = new MesaBOImpl();
        this.trabajadorBO = new TrabajadorBO();
        this.lineaPedidoBO = new LineaPedidoBOImpl();
    }
    
    @WebMethod(operationName = "crearPedido")
    public int crearPedido(@WebParam(name = "idMesa")int idMesa,
            @WebParam(name = "idMesero")int idMesero){
        Pedido pedido = new Pedido();
        pedido.setMesa(this.mesaBO.obtener(idMesa));
        pedido.setTrabajador(this.trabajadorBO.obtener(idMesero));
        return this.pedidoBO.crear(pedido);
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
    
    @WebMethod(operationName = "agregarProductoAPedido")
    public boolean agregarProductoAPedido(@WebParam(name = "idPedido") int idPedido,
            @WebParam(name = "idProd") int idProd, @WebParam(name = "idTrabajador") int idTrab,
            @WebParam(name = "cant") int cant){
        
        try{
            Pedido pedido = pedidoBO.obtener(idPedido);
            if(pedido == null) return false;
            Producto producto = productoBO.obtener(idProd);
            if(producto == null) return false;
            Trabajador trabajador = trabajadorBO.obtener(idTrab);
            if(trabajador == null) return false;
            LineaPedido linea = new LineaPedido();
            linea.setProducto(producto);
            linea.setCantidadProducto(cant);
            linea.setPedido(pedido);

            pedido.setTrabajador(trabajador);
            double monto = pedido.getMontoTotal() + cant*producto.getPrecioUnitario();
            pedido.setMontoTotal(monto);
            
            pedidoBO.guardar(pedido, Estado.MODIFICAR);
            lineaPedidoBO.guardar(linea, Estado.NUEVO);
            return true;
        } catch (Exception e){
            throw new WebServiceException("Error al agregar un "
                    + "producto "+ idProd +" al pedido "+ idPedido
                    + e.getMessage());
        }
    }    
}