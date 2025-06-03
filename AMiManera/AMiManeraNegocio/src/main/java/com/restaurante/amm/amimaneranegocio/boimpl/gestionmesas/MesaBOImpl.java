package com.restaurante.amm.amimaneranegocio.boimpl.gestionmesas;

import com.restaurante.amm.amimaneramodel.gestionmesas.Mesa;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.gestionmesas.IMesaBO;
import com.restaurante.amm.amimanerapersistencia.dao.gestionmesas.IMesaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.gestionmesas.MesaDAOImpl;
import java.util.List;

public class MesaBOImpl implements IMesaBO{
    
    private final IMesaDAO mesaDAO;
    
    public MesaBOImpl(){
        this.mesaDAO = new MesaDAOImpl();
    }
    
    @Override
    public List<Mesa> listar() {
        return this.mesaDAO.listar();
    }

    @Override
    public Mesa obtener(int id) {
        return this.mesaDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.mesaDAO.eliminar(id);
    }

    @Override
    public void guardar(Mesa modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.mesaDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.mesaDAO.modificar(modelo);
    }
    
}
