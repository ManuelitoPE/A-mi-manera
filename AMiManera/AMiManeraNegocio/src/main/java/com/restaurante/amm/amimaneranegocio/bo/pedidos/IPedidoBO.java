package com.restaurante.amm.amimaneranegocio.bo.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimaneranegocio.bo.IBaseBO;
import java.util.List;

public interface IPedidoBO extends IBaseBO<Pedido> {
    List<Pedido> listarPedidosPorMesa(int idMesa);
    List<Pedido> listarPedidosPorEstado(EstadoPedido estado);
}
