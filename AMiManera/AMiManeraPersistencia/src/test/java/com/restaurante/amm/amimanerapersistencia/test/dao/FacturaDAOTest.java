
package com.restaurante.amm.amimanerapersistencia.test.dao;

import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneramodel.pagos.Factura;
import com.restaurante.amm.amimaneramodel.pagos.MetodoPago;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimanerapersistencia.dao.IFacturaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.FacturaDAOImpl;
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

public class FacturaDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        
        Factura factura = new Factura();
        
        factura.setFechaEmision(new Date());
        factura.setMetodoPago(MetodoPago.EFECTIVO);
        factura.setMontoTotal(99.99);
        factura.setMontoPropina(99.99);
        factura.setMontoSinIGV(99.99);
        factura.setMontoIGV(99.99);
        factura.setRUC("10103131319");
        factura.setRazonSocial("Explorandes");

        Pedido pedidoTest = new Pedido();
        pedidoTest.setIdPedido(1);
        factura.setPedido(pedidoTest);
        
        Reserva reservaTest = new Reserva();
        reservaTest.setIdReserva(1);
        factura.setReserva(reservaTest);
        
        this.testId = facturaDAO.insertar(factura);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        
        Factura factura = new Factura();
        
        factura.setIdComprobantePago(this.testId);
        factura.setFechaEmision(new Date());
        factura.setMetodoPago(MetodoPago.TARJETA);
        factura.setMontoTotal(11.11);
        factura.setMontoPropina(11.11);
        factura.setMontoSinIGV(11.11);
        factura.setMontoIGV(11.11);
        factura.setRUC("10103131318");
        factura.setRazonSocial("Montage Lodge");
        
        Pedido pedidoTest = new Pedido();
        pedidoTest.setIdPedido(1);
        factura.setPedido(pedidoTest);
        
        Reserva reservaTest = new Reserva();
        reservaTest.setIdReserva(1);
        factura.setReserva(reservaTest);
        
                
        boolean modifico = facturaDAO.modificar(factura);
        assertTrue(modifico);
        
        Factura facturaModificada = facturaDAO.buscar(this.testId);
        assertEquals(facturaModificada.getMetodoPago(), MetodoPago.TARJETA);
        assertEquals(facturaModificada.getMontoTotal(), 11.11);
        assertEquals(facturaModificada.getMontoPropina(), 11.11);
        assertEquals(facturaModificada.getMontoSinIGV(), 11.11);
        assertEquals(facturaModificada.getMontoIGV(), 11.11);
        assertEquals(facturaModificada.getRUC(), "10103131318");
        assertEquals(facturaModificada.getRazonSocial(), "Montage Lodge");
    
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        
        Factura factura = new Factura();
        
        factura.setIdComprobantePago(this.idIncorrecto);
        factura.setFechaEmision(new Date());
        factura.setMetodoPago(MetodoPago.TARJETA);
        factura.setMontoTotal(11.11);
        factura.setMontoPropina(11.11);
        factura.setMontoSinIGV(11.11);
        factura.setMontoIGV(11.11);
        factura.setRUC("10103131318");
        factura.setRazonSocial("Montage Lodge");
        
        Pedido pedidoTest = new Pedido();
        pedidoTest.setIdPedido(1);
        factura.setPedido(pedidoTest);
        
        Reserva reservaTest = new Reserva();
        reservaTest.setIdReserva(1);
        factura.setReserva(reservaTest);
        
        boolean modifico = facturaDAO.modificar(factura);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        boolean elimino = facturaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        Factura factura = facturaDAO.buscar(this.testId);
        assertNotNull(factura);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        Factura factura = facturaDAO.buscar(this.idIncorrecto);
        assertNull(factura);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        List<Factura> facturas = facturaDAO.listar();
        
        assertNotNull(facturas);
        assertFalse(facturas.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IFacturaDAO facturaDAO = new FacturaDAOImpl();
        boolean elimino = facturaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
