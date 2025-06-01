/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.boimpl;

import com.restaurante.amm.amimaneramodel.pagos.DetalleFactura;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.IDetalleFacturaBO;
import com.restaurante.amm.amimanerapersistencia.dao.IDetalleFacturaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.DetalleFacturaDAOImpl;
import java.util.List;

/**
 *
 * @author USER
 */
public class DetalleFacturaBOImpl implements IDetalleFacturaBO{

    private final IDetalleFacturaDAO detalleFacturaDAO;
    
    public DetalleFacturaBOImpl(){
        this.detalleFacturaDAO = new DetalleFacturaDAOImpl();
    }
    
    public List<DetalleFactura> listar() {
        return this.detalleFacturaDAO.listar();
    }

    public DetalleFactura obtener(int id) {
        return this.detalleFacturaDAO.buscar(id);
    }

    public void eliminar(int id) {
        this.detalleFacturaDAO.eliminar(id);
    }

    public void guardar(DetalleFactura modelo, Estado estado) {
        if(estado == Estado.NUEVO) this.detalleFacturaDAO.insertar(modelo);
        else if (estado == Estado.MODIFICAR) this.detalleFacturaDAO.modificar(modelo);
    }
    
}
