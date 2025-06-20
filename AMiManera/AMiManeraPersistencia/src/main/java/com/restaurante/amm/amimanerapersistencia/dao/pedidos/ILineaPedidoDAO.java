package com.restaurante.amm.amimanerapersistencia.dao.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimanerapersistencia.dao.ICrud;
import java.util.List;

public interface ILineaPedidoDAO extends ICrud<LineaPedido> {
    List<LineaPedido> listarPorIdPedido(int idPedido);
} 