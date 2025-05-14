USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarFactura;
DROP PROCEDURE IF EXISTS modificarFactura;
DROP PROCEDURE IF EXISTS eliminarFactura;
DROP PROCEDURE IF EXISTS buscarFacturaPorId;
DROP PROCEDURE IF EXISTS listarFacturas;
DROP PROCEDURE IF EXISTS insertarDetalleFactura;

DELIMITER //
CREATE PROCEDURE insertarFactura(
    IN p_fechaEmision DATETIME,
    IN p_metodoPago VARCHAR(20),
    IN p_montoTotal DECIMAL(10,2),
    IN p_montoPropina DECIMAL(10,2),
    IN p_montoSinIGV DECIMAL(10,2),
    IN p_montoIGV DECIMAL(10,2),
    IN p_ruc VARCHAR(11),
    IN p_razonSocial VARCHAR(100),
    IN p_idPedido INT,
    IN p_idReserva INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO FACTURA(fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, RUC, razonSocial, idPedido, idReserva)
    VALUES(p_fechaEmision, p_metodoPago, p_montoTotal, p_montoPropina, p_montoSinIGV, p_montoIGV, p_ruc, p_razonSocial, p_idPedido, p_idReserva);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarFactura(
    IN p_fechaEmision DATETIME,
    IN p_metodoPago VARCHAR(20),
    IN p_montoTotal DECIMAL(10,2),
    IN p_montoPropina DECIMAL(10,2),
    IN p_montoSinIGV DECIMAL(10,2),
    IN p_montoIGV DECIMAL(10,2),
    IN p_ruc VARCHAR(11),
    IN p_razonSocial VARCHAR(100),
    IN p_idPedido INT,
    IN p_idReserva INT,
    IN p_id INT
)
BEGIN
    UPDATE FACTURA
    SET 
        fechaEmision = p_fechaEmision,
        metodoPago = p_metodoPago,
        montoTotal = p_montoTotal,
        montoPropina = p_montoPropina,
        montoSinIGV = p_montoSinIGV,
        montoIGV = p_montoIGV,
        RUC = p_ruc,
        razonSocial = p_razonSocial,
        idPedido = p_idPedido,
        idReserva = p_idReserva
    WHERE idFactura = p_id;
END //

CREATE PROCEDURE eliminarFactura(IN p_id INT)
BEGIN
    DELETE FROM FACTURA WHERE idFactura = p_id;
END //

CREATE PROCEDURE buscarFacturaPorId(IN p_id INT)
BEGIN
    SELECT * FROM FACTURA WHERE idFactura = p_id;
END //

CREATE PROCEDURE listarFacturas()
BEGIN
    SELECT * FROM FACTURA;
END //

CREATE PROCEDURE insertarDetalleFactura(
    IN p_nombreProducto VARCHAR(100),
    IN p_subtotalSinIGV DECIMAL(10,2),
    IN p_subtotalFinal DECIMAL(10,2),
    IN p_idComprobante INT
)
BEGIN
    INSERT INTO DETALLEFACTURA(nombreProducto, subtotalSinIGV, subtotalFinal, idComprobante)
    VALUES(p_nombreProducto, p_subtotalSinIGV, p_subtotalFinal, p_idComprobante);
END //
DELIMITER ; 