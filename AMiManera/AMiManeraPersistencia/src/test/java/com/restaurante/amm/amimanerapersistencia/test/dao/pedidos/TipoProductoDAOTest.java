package com.restaurante.amm.amimanerapersistencia.test.dao.pedidos;

import com.restaurante.amm.amimanerapersistencia.dao.pedidos.ITipoProductoDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pedidos.TipoProductoDAOImpl;
import com.restaurante.amm.amimaneramodel.pedidos.TipoProducto;
import com.restaurante.amm.amimanerapersistencia.test.dao.ICrudDAOTest;

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
public class TipoProductoDAOTest implements ICrudDAOTest{
    private int testId;
    private final int idIncorrecto = 99999;

    @Test
    @Order(1)
    @Override
    public void debeInsertar(){
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setDescripcion("Tipo de Plato de Prueba");
        
        this.testId = tipoProductoDao.insertar(tipoProducto);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste(){
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        TipoProducto tipoProducto = new TipoProducto();   
        
        tipoProducto.setIdTipoProducto(this.testId);
        tipoProducto.setDescripcion("Tipo de Producto Modificado");
        
        boolean modifico = tipoProductoDao.modificar(tipoProducto);
        assertTrue(modifico);
        TipoProducto tipoProductoModificado = tipoProductoDao.buscar(this.testId);
        assertEquals(tipoProductoModificado.getDescripcion(),"Tipo de Producto Modificado");
    }  
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste(){
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        TipoProducto tipoProducto = new TipoProducto();
        
        tipoProducto.setIdTipoProducto(this.idIncorrecto);
        tipoProducto.setDescripcion("Tipo de Producto Modificado");
        
        boolean modifico = tipoProductoDao.modificar(tipoProducto);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        boolean elimino = tipoProductoDao.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        TipoProducto tipoProducto = tipoProductoDao.buscar(this.testId);
        assertNotNull(tipoProducto);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        TipoProducto tipoProducto = tipoProductoDao.buscar(this.idIncorrecto);
        assertNull(tipoProducto);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        List<TipoProducto> tipoProductos = tipoProductoDao.listar();
        
        assertNotNull(tipoProductos);
        assertFalse(tipoProductos.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        ITipoProductoDAO tipoProductoDao = new TipoProductoDAOImpl();
        boolean elimino = tipoProductoDao.eliminar(this.testId);
        assertTrue(elimino);
    }    
}
