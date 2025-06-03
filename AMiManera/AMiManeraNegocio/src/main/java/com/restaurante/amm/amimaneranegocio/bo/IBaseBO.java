/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.amm.amimaneranegocio.bo;

import java.util.List;
import com.restaurante.amm.amimaneranegocio.Estado;

/**
 *
 * @author USER
 */
public interface IBaseBO<T> {
    List<T> listar();
    T obtener(int id);
    void eliminar(int id);
    void guardar(T modelo, Estado estado);
}
