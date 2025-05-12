USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarPedido;
DROP PROCEDURE IF EXISTS modificarPedido;
DROP PROCEDURE IF EXISTS eliminarPedido;
DROP PROCEDURE IF EXISTS buscarPedidoPorId;
DROP PROCEDURE IF EXISTS listarPedidos;

DELIMITER //
CREATE PROCEDURE insertarPedido(
    IN p_fecha DATE,
    IN p_estado VARCHAR(20),
    IN p_montoTotal DECIMAL(10,2),
    IN p_idMesa INT,
    IN p_idMesero INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO PEDIDO(fechaHora, estado, montoTotal, idMesa, idMesero)
    VALUES(p_fecha, p_estado, p_montoTotal, p_idMesa, p_idMesero);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarPedido(
    IN p_fecha DATE,
    IN p_estado VARCHAR(20),
    IN p_montoTotal DECIMAL(10,2),
    IN p_idMesa INT,
    IN p_idMesero INT,
    IN p_id INT
)
BEGIN
    UPDATE PEDIDO
    SET 
        fechaHora = p_fecha,
        estado = p_estado,
        montoTotal = p_montoTotal,
        idMesa = p_idMesa,
        idMesero = p_idMesero
    WHERE idPedido = p_id;
END //

CREATE PROCEDURE eliminarPedido(IN p_id INT)
BEGIN
    DELETE FROM PEDIDO WHERE idPedido = p_id;
END //

CREATE PROCEDURE buscarPedidoPorId(IN p_id INT)
BEGIN
    SELECT * FROM PEDIDO WHERE idPedido = p_id;
END //

CREATE PROCEDURE listarPedidos()
BEGIN
    SELECT * FROM PEDIDO;
END //
DELIMITER ;