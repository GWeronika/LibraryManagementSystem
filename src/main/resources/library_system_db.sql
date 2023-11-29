-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Lis 29, 2023 at 08:56 PM
-- Wersja serwera: 10.4.28-MariaDB
-- Wersja PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_system_db`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `email`, `password`) VALUES
(1, 'jan.kowalski@example.com', 'password1'),
(2, 'anna.nowak@example.com', 'password2'),
(3, 'robert.jankowski@example.com', 'password3'),
(4, 'emilia.wisniewska@example.com', 'password4'),
(5, 'michal.brazowski@example.com', 'password5'),
(6, 'amanda.miler@example.com', 'password6'),
(7, 'daniel.dawidowski@example.com', 'password7'),
(8, 'zofia.pasinska@example.com', 'password8'),
(9, 'rafal.anderson@example.com', 'password9'),
(10, 'joanna.tatrzanska@example.com', 'password10'),
(1000, 'rozalia.przybylska.admin@example.com', 'adminpassword'),
(1001, 'adam.malinowski@example.com', '100001'),
(1002, 'maria.nowak@example.com', '100002'),
(1003, 'bartosz.zajac@example.com', '100003'),
(1004, 'cecylia.szymanska@example.com', '100004'),
(1005, 'damian.kaczmarek@example.com', '100005'),
(1006, 'eliza.gorska@example.com', '100006'),
(1007, 'franciszek.grabowski@example.com', '100007'),
(1008, 'gabriela.pawlak@example.com', '100008'),
(1009, 'henryk.zielinski@example.com', '100009'),
(1010, 'izabela.zawadzka@example.com', '100010'),
(1011, 'jan.nowak@example.com', '100011'),
(1012, 'katarzyna.kowalczyk@example.com', '100012'),
(1013, 'leszek.lewandowski@example.com', '100013'),
(1014, 'monika.mazurek@example.com', '100014'),
(1015, 'norbert.nowicki@example.com', '100015'),
(1016, 'olga.kolodziej@example.com', '100016'),
(1017, 'piotr.glowacki@example.com', '100017'),
(1018, 'krzysztof.kwiatkowski@example.com', '100018'),
(1019, 'renata.rutkowska@example.com', '100019'),
(1020, 'sebastian.sadowski@example.com', '100020'),
(1021, 'teresa.tomczak@example.com', '100021'),
(1022, 'urszula.urbanek@example.com', '100022'),
(1023, 'waldemar.wojcik@example.com', '100023');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `title`, `author`) VALUES
(1, 'Pan Wołodyjowski', 'Henryk Sienkiewicz'),
(2, '1984', 'George Orwell'),
(3, 'Erystyka, czyli sztuka prowadzenia sporów', 'Artur Schopenhauer'),
(4, 'Wielki Gatsby', 'F. Scott Fitzgerald'),
(5, 'Rozprawa o metodzie', 'Rene Descartes'),
(6, 'Brzydkie kaczątko', 'Hans Christian Andersen'),
(7, 'Władca Pierścieni', 'J.R.R. Tolkien'),
(8, 'Duma i uprzedzenie', 'Jane Austen'),
(9, 'Wiele hałasu o nic', 'William Shakespeare'),
(10, 'Opowieści z Narnii', 'C.S. Lewis'),
(11, 'Zbrodnia i kara', 'Fyodor Dostoevsky'),
(12, 'Moby Dick', 'Herman Melville'),
(13, 'Odyseja', 'Homer'),
(14, 'Frankenstein', 'Mary Shelley'),
(15, 'Robinson Crusoe', 'Daniel Defoe');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `copy`
--

CREATE TABLE `copy` (
  `copy_id` int(11) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `release_year` int(11) NOT NULL,
  `format` enum('BOOK','EBOOK') NOT NULL,
  `language` varchar(255) NOT NULL,
  `blurb` text DEFAULT NULL,
  `status` enum('AVAILABLE','UNAVAILABLE') NOT NULL,
  `library_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `copy`
--

INSERT INTO `copy` (`copy_id`, `publisher`, `isbn`, `release_year`, `format`, `language`, `blurb`, `status`, `library_id`, `book_id`) VALUES
(1, 'Wydawnictwo XYZ', '9781234567855', 2022, 'BOOK', 'Polski', 'Opis egzemplarza 1', 'AVAILABLE', 1, 1),
(2, 'Inne Wydawnictwo', '9782345678901', 2021, 'BOOK', 'Angielski', 'Opis egzemplarza 2', 'AVAILABLE', 1, 2),
(3, 'Wydawnictwo ABC', '9783456789436', 2020, 'BOOK', 'Polski', 'Opis egzemplarza 3', 'UNAVAILABLE', 2, 3),
(4, 'Nowoczesne Wydawnictwo', '9784567890523', 2019, 'BOOK', 'Angielski', 'Opis egzemplarza 4', 'AVAILABLE', 2, 4),
(5, 'Książki Świata', '9785678907234', 2022, 'EBOOK', 'Polski', 'Opis egzemplarza 5', 'AVAILABLE', 3, 5),
(6, 'Wydawnictwo XYZ', '9786789012645', 2021, 'BOOK', 'Angielski', 'Opis egzemplarza 6', 'UNAVAILABLE', 3, 6),
(7, 'Inne Wydawnictwo', '9787890123486', 2020, 'BOOK', 'Polski', 'Opis egzemplarza 7', 'AVAILABLE', 4, 7),
(8, 'Wydawnictwo ABC', '9788901234560', 2019, 'BOOK', 'Angielski', 'Opis egzemplarza 8', 'UNAVAILABLE', 4, 8),
(9, 'Nowoczesne Wydawnictwo', '9789012345679', 2022, 'BOOK', 'Polski', 'Opis egzemplarza 9', 'AVAILABLE', 5, 9),
(10, 'Książki Świata', '9780123456784', 2021, 'BOOK', 'Angielski', 'Opis egzemplarza 10', 'AVAILABLE', 5, 10),
(11, 'Wydawnictwo XYZ', '9781234567895', 2020, 'BOOK', 'Rosyjski', 'Opis egzemplarza 11', 'AVAILABLE', 1, 11),
(12, 'Inne Wydawnictwo', '9782345678971', 2019, 'BOOK', 'Polski', 'Opis egzemplarza 12', 'UNAVAILABLE', 1, 12),
(13, 'Wydawnictwo ABC', '9783456789012', 2022, 'BOOK', 'Polski', 'Opis egzemplarza 13', 'AVAILABLE', 2, 13),
(14, 'Nowoczesne Wydawnictwo', '9784567890123', 2021, 'BOOK', 'Angielski', 'Opis egzemplarza 14', 'AVAILABLE', 2, 14),
(15, 'Książki Świata', '9785678901234', 2020, 'BOOK', 'Polski', 'Opis egzemplarza 15', 'UNAVAILABLE', 3, 15),
(16, 'Wydawnictwo XYZ', '9786789012345', 2019, 'EBOOK', 'Polski', 'Opis egzemplarza 16', 'AVAILABLE', 3, 1),
(17, 'Inne Wydawnictwo', '9787890123456', 2022, 'BOOK', 'Polski', 'Opis egzemplarza 17', 'AVAILABLE', 4, 2),
(18, 'Wydawnictwo ABC', '9788901234567', 2021, 'BOOK', 'Francuski', 'Opis egzemplarza 18', 'AVAILABLE', 4, 5),
(19, 'Nowoczesne Wydawnictwo', '9789012345678', 2020, 'EBOOK', 'Polski', 'Opis egzemplarza 19', 'AVAILABLE', 5, 6),
(20, 'Książki Świata', '9780123456789', 2019, 'BOOK', 'Polski', 'Opis egzemplarza 20', 'UNAVAILABLE', 5, 7),
(21, 'Wydawnictwo XYZ', '9781234567890', 2022, 'BOOK', 'Polski', 'Opis egzemplarza 21', 'AVAILABLE', 1, 10),
(22, 'Inne Wydawnictwo', '9782345678931', 2021, 'BOOK', 'Polski', 'Opis egzemplarza 22', 'AVAILABLE', 1, 11),
(23, 'Wydawnictwo ABC', '9783456789011', 2020, 'EBOOK', 'Polski', 'Opis egzemplarza 23', 'AVAILABLE', 2, 13),
(24, 'Nowoczesne Wydawnictwo', '9784567890183', 2019, 'EBOOK', 'Polski', 'Opis egzemplarza 24', 'AVAILABLE', 2, 14),
(25, 'Książki Świata', '9785678901284', 2022, 'BOOK', 'Polski', 'Opis egzemplarza 25', 'AVAILABLE', 3, 2),
(26, 'Wydawnictwo XYZ', '9786789012045', 2021, 'BOOK', 'Polski', 'Opis egzemplarza 26', 'AVAILABLE', 3, 6),
(27, 'Inne Wydawnictwo', '9787890123956', 2020, 'BOOK', 'Polski', 'Opis egzemplarza 27', 'UNAVAILABLE', 4, 7),
(28, 'Wydawnictwo ABC', '9788901234507', 2019, 'BOOK', 'Polski', 'Opis egzemplarza 28', 'AVAILABLE', 4, 13);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone_number` varchar(13) NOT NULL,
  `position` enum('MANAGER','LIBRARIAN') NOT NULL,
  `library_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `first_name`, `last_name`, `address`, `phone_number`, `position`, `library_id`, `account_id`) VALUES
(11, 'Jan', 'Kowalski', 'ul. Główna 123', '+48123456789', 'MANAGER', 1, 1),
(12, 'Anna', 'Nowak', 'ul. Dębowa 456', '+48451545145', 'LIBRARIAN', 2, 2),
(13, 'Robert', 'Jankowski', 'ul. Sosnowa 789', '+48789289489', 'LIBRARIAN', 3, 3),
(14, 'Emilia', 'Wiśniewska', 'ul. Lipowa 101', '+48123948576', 'LIBRARIAN', 4, 4),
(15, 'Michał', 'Brązowski', 'ul. Modrzewiowa 202', '+48987654444', 'MANAGER', 5, 5),
(16, 'Amanda', 'Miler', 'ul. Brzozowa 303', '+48111222334', 'LIBRARIAN', 1, 6),
(17, 'Daniel', 'Dawidowski', 'ul. Cedrowa 404', '+48444555667', 'LIBRARIAN', 2, 7),
(18, 'Zofia', 'Pasińska', 'ul. Stumilowa 100', '+48777888900', 'MANAGER', 3, 8),
(19, 'Rafał', 'Anderson', 'ul. Orzechowa 606', '+48123456790', 'LIBRARIAN', 4, 9),
(20, 'Joanna', 'Tatrzańska', 'ul. Świerkowa 707', '+48987654322', 'LIBRARIAN', 5, 10);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `library`
--

CREATE TABLE `library` (
  `library_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `phone_number` varchar(13) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `library`
--

INSERT INTO `library` (`library_id`, `name`, `location`, `phone_number`, `email`) VALUES
(1, 'Filia Wierzba', 'Adres Wierzba', '+4812223353', 'wierzba@example.com'),
(2, 'Filia Dąb', 'Adres Dąb', '+4845556606', 'dab@example.com'),
(3, 'Filia Sosna', 'Adres Sosna', '+4874888999', 'sosna@example.com'),
(4, 'Filia Jesion', 'Adres Jesion', '+4834567869', 'jesion@example.com'),
(5, 'Filia Topola', 'Adres Topola', '+4876543215', 'topola@example.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `library_opening`
--

CREATE TABLE `library_opening` (
  `library_opening_id` int(11) NOT NULL,
  `library_id` int(11) DEFAULT NULL,
  `opening_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `library_opening`
--

INSERT INTO `library_opening` (`library_opening_id`, `library_id`, `opening_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 2, 1),
(7, 2, 2),
(8, 2, 4),
(9, 2, 5),
(10, 2, 6),
(11, 3, 1),
(12, 3, 2),
(13, 3, 3),
(14, 3, 4),
(15, 3, 5),
(16, 3, 7),
(17, 4, 2),
(18, 4, 3),
(19, 4, 5),
(20, 5, 1),
(21, 5, 3),
(22, 5, 5),
(23, 5, 7);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `loan`
--

CREATE TABLE `loan` (
  `loan_id` int(11) NOT NULL,
  `loan_date` date NOT NULL,
  `return_date` date NOT NULL,
  `status` enum('ACTIVE','RETURNED','OVERDUE') NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `copy_id` int(11) DEFAULT NULL,
  `reader_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `opening`
--

CREATE TABLE `opening` (
  `opening_id` int(11) NOT NULL,
  `day` enum('MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY') NOT NULL,
  `open_hour` time NOT NULL,
  `close_hour` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `opening`
--

INSERT INTO `opening` (`opening_id`, `day`, `open_hour`, `close_hour`) VALUES
(1, 'MONDAY', '08:00:00', '16:00:00'),
(2, 'TUESDAY', '08:00:00', '16:00:00'),
(3, 'WEDNESDAY', '08:00:00', '16:00:00'),
(4, 'THURSDAY', '08:00:00', '16:00:00'),
(5, 'FRIDAY', '08:00:00', '16:00:00'),
(6, 'SATURDAY', '08:00:00', '16:00:00'),
(7, 'SATURDAY', '10:00:00', '14:00:00');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `status` enum('REMAINING','READY','CANCELLED') NOT NULL,
  `reader_id` int(11) DEFAULT NULL,
  `copy_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reader`
--

CREATE TABLE `reader` (
  `reader_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone_number` varchar(13) NOT NULL,
  `library_card_number` int(11) NOT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reader`
--

INSERT INTO `reader` (`reader_id`, `first_name`, `last_name`, `address`, `phone_number`, `library_card_number`, `account_id`) VALUES
(1, 'Adam', 'Malinowski', 'ul. Leśna 1', '111222333', 100001, 1001),
(2, 'Maria', 'Nowak', 'ul. Parkowa 2', '444555666', 100002, 1002),
(3, 'Bartosz', 'Zając', 'ul. Kwiatowa 3', '777888999', 100003, 1003),
(4, 'Cecylia', 'Szymańska', 'ul. Słoneczna 4', '123456789', 100004, 1004),
(5, 'Damian', 'Kaczmarek', 'ul. Różana 5', '987654321', 100005, 1005),
(6, 'Eliza', 'Górska', 'ul. Bławatną 6', '111222334', 100006, 1006),
(7, 'Franciszek', 'Grabowski', 'ul. Polna 7', '444555667', 100007, 1007),
(8, 'Gabriela', 'Pawlak', 'ul. Zielona 8', '777888900', 100008, 1008),
(9, 'Henryk', 'Zieliński', 'ul. Miodowa 9', '123456790', 100009, 1009),
(10, 'Izabela', 'Zawadzka', 'ul. Słowackiego 10', '987654322', 100010, 1010),
(11, 'Jan', 'Nowak', 'ul. Długa 11', '111222335', 100011, 1011),
(12, 'Katarzyna', 'Kowalczyk', 'ul. Krótka 12', '444555668', 100012, 1012),
(13, 'Leszek', 'Lewandowski', 'ul. Wąska 13', '777888901', 100013, 1013),
(14, 'Monika', 'Mazurek', 'ul. Szybka 14', '123456791', 100014, 1014),
(15, 'Norbert', 'Nowicki', 'ul. Wiosenna 15', '987654323', 100015, 1015),
(16, 'Olga', 'Kołodziej', 'ul. Jesienna 16', '111222336', 100016, 1016),
(17, 'Piotr', 'Głowacki', 'ul. Letnia 17', '444555669', 100017, 1017),
(18, 'Krzysztof', 'Kwiatkowski', 'ul. Zimowa 18', '777888902', 100018, 1018),
(19, 'Renata', 'Rutkowska', 'ul. Słowikowa 19', '123456792', 100019, 1019),
(20, 'Sebastian', 'Sadowski', 'ul. Orzechowa 20', '987654324', 100020, 1020),
(21, 'Teresa', 'Tomczak', 'ul. Malinowa 21', '111222337', 100021, 1021),
(22, 'Urszula', 'Urbanek', 'ul. Brzozowa 22', '444555670', 100022, 1022),
(23, 'Waldemar', 'Wójcik', 'ul. Cedrowa 23', '777888903', 100023, 1023);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indeksy dla tabeli `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Indeksy dla tabeli `copy`
--
ALTER TABLE `copy`
  ADD PRIMARY KEY (`copy_id`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `library_id` (`library_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indeksy dla tabeli `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `library_id` (`library_id`),
  ADD KEY `account_id` (`account_id`);

--
-- Indeksy dla tabeli `library`
--
ALTER TABLE `library`
  ADD PRIMARY KEY (`library_id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `location` (`location`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indeksy dla tabeli `library_opening`
--
ALTER TABLE `library_opening`
  ADD PRIMARY KEY (`library_opening_id`),
  ADD KEY `library_id` (`library_id`),
  ADD KEY `opening_id` (`opening_id`);

--
-- Indeksy dla tabeli `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`loan_id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `copy_id` (`copy_id`),
  ADD KEY `reader_id` (`reader_id`);

--
-- Indeksy dla tabeli `opening`
--
ALTER TABLE `opening`
  ADD PRIMARY KEY (`opening_id`);

--
-- Indeksy dla tabeli `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `reader_id` (`reader_id`),
  ADD KEY `copy_id` (`copy_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indeksy dla tabeli `reader`
--
ALTER TABLE `reader`
  ADD PRIMARY KEY (`reader_id`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `library_card_number` (`library_card_number`),
  ADD KEY `account_id` (`account_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1024;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `copy`
--
ALTER TABLE `copy`
  MODIFY `copy_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `library`
--
ALTER TABLE `library`
  MODIFY `library_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `library_opening`
--
ALTER TABLE `library_opening`
  MODIFY `library_opening_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `loan_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `opening`
--
ALTER TABLE `opening`
  MODIFY `opening_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reader`
--
ALTER TABLE `reader`
  MODIFY `reader_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `copy_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`library_id`),
  ADD CONSTRAINT `copy_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`library_id`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `library_opening`
--
ALTER TABLE `library_opening`
  ADD CONSTRAINT `library_opening_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`library_id`),
  ADD CONSTRAINT `library_opening_ibfk_2` FOREIGN KEY (`opening_id`) REFERENCES `opening` (`opening_id`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `loan_ibfk_2` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`copy_id`),
  ADD CONSTRAINT `loan_ibfk_3` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`reader_id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`reader_id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`copy_id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `reader`
--
ALTER TABLE `reader`
  ADD CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
