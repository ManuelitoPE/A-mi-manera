/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IDetalleBoletaBO;
import com.restaurante.amm.amimanerapersistencia.dao.IDetalleBoletaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.DetalleBoletaDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class DetalleBoletaBOImpl implements IDetalleBoletaBO{
    
    private final IDetalleBoletaDAO detalleBoletaDAO;
    
    public DetalleBoletaBOImpl(){
        this.detalleBoletaDAO = new DetalleBoletaDAOImpl();
    }
    @Override
    public List<DetalleBoleta> listar() {
        return this.detalleBoletaDAO.listar();
    }

    @Override
    public DetalleBoleta obtener(int id) {
        return this.detalleBoletaDAO.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        this.detalleBoletaDAO.eliminar(id);
    }

    @Override
    public void guardar(DetalleBoleta modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.detalleBoletaDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.detalleBoletaDAO.modificar(modelo);
    }
    
}
