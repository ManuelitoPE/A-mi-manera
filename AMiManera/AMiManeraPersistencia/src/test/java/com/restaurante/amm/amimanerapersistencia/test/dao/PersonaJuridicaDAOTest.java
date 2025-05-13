
package com.restaurante.amm.amimanerapersistencia.test.dao;

import com.restaurante.amm.amimaneramodel.clientes.PersonaJuridica;
import com.restaurante.amm.amimanerapersistencia.dao.IPersonaJuridicaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.PersonaJuridicaDAOImpl;
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

public class PersonaJuridicaDAOTest implements CrudDAOTest {
    private int testId;
    private final int idIncorrecto = 99999;
    
    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        
        PersonaJuridica personaJuridica = new PersonaJuridica();
        
        personaJuridica.setNombre("Nombre de Prueba");
        personaJuridica.setTelefono(9999999);
        personaJuridica.setCorreo("Correo de Prueba");
        personaJuridica.setRUC("99999999999");
        personaJuridica.setRazonSocial("Razon Social de Prueba");
               
        this.testId = personaJuridicaDAO.insertar(personaJuridica);
        assertTrue(this.testId > 0);
    }
    
    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        
        PersonaJuridica personaJuridica = new PersonaJuridica();
        
        personaJuridica.setIdCliente(this.testId);
        personaJuridica.setNombre("Nombre Modificado");
        personaJuridica.setTelefono(1111111);
        personaJuridica.setCorreo("Correo Modificado");
        personaJuridica.setRUC("11111111111");
        personaJuridica.setRazonSocial("Razon Social Modificada");
        
        boolean modifico = personaJuridicaDAO.modificar(personaJuridica);
        assertTrue(modifico);
        
        PersonaJuridica personaNaturalModificada = personaJuridicaDAO.buscar(this.testId);
        assertEquals(personaNaturalModificada.getNombre(), "Nombre Modificado");
        assertEquals(personaNaturalModificada.getTelefono(), 1111111);
        assertEquals(personaNaturalModificada.getCorreo(), "Correo Modificado");
        assertEquals(personaNaturalModificada.getRUC(), "11111111111");
        assertEquals(personaNaturalModificada.getRazonSocial(),"Razon Social Modificada");
    }
    
    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        
        PersonaJuridica personaJuridica = new PersonaJuridica();
        
        personaJuridica.setIdCliente(this.idIncorrecto);
        personaJuridica.setNombre("Nombre Modificado");
        personaJuridica.setTelefono(1111111);
        personaJuridica.setCorreo("Correo Modificado");
        personaJuridica.setRUC("11111111111");
        personaJuridica.setRazonSocial("Razon Social Modificada");
        
        boolean modifico = personaJuridicaDAO.modificar(personaJuridica);
        assertFalse(modifico);
    }
    
    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        boolean elimino = personaJuridicaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }
    
    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        PersonaJuridica personaJuridica = personaJuridicaDAO.buscar(this.testId);
        assertNotNull(personaJuridica);
    }
    
    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        PersonaJuridica personaJuridica = personaJuridicaDAO.buscar(this.idIncorrecto);
        assertNull(personaJuridica);
    }
    
    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        List<PersonaJuridica> personasJuridicas = personaJuridicaDAO.listar();
        
        assertNotNull(personasJuridicas);
        assertFalse(personasJuridicas.isEmpty());
    }
    
    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IPersonaJuridicaDAO personaJuridicaDAO = new PersonaJuridicaDAOImpl();
        boolean elimino = personaJuridicaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}
