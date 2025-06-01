package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.clientes.PersonaNatural;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IPersonaNaturalBO;
import com.restaurante.amm.amimanerapersistencia.dao.IPersonaNaturalDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.PersonaNaturalDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class PersonaNaturalBOImpl implements IPersonaNaturalBO{

    private final IPersonaNaturalDAO personaNaturalDAO;
    
    public PersonaNaturalBOImpl(){
        this.personaNaturalDAO = new PersonaNaturalDAOImpl();
    }
    
    @Override
    public List<PersonaNatural> listar() {
        return this.personaNaturalDAO.listar();
    }

    @Override
    public PersonaNatural obtener(int id) {
        return this.personaNaturalDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.personaNaturalDAO.eliminar(id);
    }

    @Override
    public void guardar(PersonaNatural modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.personaNaturalDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.personaNaturalDAO.modificar(modelo);
    }
    
}
