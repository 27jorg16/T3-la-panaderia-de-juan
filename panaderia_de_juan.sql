CREATE TABLE Productos (
    ProductoId INT PRIMARY KEY AUTO_INCREMENT,
    NombreProducto VARCHAR(100) NOT NULL,
    DescripcionProducto TEXT,
    PrecioProducto DECIMAL(10, 2) NOT NULL,
    StockProducto INT NOT NULL
);

CREATE TABLE Clientes (
    ClienteId INT PRIMARY KEY AUTO_INCREMENT,
    NombreCliente VARCHAR(100) NOT NULL,
    CorreoCliente VARCHAR(100) NOT NULL UNIQUE,
    TelefonoCliente VARCHAR(15),
    DireccionCliente VARCHAR(255) NOT NULL
);

CREATE TABLE Pedidos (
    PedidoId INT PRIMARY KEY AUTO_INCREMENT,
    ClienteId INT,
    FechaPedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    TotalPedido DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ClienteId) REFERENCES Clientes(ClienteId)
);

CREATE TABLE Proveedores (
    ProveedorId INT PRIMARY KEY AUTO_INCREMENT,
    NombreProveedor VARCHAR(100) NOT NULL,
    TelefonoProveedor VARCHAR(15),
    CorreoProveedor VARCHAR(100),
    DireccionProveedor VARCHAR(255)
);

CREATE TABLE Empleados (
    EmpleadoId INT PRIMARY KEY AUTO_INCREMENT,
    NombreEmpleado VARCHAR(100) NOT NULL,
    CargoEmpleado VARCHAR(50) NOT NULL,
    SalarioEmpleado DECIMAL(10, 2) NOT NULL
);

INSERT INTO Productos (NombreProducto, DescripcionProducto, PrecioProducto, StockProducto) VALUES
('Pan Francés', 'Pan crujiente ideal para el desayuno.', 0.50, 100),
('Baguette', 'Baguette artesanal, fresco y delicioso.', 1.20, 50),
('Torta de Chocolate', 'Torta de chocolate húmeda y rica.', 15.00, 30),
('Pan Integral', 'Pan saludable de trigo integral.', 0.80, 80),
('Pastel de Frutas', 'Pastel fresco con frutas de temporada.', 12.00, 20),
('Pan de Ajo', 'Pan con sabor a ajo y perejil.', 1.00, 40),
('Galletas de Mantequilla', 'Galletas crujientes con mantequilla.', 2.50, 60),
('Rosquillas', 'Rosquillas dulces, ideales para el café.', 1.50, 70);

INSERT INTO Clientes (NombreCliente, CorreoCliente, TelefonoCliente, DireccionCliente) VALUES
('Juan Pérez', 'juan.perez@example.com', '987654321', 'Calle Falsa 123'),
('Ana García', 'ana.garcia@example.com', '965432109', 'Av. Siempre Viva 456'),
('Carlos López', 'carlos.lopez@example.com', '912345678', 'Calle de los Olivos 789'),
('María Torres', 'maria.torres@example.com', '998877665', 'Pueblo de los Arboles 101'),
('Luis Fernández', 'luis.fernandez@example.com', '998123456', 'Calle 20 de Julio 202'),
('Laura Jiménez', 'laura.jimenez@example.com', '987654321', 'Av. Los Castaños 303'),
('Pedro Ruiz', 'pedro.ruiz@example.com', '965432109', 'Calle El Sol 404'),
('Sofía Méndez', 'sofia.mendez@example.com', '912345678', 'Calle del Río 505');

INSERT INTO Pedidos (ClienteId, FechaPedido, TotalPedido) VALUES
(1, '2022-01-01 10:30:00', 10.50),
(2, '2022-01-05 11:00:00', 5.00),
(3, '2022-01-10 12:15:00', 20.00),
(4, '2022-01-15 14:00:00', 15.00),
(5, '2022-01-20 09:45:00', 12.50),
(6, '2022-01-22 10:30:00', 8.00),
(7, '2022-01-25 16:00:00', 25.00),
(8, '2022-01-31 09:00:00', 7.50);

INSERT INTO Proveedores (NombreProveedor, TelefonoProveedor, CorreoProveedor, DireccionProveedor) VALUES
('Distribuidora Panes', '998877665', 'distribuidora.panes@example.com', 'Av. Panaderos 1'),
('Frutas Frescas S.A.', '912345678', 'frutasfrescas@example.com', 'Calle de las Frutas 2'),
('Lácteos del Valle', '965432109', 'lacteosvalle@example.com', 'Calle de la Leche 3'),
('Harinas y Más', '987654321', 'harinasymas@example.com', 'Av. Molinos 4'),
('Frescos del Campo', '912345678', 'frescoscampo@example.com', 'Calle Verde 5'),
('Bebidas Naturales', '998877665', 'bebidasnaturales@example.com', 'Calle del Agua 6'),
('Dulces y Postres', '998123456', 'dulcesypostres@example.com', 'Av. Dulce 7'),
('Granos y Cereales', '965432109', 'granosycereales@example.com', 'Calle de los Granos 8');

INSERT INTO Empleados (NombreEmpleado, CargoEmpleado, SalarioEmpleado) VALUES
('Juan Martínez', 'Panadero', 1500.00),
('Ana Torres', 'Vendedora', 1200.00),
('Luis Salazar', 'Gerente', 2000.00),
('Maria López', 'Asistente', 1000.00),
('Pedro Sánchez', 'Contador', 1800.00),
('Laura Ruiz', 'Cajera', 1100.00),
('Carlos Díaz', 'Repartidor', 1300.00),
('Sofía Rojas', 'Auxiliar', 900.00);

