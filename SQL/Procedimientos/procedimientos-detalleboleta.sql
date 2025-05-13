USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarDetalleBoleta;
DROP PROCEDURE IF EXISTS modificarDetalleBoleta;
DROP PROCEDURE IF EXISTS eliminarDetalleBoleta;
DROP PROCEDURE IF EXISTS buscarDetalleBoletaPorId;
DROP PROCEDURE IF EXISTS listarDetallesBoleta;

DELIMITER //
CREATE PROCEDURE insertarDetalleBoleta(
    IN p_cantidadProducto INT,
	IN p_precioUnitario DECIMAL(10,2),
	IN p_subTotal DECIMAL(10,2),
	IN p_idProducto INT,
	IN p_idComprobantePago INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO DETALLEBOLETA(cantidadProducto, precioUnitario,
		subTotal,idProducto, idComprobantePago)		
    VALUES(p_cantidadProducto,p_precioUnitario, p_subTotal, p_idProducto,
		p_idComprobantePago);
		
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarDetalleBoleta(
    IN p_cantidadProducto INT,
	IN p_precioUnitario DECIMAL(10,2),
	IN p_subTotal DECIMAL(10,2),
	IN p_idProducto INT,
	IN p_idComprobantePago INT,
    IN p_id INT
)
BEGIN
    UPDATE DETALLEBOLETA
    SET 
        cantidadProducto = p_cantidadProducto,
        precioUnitario = p_precioUnitario,
		subTotal = p_subTotal,
		idProducto = p_idProducto,
		idComprobantePago = p_idComprobantePago
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