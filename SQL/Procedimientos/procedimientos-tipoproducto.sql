USE Progra3AM;

DROP PROCEDURE IF EXISTS insertarTipoProducto;
DROP PROCEDURE IF EXISTS modificarTipoProducto;
DROP PROCEDURE IF EXISTS eliminarTipoProducto;
DROP PROCEDURE IF EXISTS buscarTipoProductoPorId;
DROP PROCEDURE IF EXISTS listarTipoProductos;

DELIMITER //
CREATE PROCEDURE insertarTipoProducto(
  IN p_descripcion VARCHAR(200),
  OUT p_id INT
)
BEGIN
  INSERT INTO TIPO_PRODUCTO(descripcion) VALUES (p_descripcion);
  SET p_id = LAST_INSERT_ID();
END //

CREATE PROCEDURE modificarTipoProducto(
  IN p_descripcion VARCHAR(200),
  IN p_id INT
)
BEGIN
  UPDATE TIPO_PRODUCTO
  SET
      descripcion = p_descripcion
  WHERE idTipoProducto = p_id;
END //

CREATE PROCEDURE eliminarTipoProducto(IN p_id INT)
BEGIN
    DELETE FROM TIPO_PRODUCTO WHERE idTipoProducto = p_id;
END //

CREATE PROCEDURE buscarTipoProductoPorId(IN p_id INT)
BEGIN
    SELECT * FROM TIPO_PRODUCTO WHERE idTipoProducto = p_id;
END //

CREATE PROCEDURE listarTipoProductos()
BEGIN
    SELECT * FROM TIPO_PRODUCTO;
END //
DELIMITER ;
