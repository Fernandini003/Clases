CREATE DATABASE Tienda_DB;
USE Tienda_DB;

CREATE TABLE categoria (
    id_cate INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    frecuencia_compra INT
);

CREATE TABLE productos (
    id_prod INT AUTO_INCREMENT PRIMARY KEY, 
    nom_producto VARCHAR(20),
    stock_actual DECIMAL(10,2)
);

CREATE TABLE inventario (
    nro_inventario INT AUTO_INCREMENT PRIMARY KEY, 
    fecha DATE,
    costo_ingresos DECIMAL(10,2)
);

-- Inserción de 10 datos en la tabla categoria
INSERT INTO categoria (descripcion, frecuencia_compra) VALUES
('Electrónica', 50),
('Smartphones', 90),
('Accesorios', 120),
('Periféricos', 35),
('Redes', 25),
('Audio', 65),
('Video', 55),
('Almacenamiento', 70),
('Consolas', 20),
('Wearables', 60);

-- Inserción de 10 datos en la tabla productos
INSERT INTO productos (nom_producto, stock_actual) VALUES
('Laptop Acer', 18.00),
('iPhone 15', 50.00),
('Auriculares Sony', 40.00),
('Monitor HP', 25.00),
('Router Linksys', 15.00),
('Cámara GoPro', 12.00),
('SSD 1TB', 35.00),
('PlayStation 5', 8.00),
('Smartwatch Garmin', 22.00),
('Teclado Razer', 45.00);

-- Inserción de 10 datos en la tabla inventario
INSERT INTO inventario (fecha, costo_ingresos) VALUES
('2025-01-10', 1100.00),
('2025-02-05', 850.25),
('2025-03-01', 140.50),
('2025-03-20', 300.00),
('2025-04-15', 95.00),
('2025-05-01', 450.75),
('2025-05-20', 200.00),
('2025-06-01', 1300.00),
('2025-06-10', 270.25),
('2025-06-15', 85.50);

