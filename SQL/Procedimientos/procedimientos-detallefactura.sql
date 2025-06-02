USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarDetalleFactura;
DROP PROCEDURE IF EXISTS modificarDetalleFactura;
DROP PROCEDURE IF EXISTS eliminarDetalleFactura;
DROP PROCEDURE IF EXISTS buscarDetalleFacturaPorId;
DROP PROCEDURE IF EXISTS listarDetallesFactura;

DELIMITER //
CREATE PROCEDURE insertarDetalleFactura(
    IN p_cantidadProducto INT,
	IN p_precioUnitario DECIMAL(10,2),
	IN p_subTotal DECIMAL(10,2),
	IN p_idProducto INT,
	IN p_idComprobantePago INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO DETALLEFACTURA(cantidadProducto, precioUnitario,
		subTotal,idProducto, idComprobantePago)
    VALUES(p_cantidadProducto,p_precioUnitario, p_subTotal, p_idProducto,
		p_idComprobantePago);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarDetalleFactura(
    IN p_cantidadProducto INT,
	IN p_precioUnitario DECIMAL(10,2),
	IN p_subTotal DECIMAL(10,2),
	IN p_idProducto INT,
	IN p_idComprobantePago INT,
    IN p_id INT
)
BEGIN
    UPDATE DETALLEFACTURA
    SET 
        cantidadProducto = p_cantidadProducto,
        precioUnitario = p_precioUnitario,
		subTotal = p_subTotal,
		idProducto = p_idProducto,
		idComprobantePago = p_idComprobantePago
    WHERE idDetalleFactura = p_id;
END //

CREATE PROCEDURE eliminarDetalleFactura(IN p_id INT)
BEGIN
    DELETE FROM DETALLEFACTURA WHERE idDetalleFactura = p_id;
END //

CREATE PROCEDURE buscarDetalleFacturaPorId(IN p_id INT)
BEGIN
    SELECT * FROM DETALLEFACTURA WHERE idDetalleFactura = p_id;
END //

CREATE PROCEDURE listarDetallesFactura()
BEGIN
    SELECT * FROM DETALLEFACTURA;
END //
DELIMITER ; 