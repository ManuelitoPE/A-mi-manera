
package com.restaurante.amm.amimaneratest.pagos;

import com.restaurante.amm.amimaneramodel.pagos.Boleta;
import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.dao.pagos.IDetalleBoletaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pagos.DetalleBoletaDAOImpl;
import com.restaurante.amm.amimaneratest.ICrudDAOTest;
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

public class DetalleBoletaDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        
        DetalleBoleta detalleBoleta = new DetalleBoleta();
        
        detalleBoleta.setCantidadProducto(1);
        detalleBoleta.setPrecioUnitario(99.99);
        detalleBoleta.setSubTotal(99.99);
        
        Producto productoTest = new Producto();
        productoTest.setIdProducto(1);
        detalleBoleta.setProducto(productoTest);
        
        Boleta boletaTest = new Boleta();
        boletaTest.setIdComprobantePago(1);
        detalleBoleta.setBoleta(boletaTest);
                
        this.testId = detalleBoletaDAO.insertar(detalleBoleta);

        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        
        DetalleBoleta detalleBoleta = new DetalleBoleta();
        
        detalleBoleta.setIdDetalleBoleta(this.testId);
        detalleBoleta.setCantidadProducto(2);
        detalleBoleta.setPrecioUnitario(10.00);
        detalleBoleta.setSubTotal(20.00);
        
        Producto productoTest = new Producto();
        productoTest.setIdProducto(2);
        detalleBoleta.setProducto(productoTest);
        
        Boleta boletaTest = new Boleta();
        boletaTest.setIdComprobantePago(2);
        detalleBoleta.setBoleta(boletaTest);
        
        boolean modifico = detalleBoletaDAO.modificar(detalleBoleta);
        assertTrue(modifico);
        
        DetalleBoleta detalleBoletaModificada = detalleBoletaDAO.buscar(this.testId);
        assertEquals(detalleBoletaModificada.getCantidadProducto(), 2);
        assertEquals(detalleBoletaModificada.getPrecioUnitario(), 10.00);
        assertEquals(detalleBoletaModificada.getSubTotal(), 20.00);
        assertEquals(detalleBoletaModificada.getProducto().getIdProducto(), 2);
        assertEquals(detalleBoletaModificada.getBoleta().getIdComprobantePago(),2);
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        
        DetalleBoleta detalleBoleta = new DetalleBoleta();
        
        detalleBoleta.setIdDetalleBoleta(this.idIncorrecto);
        detalleBoleta.setCantidadProducto(2);
        detalleBoleta.setPrecioUnitario(10.00);
        detalleBoleta.setSubTotal(20.00);
        
        Producto productoTest = new Producto();
        productoTest.setIdProducto(2);
        detalleBoleta.setProducto(productoTest);
        
        Boleta boletaTest = new Boleta();
        boletaTest.setIdComprobantePago(2);
        detalleBoleta.setBoleta(boletaTest);
        
        
        boolean modifico = detalleBoletaDAO.modificar(detalleBoleta);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        boolean elimino = detalleBoletaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        DetalleBoleta detalleBoleta = detalleBoletaDAO.buscar(this.testId);
        assertNotNull(detalleBoleta);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        DetalleBoleta detalleBoleta = detalleBoletaDAO.buscar(this.idIncorrecto);
        assertNull(detalleBoleta);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        List<DetalleBoleta> detallesBoleta = detalleBoletaDAO.listar();
        
        assertNotNull(detallesBoleta);
        assertFalse(detallesBoleta.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IDetalleBoletaDAO detalleBoletaDAO = new DetalleBoletaDAOImpl();
        boolean elimino = detalleBoletaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
