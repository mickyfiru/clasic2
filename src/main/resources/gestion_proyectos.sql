-- Base de datos de gestión de proyectos
DROP DATABASE IF EXISTS gestion_proyectos;
CREATE DATABASE gestion_proyectos;
USE gestion_proyectos;

-- Tabla de departamentos
CREATE TABLE departamentos (
    id_depto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_depto VARCHAR(100) NOT NULL,
    centro_costo VARCHAR(30) NOT NULL,
    UNIQUE KEY uk_departamentos_centro_costo (centro_costo)
);

-- Tabla de empleados
CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    apellido VARCHAR(60) NOT NULL,
    cargo VARCHAR(80) NOT NULL,
    id_depto INT NOT NULL,
    CONSTRAINT fk_empleados_departamentos FOREIGN KEY (id_depto)
        REFERENCES departamentos (id_depto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE INDEX idx_empleados_departamento ON empleados(id_depto);

-- Tabla de tareas
CREATE TABLE tareas (
    id_tarea INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado_asignado INT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    horas_estimadas DECIMAL(8,2) NOT NULL,
    CONSTRAINT chk_tareas_estado CHECK (estado IN ('Pendiente', 'En progreso', 'En revisión', 'Completada')),
    CONSTRAINT chk_tareas_horas CHECK (horas_estimadas >= 0),
    CONSTRAINT fk_tareas_empleados FOREIGN KEY (id_empleado_asignado)
        REFERENCES empleados (id_empleado)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE INDEX idx_tareas_empleado ON tareas(id_empleado_asignado);

-- Datos iniciales
INSERT INTO departamentos (nombre_depto, centro_costo) VALUES
    ('Desarrollo de Software', 'CC-100'),
    ('Recursos Humanos', 'CC-200'),
    ('Finanzas', 'CC-300'),
    ('Infraestructura', 'CC-400');

INSERT INTO empleados (nombre, apellido, cargo, id_depto) VALUES
    ('Ana', 'García', 'Jefa de Proyecto', 1),
    ('Luis', 'Martínez', 'Desarrollador Senior', 1),
    ('María', 'López', 'Analista Funcional', 1),
    ('Carlos', 'Pérez', 'Especialista DevOps', 4),
    ('Sofía', 'Rodríguez', 'Generalista de RRHH', 2),
    ('Jorge', 'Hernández', 'Contador', 3);

INSERT INTO tareas (id_empleado_asignado, estado, horas_estimadas) VALUES
    (1, 'En progreso', 120.00),
    (2, 'Pendiente', 40.00),
    (3, 'Pendiente', 55.50),
    (4, 'En revisión', 32.00),
    (2, 'Completada', 16.75),
    (6, 'En progreso', 24.00);
