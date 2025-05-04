USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarPersonaNatural;
DROP PROCEDURE IF EXISTS modificarPersonaNatural;
DROP PROCEDURE IF EXISTS eliminarPersonaNatural;
DROP PROCEDURE IF EXISTS buscarPersonaNaturalPorId;
DROP PROCEDURE IF EXISTS listarPersonasNaturales;

DELIMITER //
CREATE PROCEDURE insertarPersonaNatural(
    IN p_nombre VARCHAR(100),
    IN p_telefono INT,
    IN p_correo VARCHAR(100),
    IN p_dni VARCHAR(8),
    OUT p_id INT
)
BEGIN
    INSERT INTO PERSONA_NATURAL(nombre, telefono, correo, DNI)
    VALUES(p_nombre, p_telefono, p_correo, p_dni);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarPersonaNatural(
    IN p_nombre VARCHAR(100),
    IN p_telefono INT,
    IN p_correo VARCHAR(100),
    IN p_dni VARCHAR(8),
    IN p_id INT
)
BEGIN
    UPDATE PERSONA_NATURAL
    SET 
        nombre = p_nombre,
        telefono = p_telefono,
        correo = p_correo,
        DNI = p_dni
    WHERE idPersonaNatural = p_id;
END //

CREATE PROCEDURE eliminarPersonaNatural(IN p_id INT)
BEGIN
    DELETE FROM PERSONA_NATURAL WHERE idPersonaNatural = p_id;
END //

CREATE PROCEDURE buscarPersonaNaturalPorId(IN p_id INT)
BEGIN
    SELECT * FROM PERSONA_NATURAL WHERE idPersonaNatural = p_id;
END //

CREATE PROCEDURE listarPersonasNaturales()
BEGIN
    SELECT * FROM PERSONA_NATURAL;
END //
DELIMITER ;