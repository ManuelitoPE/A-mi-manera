USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarDetalleFactura;
DROP PROCEDURE IF EXISTS modificarDetalleFactura;
DROP PROCEDURE IF EXISTS eliminarDetalleFactura;
DROP PROCEDURE IF EXISTS buscarDetalleFacturaPorId;
DROP PROCEDURE IF EXISTS listarDetallesFactura;

DELIMITER //
CREATE PROCEDURE insertarDetalleFactura(
    IN p_nombreProducto VARCHAR(100),
    IN p_subtotalSinIGV DECIMAL(10,2),
    IN p_subtotalFinal DECIMAL(10,2),
    IN p_idComprobante INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO DETALLEFACTURA(nombreProducto, subtotalSinIGV, subtotalFinal, idComprobante)
    VALUES(p_nombreProducto, p_subtotalSinIGV, p_subtotalFinal, p_idComprobante);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarDetalleFactura(
    IN p_nombreProducto VARCHAR(100),
    IN p_subtotalSinIGV DECIMAL(10,2),
    IN p_subtotalFinal DECIMAL(10,2),
    IN p_idComprobante INT,
    IN p_id INT
)
BEGIN
    UPDATE DETALLEFACTURA
    SET 
        nombreProducto = p_nombreProducto,
        subtotalSinIGV = p_subtotalSinIGV,
        subtotalFinal = p_subtotalFinal,
        idComprobante = p_idComprobante
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