package com.restaurante.amm.amimanerapersistencia.test.dao;

public interface CrudDAOTest {
    void debeInsertar();
    void debeModificarSiIdExiste();
    void noDebeModificarSiIdNoExiste();
    void noDebeEliminarSiIdNoExiste();
    void debeEncontrarSiIdExiste();
    void noDebeEncontrarSiIdNoExiste();
    void debeListar();
    void debeEliminarSiIdExiste();
} 