
package com.restaurante.amm.amimanerapersistencia.test.dao.clientes;

import com.restaurante.amm.amimaneramodel.clientes.PersonaNatural;
import com.restaurante.amm.amimanerapersistencia.dao.clientes.IPersonaNaturalDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.clientes.PersonaNaturalDAOImpl;
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
public class PersonaNaturalDAOTest implements ICrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        
        PersonaNatural personaNatural = new PersonaNatural();
        
        personaNatural.setNombre("Nombre de Prueba");
        personaNatural.setTelefono(9999999);
        personaNatural.setCorreo("Correo de Prueba");
        personaNatural.setDNI("11111111");
               
        this.testId = personaNaturalDAO.insertar(personaNatural);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        
        PersonaNatural personaNatural = new PersonaNatural();
        
        personaNatural.setIdCliente(this.testId);
        personaNatural.setNombre("Nombre Modificado");
        personaNatural.setTelefono(1111111);
        personaNatural.setCorreo("Correo Modificado");
        personaNatural.setDNI("99999999");
        
        boolean modifico = personaNaturalDAO.modificar(personaNatural);
        assertTrue(modifico);
        
        PersonaNatural personaNaturalModificada = personaNaturalDAO.buscar(this.testId);
        assertEquals(personaNaturalModificada.getNombre(), "Nombre Modificado");
        assertEquals(personaNaturalModificada.getTelefono(), 1111111);
        assertEquals(personaNaturalModificada.getCorreo(), "Correo Modificado");
        assertEquals(personaNaturalModificada.getDNI(), "99999999");
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        
        PersonaNatural personaNatural = new PersonaNatural();
        
        personaNatural.setIdCliente(this.idIncorrecto);
        personaNatural.setNombre("Nombre Modificado");
        personaNatural.setTelefono(1111111);
        personaNatural.setCorreo("Correo Modificado");
        personaNatural.setDNI("99999999");
        
        boolean modifico = personaNaturalDAO.modificar(personaNatural);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        boolean elimino = personaNaturalDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        PersonaNatural personaNatural = personaNaturalDAO.buscar(this.testId);
        assertNotNull(personaNatural);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        PersonaNatural personaNatural = personaNaturalDAO.buscar(this.idIncorrecto);
        assertNull(personaNatural);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        List<PersonaNatural> personasNaturales = personaNaturalDAO.listar();
        
        assertNotNull(personasNaturales);
        assertFalse(personasNaturales.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IPersonaNaturalDAO personaNaturalDAO = new PersonaNaturalDAOImpl();
        boolean elimino = personaNaturalDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
