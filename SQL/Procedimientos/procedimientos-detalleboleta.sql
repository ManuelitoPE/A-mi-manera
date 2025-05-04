USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarDetalleBoleta;
DROP PROCEDURE IF EXISTS modificarDetalleBoleta;
DROP PROCEDURE IF EXISTS eliminarDetalleBoleta;
DROP PROCEDURE IF EXISTS buscarDetalleBoletaPorId;
DROP PROCEDURE IF EXISTS listarDetallesBoleta;

DELIMITER //
CREATE PROCEDURE insertarDetalleBoleta(
    IN p_nombreProducto VARCHAR(100),
    IN p_montoProducto DECIMAL(10,2),
    IN p_idComprobante INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO DETALLEBOLETA(nombreProducto, montoProducto, idComprobante)
    VALUES(p_nombreProducto, p_montoProducto, p_idComprobante);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarDetalleBoleta(
    IN p_nombreProducto VARCHAR(100),
    IN p_montoProducto DECIMAL(10,2),
    IN p_idComprobante INT,
    IN p_id INT
)
BEGIN
    UPDATE DETALLEBOLETA
    SET 
        nombreProducto = p_nombreProducto,
        montoProducto = p_montoProducto,
        idComprobante = p_idComprobante
    WHERE idDetalleBoleta = p_id;
END //

CREATE PROCEDURE eliminarDetalleBoleta(IN p_id INT)
BEGIN
    DELETE FROM DETALLEBOLETA WHERE idDetalleBoleta = p_id;
END //

CREATE PROCEDURE buscarDetalleBoletaPorId(IN p_id INT)
BEGIN
    SELECT * FROM DETALLEBOLETA WHERE idDetalleBoleta = p_id;
END //

CREATE PROCEDURE listarDetallesBoleta()
BEGIN
    SELECT * FROM DETALLEBOLETA;
END //
DELIMITER ; 