package com.restaurante.amm.amimaneratest.gestionmesas;

import com.restaurante.amm.amimaneramodel.clientes.PersonaJuridica;
import com.restaurante.amm.amimaneramodel.clientes.PersonaNatural;
import com.restaurante.amm.amimaneramodel.gestionmesas.EstadoReserva;
import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IReservaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas.ReservaDAOImpl;
import com.restaurante.amm.amimaneratest.ICrudDAOTest;
import java.time.LocalDateTime;
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
public class ReservaDAOTest implements ICrudDAOTest {

    private int testId;
    private final int idIncorrecto = 99999;

    @Test
    @Order(1)
    @Override
    public void debeInsertar() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();

        Reserva reserva = new Reserva();
        reserva.setFechaHoraInicio(LocalDateTime.now().plusDays(1).withHour(12));
        reserva.setFechaHoraFin(LocalDateTime.now().plusDays(1).withHour(14));
        reserva.setCantidadPersonas(3);
        reserva.setEstado(EstadoReserva.PENDIENTE);
        reserva.setMontoReserva(90.00);
        
        Mesa mesa = new Mesa();
        mesa.setIdMesa(1);
        reserva.setMesa(mesa); 
        
        PersonaNatural personaNatural = new PersonaNatural();
        personaNatural.setIdCliente(1);
        reserva.setPersonaNatural(personaNatural); 
        
        PersonaJuridica personaJuridica = new PersonaJuridica();
        personaJuridica.setIdCliente(2);
        reserva.setPersonaJuridica(personaJuridica); 

        this.testId = reservaDAO.insertar(reserva);
        assertTrue(this.testId > 0);
    }

    @Test
    @Order(2)
    @Override
    public void debeModificarSiIdExiste() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();

        Reserva reserva = new Reserva();
        reserva.setIdReserva(this.testId);
        reserva.setCantidadPersonas(5);
        reserva.setFechaHoraInicio(LocalDateTime.now().plusDays(1).withHour(12));
        reserva.setFechaHoraFin(LocalDateTime.now().plusDays(1).withHour(14));
        reserva.setEstado(EstadoReserva.CONFIRMADA);
        
        Mesa mesa = new Mesa();
        mesa.setIdMesa(1);
        reserva.setMesa(mesa); 
        
        PersonaNatural personaNatural = new PersonaNatural();
        personaNatural.setIdCliente(1);
        reserva.setPersonaNatural(personaNatural); 
        
        PersonaJuridica personaJuridica = new PersonaJuridica();
        personaJuridica.setIdCliente(2);
        reserva.setPersonaJuridica(personaJuridica); 

        boolean modifico = reservaDAO.modificar(reserva);
        assertTrue(modifico);

        Reserva modificada = reservaDAO.buscar(this.testId);
        assertEquals(5, modificada.getCantidadPersonas());
        assertEquals(EstadoReserva.CONFIRMADA, modificada.getEstado());
    }

    @Test
    @Order(3)
    @Override
    public void noDebeModificarSiIdNoExiste() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();

        Reserva reserva = new Reserva();
        reserva.setIdReserva(this.idIncorrecto);
        reserva.setFechaHoraInicio(LocalDateTime.now().plusDays(1).withHour(12));
        reserva.setFechaHoraFin(LocalDateTime.now().plusDays(1).withHour(14));
        reserva.setCantidadPersonas(2);
        reserva.setEstado(EstadoReserva.CANCELADA);
        PersonaNatural personaNatural = new PersonaNatural();
        personaNatural.setIdCliente(1);
        reserva.setPersonaNatural(personaNatural); 
        
        PersonaJuridica personaJuridica = new PersonaJuridica();
        personaJuridica.setIdCliente(2);
        reserva.setPersonaJuridica(personaJuridica);
        Mesa mesa = new Mesa();
        mesa.setIdMesa(1);
        reserva.setMesa(mesa); 

        boolean modifico = reservaDAO.modificar(reserva);
        assertFalse(modifico);
    }

    @Test
    @Order(4)
    @Override
    public void noDebeEliminarSiIdNoExiste() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();
        boolean elimino = reservaDAO.eliminar(this.idIncorrecto);
        assertFalse(elimino);
    }

    @Test
    @Order(5)
    @Override
    public void debeEncontrarSiIdExiste() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();
        Reserva reserva = reservaDAO.buscar(this.testId);
        assertNotNull(reserva);
    }

    @Test
    @Order(6)
    @Override
    public void noDebeEncontrarSiIdNoExiste() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();
        Reserva reserva = reservaDAO.buscar(this.idIncorrecto);
        assertNull(reserva);
    }

    @Test
    @Order(7)
    @Override
    public void debeListar() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();
        List<Reserva> reservas = reservaDAO.listar();

        assertNotNull(reservas);
        assertFalse(reservas.isEmpty());
    }

    @Test
    @Order(8)
    @Override
    public void debeEliminarSiIdExiste() {
        IReservaDAO reservaDAO = new ReservaDAOImpl();
        boolean elimino = reservaDAO.eliminar(this.testId);
        assertTrue(elimino);
    }
}