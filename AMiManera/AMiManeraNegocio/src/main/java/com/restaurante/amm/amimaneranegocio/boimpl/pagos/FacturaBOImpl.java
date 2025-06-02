package com.restaurante.amm.amimaneranegocio.boimpl.pagos;

import com.restaurante.amm.amimaneramodel.pagos.Factura;
import com.restaurante.amm.amimaneranegocio.Estado;
import com.restaurante.amm.amimaneranegocio.bo.pagos.IFacturaBO;
import com.restaurante.amm.amimanerapersistencia.dao.pagos.IFacturaDAO;
import com.restaurante.amm.amimanerapersistencia.daoimpl.pagos.FacturaDAOImpl;
import java.util.List;

public class FacturaBOImpl implements IFacturaBO{
    private final IFacturaDAO facturaDAO;
    
    public FacturaBOImpl(){
        this.facturaDAO = new FacturaDAOImpl();
    }
    
    @Override
    public void guardar(Factura factura,Estado estado){
        if(estado == Estado.NUEVO) this.facturaDAO.insertar(factura);
        else if (estado == Estado.MODIFICAR) this.facturaDAO.modificar(factura);
    }
    
    @Override
    public void eliminar(int id){
        this.facturaDAO.eliminar(id);
    }
    
    @Override
    public Factura obtener(int id){
        return this.facturaDAO.buscar(id);
    }
    
    @Override
    public List<Factura> listar(){
        return this.facturaDAO.listar();
    }
}
