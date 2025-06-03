package com.restaurante.amm.amimaneranegocio.boimpl.pagos;

import com.restaurante.amm.amimaneramodel.pagos.DetalleBoleta;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pagos.IDetalleBoletaBO;
import com.restaurante.amm.amimanerapersistencia.dao.pagos.IDetalleBoletaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pagos.DetalleBoletaDAOImpl;
import java.util.List;

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
