-- Desactivar claves foráneas temporalmente
SET SQL_SAFE_UPDATES = 0;

-- 1. Eliminar todos los datos
DELETE FROM DETALLEFACTURA;
DELETE FROM DETALLEBOLETA;
DELETE FROM FACTURA;
DELETE FROM BOLETA;
DELETE FROM RESERVA;
DELETE FROM LINEAPEDIDO;
DELETE FROM PRODUCTO;
DELETE FROM TIPO_PRODUCTO;
DELETE FROM PEDIDO;
DELETE FROM TRABAJADOR;
DELETE FROM CUENTAUSUARIO;
DELETE FROM MESA;
DELETE FROM PERSONA_JURIDICA;
DELETE FROM PERSONA_NATURAL;

-- 2. Reiniciar AUTO_INCREMENT
ALTER TABLE DETALLEFACTURA AUTO_INCREMENT = 1;
ALTER TABLE DETALLEBOLETA AUTO_INCREMENT = 1;
ALTER TABLE FACTURA AUTO_INCREMENT = 1;
ALTER TABLE BOLETA AUTO_INCREMENT = 1;
ALTER TABLE RESERVA AUTO_INCREMENT = 1;
ALTER TABLE LINEAPEDIDO AUTO_INCREMENT = 1;
ALTER TABLE PRODUCTO AUTO_INCREMENT = 1;
ALTER TABLE TIPO_PRODUCTO AUTO_INCREMENT = 1;
ALTER TABLE PEDIDO AUTO_INCREMENT = 1;
ALTER TABLE TRABAJADOR AUTO_INCREMENT = 1;
ALTER TABLE CUENTAUSUARIO AUTO_INCREMENT = 1;
ALTER TABLE MESA AUTO_INCREMENT = 1;
ALTER TABLE PERSONA_JURIDICA AUTO_INCREMENT = 1;
ALTER TABLE PERSONA_NATURAL AUTO_INCREMENT = 1;

-- Reactivar claves foráneas
SET SQL_SAFE_UPDATES = 1;

-- 3. Reinsertar todos los datos

-- PERSONA_NATURAL
INSERT INTO PERSONA_NATURAL (nombre, telefono, correo, DNI) VALUES
('Juan Pérez', '987654321', 'juan@example.com', '12345678'),
('María Gómez', '912345678', 'maria@example.com', '87654321'),
('Luis Torres', '956789123', 'luis@example.com', '56781234');

-- PERSONA_JURIDICA
INSERT INTO PERSONA_JURIDICA (nombre, telefono, correo, RUC, razonSocial) VALUES
('Empresa A', '011223344', 'empresaA@example.com', '20123456789', 'Servicios S.A.'),
('Empresa B', '022334455', 'empresaB@example.com', '20987654321', 'Comercial EIRL'),
('Empresa C', '033445566', 'empresaC@example.com', '20567812345', 'Importaciones SAC');

-- MESA
INSERT INTO MESA (cantidadAsientos, estado) VALUES
(4, 'LIBRE'),
(6, 'OCUPADA'),
(2, 'RESERVADA');

-- CUENTAUSUARIO
INSERT INTO CUENTAUSUARIO (nombreUsuario, contraseña, tipoUsuario) VALUES
('usuario1', 'pass123', 'Mesero'),
('usuario2', 'clave456', 'Administrador'),
('usuario3', '123abc', 'Cajero');

-- TRABAJADOR
INSERT INTO TRABAJADOR (nombre, rol, apellidoPaterno, apellidoMaterno, idCuentaUsuario) VALUES
('Carlos Herrera', 'Mesero', 'Herrera', 'López', 1),
('Ana Ramírez', 'Cajero', 'Ramírez', 'Díaz', 2),
('Sofía Castro', 'Bartender', 'Castro', 'Mendoza', 3);

-- PEDIDO
INSERT INTO PEDIDO (fecha, estadoPedido, montoTotal, idMesa, idMesero) VALUES
(NOW(), 'EN_ORDEN', 150.00, 1, 1),
(NOW(), 'CANCELADO', 200.50, 2, 2),
(NOW(), 'ENTREGADO', 75.99, 3, 3),
(NOW(), 'EN_ORDEN', 175.99, 2, 1),
(NOW(), 'EN_ORDEN', 120.99, 2, 1),
(NOW(), 'EN_ORDEN', 17.99, 2, 1),
(NOW(), 'EN_ORDEN', 45.99, 2, 1),
(NOW(), 'EN_ORDEN', 78.99, 2, 1);

-- TIPO_PRODUCTO
INSERT INTO TIPO_PRODUCTO (descripcion) VALUES
('Bebidas'),
('Comida'),
('Postres');

-- PRODUCTO
INSERT INTO PRODUCTO (nombre, descripcion, precioUnitario, idTipoProducto) VALUES
('Cerveza', 'Bebida alcohólica', 10.00, 1),
('Hamburguesa', 'Carne con pan y acompañamiento', 25.00, 2),
('Pastel de chocolate', 'Postre con relleno de chocolate', 15.00, 3);

-- LINEAPEDIDO
INSERT INTO LINEAPEDIDO (cantidadProducto, idPedido, idProducto) VALUES
(2, 1, 1),
(3, 2, 2),
(1, 3, 3);

-- RESERVA
INSERT INTO RESERVA (fecha, horaInicio, horaFin, cantidadPersonas, estado, horaMaximaCancelacion, montoReserva, idPersonaNatural, idPersonaJuridica, idMesa) VALUES
(CURDATE(), '2025-05-14 12:00:00', '2025-05-14 14:00:00', 4, 'CONFIRMADA', '2025-05-13 18:00:00', 50.00, 1, NULL, 1),
(CURDATE(), '2025-05-15 18:00:00', '2025-05-15 20:00:00', 6, 'PENDIENTE', '2025-05-14 18:00:00', 80.00, NULL, 1, 2),
(CURDATE(), '2025-05-16 20:00:00', '2025-05-16 22:00:00', 2, 'CANCELADA', '2025-05-15 18:00:00', 30.00, 3, NULL, 3);

-- BOLETA
INSERT INTO BOLETA (fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, idPedido, idReserva) VALUES
(NOW(), 'TARJETA', 100.00, 10.00, 85.00, 15.00, 1, 1),
(NOW(), 'EFECTIVO', 200.00, 20.00, 170.00, 30.00, 2, 2),
(NOW(), 'TARJETA', 75.00, 5.00, 65.00, 10.00, 3, 3);

-- FACTURA
INSERT INTO FACTURA (fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, RUC, razonSocial, idPedido, idReserva) VALUES
(NOW(), 'TARJETA', 150.00, 15.00, 127.50, 22.50, '20123456789', 'Servicios S.A.', 1, 1),
(NOW(), 'EFECTIVO', 220.00, 25.00, 187.00, 33.00, '20987654321', 'Comercial EIRL', 2, 2),
(NOW(), 'TARJETA', 90.00, 7.00, 76.50, 13.50, '20567812345', 'Importaciones SAC', 3, 3);

-- DETALLEBOLETA
INSERT INTO DETALLEBOLETA (cantidadProducto, precioUnitario, subTotal, idProducto, idComprobantePago) VALUES
(2, 10.00, 20.00, 1, 1),
(3, 25.00, 75.00, 2, 2),
(1, 15.00, 15.00, 3, 3);

-- DETALLEFACTURA
INSERT INTO DETALLEFACTURA (cantidadProducto, precioUnitario, subTotal, idProducto, idComprobantePago) VALUES
(2, 10.00, 20.00, 1, 1),
(3, 25.00, 75.00, 2, 2),
(1, 15.00, 15.00, 3, 3);
