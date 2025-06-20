/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.bo.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.LineaPedido;
import com.restaurante.amm.amimaneranegocio.bo.IBaseBO;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ILineaPedidoBO extends IBaseBO<LineaPedido>{
    List<LineaPedido> listarPorIdPedido(int idPedido);
}
