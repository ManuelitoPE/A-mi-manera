USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarMesa;
DROP PROCEDURE IF EXISTS modificarMesa;
DROP PROCEDURE IF EXISTS eliminarMesa;
DROP PROCEDURE IF EXISTS buscarMesaPorId;
DROP PROCEDURE IF EXISTS listarMesas;

DELIMITER //
CREATE PROCEDURE insertarMesa(IN p_cantidadAsientos INT, IN p_estado VARCHAR(20), OUT p_id INT)
BEGIN
    INSERT INTO MESA(cantidadAsientos, estado) VALUES(p_cantidadAsientos, p_estado);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarMesa(IN p_cantidadAsientos INT, IN p_estado VARCHAR(20), IN p_id INT)
BEGIN
    UPDATE MESA
    SET 
        cantidadAsientos = p_cantidadAsientos, 
        estado = p_estado
    WHERE idMesa = p_id;
END //

CREATE PROCEDURE eliminarMesa(IN p_id INT)
BEGIN
    DELETE FROM MESA WHERE idMesa = p_id;
END //

CREATE PROCEDURE buscarMesaPorId(IN p_id INT)
BEGIN
    SELECT * FROM MESA WHERE idMesa = p_id;
END //

CREATE PROCEDURE listarMesas()
BEGIN
    SELECT * FROM MESA;
END //
DELIMITER ; 