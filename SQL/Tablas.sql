-- Crear y seleccionar la base de datos
USE Progra3AM;

-- Tabla Cliente (base)
CREATE TABLE CLIENTE (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100)
);

-- Tablas de herencia para clientes
CREATE TABLE PERSONANATURAL (
    idCliente INT PRIMARY KEY,
    DNI VARCHAR(8) UNIQUE NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)
);

CREATE TABLE PERSONAJURIDICA (
    idCliente INT PRIMARY KEY,
    RUC VARCHAR(11) UNIQUE NOT NULL,
    razonSocial VARCHAR(100) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)
);

-- Tabla Mesa con estado ENUM
CREATE TABLE MESA (
    idMesa INT AUTO_INCREMENT PRIMARY KEY,
    cantidadAsientos INT NOT NULL CHECK (cantidadAsientos > 0),
    estado ENUM('LIBRE', 'OCUPADA', 'RESERVADA', 'NO_DISPONIBLE') DEFAULT 'LIBRE'
);

-- Tabla CuentaUsuario
CREATE TABLE CUENTAUSUARIO (
    idCuentaUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario VARCHAR(50) NOT NULL,
    contraseña VARCHAR(50) NOT NULL,
    tipoUsuario VARCHAR(20) NOT NULL
);

-- Tabla Personal (incluyendo meseros)
CREATE TABLE TRABAJADOR (
    idTrabajador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL CHECK (rol IN ('Mesero', 'Bartender', 'Cajero', 'Administrador')),
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50) NOT NULL,
    idCuentaUsuario INT UNIQUE,
    FOREIGN KEY (idCuentaUsuario) REFERENCES CUENTAUSUARIO(idCuentaUsuario)
);

-- Tabla Pedido con relación a mesero
CREATE TABLE PEDIDO (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    fechaHora DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('EN_ORDEN', 'CANCELADO', 'PAGADO') DEFAULT 'EN_ORDEN',
    montoTotal DECIMAL(10,2) NOT NULL,
    montoDescuento DECIMAL(10,2) DEFAULT 0,
    idMesa INT NOT NULL,
    idMesero INT NOT NULL,
    FOREIGN KEY (idMesa) REFERENCES MESA(idMesa),
    FOREIGN KEY (idMesero) REFERENCES TRABAJADOR(idTrabajador)
);

-- Tabla Producto
CREATE TABLE PRODUCTO (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(1000),
    precioUnitario DECIMAL(10,2) NOT NULL CHECK (precioUnitario > 0),
    TipoProducto ENUM('Comida', 'Bebida') NOT NULL
);

-- Tabla LineaPedido
CREATE TABLE LINEAPEDIDO (
    idLineaPedido INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    montoParcial DECIMAL(10,2) NOT NULL,
    descripcion VARCHAR(200),
    idPedido INT NOT NULL,
    idProducto INT NOT NULL,
    FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido),
    FOREIGN KEY (idProducto) REFERENCES PRODUCTO(idProducto)
);

-- Tablas de comprobantes separadas
CREATE TABLE BOLETA (
    idBoleta INT AUTO_INCREMENT PRIMARY KEY,
    fechaEmision DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodoPago ENUM('TARJETA', 'EFECTIVO') DEFAULT 'EFECTIVO',
    montoTotal DECIMAL(10,2) NOT NULL,
    montoPropina DECIMAL(10,2) DEFAULT 0,
    montoSinIGV DECIMAL(10,2) NOT NULL,
    montoIGV DECIMAL(10,2) NOT NULL,
    idPedido INT NOT NULL,
    FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido)
);

CREATE TABLE FACTURA (
    idFactura INT AUTO_INCREMENT PRIMARY KEY,
    fechaEmision DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodoPago ENUM('TARJETA', 'EFECTIVO') DEFAULT 'EFECTIVO',
    montoTotal DECIMAL(10,2) NOT NULL,
    montoPropina DECIMAL(10,2) DEFAULT 0,
    montoSinIGV DECIMAL(10,2) NOT NULL,
    montoIGV DECIMAL(10,2) NOT NULL,
    RUC VARCHAR(11) NOT NULL,
    razonSocial VARCHAR(100) NOT NULL,
    idPedido INT NOT NULL,
    FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido)
);

-- Tabla Reserva con estado ENUM
CREATE TABLE RESERVA (
    idReserva INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    horaInicio DATETIME NOT NULL,
    horaFin DATETIME NOT NULL,
    cantidadPersonas INT NOT NULL,
    estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') NOT NULL,
    horaMaximaCancelacion DATETIME NOT NULL,
    montoReserva DECIMAL(10,2) NOT NULL,
    idCliente INT NOT NULL,
    idMesa INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente),
    FOREIGN KEY (idMesa) REFERENCES MESA(idMesa)
);

-- Tabla DetalleBoleta
CREATE TABLE DETALLEBOLETA (
    idDetalleBoleta INT AUTO_INCREMENT PRIMARY KEY,
    nombreProducto VARCHAR(100) NOT NULL,
    montoProducto DECIMAL(10,2) NOT NULL,
    idComprobante INT NOT NULL,
    FOREIGN KEY (idComprobante) REFERENCES BOLETA(idBoleta)
);

-- Tabla DetalleFactura
CREATE TABLE DETALLEFACTURA (
    idDetalleFactura INT AUTO_INCREMENT PRIMARY KEY,
    nombreProducto VARCHAR(100) NOT NULL,
    subtotalSinIGV DECIMAL(10,2) NOT NULL,
    subtotalFinal DECIMAL(10,2) NOT NULL,
    idComprobante INT NOT NULL,
    FOREIGN KEY (idComprobante) REFERENCES FACTURA(idFactura)
);

-- Índices para optimización
CREATE INDEX idx_cliente_nombre ON CLIENTE(nombre);
CREATE INDEX idx_pedido_estado ON PEDIDO(estado);
CREATE INDEX idx_producto_tipo ON PRODUCTO(TipoProducto);
CREATE INDEX idx_mesa_estado ON MESA(estado); 