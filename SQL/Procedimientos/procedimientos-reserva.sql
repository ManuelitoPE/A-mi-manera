USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarReserva;
DROP PROCEDURE IF EXISTS modificarReserva;
DROP PROCEDURE IF EXISTS eliminarReserva;
DROP PROCEDURE IF EXISTS buscarReservaPorId;
DROP PROCEDURE IF EXISTS listarReservas;

DELIMITER //
CREATE PROCEDURE insertarReserva(
    IN p_fechaHoraInicio DATETIME,
    IN p_fechaHoraFin DATETIME,
    IN p_cantidadPersonas INT,
    IN p_estado VARCHAR(20),
    IN p_montoReserva DECIMAL(10,2),
    IN p_idPersonaNatural INT,
	IN p_idPersonaJuridica INT,
    IN p_idMesa INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO RESERVA(
		fechaHoraInicio, 
		fechaHoraFin, 
		cantidadPersonas, 
		estado, 
		montoReserva, 
		idPersonaNatural, 
		idPersonaJuridica, 
		idMesa)
    VALUES(
		p_fechaHoraInicio,
		p_fechaHoraFin,
		p_cantidadPersonas,
		p_estado,
		p_montoReserva, 
		p_idPersonaNatural,
		p_idPersonaJuridica,
		p_idMesa);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarReserva(
    IN p_fechaHoraInicio DATETIME,
    IN p_fechaHoraFin DATETIME,
    IN p_cantidadPersonas INT,
    IN p_estado VARCHAR(20),
    IN p_montoReserva DECIMAL(10,2),
    IN p_idPersonaNatural INT,
	IN p_idPersonaJuridica INT,
    IN p_idMesa INT,
    IN p_id INT
)
BEGIN
    UPDATE RESERVA
    SET 
        fechaHoraInicio = p_fechaHoraInicio,
        fechaHoraFin = p_fechaHoraFin,
        cantidadPersonas = p_cantidadPersonas,
        estado = p_estado,
        montoReserva = p_montoReserva,
        idPersonaNatural = p_idPersonaNatural,
		idPersonaJuridica = p_idPersonaJuridica,
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