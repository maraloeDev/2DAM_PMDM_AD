-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2024 a las 13:36:24
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test covid gf`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_sintomas`
--

CREATE TABLE `tabla_sintomas` (
  `fiebre` int(11) NOT NULL,
  `tos_seca` int(11) NOT NULL,
  `diarrea` int(11) NOT NULL,
  `dolor_muscular` int(11) NOT NULL,
  `perdida_olfato` int(11) NOT NULL,
  `id_sintomas` int(11) NOT NULL COMMENT 'PRIMARY KEY'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tabla_sintomas`
--
ALTER TABLE `tabla_sintomas`
  ADD PRIMARY KEY (`id_sintomas`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tabla_sintomas`
--
ALTER TABLE `tabla_sintomas`
  MODIFY `id_sintomas` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PRIMARY KEY';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
