
package com.restaurante.amm.amimanerapersistencia.test.dao;

import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.pagos.Boleta;
import com.restaurante.amm.amimaneramodel.pagos.MetodoPago;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimanerapersistencia.dao.IBoletaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.BoletaDAOImpl;
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

public class BoletaDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        
        Boleta boleta = new Boleta();
        
        boleta.setFechaEmision(new Date());
        boleta.setMetodoPago(MetodoPago.EFECTIVO);
        boleta.setMontoTotal(99.99);
        boleta.setMontoPropina(99.99);
        boleta.setMontoSinIGV(99.99);
        boleta.setMontoIGV(99.99);
        
        Pedido pedidoTest = new Pedido();
        pedidoTest.setIdPedido(1);
        boleta.setPedido(pedidoTest);
        
        Reserva reservaTest = new Reserva();
        reservaTest.setIdReserva(1);
        boleta.setReserva(reservaTest);
        
        this.testId = boletaDAO.insertar(boleta);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        
        Boleta boleta = new Boleta();
        
        boleta.setIdComprobantePago(this.testId);
        boleta.setFechaEmision(new Date());
        boleta.setMetodoPago(MetodoPago.TARJETA);
        boleta.setMontoTotal(11.11);
        boleta.setMontoPropina(11.11);
        boleta.setMontoSinIGV(11.11);
        boleta.setMontoIGV(11.11);
        
        Pedido pedidoTest = new Pedido();
        pedidoTest.setIdPedido(2);
        boleta.setPedido(pedidoTest);
        
        Reserva reservaTest = new Reserva();
        reservaTest.setIdReserva(2);
        boleta.setReserva(reservaTest);
        
                
        boolean modifico = boletaDAO.modificar(boleta);
        assertTrue(modifico);
        
        Boleta boletaModificada = boletaDAO.buscar(this.testId);
        assertEquals(boletaModificada.getMetodoPago(), MetodoPago.TARJETA);
        assertEquals(boletaModificada.getMontoTotal(), 11.11);
        assertEquals(boletaModificada.getMontoPropina(), 11.11);
        assertEquals(boletaModificada.getMontoSinIGV(), 11.11);
        assertEquals(boletaModificada.getMontoIGV(), 11.11);
        assertEquals(boletaModificada.getPedido().getIdPedido(), 2);
//        assertEquals(boletaModificada.getReserva().getIdReserva(), 2);
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        
        Boleta boleta = new Boleta();
        
        boleta.setIdComprobantePago(this.idIncorrecto);
        boleta.setFechaEmision(new Date());
        boleta.setMetodoPago(MetodoPago.TARJETA);
        boleta.setMontoTotal(11.11);
        boleta.setMontoPropina(11.11);
        boleta.setMontoSinIGV(11.11);
        boleta.setMontoIGV(11.11);
        
        Pedido pedidoTest = new Pedido();
        pedidoTest.setIdPedido(2);
        boleta.setPedido(pedidoTest);
        
        Reserva reservaTest = new Reserva();
        reservaTest.setIdReserva(2);
        boleta.setReserva(reservaTest);
        
        boolean modifico = boletaDAO.modificar(boleta);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        boolean elimino = boletaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        Boleta boleta = boletaDAO.buscar(this.testId);
        assertNotNull(boleta);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        Boleta boleta = boletaDAO.buscar(this.idIncorrecto);
        assertNull(boleta);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        List<Boleta> boletas = boletaDAO.listar();
        
        assertNotNull(boletas);
        assertFalse(boletas.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IBoletaDAO boletaDAO = new BoletaDAOImpl();
        boolean elimino = boletaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
