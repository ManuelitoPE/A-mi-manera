package com.restaurante.amm.amimanerapersistencia.test.dao;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;

import com.restaurante.amm.amimanerapersistencia.dao.IProductoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.ProductoDAOImpl;
import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneramodel.pedidos.TipoProducto;
import com.restaurante.amm.amimanerapersistencia.daoimpl.TipoProductoDAOImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ProductoDAOTest implements ICrudDAOTest{
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        Producto producto = new Producto();
        
        producto.setNombre("Producto de Prueba");
        producto.setDescripcion("Descripción de prueba");
        producto.setPrecioUnitario(19.99);
        
        TipoProducto tipoProductoTest = new TipoProducto();
        tipoProductoTest.setIdTipoProducto(1);
        producto.setTipoProducto(tipoProductoTest);
        
        this.testId = productoDao.insertar(producto);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        
        Producto producto = new Producto();
        
        producto.setIdProducto(this.testId);
        producto.setNombre("Producto Modificado");
        producto.setDescripcion("Descripción modificada");
        producto.setPrecioUnitario(29.99);
        
        TipoProducto tipoProductoTest = new TipoProducto();
        tipoProductoTest.setIdTipoProducto(2);
        producto.setTipoProducto(tipoProductoTest);
        
        boolean modifico = productoDao.modificar(producto);
        assertTrue(modifico);
        
        Producto productoModificado = productoDao.buscar(this.testId);
        assertEquals(productoModificado.getNombre(), "Producto Modificado");
        assertEquals(productoModificado.getDescripcion(), "Descripción modificada");
        assertEquals(productoModificado.getPrecioUnitario(), 29.99);
        assertEquals(productoModificado.getTipoProducto().getIdTipoProducto(), 2);

    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        Producto producto = new Producto();
        producto.setIdProducto(this.idIncorrecto);
        producto.setNombre("Producto Modificado");
        producto.setDescripcion("Descripción modificada");
        producto.setPrecioUnitario(29.99);
        
        TipoProducto tipoProductoTest = new TipoProducto();
        tipoProductoTest.setIdTipoProducto(2);
        producto.setTipoProducto(tipoProductoTest);
        
        boolean modifico = productoDao.modificar(producto);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        boolean elimino = productoDao.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        Producto producto = productoDao.buscar(this.testId);
        assertNotNull(producto);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        Producto producto = productoDao.buscar(this.idIncorrecto);
        assertNull(producto);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        List<Producto> productos = productoDao.listar();
        
        assertNotNull(productos);
        assertFalse(productos.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IProductoDAO productoDao = new ProductoDAOImpl();
        boolean elimino = productoDao.eliminar(this.testId);
        assertTrue(elimino);
    }    
}