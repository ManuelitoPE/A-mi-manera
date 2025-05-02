package com.restaurante.amm.amimanerapersistencia.daoimpl;

import java.util.List;

public interface ICrud<T> {
    int insertar(T modelo);
    boolean modificar(T modelo);
    boolean eliminar(int id);
    T buscar(int id);
    List<T> listar();
}
