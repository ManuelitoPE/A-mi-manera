package com.restaurante.amm.amimanerapersistencia.dao;

import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import java.util.List;

public interface IPedidoDAO extends ICrud<Pedido> {
    List<Pedido> listarPorMesa(int idMesa);
}
