USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarPersonaJuridica;
DROP PROCEDURE IF EXISTS modificarPersonaJuridica;
DROP PROCEDURE IF EXISTS eliminarPersonaJuridica;
DROP PROCEDURE IF EXISTS buscarPersonaJuridicaPorId;
DROP PROCEDURE IF EXISTS listarPersonasJuridicas;

DELIMITER //
CREATE PROCEDURE insertarPersonaJuridica(
    IN p_nombre VARCHAR(100),
    IN p_telefono INT,
    IN p_correo VARCHAR(100),
    IN p_ruc VARCHAR(11),
    IN p_razonSocial VARCHAR(100),
    OUT p_id INT
)
BEGIN
    INSERT INTO PERSONA_JURIDICA(nombre, telefono, correo, RUC, razonSocial)
    VALUES(p_nombre, p_telefono, p_correo, p_ruc, p_razonSocial);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarPersonaJuridica(
    IN p_nombre VARCHAR(100),
    IN p_telefono INT,
    IN p_correo VARCHAR(100),
    IN p_ruc VARCHAR(11),
    IN p_razonSocial VARCHAR(100),
    IN p_id INT
)
BEGIN
    UPDATE PERSONA_JURIDICA
    SET 
        nombre = p_nombre,
        telefono = p_telefono,
        correo = p_correo,
        RUC = p_ruc,
        razonSocial = p_razonSocial
    WHERE idPersonaJuridica = p_id;
END //

CREATE PROCEDURE eliminarPersonaJuridica(IN p_id INT)
BEGIN
    DELETE FROM PERSONA_JURIDICA WHERE idPersonaJuridica = p_id;
END //

CREATE PROCEDURE buscarPersonaJuridicaPorId(IN p_id INT)
BEGIN
    SELECT * FROM PERSONA_JURIDICA WHERE idPersonaJuridica = p_id;
END //

CREATE PROCEDURE listarPersonasJuridicas()
BEGIN
    SELECT * FROM PERSONA_JURIDICA;
END //
DELIMITER ;