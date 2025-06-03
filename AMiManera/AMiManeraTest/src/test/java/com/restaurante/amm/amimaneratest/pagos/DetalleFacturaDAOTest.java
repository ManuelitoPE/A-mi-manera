
package com.restaurante.amm.amimaneratest.pagos;

import com.restaurante.amm.amimaneramodel.pagos.Factura;
import com.restaurante.amm.amimaneramodel.pagos.DetalleFactura;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.dao.pagos.IDetalleFacturaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pagos.DetalleFacturaDAOImpl;
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

public class DetalleFacturaDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        DetalleFactura detalleFactura = new DetalleFactura();
        
        detalleFactura.setCantidadProducto(1);
        detalleFactura.setPrecioUnitario(99.99);
        detalleFactura.setSubTotal(99.99);
        
        Producto productoTest = new Producto();
        productoTest.setIdProducto(1);
        detalleFactura.setProducto(productoTest);
        
        Factura facturaTest = new Factura();
        facturaTest.setIdComprobantePago(1);
        detalleFactura.setFactura(facturaTest);
                
        this.testId = detalleFacturaDAO.insertar(detalleFactura);

        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        
        DetalleFactura detalleFactura = new DetalleFactura();
        
        detalleFactura.setIdDetalleFactura(this.testId);
        detalleFactura.setCantidadProducto(2);
        detalleFactura.setPrecioUnitario(10.00);
        detalleFactura.setSubTotal(20.00);
        
        Producto productoTest = new Producto();
        productoTest.setIdProducto(2);
        detalleFactura.setProducto(productoTest);
        
        Factura facturaTest = new Factura();
        facturaTest.setIdComprobantePago(2);
        detalleFactura.setFactura(facturaTest);
        
        boolean modifico = detalleFacturaDAO.modificar(detalleFactura);
        assertTrue(modifico);
        
        DetalleFactura detalleFacturaModificada = detalleFacturaDAO.buscar(this.testId);
        assertEquals(detalleFacturaModificada.getCantidadProducto(), 2);
        assertEquals(detalleFacturaModificada.getPrecioUnitario(), 10.00);
        assertEquals(detalleFacturaModificada.getSubTotal(), 20.00);
        assertEquals(detalleFacturaModificada.getProducto().getIdProducto(), 2);
        assertEquals(detalleFacturaModificada.getFactura().getIdComprobantePago(),2);
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        
        DetalleFactura detalleFactura = new DetalleFactura();
        
        detalleFactura.setIdDetalleFactura(this.idIncorrecto);
        detalleFactura.setCantidadProducto(2);
        detalleFactura.setPrecioUnitario(10.00);
        detalleFactura.setSubTotal(20.00);
        
        Producto productoTest = new Producto();
        productoTest.setIdProducto(2);
        detalleFactura.setProducto(productoTest);
        
        Factura facturaTest = new Factura();
        facturaTest.setIdComprobantePago(2);
        detalleFactura.setFactura(facturaTest);
        
        
        boolean modifico = detalleFacturaDAO.modificar(detalleFactura);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        boolean elimino = detalleFacturaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        DetalleFactura detalleFactura = detalleFacturaDAO.buscar(this.testId);
        assertNotNull(detalleFactura);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        DetalleFactura detalleFactura = detalleFacturaDAO.buscar(this.idIncorrecto);
        assertNull(detalleFactura);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        List<DetalleFactura> detallesFactura = detalleFacturaDAO.listar();
        
        assertNotNull(detallesFactura);
        assertFalse(detallesFactura.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
        boolean elimino = detalleFacturaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
