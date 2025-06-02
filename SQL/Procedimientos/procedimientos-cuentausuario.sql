DELIMITER //

-- Procedimiento para insertar una cuenta de usuario
CREATE PROCEDURE insertarCuentaUsuario(
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasenia VARCHAR(50),
    IN p_tipoUsuario VARCHAR(20),
    OUT p_id INT
)
BEGIN
    INSERT INTO CuentaUsuario (nombreUsuario, contrasenia, tipoUsuario)
    VALUES (p_nombreUsuario, p_contrasenia, p_tipoUsuario);
    SET p_id = LAST_INSERT_ID();
END //

-- Procedimiento para modificar una cuenta de usuario
CREATE PROCEDURE modificarCuentaUsuario(
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasenia VARCHAR(50),
    IN p_tipoUsuario VARCHAR(20),
    IN p_id INT
)
BEGIN
    UPDATE CuentaUsuario
    SET nombreUsuario = p_nombreUsuario,
        contrasenia = p_contrasenia,
        tipoUsuario = p_tipoUsuario
    WHERE idCuentaUsuario = p_id;
END //

-- Procedimiento para eliminar una cuenta de usuario
CREATE PROCEDURE eliminarCuentaUsuario(
    IN p_id INT
)
BEGIN
    DELETE FROM CuentaUsuario
    WHERE idCuentaUsuario = p_id;
END //

-- Procedimiento para buscar una cuenta de usuario por ID
CREATE PROCEDURE buscarCuentaUsuarioPorId(
    IN p_id INT
)
BEGIN
    SELECT idCuentaUsuario, nombreUsuario, contrasenia, tipoUsuario
    FROM CuentaUsuario
    WHERE idCuentaUsuario = p_id;
END //

-- Procedimiento para listar todas las cuentas de usuario
CREATE PROCEDURE listarCuentasUsuario()
BEGIN
    SELECT idCuentaUsuario, nombreUsuario, contrasenia, tipoUsuario
    FROM CuentaUsuario;
END //

-- Procedimiento para buscar una cuenta de usuario por nombre de usuario y contrasenia
CREATE PROCEDURE autenticarUsuario(
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasenia VARCHAR(50)
)
BEGIN
    SELECT idCuentaUsuario, nombreUsuario, contrasenia, tipoUsuario
    FROM CuentaUsuario
    WHERE nombreUsuario = p_nombreUsuario AND contrasenia = p_contrasenia;
END //
DELIMITER ; 