-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS sede;
USE sede;

-- Tabla de entidades administrativas
CREATE TABLE entidades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla de registros
-- Tabla de registros corregida
CREATE TABLE registros (
    num_registro INT PRIMARY KEY,
    DNI_solicitante VARCHAR(15) NOT NULL,
    Nombre_solicitante VARCHAR(100) NOT NULL,
    apellidos_solicitante VARCHAR(200) NOT NULL,
    tramite VARCHAR(100) NOT NULL,
    entidad INT NOT NULL,
    FOREIGN KEY (entidad) REFERENCES entidades(id)
);


-- Insertar algunas entidades de ejemplo
INSERT INTO entidades (nombre) VALUES 
('INSPECCIÓN EDUCATIVA INFANTIL'),
('INSPECCIÓN EDUCATIVA PRIMARIA'),
('INSPECCIÓN EDUCATIVA SECUNDARIO'),
('INSPECCIÓN EDUCATIVA BACHILLERATO'),
('INSPECCIÓN EDUCATIVA FP'),
('CONSEJERÍA DE EDUCACIÓN'),
('MINISTERIO DE EDUCACIÓN Y CIENCIA');
