-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2018 at 04:22 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agenda`
--

-- --------------------------------------------------------

--
-- Table structure for table `amigos`
--

CREATE TABLE `amigos` (
  `DOCUMENTO` bigint(50) NOT NULL,
  `TELEFONO` bigint(50) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `CORREO` varchar(50) NOT NULL,
  `DIRECCION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `amigos`
--

INSERT INTO `amigos` (`DOCUMENTO`, `TELEFONO`, `NOMBRE`, `CORREO`, `DIRECCION`) VALUES
(98081006873, 3107505022, 'Vanessa Corredor', 'vane@gmail.com', 'calle 56 a sur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amigos`
--
ALTER TABLE `amigos`
  ADD PRIMARY KEY (`DOCUMENTO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
