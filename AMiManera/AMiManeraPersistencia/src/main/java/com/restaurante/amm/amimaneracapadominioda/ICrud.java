package com.restaurante.amm.amimaneracapadominioda;

import java.util.List;

public interface ICrud<T> {
    int insertar(T modelo);
    boolean modificar(T modelo);
    boolean eliminar(int id);
    T buscar(int id);
    List<T> listar();
}
