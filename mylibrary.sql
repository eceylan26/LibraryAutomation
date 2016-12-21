-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 07 Haz 2016, 22:52:20
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `mylibrary`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `books`
--

INSERT INTO `books` (`bookid`, `bookname`, `author`, `availability`) VALUES
(1, 'Ucurtma Avcisi', 'Khaled Hosseini', 1),
(2, 'Ask', 'Elif Safak', 1),
(3, 'Olasiliksiz', 'Adam Fawer', 1),
(4, 'Sefiller', 'Victor Hugo', 1),
(5, 'Simyaci', 'Paulo Coelho', 1),
(6, 'Calikusu', 'Resat Nuri Guntekin', 1),
(7, 'Fareler ve Insanlar', 'John Steinbeck', 1),
(8, 'Da Vinci Sifresi', 'Dan Brown', 1),
(9, 'Donusum', 'Franz Kafka', 1),
(10, 'Aclik Oyunlari 1', 'Suzanne Collins', 1),
(11, 'Hayvan Ciftligi', 'George Orwell', 1),
(12, 'Kuyucakli Yusuf', 'Sabahattin Ali', 1),
(13, 'Beyaz Dis', 'Jack London', 1),
(14, 'Yaprak Dokumu', 'Resat Nuri Guntekin', 1),
(15, '1984', 'George Orwell', 1),
(16, 'Sol Ayagim', 'Christy Brown', 1),
(17, 'Safak Vakti', 'Stephenie Meyer', 1),
(18, 'Yeniay', 'Stephenie Meyer', 1),
(19, ' Su Cilgin Turkler', 'Turgut Ozakman', 1),
(20, 'Alayci Kus', 'Suzanne Collins', 1),
(21, 'Tutulma', 'Stephenie Meyer', 1),
(22, 'Bukre', 'Kahraman Tazeoglu', 1),
(23, 'Iskender', 'Elif Safak', 1),
(24, 'Kayip Gul', 'Serdar Ozkan', 1),
(26, 'Yabanci', 'Albert Camus', 1),
(27, 'Eroinle Dans', 'Canan Tan', 1),
(28, 'Sah ve Sultan', 'Iskender Pala', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `borrowrel`
--

CREATE TABLE IF NOT EXISTS `borrowrel` (
  `username` varchar(255) NOT NULL,
  `bookid` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `borrowrel`
--

INSERT INTO `borrowrel` (`username`, `bookid`, `comment`) VALUES
('tipsiz', 2, 'Cok guzeldi'),
('crazyboy', 27, 'Bu mal bir harika dostum'),
('crazyboy', 26, 'Bu kitapta yazar cok fazla dil bilgisini on planda tuttugu icin zor okunuyor'),
('crazyboy', 18, 'Mukemmel'),
('crazyboy', 21, 'Harika bir kitap boyle bisey gormedim.'),
('premses', 15, 'Idare eder');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `username` varchar(255) NOT NULL,
  `password` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `tel` double NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `members`
--

INSERT INTO `members` (`username`, `password`, `name`, `surname`, `tel`, `email`, `gender`) VALUES
('admin', 12345, 'Uraz', 'Turker', 5457854625, 'urazturker@gmail.com', 'male'),
('cavresamin', 548, 'Zehra', 'Seyhan', 5486458263, 'zehraseyhan@gmail.com', 'female'),
('civciv', 457, 'Sedef', 'Sengun', 5478965242, 'sdfsngn@gmail.com', 'female'),
('crazyboy', 124, 'Ersin', 'Ceylan', 5347896524, 'ersinceylan@gmail.com', 'male'),
('kahya1', 239, 'Emre', 'Kahya', 5462659853, 'emrekahya@gmail.com', 'male'),
('premses', 471, 'Aleyna', 'Guner', 5468514624, 'lynguner@gmail.com', 'female'),
('seyfo', 235, 'Seyfullah', 'Becerikli', 5478659231, 'seyfobecerikli@gmail.com', 'male'),
('sirine', 456, 'Ozlem', 'Aydar', 5468524619, 'ozlmaydar@gmail.com', 'female'),
('tipsiz', 666, 'Alper', 'Isikci', 5478545475, 'alperiskci@gmail.com', 'male');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
