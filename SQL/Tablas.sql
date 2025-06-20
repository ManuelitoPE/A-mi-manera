-- Crear y seleccionar la base de datos
USE Progra3AM;

-- Eliminar tablas existentes (en orden inverso para respetar dependencias)
DROP TABLE IF EXISTS DETALLEFACTURA;
DROP TABLE IF EXISTS DETALLEBOLETA;
DROP TABLE IF EXISTS FACTURA;
DROP TABLE IF EXISTS BOLETA;
DROP TABLE IF EXISTS RESERVA;
DROP TABLE IF EXISTS LINEAPEDIDO;
DROP TABLE IF EXISTS PRODUCTO;
DROP TABLE IF EXISTS PEDIDO;
DROP TABLE IF EXISTS TRABAJADOR;
DROP TABLE IF EXISTS CUENTAUSUARIO;
DROP TABLE IF EXISTS MESA;
DROP TABLE IF EXISTS PERSONA_JURIDICA;
DROP TABLE IF EXISTS PERSONA_NATURAL;
DROP TABLE IF EXISTS TIPO_PRODUCTO;

-- Tabla Persona Natural
CREATE TABLE PERSONA_NATURAL (
    idPersonaNatural INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100),
    DNI VARCHAR(8) UNIQUE NOT NULL
);

-- Tabla Persona Jurídica
CREATE TABLE PERSONA_JURIDICA (
    idPersonaJuridica INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100),
    RUC VARCHAR(11) UNIQUE NOT NULL,
    razonSocial VARCHAR(100) NOT NULL
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
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    estadoPedido ENUM('EN_ORDEN', 'CANCELADO', 'ENTREGADO') DEFAULT 'EN_ORDEN',
    montoTotal DECIMAL(10,2) NOT NULL,
    idMesa INT NOT NULL,
    idMesero INT NOT NULL,
    FOREIGN KEY (idMesa) REFERENCES MESA(idMesa),
    FOREIGN KEY (idMesero) REFERENCES TRABAJADOR(idTrabajador)
);

-- Tabla tipoProducto
CREATE TABLE TIPO_PRODUCTO (
	idTipoProducto INT AUTO_INCREMENT PRIMARY KEY,
	descripcion VARCHAR(200) NOT NULL
);

-- Tabla Producto
CREATE TABLE PRODUCTO (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(1000),
    precioUnitario DECIMAL(10,2) NOT NULL CHECK (precioUnitario > 0),
    idTipoProducto INT NOT NULL,
    FOREIGN KEY (idTipoProducto) REFERENCES TIPO_PRODUCTO(idTipoProducto)
);

-- Tabla LineaPedido
CREATE TABLE LINEAPEDIDO (
    idLineaPedido INT AUTO_INCREMENT PRIMARY KEY,
    cantidadProducto INT NOT NULL CHECK (cantidadProducto > 0),
    idPedido INT NOT NULL,
    idProducto INT NOT NULL,
    FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido),
    FOREIGN KEY (idProducto) REFERENCES PRODUCTO(idProducto)
);


-- Tabla Reserva con estado ENUM
CREATE TABLE RESERVA (
    idReserva INT AUTO_INCREMENT PRIMARY KEY,
    fechaHoraInicio DATETIME NOT NULL,
    fechaHoraFin DATETIME NOT NULL,
    cantidadPersonas INT NOT NULL,
    estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') NOT NULL,
    montoReserva DECIMAL(10,2) NOT NULL,
    idPersonaNatural INT,
    idPersonaJuridica INT,
    idMesa INT NOT NULL,
    FOREIGN KEY (idPersonaNatural) REFERENCES PERSONA_NATURAL(idPersonaNatural),
    FOREIGN KEY (idPersonaJuridica) REFERENCES PERSONA_JURIDICA(idPersonaJuridica),
    FOREIGN KEY (idMesa) REFERENCES MESA(idMesa)
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
    FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido),
	idReserva INT NOT NULL,
	FOREIGN KEY (idReserva) REFERENCES RESERVA(idReserva)
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
    FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido),
    idReserva INT NOT NULL,
	FOREIGN KEY (idReserva) REFERENCES RESERVA(idReserva)
);


-- Tabla DetalleBoleta

CREATE TABLE DETALLEBOLETA (
    idDetalleBoleta INT AUTO_INCREMENT PRIMARY KEY,
    cantidadProducto INT NOT NULL,
	precioUnitario DECIMAL(10,2) NOT NULL,
	subTotal DECIMAL(10,2) NOT NULL,
	idProducto INT NOT NULL,
	idComprobantePago INT NOT NULL,
    FOREIGN KEY (idProducto) REFERENCES PRODUCTO(idProducto),
    FOREIGN KEY (idComprobantePago) REFERENCES BOLETA(idBoleta)
);

-- Tabla DetalleFactura
CREATE TABLE DETALLEFACTURA (
    idDetalleFactura INT AUTO_INCREMENT PRIMARY KEY,
    cantidadProducto INT NOT NULL,
    precioUnitario DECIMAL(10,2) NOT NULL,
    subTotal DECIMAL(10,2) NOT NULL,
    idProducto INT NOT NULL,
    idComprobantePago INT NOT NULL,
    FOREIGN KEY (idComprobantePago) REFERENCES FACTURA(idFactura),
    FOREIGN KEY (idProducto) REFERENCES PRODUCTO(idProducto)
);


-- Índices para optimización
CREATE INDEX idx_persona_natural_nombre ON PERSONA_NATURAL(nombre);
CREATE INDEX idx_persona_juridica_nombre ON PERSONA_JURIDICA(nombre);
CREATE INDEX idx_pedido_estado ON PEDIDO(estadoPedido);
CREATE INDEX idx_mesa_estado ON MESA(estado); 
