Roberto, [30/11/2021 22:43]
-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2021 a las 22:12:32
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: proyecto
--
CREATE DATABASE IF NOT EXISTS proyecto DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE proyecto;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla gastos
--

DROP TABLE IF EXISTS gastos;
CREATE TABLE gastos (
  idg int(11) NOT NULL,
  idu int(11) DEFAULT NULL,
  descripcion text DEFAULT NULL,
  monto_gastado float DEFAULT NULL,
  fecha date DEFAULT NULL,
  hora time DEFAULT NULL,
  imagen blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla gastos
--
INSERT INTO `gastos` (`idg`, `idu`, `descripcion`, `monto_gastado`, `fecha`, `hora`, `imagen`) VALUES

(1, 2, 'celular SamSung ', 2010.5, '2021-12-01', '18:29:55', NULL),
(2, 3, 'laptop', 8000.59, '2021-12-02', '10:10:00', NULL);




-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla ingresos
--

DROP TABLE IF EXISTS ingresos;
CREATE TABLE ingresos (
  idi int(11) NOT NULL,
  idu int(11) DEFAULT NULL,
  descripcion text DEFAULT NULL,
  monto_ingreso float DEFAULT NULL,
  fecha date DEFAULT NULL,
  hora time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla ingresos
--

INSERT INTO `ingresos` (`idi`, `idu`, `descripcion`, `monto_ingreso`, `fecha`, `hora`) VALUES
(1, 3, 'laptop ', 1500.7, '2021-06-28', '01:11:05'),
(2, 3, 'laptop ', 1500.7, '2021-06-28', '01:13:01');




-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla usuarios
--

DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  idu int(11) NOT NULL,
  nombre varchar(50) DEFAULT NULL,
  apellido varchar(50) DEFAULT NULL,
  CI int(12) DEFAULT NULL,
  telefono varchar(50) DEFAULT NULL,
  celular varchar(50) DEFAULT NULL,
  correo varchar(50) DEFAULT NULL,
  password varchar(20) DEFAULT NULL,
  nivel varchar(20) DEFAULT NULL,
  imagen blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla usuarios
--

INSERT INTO usuarios (idu, nombre, apellido, CI, telefono, celular, correo, password, nivel, imagen) VALUES
(1, 'Javier ', 'Huanca Quispe', 13150670, '73048506', '+591 73048506', 'javihq7@gmail.com', '13150670', 'Administrador', NULL),
(2, 'Roberto', 'Chapi Choque', 9952701, '63219040', '+591 63219040', 'robertchch21@gmail.com', '9952701', 'Usuario', NULL),
(3, 'Ruben ', 'Quispe Huayhu', 123456, '1234567890', '+591 60655925', 'ruben@gmail.com', '123456', 'Visitante', NULL);


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla gastos
--
ALTER TABLE gastos
  ADD PRIMARY KEY (idg),
  ADD KEY idu (idu);

Roberto, [30/11/2021 22:43]
--
-- Indices de la tabla ingresos
--
ALTER TABLE ingresos
  ADD PRIMARY KEY (idi),
  ADD KEY idu (idu);

--
-- Indices de la tabla usuarios
--
ALTER TABLE usuarios
  ADD PRIMARY KEY (idu);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla gastos
--
ALTER TABLE gastos
  MODIFY idg int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla ingresos
--
ALTER TABLE ingresos
  MODIFY idi int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla usuarios
--
ALTER TABLE usuarios
  MODIFY idu int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla gastos
--
ALTER TABLE gastos
  ADD CONSTRAINT gastos_ibfk_1 FOREIGN KEY (idu) REFERENCES usuarios (idu);

--
-- Filtros para la tabla ingresos
--
ALTER TABLE ingresos
  ADD CONSTRAINT ingresos_ibfk_1 FOREIGN KEY (idu) REFERENCES usuarios (idu);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;