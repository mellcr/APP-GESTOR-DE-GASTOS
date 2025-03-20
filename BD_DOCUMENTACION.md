# 📌 DAOImpl - Documentación  

## 📖 Descripción  
Este documento detalla la estructura y el script de creación de la tabla **Gasto**, utilizada en la aplicación **Gestor de Gastos**.  
La tabla **Gasto** almacena los registros de los gastos realizados, incluyendo su título, motivo, fecha, monto y un indicador de estado (activo/inactivo).  

---

## 📊 Estructura de la Tabla `Gasto`  

| Columna    | Tipo de dato       | Descripción                                       |
|------------|--------------------|---------------------------------------------------|
| `idGasto`  | INT AUTO_INCREMENT | Identificador único del gasto                     |
| `titulo`   | VARCHAR(255)       | Nombre corto del gasto                            |
| `motivo`   | VARCHAR(255)       | Razón o detalle del gasto                         |
| `fecha`    | DATE               | Fecha en la que se realizó el gasto               |
| `monto`    | DECIMAL(10,2)      | Monto gastado                                     |
| `activo`   | TINYINT(1)         | Indica si el gasto está activo (1) o inactivo (0) |

---

## 🚀 Script de Creación de la Tabla  

```sql
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
