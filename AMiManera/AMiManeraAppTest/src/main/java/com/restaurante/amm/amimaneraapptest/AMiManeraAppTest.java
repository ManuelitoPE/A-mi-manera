package com.restaurante.amm.amimaneraapptest;

import com.restaurante.amm.amimaneracapadominioda.IProductoDAO;
import com.restaurante.amm.amimaneracapadominioda.mysql.ProductoDAOImpl;
import com.restaurante.amm.amimaneracapadominiomodel.pedidos.Producto;
import com.restaurante.amm.amimaneracapadominiomodel.pedidos.TipoProducto;

public class AMiManeraAppTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        /*AreaActiveRecord area = new AreaActiveRecord();
        area.setNombre("RRHH");
        area.setActivo(true);
        int id = area.insertar();
        area.setId(id);
        
        area.setActivo(false);
        if (area.actualizar()) {
            System.out.println("El registro fue actualizado correctamente");
        }
        
        area = AreaActiveRecord.buscar(id);
        System.out.println("Codigo: " + area.getId());
        System.out.println("Nombre: " + area.getNombre());
        System.out.println("Activo: " + area.isActivo());
        
        if (area.eliminar()) {
            System.out.println("El registro fue eliminado");
        }*/
        
        Producto producto = new Producto();
        producto.setNombre("Chicharron");
        producto.setPrecioUnitario(12.3);
        producto.setDescripcion("Es muy rico");
        producto.setTipoProducto(TipoProducto.Comida);
        
        IProductoDAO productoDao = new ProductoDAOImpl();
        int id = productoDao.insertar(producto);
        producto.setIdProducto(id);
        System.out.println("Se creo el registro con id: " + id);
//
//        
//        TipoProducto tipo = TipoProducto.Comida;
//        System.out.println("Tipo: " + tipo);
    }
}
