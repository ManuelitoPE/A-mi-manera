USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarReserva;
DROP PROCEDURE IF EXISTS modificarReserva;
DROP PROCEDURE IF EXISTS eliminarReserva;
DROP PROCEDURE IF EXISTS buscarReservaPorId;
DROP PROCEDURE IF EXISTS listarReservas;

DELIMITER //
CREATE PROCEDURE insertarReserva(
    IN p_fecha DATE,
    IN p_horaInicio DATETIME,
    IN p_horaFin DATETIME,
    IN p_cantidadPersonas INT,
    IN p_estado VARCHAR(20),
    IN p_horaMaximaCancelacion DATETIME,
    IN p_montoReserva DECIMAL(10,2),
    IN p_idCliente INT,
    IN p_idMesa INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO RESERVA(fecha, horaInicio, horaFin, cantidadPersonas, estado, horaMaximaCancelacion, montoReserva, idCliente, idMesa)
    VALUES(p_fecha, p_horaInicio, p_horaFin, p_cantidadPersonas, p_estado, p_horaMaximaCancelacion, p_montoReserva, p_idCliente, p_idMesa);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarReserva(
    IN p_fecha DATE,
    IN p_horaInicio DATETIME,
    IN p_horaFin DATETIME,
    IN p_cantidadPersonas INT,
    IN p_estado VARCHAR(20),
    IN p_horaMaximaCancelacion DATETIME,
    IN p_montoReserva DECIMAL(10,2),
    IN p_idCliente INT,
    IN p_idMesa INT,
    IN p_id INT
)
BEGIN
    UPDATE RESERVA
    SET 
        fecha = p_fecha,
        horaInicio = p_horaInicio,
        horaFin = p_horaFin,
        cantidadPersonas = p_cantidadPersonas,
        estado = p_estado,
        horaMaximaCancelacion = p_horaMaximaCancelacion,
        montoReserva = p_montoReserva,
        idCliente = p_idCliente,
        idMesa = p_idMesa
    WHERE idReserva = p_id;
END //

CREATE PROCEDURE eliminarReserva(IN p_id INT)
BEGIN
    DELETE FROM RESERVA WHERE idReserva = p_id;
END //

CREATE PROCEDURE buscarReservaPorId(IN p_id INT)
BEGIN
    SELECT * FROM RESERVA WHERE idReserva = p_id;
END //

CREATE PROCEDURE listarReservas()
BEGIN
    SELECT * FROM RESERVA;
END //
DELIMITER ; 