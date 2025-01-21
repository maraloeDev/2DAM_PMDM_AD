-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-02-2022 a las 12:18:39
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gregorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preinscripciones`
--

CREATE TABLE IF NOT EXISTS `preinscripciones` (
  `DNI` varchar(9) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDOS` varchar(30) NOT NULL,
  `FECHA` varchar(20) NOT NULL,
  `CODTITULO` varchar(3) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `CODTITULO` (`CODTITULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `preinscripciones`
--

INSERT INTO `preinscripciones` (`DNI`, `NOMBRE`, `APELLIDOS`, `FECHA`, `CODTITULO`) VALUES
('88888888V', 'PEDRO', 'GUITIERREZ MARIN', '13/01/2022', 'GM1'),
('99999999S', 'MARÍA', 'FERRERO PÉREZ', '12/01/2021', 'GS1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titulos`
--

CREATE TABLE IF NOT EXISTS `titulos` (
  `CODTITULO` varchar(3) NOT NULL,
  `ESPECIALIDAD` varchar(30) NOT NULL,
  `CICLO` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`CODTITULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `titulos`
--

INSERT INTO `titulos` (`CODTITULO`, `ESPECIALIDAD`, `CICLO`, `DESCRIPCION`) VALUES
('GM1', 'INFORMÁTICA', 'CFGM', 'SISTEMAS MICROINFORMATIOS Y REDES'),
('GS1', 'INFORMÁTICA', 'CFGS', 'DESARROLLO DE APLICACIONES MULTIPLATAFORMA');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `preinscripciones`
--
ALTER TABLE `preinscripciones`
  ADD CONSTRAINT `preinscripciones_ibfk_1` FOREIGN KEY (`CODTITULO`) REFERENCES `titulos` (`CODTITULO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
