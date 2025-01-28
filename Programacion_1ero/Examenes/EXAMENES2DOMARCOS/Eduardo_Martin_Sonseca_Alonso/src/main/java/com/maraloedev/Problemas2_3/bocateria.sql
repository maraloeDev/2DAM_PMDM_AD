SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

 
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bocateria`
--
CREATE DATABASE `bocateria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bocateria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bebidas`
--

CREATE TABLE IF NOT EXISTS `bebidas` (
  `id_bebida` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_bebida` varchar(20) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_bebida`),
  UNIQUE KEY `id_bebida` (`id_bebida`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `bebidas`
--

INSERT INTO `bebidas` (`id_bebida`, `nombre_bebida`, `precio`) VALUES
(1, 'Agua', '1.00'),
(2, 'Cerveza', '1.50'),
(3, 'Coca cola', '1.50'),
(4, 'Naranza', '1.50'),
(5, 'Limón', '1.50'),
(6, 'Zumo', '1.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bocadillos`
--

CREATE TABLE IF NOT EXISTS `bocadillos` (
  `id_bocadillo` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_bocadillo` varchar(30) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_bocadillo`),
  UNIQUE KEY `id_bocadillo` (`id_bocadillo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `bocadillos`
--

INSERT INTO `bocadillos` (`id_bocadillo`, `nombre_bocadillo`, `precio`) VALUES
(1, 'Jamón serrano', '3.50'),
(2, 'York queso', '2.50'),
(3, 'Tortilla patata', '2.00'),
(4, 'Salchichas', '2.00'),
(5, 'Vegetal', '2.75'),
(6, 'Pollo', '3.00'),
(7, 'Lomo pimiento', '3.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `nombre_empleado` varchar(30) NOT NULL,
  `comision` decimal(5,2) NOT NULL,
  `cod_empleado` varchar(3) NOT NULL,
  PRIMARY KEY (`cod_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`nombre_empleado`, `comision`, `cod_empleado`) VALUES
('Luis', '15.75', 'E1'),
('Marta', '5.15', 'E2'),
('Carlos', '3.25', 'E3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `otros`
--

CREATE TABLE IF NOT EXISTS `otros` (
  `id_producto` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(30) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto` (`id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `otros`
--

INSERT INTO `otros` (`id_producto`, `nombre_producto`, `precio`) VALUES
(1, 'Ensalada', '3.50'),
(2, 'Patatas', '1.50'),
(3, 'Aros cebolla', '1.00'),
(4, 'Postre', '3.50');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
