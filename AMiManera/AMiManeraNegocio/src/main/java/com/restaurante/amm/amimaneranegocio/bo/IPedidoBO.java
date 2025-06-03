/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.bo;

import com.restaurante.amm.amimaneramodel.pedidos.Pedido;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPedidoBO extends IBaseBO<Pedido> {
    List<Pedido> listarPedidoPorMesa(int idMesa);
}
