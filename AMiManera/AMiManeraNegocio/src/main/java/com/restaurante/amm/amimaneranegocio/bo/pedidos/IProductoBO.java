package com.restaurante.amm.amimaneranegocio.bo.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimaneranegocio.bo.IBaseBO;
import java.util.List;

public interface IProductoBO extends IBaseBO<Producto>{
    List<Producto> obtenerPorNombre(String nombre);
}
