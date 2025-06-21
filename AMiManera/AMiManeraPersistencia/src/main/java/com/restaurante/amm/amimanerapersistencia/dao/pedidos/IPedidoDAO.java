package com.restaurante.amm.amimanerapersistencia.dao.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.EstadoPedido;
import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import com.restaurante.amm.amimanerapersistencia.dao.ICrud;
import java.util.List;

public interface IPedidoDAO extends ICrud<Pedido> {
    List<Pedido> listarPorMesa(int idMesa);
    List<Pedido> listarPorEstado(EstadoPedido estado);
}
