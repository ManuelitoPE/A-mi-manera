/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.clientes.PersonaJuridica;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IPersonaJuridicaBO;
import com.restaurante.amm.amimanerapersistencia.dao.IPersonaJuridicaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.PersonaJuridicaDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
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
