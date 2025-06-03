package com.restaurante.amm.amimaneranegocio.boimpl.clientes;

import com.restaurante.amm.amimaneramodel.clientes.PersonaJuridica;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.clientes.IPersonaJuridicaBO;
import com.restaurante.amm.amimanerapersistencia.dao.clientes.IPersonaJuridicaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.clientes.PersonaJuridicaDAOImpl;
import java.util.List;

public class PersonaJuridicaBOImpl implements IPersonaJuridicaBO{

    private final IPersonaJuridicaDAO personaJuridicaDAO;
    
    public PersonaJuridicaBOImpl(){
        this.personaJuridicaDAO = new PersonaJuridicaDAOImpl();
    }
    
    @Override
    public List<PersonaJuridica> listar() {
        return this.personaJuridicaDAO.listar();
    }

    @Override
    public PersonaJuridica obtener(int id) {
        return this.personaJuridicaDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.personaJuridicaDAO.eliminar(id);
    }

    @Override
    public void guardar(PersonaJuridica modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.personaJuridicaDAO.insertar(modelo);
        else if(estado == Estado.MODIFICAR) this.personaJuridicaDAO.modificar(modelo);
    }
    
}
