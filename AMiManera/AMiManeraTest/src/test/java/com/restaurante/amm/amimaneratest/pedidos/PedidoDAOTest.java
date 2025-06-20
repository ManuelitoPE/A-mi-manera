
package com.restaurante.amm.amimaneratest.pedidos;
import com.restaurante.amm.amimanerapersistencia.dao.pedidos.IPedidoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.PedidoDAOImpl;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.personal.Mesero;
import com.restaurante.amm.amimaneratest.ICrudDAOTest;

import java.util.Date;
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

public class PedidoDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        
        Pedido pedido = new Pedido();
        pedido.setFecha(new Date());
        pedido.setEstadoPedido(EstadoPedido.EN_ORDEN);
        pedido.setMontoTotal(100.99);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(1);
        pedido.setMesa(mesa);

        Mesero mesero = new Mesero();
        mesero.setIdTrabajador(1);
<<<<<<< HEAD
        pedido.setMesero(mesero);
=======
        pedido.setTrabajador(mesero);
>>>>>>> main

        this.testId = pedidoDao.insertar(pedido);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        Pedido pedido = new Pedido();
        
        pedido.setIdPedido(this.testId);
        pedido.setFecha(new Date());
        pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
        pedido.setMontoTotal(99.99);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(2);
        pedido.setMesa(mesa);

        Mesero mesero = new Mesero();
        mesero.setIdTrabajador(1);
<<<<<<< HEAD
        pedido.setMesero(mesero);
=======
        pedido.setTrabajador(mesero);
>>>>>>> main
        
        boolean modifico = pedidoDao.modificar(pedido);
        assertTrue(modifico);
        
        Pedido pedidoModificado = pedidoDao.buscar(this.testId);
        assertEquals(pedidoModificado.getEstadoPedido(), EstadoPedido.ENTREGADO);
        assertEquals(pedidoModificado.getMontoTotal(), 99.99);
        assertEquals(pedidoModificado.getMesa().getIdMesa(), 2);
//        assertEquals(pedidoModificado.getMesero().getIdTrabajador(), 1);
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        Pedido pedido = new Pedido();
        pedido.setIdPedido(this.idIncorrecto);
        pedido.setFecha(new Date());
        pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
        pedido.setMontoTotal(99.99);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(2);
        pedido.setMesa(mesa);

        Mesero mesero = new Mesero();
        mesero.setIdTrabajador(2);
<<<<<<< HEAD
        pedido.setMesero(mesero);
=======
        pedido.setTrabajador(mesero);
>>>>>>> main
        
        boolean modifico = pedidoDao.modificar(pedido);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        boolean elimino = pedidoDao.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        Pedido pedido = pedidoDao.buscar(this.testId);
        assertNotNull(pedido);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        Pedido pedido = pedidoDao.buscar(this.idIncorrecto);
        assertNull(pedido);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        List<Pedido> pedidos = pedidoDao.listar();
        
        assertNotNull(pedidos);
        assertFalse(pedidos.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IPedidoDAO pedidoDao = new PedidoDAOImpl();
        boolean elimino = pedidoDao.eliminar(this.testId);
        assertTrue(elimino);
    }    
}

