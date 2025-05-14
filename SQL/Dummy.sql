-- Insertar en PERSONA_NATURAL
INSERT INTO PERSONA_NATURAL (nombre, telefono, correo, DNI) VALUES
('Juan Pérez', '987654321', 'juan@example.com', '12345678'),
('María Gómez', '912345678', 'maria@example.com', '87654321'),
('Luis Torres', '956789123', 'luis@example.com', '56781234');

-- Insertar en PERSONA_JURIDICA
INSERT INTO PERSONA_JURIDICA (nombre, telefono, correo, RUC, razonSocial) VALUES
('Empresa A', '011223344', 'empresaA@example.com', '20123456789', 'Servicios S.A.'),
('Empresa B', '022334455', 'empresaB@example.com', '20987654321', 'Comercial EIRL'),
('Empresa C', '033445566', 'empresaC@example.com', '20567812345', 'Importaciones SAC');

-- Insertar en MESA
INSERT INTO MESA (cantidadAsientos, estado) VALUES
(4, 'LIBRE'),
(6, 'OCUPADA'),
(2, 'RESERVADA');

-- Insertar en CUENTAUSUARIO
INSERT INTO CUENTAUSUARIO (nombreUsuario, contraseña, tipoUsuario) VALUES
('usuario1', 'pass123', 'Mesero'),
('usuario2', 'clave456', 'Administrador'),
('usuario3', '123abc', 'Cajero');

-- Insertar en TRABAJADOR
INSERT INTO TRABAJADOR (nombre, rol, apellidoPaterno, apellidoMaterno, idCuentaUsuario) VALUES
('Carlos Herrera', 'Mesero', 'Herrera', 'López', 1),
('Ana Ramírez', 'Cajero', 'Ramírez', 'Díaz', 2),
('Sofía Castro', 'Bartender', 'Castro', 'Mendoza', 3);

-- Insertar en PEDIDO
INSERT INTO PEDIDO (fecha, estadoPedido, montoTotal, idMesa, idMesero) VALUES
(NOW(), 'EN_ORDEN', 150.00, 1, 1),
(NOW(), 'CANCELADO', 200.50, 2, 2),
(NOW(), 'ENTREGADO', 75.99, 3, 3);

-- Insertar en TIPO_PRODUCTO
INSERT INTO TIPO_PRODUCTO (descripcion) VALUES
('Bebidas'),
('Comida'),
('Postres');

-- Insertar en PRODUCTO
INSERT INTO PRODUCTO (nombre, descripcion, precioUnitario, idTipoProducto) VALUES
('Cerveza', 'Bebida alcohólica', 10.00, 1),
('Hamburguesa', 'Carne con pan y acompañamiento', 25.00, 2),
('Pastel de chocolate', 'Postre con relleno de chocolate', 15.00, 3);

-- Insertar en LINEAPEDIDO
INSERT INTO LINEAPEDIDO (cantidadProducto, idPedido, idProducto) VALUES
(2, 1, 1),
(3, 2, 2),
(1, 3, 3);

-- Insertar en RESERVA
INSERT INTO RESERVA (fecha, horaInicio, horaFin, cantidadPersonas, estado, horaMaximaCancelacion, montoReserva, idPersonaNatural, idPersonaJuridica, idMesa) VALUES
(CURDATE(), '2025-05-14 12:00:00', '2025-05-14 14:00:00', 4, 'CONFIRMADA', '2025-05-13 18:00:00', 50.00, 1, NULL, 1),
(CURDATE(), '2025-05-15 18:00:00', '2025-05-15 20:00:00', 6, 'PENDIENTE', '2025-05-14 18:00:00', 80.00, NULL, 1, 2),
(CURDATE(), '2025-05-16 20:00:00', '2025-05-16 22:00:00', 2, 'CANCELADA', '2025-05-15 18:00:00', 30.00, 3, NULL, 3);

-- Insertar en BOLETA
INSERT INTO BOLETA (fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, idPedido, idReserva) VALUES
(NOW(), 'TARJETA', 100.00, 10.00, 85.00, 15.00, 1, 1),
(NOW(), 'EFECTIVO', 200.00, 20.00, 170.00, 30.00, 2, 2),
(NOW(), 'TARJETA', 75.00, 5.00, 65.00, 10.00, 3, 3);

-- Insertar en FACTURA
INSERT INTO FACTURA (fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, RUC, razonSocial, idPedido, idReserva) VALUES
(NOW(), 'TARJETA', 150.00, 15.00, 127.50, 22.50, '20123456789', 'Servicios S.A.', 1, 1),
(NOW(), 'EFECTIVO', 220.00, 25.00, 187.00, 33.00, '20987654321', 'Comercial EIRL', 2, 2),
(NOW(), 'TARJETA', 90.00, 7.00, 76.50, 13.50, '20567812345', 'Importaciones SAC', 3, 3);

-- Insertar en DETALLEBOLETA
INSERT INTO DETALLEBOLETA (cantidadProducto, precioUnitario, subTotal, idProducto, idComprobantePago) VALUES
(2, 10.00, 20.00, 1, 1),
(3, 25.00, 75.00, 2, 2),
(1, 15.00, 15.00, 3, 3);

-- Insertar en DETALLEFACTURA
INSERT INTO DETALLEFACTURA (cantidadProducto, precioUnitario, subTotal, idProducto, idComprobantePago) VALUES
(2, 10.00, 20.00, 1, 1),
(3, 25.00, 75.00, 2, 2),
(1, 15.00, 15.00, 3, 3);