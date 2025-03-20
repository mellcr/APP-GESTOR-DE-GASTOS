-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS mibanco;
USE mibanco;

-- Crear la tabla Gasto
CREATE TABLE IF NOT EXISTS Gasto (
    idGasto INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    motivo VARCHAR(255),
    fecha DATE NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    activo TINYINT(1) NOT NULL DEFAULT 1
);

-- Insertar datos de prueba
INSERT INTO Gasto (titulo, motivo, fecha, monto, activo) VALUES
('Alquiler', 'Pago mensual modificado', '2025-03-19', 1250.00, 0),
('Alquiler', 'Pago mensual', '2025-03-19', 1250.00, 0),
('Netflix', 'Pago mensual', '2025-03-19', 120.00, 1),
('HBOMax', 'Pago mensual', '2025-03-19', 120.00, 1),
('PrimeVideo', 'Pago mensual', '2025-11-20', 120.00, 1),
('PrimeVideo', 'Pago mensual', '2025-11-20', 120.00, 1),
('Tarjeta Credito', 'Pago mensual', '2025-03-20', 100.00, 1),
('Gasto Prueba', 'Prueba', '2025-03-20', 10000.00, 1),
('Compra Laptop', 'Renovacion de mi laptop', '2025-03-20', 3500.00, 1);
