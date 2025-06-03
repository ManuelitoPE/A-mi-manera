package com.restaurante.amm.amimaneratest.gestionmesas;

import com.restaurante.amm.amimaneramodel.gestionmesas.EstadoMesa;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IMesaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas.MesaDAOImpl;
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
public class MesaDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        
        Mesa mesa = new Mesa();
        
        mesa.setCantidadAsientos(1);
        mesa.setEstado(EstadoMesa.LIBRE);
               
        this.testId = mesaDAO.insertar(mesa);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        
        Mesa mesa = new Mesa();
        
        mesa.setIdMesa(this.testId);
        mesa.setCantidadAsientos(2);
        mesa.setEstado(EstadoMesa.OCUPADA);
        
        boolean modifico = mesaDAO.modificar(mesa);
        assertTrue(modifico);
        
        Mesa mesaModificada = mesaDAO.buscar(this.testId);
        assertEquals(mesaModificada.getCantidadAsientos(), 2);
        assertEquals(mesaModificada.getEstado(), EstadoMesa.OCUPADA);
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        
        Mesa mesa = new Mesa();
        
        mesa.setIdMesa(this.idIncorrecto);
        mesa.setCantidadAsientos(2);
        mesa.setEstado(EstadoMesa.OCUPADA);
        
        boolean modifico = mesaDAO.modificar(mesa);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        boolean elimino = mesaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        Mesa mesa = mesaDAO.buscar(this.testId);
        assertNotNull(mesa);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        Mesa mesa = mesaDAO.buscar(this.idIncorrecto);
        assertNull(mesa);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        List<Mesa> mesas = mesaDAO.listar();
        
        assertNotNull(mesas);
        assertFalse(mesas.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IMesaDAO mesaDAO = new MesaDAOImpl();
        boolean elimino = mesaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
