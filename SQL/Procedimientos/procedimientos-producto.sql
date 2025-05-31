USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarProducto;
DROP PROCEDURE IF EXISTS modificarProducto;
DROP PROCEDURE IF EXISTS eliminarProducto;
DROP PROCEDURE IF EXISTS buscarProductoPorId;
DROP PROCEDURE IF EXISTS listarProductos;

DELIMITER //
CREATE PROCEDURE insertarProducto(
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(1000),
    IN p_precioUnitario DECIMAL(10,2),
    IN p_idTipoProducto VARCHAR(20),
    OUT p_id INT
)
BEGIN
    INSERT INTO PRODUCTO(nombre, descripcion, precioUnitario, idTipoProducto)
    VALUES(p_nombre, p_descripcion, p_precioUnitario, p_idTipoProducto);
    SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarProducto(
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(1000),
    IN p_precioUnitario DECIMAL(10,2),
    IN p_idTipoProducto VARCHAR(20),
    IN p_id INT
)
BEGIN
    UPDATE PRODUCTO
    SET 
        nombre = p_nombre,
        descripcion = p_descripcion,
        precioUnitario = p_precioUnitario,
        idTipoProducto = p_idTipoProducto
    WHERE idProducto = p_id;
END //

CREATE PROCEDURE eliminarProducto(IN p_id INT)
BEGIN
    DELETE FROM PRODUCTO WHERE idProducto = p_id;
END //

CREATE PROCEDURE buscarProductoPorId(IN p_id INT)
BEGIN
    SELECT * FROM PRODUCTO WHERE idProducto = p_id;
END //

CREATE PROCEDURE listarProductos()
BEGIN
    SELECT * FROM PRODUCTO;
END //
DELIMITER ; 