USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarTrabajador;
DROP PROCEDURE IF EXISTS modificarTrabajador;
DROP PROCEDURE IF EXISTS eliminarTrabajador;
DROP PROCEDURE IF EXISTS buscarTrabajadorPorId;
DROP PROCEDURE IF EXISTS listarTrabajadores;

DELIMITER //
CREATE PROCEDURE insertarTrabajador(
    IN p_nombre VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(50),
    IN p_apellidoMaterno VARCHAR(50),
    IN p_rol VARCHAR(20),
    IN p_idCuentaUsuario INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO TRABAJADOR(nombre, apellidoPaterno, apellidoMaterno, rol, idCuentaUsuario)
    VALUES(p_nombre, p_apellidoPaterno, p_apellidoMaterno, p_rol, p_idCuentaUsuario);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarTrabajador(
    IN p_nombre VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(50),
    IN p_apellidoMaterno VARCHAR(50),
    IN p_rol VARCHAR(20),
    IN p_idCuentaUsuario INT,
    IN p_id INT
)
BEGIN
    UPDATE TRABAJADOR
    SET 
        nombre = p_nombre,
        apellidoPaterno = p_apellidoPaterno,
        apellidoMaterno = p_apellidoMaterno,
        rol = p_rol,
        idCuentaUsuario = p_idCuentaUsuario
    WHERE idTrabajador = p_id;
END //

CREATE PROCEDURE eliminarTrabajador(IN p_id INT)
BEGIN
    DELETE FROM TRABAJADOR WHERE idTrabajador = p_id;
END //

CREATE PROCEDURE buscarTrabajadorPorId(IN p_id INT)
BEGIN
    SELECT * FROM TRABAJADOR WHERE idTrabajador = p_id;
END //

CREATE PROCEDURE listarTrabajadores()
BEGIN
    SELECT * FROM TRABAJADOR;
END //
DELIMITER ; 