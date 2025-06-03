package com.restaurante.amm.amimaneranegocio.boimpl.gestionmesas;

import com.restaurante.amm.amimaneramodel.gestionmesas.Reserva;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.gestionmesas.IReservaBO;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IReservaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas.ReservaDAOImpl;
import java.util.List;


public class ReservaBOImpl implements IReservaBO{

    private final IReservaDAO reservaDAO;
    
    public ReservaBOImpl(){
        this.reservaDAO = new ReservaDAOImpl();
    }
    
    @Override
    public List<Reserva> listar() {
        return this.reservaDAO.listar();
    }

    @Override
    public Reserva obtener(int id) {
        return this.reservaDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.reservaDAO.eliminar(id);
    }

    @Override
    public void guardar(Reserva modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.reservaDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.reservaDAO.modificar(modelo);
    }
    
}
