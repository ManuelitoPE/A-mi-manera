USE Progra3AM;

-- Desactivar restricciones de claves foráneas temporalmente
SET FOREIGN_KEY_CHECKS = 0;

-- Eliminar datos de tablas dependientes primero
DELETE FROM DETALLEFACTURA;
DELETE FROM DETALLEBOLETA;
DELETE FROM RESERVA;
DELETE FROM FACTURA;
DELETE FROM BOLETA;
DELETE FROM LINEAPEDIDO;

-- Eliminar datos de tablas principales
DELETE FROM PEDIDO;
DELETE FROM PRODUCTO;
DELETE FROM TRABAJADOR;
DELETE FROM CUENTAUSUARIO;
DELETE FROM MESA;
DELETE FROM PERSONA_JURIDICA;
DELETE FROM PERSONA_NATURAL;

-- Reactivar restricciones de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

-- Insertar datos dummy en la tabla CUENTAUSUARIO
INSERT INTO CUENTAUSUARIO (nombreUsuario, contraseña, tipoUsuario)
VALUES 
    ('admin', 'admin123', 'Administrador'),
    ('mesero1', 'mesero123', 'Mesero'),
    ('cajero1', 'cajero123', 'Cajero');

-- Insertar datos dummy en la tabla TRABAJADOR
INSERT INTO TRABAJADOR (nombre, apellidoPaterno, apellidoMaterno, rol, idCuentaUsuario)
VALUES 
    ('Juan', 'Perez', 'Lopez', 'Mesero', 2),
    ('Maria', 'Gomez', 'Diaz', 'Cajero', 3);

-- Insertar datos dummy en la tabla MESA
INSERT INTO MESA (cantidadAsientos, estado)
VALUES 
    (4, 'LIBRE'),
    (6, 'OCUPADA'),
    (2, 'RESERVADA');

-- Insertar datos dummy en la tabla PRODUCTO
INSERT INTO PRODUCTO (nombre, descripcion, precioUnitario, TipoProducto)
VALUES 
    ('Ceviche', 'Plato típico peruano', 25.00, 'ENTRADA'),
    ('Lomo Saltado', 'Plato principal con carne y papas', 35.00, 'PLATO_PRINCIPAL'),
    ('Torta de Chocolate', 'Postre dulce', 15.00, 'POSTRE'),
    ('Inca Kola', 'Bebida gaseosa', 5.00, 'BEBIDA');

-- Insertar datos dummy en la tabla PEDIDO
INSERT INTO PEDIDO (fechaHora, estado, montoTotal, montoDescuento, idMesa, idMesero)
VALUES 
    ('2025-05-11 12:30:00', 'EN_ORDEN', 100.00, 10.00, 1, 1),
    ('2025-05-11 13:00:00', 'PAGADO', 50.00, 5.00, 2, 2);

-- Insertar datos dummy en la tabla LINEAPEDIDO
INSERT INTO LINEAPEDIDO (cantidad, montoParcial, descripcion, idPedido, idProducto)
VALUES 
    (2, 50.00, 'Ceviche para dos personas', 1, 1),
    (1, 35.00, 'Lomo Saltado', 1, 2),
    (1, 15.00, 'Torta de Chocolate', 2, 3),
    (2, 10.00, 'Inca Kola', 2, 4);

-- Insertar datos dummy en la tabla BOLETA
INSERT INTO BOLETA (fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, idPedido)
VALUES 
    ('2025-05-11 13:30:00', 'EFECTIVO', 50.00, 5.00, 42.37, 7.63, 2);

-- Insertar datos dummy en la tabla FACTURA
INSERT INTO FACTURA (fechaEmision, metodoPago, montoTotal, montoPropina, montoSinIGV, montoIGV, RUC, razonSocial, idPedido)
VALUES 
    ('2025-05-11 14:30:00', 'TARJETA', 100.00, 10.00, 84.75, 15.25, '20123456789', 'Empresa Dummy S.A.', 1);

-- Insertar datos dummy en la tabla PERSONA_NATURAL
INSERT INTO PERSONA_NATURAL (nombre, telefono, correo, DNI)
VALUES 
    ('Carlos Perez', '987654321', 'carlos.perez@example.com', '12345678'),
    ('Ana Gomez', '912345678', 'ana.gomez@example.com', '87654321');

-- Insertar datos dummy en la tabla PERSONA_JURIDICA
INSERT INTO PERSONA_JURIDICA (nombre, telefono, correo, RUC, razonSocial)
VALUES 
    ('Empresa ABC', '987654321', 'contacto@empresaabc.com', '20123456789', 'Empresa ABC S.A.C.'),
    ('Empresa XYZ', '912345678', 'info@empresaxyz.com', '20987654321', 'Empresa XYZ S.A.C.');

-- Insertar datos dummy en la tabla RESERVA
INSERT INTO RESERVA (fecha, horaInicio, horaFin, cantidadPersonas, estado, horaMaximaCancelacion, montoReserva, idPersonaNatural, idMesa)
VALUES 
    ('2025-05-15', '2025-05-15 12:00:00', '2025-05-15 14:00:00', 4, 'CONFIRMADA', '2025-05-14 12:00:00', 50.00, 1, 1),
    ('2025-05-16', '2025-05-16 18:00:00', '2025-05-16 20:00:00', 6, 'PENDIENTE', '2025-05-15 18:00:00', 75.00, 2, 2);

-- Insertar datos dummy en la tabla DETALLEBOLETA
INSERT INTO DETALLEBOLETA (nombreProducto, montoProducto, idComprobante)
VALUES 
    ('Ceviche', 25.00, 1),
    ('Inca Kola', 5.00, 1);

-- Insertar datos dummy en la tabla DETALLEFACTURA
INSERT INTO DETALLEFACTURA (nombreProducto, subtotalSinIGV, subtotalFinal, idComprobante)
VALUES 
    ('Lomo Saltado', 30.00, 35.40, 1),
    ('Torta de Chocolate', 12.50, 15.00, 1);