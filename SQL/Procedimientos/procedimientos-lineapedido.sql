USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarLineaPedido;
DROP PROCEDURE IF EXISTS modificarLineaPedido;
DROP PROCEDURE IF EXISTS eliminarLineaPedido;
DROP PROCEDURE IF EXISTS buscarLineaPedidoPorId;
DROP PROCEDURE IF EXISTS listarLineasPedido;

DELIMITER //
CREATE PROCEDURE insertarLineaPedido(
    IN p_cantidadProducto INT,
    IN p_idPedido INT,
    IN p_idProducto INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO LINEAPEDIDO(cantidadProducto, idPedido, idProducto)
    VALUES(p_cantidadProducto, p_idPedido, p_idProducto);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarLineaPedido(
    IN p_cantidadProducto INT,
    IN p_idPedido INT,
    IN p_idProducto INT,
    IN p_id INT
)
BEGIN
    UPDATE LINEAPEDIDO
    SET 
        cantidadProducto = p_cantidadProducto,
        idPedido = p_idPedido,
        idProducto = p_idProducto
    WHERE idLineaPedido = p_id;
END //

CREATE PROCEDURE eliminarLineaPedido(IN p_id INT)
BEGIN
    DELETE FROM LINEAPEDIDO WHERE idLineaPedido = p_id;
END //

CREATE PROCEDURE buscarLineaPedidoPorId(IN p_id INT)
BEGIN
    SELECT * FROM LINEAPEDIDO WHERE idLineaPedido = p_id;
END //

CREATE PROCEDURE listarLineasPedido()
BEGIN
    SELECT * FROM LINEAPEDIDO;
END //
DELIMITER ; 