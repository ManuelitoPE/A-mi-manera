
package com.restaurante.amm.amimanerapersistencia.test.dao;

import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.dao.ILineaPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.LineaPedidoDAOImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class LineaPedidoDAOTest implements ICrudDAOTest{
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        LineaPedido lineaPedido = new LineaPedido();
        
        lineaPedido.setCantidadProducto(10);
        
        Producto producto = new Producto();
        producto.setIdProducto(1);
        lineaPedido.setProducto(producto);
        
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1);
        lineaPedido.setPedido(pedido);

        this.testId = lineaPedidoDao.insertar(lineaPedido);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        LineaPedido lineaPedido = new LineaPedido();

        lineaPedido.setIdLineaPedido(this.testId);
        lineaPedido.setCantidadProducto(99);
        
        Producto producto = new Producto();
        producto.setIdProducto(2);
        lineaPedido.setProducto(producto);
        
        Pedido pedido = new Pedido();
        pedido.setIdPedido(2);
        lineaPedido.setPedido(pedido);
        
        boolean modifico = lineaPedidoDao.modificar(lineaPedido);
        assertTrue(modifico);
        
        LineaPedido lineaPedidoModificado = lineaPedidoDao.buscar(this.testId);
        assertEquals(lineaPedidoModificado.getCantidadProducto(), 99);
        assertEquals(lineaPedidoModificado.getProducto().getIdProducto(), 2);
        assertEquals(lineaPedidoModificado.getPedido().getIdPedido(), 2);
        
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        LineaPedido lineaPedido = new LineaPedido();

        lineaPedido.setIdLineaPedido(this.idIncorrecto);
        lineaPedido.setCantidadProducto(99);
        
        Producto producto = new Producto();
        producto.setIdProducto(2);
        lineaPedido.setProducto(producto);
        
        Pedido pedido = new Pedido();
        pedido.setIdPedido(2);
        lineaPedido.setPedido(pedido);
        
        boolean modifico = lineaPedidoDao.modificar(lineaPedido);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        boolean elimino = lineaPedidoDao.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        LineaPedido lineaPedido = lineaPedidoDao.buscar(this.testId);
        assertNotNull(lineaPedido);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        LineaPedido lineaPedido = lineaPedidoDao.buscar(this.idIncorrecto);
        assertNull(lineaPedido);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        List<LineaPedido> lineaPedidos = lineaPedidoDao.listar();
        
        assertNotNull(lineaPedidos);
        assertFalse(lineaPedidos.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        ILineaPedidoDAO lineaPedidoDao = new LineaPedidoDAOImpl();
        boolean elimino = lineaPedidoDao.eliminar(this.testId);
        assertTrue(elimino);
    }        
}
