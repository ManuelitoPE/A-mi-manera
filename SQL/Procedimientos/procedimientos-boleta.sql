 USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarBoleta;
DROP PROCEDURE IF EXISTS modificarBoleta;
DROP PROCEDURE IF EXISTS eliminarBoleta;
DROP PROCEDURE IF EXISTS buscarBoletaPorId;
DROP PROCEDURE IF EXISTS listarBoletas;
DROP PROCEDURE IF EXISTS insertarDetalleBoleta;

DELIMITER //
CREATE PROCEDURE insertarBoleta(
    IN p_fechaEmision DATETIME,
    IN p_metodoPago VARCHAR(20),
    IN p_montoTotal DECIMAL(10,2),
    IN p_montoPropina DECIMAL(10,2),
    IN p_montoSinIGV DECIMAL(10,2),
    IN p_montoIGV DECIMAL(10,2),
    IN p_idPedido INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO BOLETA(fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, idPedido)
    VALUES(p_fechaEmision, p_metodoPago, p_montoTotal, p_montoPropina, p_montoSinIGV, p_montoIGV, p_idPedido);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarBoleta(
    IN p_fechaEmision DATETIME,
    IN p_metodoPago VARCHAR(20),
    IN p_montoTotal DECIMAL(10,2),
    IN p_montoPropina DECIMAL(10,2),
    IN p_montoSinIGV DECIMAL(10,2),
    IN p_montoIGV DECIMAL(10,2),
    IN p_idPedido INT,
    IN p_id INT
)
BEGIN
    UPDATE BOLETA
    SET 
        fechaEmision = p_fechaEmision,
        metodoPago = p_metodoPago,
        montoTotal = p_montoTotal,
        montoPropina = p_montoPropina,
        montoSinIGV = p_montoSinIGV,
        montoIGV = p_montoIGV,
        idPedido = p_idPedido
    WHERE idBoleta = p_id;
END //

CREATE PROCEDURE eliminarBoleta(IN p_id INT)
BEGIN
    DELETE FROM BOLETA WHERE idBoleta = p_id;
END //

CREATE PROCEDURE buscarBoletaPorId(IN p_id INT)
BEGIN
    SELECT * FROM BOLETA WHERE idBoleta = p_id;
END //

CREATE PROCEDURE listarBoletas()
BEGIN
    SELECT * FROM BOLETA;
END //

CREATE PROCEDURE insertarDetalleBoleta(
    IN p_nombreProducto VARCHAR(100),
    IN p_montoProducto DECIMAL(10,2),
    IN p_idComprobante INT
)
BEGIN
    INSERT INTO DETALLEBOLETA(nombreProducto, montoProducto, idComprobante)
    VALUES(p_nombreProducto, p_montoProducto, p_idComprobante);
END //
DELIMITER ; 