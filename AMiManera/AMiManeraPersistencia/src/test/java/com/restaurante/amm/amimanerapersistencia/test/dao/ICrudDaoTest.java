package com.restaurante.amm.amimanerapersistencia.test.dao;

<<<<<<< HEAD:AMiManera/AMiManeraPersistencia/src/test/java/com/restaurante/amm/amimanerapersistencia/test/dao/ICrudDaoTest.java
public interface ICrudDAOTest {
=======
public interface CrudDAOTest {
>>>>>>> f4e3c6aa7f867579a2d5adaba31ab2deb92777cc:AMiManera/AMiManeraPersistencia/src/test/java/com/restaurante/amm/amimanerapersistencia/test/dao/CrudDaoTest.java
    void debeInsertar();
    void debeModificarSiIdExiste();
    void noDebeModificarSiIdNoExiste();
    void noDebeEliminarSiIdNoExiste();
    void debeEncontrarSiIdExiste();
    void noDebeEncontrarSiIdNoExiste();
    void debeListar();
    void debeEliminarSiIdExiste();
} 