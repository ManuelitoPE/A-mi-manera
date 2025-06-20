package com.restaurante.amm.amimaneranegocio.bo.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneranegocio.bo.IBaseBO;
<<<<<<< HEAD

public interface IProductoBO extends IBaseBO<Producto>{
    
=======
import java.util.List;

public interface IProductoBO extends IBaseBO<Producto>{
    List<Producto> obtenerPorNombre(String nombre);
>>>>>>> main
}
