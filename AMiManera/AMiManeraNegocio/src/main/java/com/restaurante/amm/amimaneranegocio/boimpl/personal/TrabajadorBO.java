
package com.restaurante.amm.amimaneranegocio.boimpl.personal;

import com.restaurante.amm.amimaneramodel.personal.Trabajador;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.personal.ITrabajadorBO;
import com.restaurante.amm.amimanerapersistencia.dao.personal.ITrabajadorDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.personal.TrabajadorDAOImpl;
import java.util.List;

public class TrabajadorBO implements ITrabajadorBO{

    private final ITrabajadorDAO trabajadorDAO;
    
    public TrabajadorBO(){
        this.trabajadorDAO = new TrabajadorDAOImpl();
    }
    
    @Override
    public List<Trabajador> listar() {
        return this.trabajadorDAO.listar();
    }

    @Override
    public Trabajador obtener(int id) {
        return this.trabajadorDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.trabajadorDAO.eliminar(id);
    }

    @Override
    public void guardar(Trabajador modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.trabajadorDAO.insertar(modelo);
        else if(estado == Estado.MODIFICAR) this.trabajadorDAO.modificar(modelo);
    }
    
}
