-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2024 at 02:59 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `judul` varchar(30) NOT NULL,
  `alur` double NOT NULL,
  `penokohan` double NOT NULL,
  `akting` double NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES
('Attack on Titan', 5, 4, 4, 4.333),
('BA the Animation', 3.5, 4, 4.2, 3.9),
('Chainsaw Man', 3, 5, 4, 4),
('Demon Slayer', 4, 4, 5, 4.333),
('Evangelion', 4, 1, 3, 2.667),
('Frieren : Beyond\'s Journey End', 5, 5, 4.5, 4.833),
('Initial D', 3, 3.9, 5, 3.967),
('Jojo Bizzare Adventure', 3, 5, 5, 4.333),
('Jujutsu Kaisen', 3, 4, 3.5, 3.5),
('Made in Abyss', 4, 4, 4, 4),
('Naruto Shippuden', 2, 3.5, 3.4, 2.967),
('No Game No Life', 3.8, 4.1, 4.4, 4.1),
('Plastic Memories', 3.75, 4.1111, 4.555, 4.139),
('Spy x Family', 3.2, 4.7, 5, 4.3),
('Sword Art Online', 1, 3, 3, 2.333),
('Vinland Saga', 4.3, 5, 4, 4.433),
('Violet Evergarden', 4, 4, 4.9, 4.3),
('Weathering With You', 3, 3.5, 4, 3.5),
('Your Name', 5, 3.9, 4.5, 4.467),
('Yuru Camp', 4.3, 4.1, 5, 4.467);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD UNIQUE KEY `judul` (`judul`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
