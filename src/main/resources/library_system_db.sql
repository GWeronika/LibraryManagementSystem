-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2023 at 09:53 AM
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
(15, 'Robinson Crusoe', 'Daniel Defoe'),
(16, 'Harry Potter i Kamień Filozoficzny', 'J.K. Rowling'),
(17, 'Zabić drozda', 'Harper Lee'),
(18, 'Więzień labiryntu', 'James Dashner'),
(19, 'Chłopiec z latawcem', 'Khaled Hosseini'),
(20, 'Lśnienie', 'Stephen King'),
(21, 'Zakazana retoryka', 'Gloria Beck'),
(22, 'Hobbit, czyli tam i z powrotem', 'J.R.R. Tolkien'),
(23, 'Lalka', 'Bolesław Prus'),
(24, 'Sto lat samotności', 'Gabriel García Márquez'),
(25, 'Nowy wspaniały świat', 'Aldous Huxley'),
(26, 'Mikołajek', 'René Goscinny, Jean-Jacques Sempé'),
(27, 'Iliada', 'Homer'),
(28, 'Boska komedia', 'Dante Alighieri'),
(29, 'I nie było już nikogo', 'Agatha Christie'),
(30, 'Wojna i pokój', 'Leo Tolstoy'),
(31, 'Wiedźmin. Tom 1. Ostatnie życzenie', 'Andrzej Sapkowski'),
(32, 'Anna Karenina', 'Leo Tolstoy'),
(33, 'Don Kichot', 'Miguel de Cervantes'),
(34, 'Portret Doriana Graya', 'Oscar Wilde'),
(35, 'Wichrowe wzgórza', 'Emily Brontë'),
(36, 'Dziennik panny Jane', 'Charlotte Brontë'),
(37, 'Hrabia Monte Christo', 'Alexandre Dumas'),
(38, 'Nędznicy', 'Victor Hugo'),
(39, 'Wielkie nadzieje', 'Charles Dickens'),
(40, 'Bracia Karamazow', 'Fyodor Dostoevsky'),
(41, 'Harry Potter i Komnata Tajemnic', 'J.K. Rowling'),
(42, 'Harry Potter i Więzień Azkabanu', 'J.K. Rowling'),
(43, 'Harry Potter i Czara Ognia', 'J.K. Rowling'),
(44, 'Harry Potter i Zakon Feniksa', 'J.K. Rowling'),
(45, 'Harry Potter i Książę Półkrwi', 'J.K. Rowling'),
(46, 'Harry Potter i Insygnia Śmierci', 'J.K. Rowling'),
(47, 'Potop', 'Henryk Sienkiewicz'),
(48, 'Ogniem i mieczem', 'Henryk Sienkiewicz'),
(49, 'Mały książę', 'Antoine de Saint-Exupéry'),
(50, 'Opowieści z Narnii: Siostrzeniec czarodzieja', 'C.S. Lewis'),
(51, 'Opowieści z Narnii: Książę Kaspian', 'C.S. Lewis'),
(52, 'Opowieści z Narnii: Podróż \"Wędrowca do Świtu\"', 'C.S. Lewis'),
(53, 'Opowieści z Narnii: Srebrne krzesło', 'C.S. Lewis'),
(54, 'Opowieści z Narnii: Koń i jego chłopiec', 'C.S. Lewis'),
(55, 'Opowieści z Narnii: Ostatnia bitwa', 'C.S. Lewis'),
(56, 'Na zachodzie bez zmian', 'Erich Remarque'),
(57, 'Inny świat', 'Gustaw Herling-Grudziński'),
(58, 'Tom 1. Diuna', 'Frank Herbert'),
(59, 'Tom 2. Mesjasz Diuny', 'Frank Herbert'),
(60, 'Tom 3. Dzieci Diuny', 'Frank Herbert'),
(61, 'Tom 4. Bóg Imperator Diuny', 'Frank Herbert'),
(62, 'Tom 5. Heretycy Diuny', 'Frank Herbert'),
(63, 'Tom 6. Kapitularz Diuną', 'Frank Herbert'),
(64, 'Opowieść podręcznej', 'Margaret Atwood'),
(65, 'Gra o tron', 'George R.R. Martin'),
(66, 'Starcie królów', 'George R.R. Martin'),
(67, 'Nawałnica mieczy cz.1', 'George R.R. Martin'),
(68, 'Nawałnica mieczy cz.2', 'George R.R. Martin'),
(69, 'Uczta wron cz.1', 'George R.R. Martin'),
(70, 'Uczta wron cz.2', 'George R.R. Martin'),
(71, 'Taniec ze Smokami cz.1', 'George R.R. Martin'),
(72, 'Taniec ze Smokami cz.2', 'George R.R. Martin'),
(73, 'Hamlet', 'William Shakespeare'),
(74, 'Stary człowiek i morze', 'Ernest Hemingway'),
(75, 'Tajemniczy ogród', 'Frances Burnett'),
(76, 'Mitologia', 'Jan Parandowski'),
(77, 'Transatlantyk', 'Witold Gombrowicz'),
(78, 'Cierpienia młodego Wertera', 'Johann Wolfgang Goethe'),
(79, 'Pamiętnik z Powstania Warszawskiego', 'Miron Białoszewski'),
(80, 'Opowiadania', 'Stefan Żeromski'),
(81, 'Opowiadania', 'Tadeusz Borowski'),
(82, 'Moralność Pani Dulskiej', 'Gabriela Zapolska'),
(83, 'Przedwiośnie', 'Stefan Żeromski'),
(84, 'Nie-boska komedia', 'Zygmunt Krasiński'),
(85, 'Ferdydurke', 'Witold Gombrowicz'),
(86, 'Imię Róży', 'Umberto Eco'),
(87, 'Kandyd', 'Voltaire'),
(88, 'Władca Pierścieni. Dwie wieże', 'J.R.R. Tolkien'),
(89, 'Władca Pierścieni. Powrót króla', 'J.R.R. Tolkien'),
(90, 'Jądro ciemności', 'Joseph Conrad'),
(91, 'Opowieść wigilijna', 'Charles Dickens'),
(92, 'Kamienie na szaniec', 'Aleksander Kamiński'),
(93, 'Medaliony', 'Zofia Nałkowska'),
(94, 'Zemsta', 'Aleksander Fredro'),
(95, 'Faraon', 'Bolesław Prus'),
(96, 'Giaur', 'George Byron'),
(97, 'Poezje', 'Kazimierz Przerwa-Tetmajer'),
(98, 'Poezje', 'Leopold Staff'),
(99, 'Nowele', 'Henryk Sienkiewicz'),
(100, 'Nowele', 'Maria Konopnicka'),
(101, 'Poces', 'Franz Kafka'),
(102, 'Folwark zwierzęcy', 'George Orwell'),
(103, 'Syzyfowe prace', 'Stefan Żeromski'),
(104, 'Krzyżacy', 'Henryk Sienkiewicz'),
(105, 'Dżuma', 'Albert Camus'),
(106, 'Poezje', 'Czesław Miłosz'),
(107, 'Poezje', 'Juliusz Słowacki'),
(108, 'Szewcy', 'Honoré de Balzac'),
(109, 'Ojciec Goriot', 'Honoré de Balzac'),
(110, 'Poezje', 'Adam Mickiewicz'),
(111, 'Pan Tadeusz', 'Adam Mickiewicz'),
(112, 'Tango', 'Sławomir Mrożek'),
(113, 'Makbet', 'William Shakespeare'),
(114, 'Treny', 'Jan Kochanowski'),
(115, 'Fraszki', 'Jan Kochanowski'),
(116, 'Odprawa posłów greckich', 'Jan Kochanowski'),
(117, 'Konrad Wallenrod', 'Adam Mickiewicz'),
(118, 'Nad Niemnem', 'Eliza Orzeszkowa'),
(119, 'Antygona', 'Sofokles'),
(120, 'Granica', 'Zofia Nałkowska'),
(121, 'Wesele', 'Stanisław Wyspiański'),
(122, 'Dziady cz III', 'Adam Mickiewicz'),
(123, 'Skąpiec', 'Molier'),
(124, 'Świętoszek', 'Molier'),
(125, 'Romeo i Julia', 'William Shakespeare'),
(126, 'Sklepy cynamonowe', 'Bruno Schulz'),
(127, 'Śluby panieńskie', 'Aleksander Fredro'),
(128, 'Biblia', '-'),
(129, 'Silmarilion', 'J.R.R. Tolkien'),
(130, 'Dzieci z Bullerbyn', 'Astrid Lindgren'),
(131, 'Ulisses', 'James Joyce'),
(132, 'Ania z Zielonego Wzgórza', 'Lucy Maud Montgomery'),
(133, 'Pamiętniki Adama i Ewy', 'Mark Twain'),
(134, 'Baśnie', 'Hans Christian Andersen'),
(135, 'Dekameron', 'Giovanni Boccaccio'),
(136, 'Pani Bovary', 'Gustave Flaubert'),
(137, 'Rozważna i romantyczna', 'Jane Austen'),
(138, 'W poszukiwaniu straconego czasu', 'Marcel Proust'),
(139, 'Kiedyś byłem dziełem sztuki', 'Eric Emmanuel Schmitt'),
(140, 'Oczy smoka', 'Stephen King'),
(141, 'Czarnoksiężnik z Archipelagu: Ziemiomorze', 'Ursula LeGuin'),
(142, 'Dzienniki gwiazdowe', 'Stanisław Lem'),
(143, 'Martwe Dusze', 'Nikolai Gogol'),
(144, 'TO', 'Stephen King'),
(145, 'Solaris', 'Stanisław Lem'),
(146, 'Wiedźmin. Tom 8. Sezon burz', 'Andrzej Sapkowski'),
(147, 'Król Edyp', 'Sofokles'),
(148, 'Pinokio', 'Carlo Collodi'),
(149, 'W 80 dni dookoła świata', 'Jules Verne'),
(150, 'Charlie i fabryka czekolady', 'Roald Dahl'),
(151, 'Pomniejsze bóstwa', 'Terry Pratchett'),
(152, 'Mistrz i Małgorzata', 'Mikhail Bulgakov'),
(153, 'Szachinszach', 'Ryszard Kapuściński'),
(154, 'Gra w klasy', 'Julio Cortázar'),
(155, 'Studium w szkarłacie', 'Arthur Conan Doyle'),
(156, 'Dzwonnik z Notre Dame', 'Victor Hugo'),
(157, 'Szept Anioła', 'Angela Seraphim'),
(158, 'Wędrująca Gwiazda', 'Oggy Stellarius'),
(159, 'Szmaragdowe Marzenia', 'Edward Dreamweaver'),
(160, 'Zaklęta Saga', 'Matthew Enchantus'),
(161, 'Przez Bramy Czasu', 'Chris Gatekeeper'),
(162, 'Kwiaty Deszczu', 'Emma Aquatica'),
(163, 'Magia Ciemności', 'Morgana Noctis'),
(164, 'Śpiewające Drzewa', 'Sylvan Melodia'),
(165, 'Podwodny Portal', 'Nelly Wave'),
(166, 'Księżycowy Lament', 'Linda Sorrow'),
(167, 'Ostatni Smok', 'Derek Ignis'),
(168, 'Złota Strzała', 'Adam Arrow'),
(169, 'Szept Zjaw', 'Phill Whispers'),
(170, 'Nocna Orchidea', 'Oscar Nocturna'),
(171, 'Arcane Codex', 'Myranda Cipher'),
(172, 'Szepty Aniołów', 'Shawncy Whispers'),
(173, 'Kosmiczny Taniec', 'Casper Dance'),
(174, 'Przełamujący Granice', 'Hubert Explorer'),
(175, 'Stalowe Serce', 'Ivan Sentinel'),
(176, 'Łowcy Gwiazd', 'Stella Hunters'),
(177, 'Anielski Strumień', 'Angelica Stream'),
(178, 'Mroczny Brzask', 'Dorothy Dawn'),
(179, 'Kwiat Pustyni', 'Victoria Bloom'),
(180, 'Obserwator Wszechświata', 'Joe Observer'),
(181, 'Wibracje Przestrzeni', 'Simon Mess'),
(182, 'Czarny Zaklęty Las', 'Matt Shadowwood'),
(183, 'Złoty Kurant', 'Gary Gold'),
(184, 'Tajemniczy Fosfor', 'Phoebe Mystery'),
(185, 'Księga Złotego Ptaka', 'Patric Goldbook'),
(186, 'Płomień Wyobraźni', 'Isabell Fantasy'),
(187, 'Zaklinacz Czasu', 'Anna Nowak'),
(188, 'Nadzieja w Płomieniach', 'Tomasz Kowalski'),
(189, 'Przeznaczeni dla Siebie', 'Karolina Wiśniewska'),
(190, 'Gwiezdne Widzenia', 'Piotr Jankowski'),
(191, 'Sny o Przeszłości', 'Magdalena Kwiatkowska'),
(192, 'Droga do Marzeń', 'Kamil Szymański'),
(193, 'Nieskrępowane Pragnienia', 'Natalia Kaczmarek'),
(194, 'Mroczny Świat', 'Krzysztof Wojciechowski'),
(195, 'Pod Niebem Nadziei', 'Monika Zawadzka'),
(196, 'Zakazany Czas', 'Michał Włodarczyk'),
(197, 'Mistyka Minionej Ery', 'Alicja Krawczyk'),
(198, 'Kosmiczna Harmonia', 'Rafał Nowicki'),
(199, 'Kwiaty Księżyca', 'Ewa Wesołowska'),
(200, 'Magia Księżycowa', 'Artur Tomaszewski'),
(201, 'Ostatni Bastion', 'Katarzyna Kowalczyk'),
(202, 'Ciemne Proroctwa', 'Tomasz Wójcik'),
(203, 'Światło w Mroku', 'Anna Lisowska'),
(204, 'Skrywana Twarz', 'Marcin Dąbrowski'),
(205, 'Wieża Zmierzchu', 'Karolina Kwiatkowska'),
(206, 'Skrywane Tajemnice', 'Tadeusz Nowak'),
(207, 'Gwiezdne Legendy', 'Agata Górska'),
(208, 'Kwiaty Pustyni', 'Dariusz Zieliński'),
(209, 'Zaklęte Marzenia', 'Joanna Jankowska'),
(210, 'Mroczne Lustro', 'Marek Sosnowski'),
(211, 'Anielski Deszcz', 'Kinga Adamczyk'),
(212, 'Złoty Świt', 'Kamil Adamczak'),
(213, 'Szept Zorzy', 'Anna Szewczyk'),
(214, 'Mistyfikacja Czasu', 'Rafał Kowal'),
(215, 'Księga Przeznaczenia', 'Katarzyna Wojciechowska'),
(216, 'Skowyt Nocy', 'Krzysztof Nowicki'),
(217, 'Zaklęta Rzeczywistość', 'Natalia Kowalska'),
(218, 'Błękitne Widma', 'Piotr Krawczyk'),
(219, 'Anielski Strój', 'Dominika Górska'),
(220, 'Wzór Gwiezdnej Pyłki', 'Tomasz Zawadzki'),
(221, 'Czarodziejka Nocy', 'Katarzyna Pawlak'),
(222, 'Płonący Księżyc', 'Marek Zięba'),
(223, 'Złoty Labirynt', 'Ewelina Sobczak'),
(224, 'Magia Czarnego Księżyca', 'Michał Głowacki'),
(225, 'Skrywane Tajemnice', 'Anna Nowakowska'),
(226, 'Anielski Element', 'Piotr Kaczmarek'),
(227, 'Królestwo Cienia', 'Karolina Zawadzka'),
(228, 'Złota Kraina', 'Marek Wojciechowski'),
(229, 'Gwiezdna Przełęcz', 'Anna Zając'),
(230, 'Mroczna Symfonia', 'Krzysztof Szymański'),
(231, 'Światło Luny', 'Joanna Nowak'),
(232, 'Kwiaty Kosmosu', 'Tomasz Zawadzki'),
(233, 'Złote Wizje', 'Alicja Krawczyk'),
(234, 'Gwiezdny Mistrz', 'Michał Włodarczyk'),
(235, 'Anielski Codex', 'Karolina Wiśniewska'),
(236, 'Magia Szeptów', 'Piotr Jankowski'),
(237, 'Zaklęte Opowieści', 'Magdalena Kwiatkowska'),
(238, 'Obrzeża Ciemności', 'Kamil Szymański'),
(239, 'Czarodziejka Zorzy', 'Natalia Kaczmarek'),
(240, 'Niewidzialny Świat', 'Krzysztof Wojciechowski'),
(241, 'Gwiezdny Wędrowiec', 'Monika Zawadzka'),
(242, 'Anielski Skrytobójca', 'Michał Nowicki'),
(243, 'Złote Marzenia', 'Alicja Krawczyk'),
(244, 'Zaklęta Galaktyka', 'Piotr Jankowski'),
(245, 'Królowa Gwiazd', 'Karolina Wiśniewska'),
(246, 'Światło Księżyca', 'Tomasz Kowalski'),
(247, 'Gwiezdna Noc', 'Magdalena Kwiatkowska'),
(248, 'Mroczne Tropy', 'Kamil Szymański'),
(249, 'Zaklęta Wyspa', 'Anna Nowak'),
(250, 'Promień Nadziei', 'Piotr Jankowski'),
(251, 'Szept Drzew', 'Karolina Wiśniewska'),
(252, 'Ciemne Zakątki', 'Tomasz Kowalski'),
(253, 'Skrywane Ulice', 'Magdalena Kwiatkowska'),
(254, 'Gwiezdna Melodia', 'Kamil Szymański'),
(255, 'Niezapomniane Chwile', 'Anna Nowak'),
(256, 'Złote Pióro', 'Piotr Jankowski'),
(257, 'Intrygująca Melodia', 'Mary Intrigue'),
(258, 'Mistyczna Opowieść', 'Mary Tale'),
(259, 'Zaginiony Wymiar', 'Leo Dimension'),
(260, 'Świt Nadziei', 'Mary Hope'),
(261, 'Mgiełka Przeznaczenia', 'Frank Destiny'),
(262, 'Przeklęte Lustro', 'Christina Mirror'),
(263, 'Księżycowy Księgozbiór', 'Joe Luna'),
(264, 'Kawiarniane Tajemnice', 'Anna Nowak'),
(265, 'Szepty Montmartre', 'Pierre Dubois'),
(266, 'Wieczna Elegancja', 'Isabella Rossi'),
(267, 'Siempre Amor', 'Carlos Hernandez'),
(268, 'Nordycka Zagadka', 'Ingrid Andersen'),
(269, 'Zamek Marzeń', 'Elena Petrov'),
(270, 'Samba Noce w Rio', 'Antonio Silva'),
(271, 'Sekrety Sahary', 'Fatima Ahmed'),
(272, 'Tajemniczy Krąg', 'Mateusz Kowalski'),
(273, 'Pod Atlantyckim Niebem', 'Ewa Nowakowska'),
(274, 'Lato w Toskanii', 'Giuseppe Rossi'),
(275, 'Złoty Pałac Seulu', 'Lee Ji-Yeon'),
(276, 'Parisian Nights', 'Claire Leclair'),
(277, 'Tajemnica Akropolu', 'Nikos Papadopoulos'),
(278, 'Karmazynowy Zachód', 'Lila Rodriguez'),
(279, 'Dolina Kwiatów', 'Ryszard Nowak'),
(280, 'Orient Express', 'Ayşe Yılmaz'),
(281, 'Szlakiem Samurajów', 'Hiroshi Tanaka'),
(282, 'Amsterdamskie Nocne Życie', 'Sophie de Vries'),
(283, 'Zaklęta Czekolada', 'Anna Nowak'),
(284, 'Tajemnice Gór', 'Marek Wójcik'),
(285, 'Miłość w Paryżu', 'Jan Kowalczyk'),
(286, 'Ostatni Skarb Templariuszy', 'Piotr Jankowski'),
(287, 'Kwiaty na Balkonie', 'Natalia Kwiatkowska'),
(288, 'Wyspa Marzeń', 'Tomasz Szymański'),
(289, 'Czekoladowe Namiętności', 'Anna Nowak'),
(290, 'Pod Sycylijskim Słońcem', 'Luca Rossi'),
(291, 'Przystanek Podróż', 'Kamila Zawadzka'),
(292, 'Słodka Pamiątka', 'Marek Kaczmarek'),
(293, 'Urok Księżycowej Nocy', 'Karolina Włodarczyk'),
(294, 'Róża w Wietrze', 'Antonio Bianchi'),
(295, 'Gdzieś w Toskanii', 'Ewa Tomaszewska'),
(296, 'Złote Klimaty', 'Piotr Sobczak'),
(297, 'Na Skrzydłach Marzeń', 'Magdalena Adamczyk'),
(298, 'Skrzydła Nocy', 'Rafael Moreno'),
(299, 'Portugalskie Melodie', 'Isabel Silva'),
(300, 'Tajemnicza Dziedzina', 'Krzysztof Dąbrowski'),
(301, 'Szczęśliwe Chwile', 'Joanna Górska'),
(302, 'Sztuka Czekolady', 'Dominik Wesołowski'),
(303, 'Wieczór w Wersalu', 'Camille Leblanc'),
(304, 'Czarodziejski Ogrod', 'Ewa Sobczak'),
(305, 'Zaklęte Wino', 'Giovanni Rossi'),
(306, 'Magiczne Wzgórze', 'Katarzyna Jankowska'),
(307, 'Wiatr we Włoszech', 'Marco Conti'),
(308, 'Złoty Ogród', 'Anna Zając'),
(309, 'Polskie Smaki', 'Tomasz Wojciechowski'),
(310, 'Urok Śródziemnomorski', 'Elena Pappas'),
(311, 'Podróże Kulinarno-Muzyczne', 'Kamil Górski'),
(312, 'Wspomnienia z Andaluzji', 'Isabella Sánchez'),
(313, 'Zaklęte Mazury', 'Piotr Krawczyk'),
(314, 'Róża w Czarnej Równinie', 'Karolina Zawadzka'),
(315, 'Grecka Opowieść', 'Nikos Papadopoulos'),
(316, 'Krakowska Nostalgia', 'Kamila Jankowska'),
(317, 'Przez Wieki', 'Dominik Wójcik'),
(318, 'Złota Jesień', 'Anna Lisowska'),
(319, 'Nocne Ognie', 'Marek Sosnowski'),
(320, 'Chwile Refleksji', 'Ewa Nowak'),
(321, 'Paryska Sonata', 'Philippe Leclair'),
(322, 'Wino z Toskanii', 'Francesca Ricci'),
(323, 'Słoneczne Wzgórze', 'Tomasz Kaczmarek'),
(324, 'Podróże Marzeń', 'Magdalena Wojciechowska'),
(325, 'Między Kontynentami', 'Alexandra Petrov'),
(326, 'Sekrety Prowansji', 'Jean-Luc Dubois'),
(327, 'Polskie Mazury', 'Marta Kowalska'),
(328, 'Tajemnice Wschodu', 'Ali Al-Farsi'),
(329, 'Wieża Gdańska', 'Anna Malinowska'),
(330, 'Wino z Burgundii', 'Pierre Martin'),
(331, 'Podróże Czasu', 'Karolina Zając'),
(332, 'Jesienne Melodie', 'Mateusz Szymański'),
(333, 'Słoneczna Riwiera', 'Sophie Laurent'),
(334, 'Zaklęte Jezioro', 'Marek Kowalski'),
(335, 'Wielki Mur', 'Li Wei'),
(336, 'Opowieści z Białowieskiego Lasu', 'Katarzyna Nowak'),
(337, 'Meksykańska Fiesta', 'Carlos Rodriguez'),
(338, 'Roztańczona Barcelona', 'Isabel Morales'),
(339, 'Podróże przez Bałkany', 'Nikola Ivanov'),
(340, 'Śladami Wikingów', 'Ewa Tomaszewska'),
(341, 'Mroczne Zakątki Krakowa', 'Andrzej Kowalski'),
(342, 'Przez Bambusowy Zagajnik', 'Wei Lin'),
(343, 'Słońce nad Kenią', 'Nia Njeri'),
(344, 'Hawaje: Kwiaty Oceanu', 'Kai Johnson'),
(345, 'Wielka Rafa Koralowa', 'Liam OConnor'),
(346, 'Rzeki Amazonii', 'Isabella Silva'),
(347, 'Dolina Królów', 'Ahmed Salah'),
(348, 'Księżyc nad Saharą', 'Amina Ibrahim'),
(349, 'Sydney: Miasto Kontrastów', 'Jackie Chen'),
(350, 'Wulkaniczne Przygody', 'Lila Wong'),
(351, 'Safari w Tanzanii', 'Rashidi Mbele'),
(352, 'Bambusowy Labirynt', 'Wei Lin'),
(353, 'Urok Indii', 'Arun Patel'),
(354, 'Wodospady Iguazu', 'Elena Gomez'),
(355, 'Sekrety Lasu Białowieskiego', 'Marek Nowak'),
(356, 'Przeszłość i Przyszłość', 'Thomas Time'),
(357, 'Szkarłatny Zachód', 'Scarlet Sunset'),
(358, 'Mroczna Noc', 'Dora Nightfall'),
(359, 'Przebudzenie Magiczne', 'Maggie Awakening'),
(360, 'Anielski Kwiat', 'Leo Bloom'),
(361, 'Dźwięki Paryża', 'Claire Dubois'),
(362, 'Echo w Andach', 'Mateo Rodriguez'),
(363, 'Tajemnice Kyoto', 'Yuki Tanaka'),
(364, 'Wenecka Serenada: z cyklu włoskie melodie', 'Giulia Rossi'),
(365, 'Karaibski sen - przewodnik dla leniwych', 'Carlos Hernandez'),
(366, 'Poranek w Moskwie', 'Elena Petrov'),
(367, 'New York Nocturne', 'John Smith'),
(368, 'Mumbai w pigułce', 'Priya Patel'),
(369, 'Bursztyny Bałtyku', 'Andrei Ivanov'),
(370, 'Co szepcze w Kairze?', 'Amira Hassan'),
(371, 'Wylambaduj się w Rio', 'Carlos Hernandez'),
(372, 'Istambuł - przewodnik', 'Ayse Demir'),
(373, 'Opowieści z Tokio', 'Hiroshi Yamamoto'),
(374, 'Barcelona: z cyklu \"Gdzie cię niesie\"', 'Sofia Ramos'),
(375, 'W Dubaju już zmierzcha', 'Khalid Al-Farsi'),
(376, 'Walc Wiedeński', 'Eva Weber'),
(377, 'Kroniki Safari cz.1', 'Liam OConnor'),
(378, 'Sydney: z cyklu \"Gdzie cię niesie\"', 'Sofia Ramos'),
(379, 'Gdzie tym razem? Mumbai', 'Raj Kapoor'),
(380, 'Przewodnik po Berlinie', 'Anna Schmidt'),
(381, 'Rio de Janeiro - warte zwiedzenia', 'Lucia Silva'),
(382, 'Amsterdam rowerem', 'Lars Jensen'),
(383, 'Hawańska zaduma', 'Miguel Rodriguez'),
(384, 'Cześć, Seoul', 'Ji-Hoon Kim'),
(385, 'Szkocka Elegia', 'Eleanor Campbell'),
(386, 'Marrakech Melancholy', 'Yasmine Abbas'),
(387, 'Auckland: z cyklu \"Gdzie cię niesie\"', 'Sofia Ramos'),
(388, 'Kopenhaga rowerem', 'Lars Jensen'),
(389, 'Buenos Aires - przewodnik', 'Sofia Morales'),
(390, 'A w Krakowie', 'Marek Nowak'),
(391, 'Tel Awiw - przewodnik', 'Avi Cohen'),
(392, 'Dzieje się w Dublinie', 'Sean Murphy'),
(393, 'Ateny - stare i nowe', 'Eleni Papadopoulos'),
(394, 'Tango w Toronto', 'Luis Rodriguez'),
(395, 'Praga? To tu', 'Katerina Novak'),
(396, 'Romeo w Rzymie', 'Giorgio Bianchi'),
(397, 'Johannesburg Journeys', 'Thabo Mbeki'),
(398, 'W realu w Montrealu', 'Claude Tremblay'),
(399, 'Barbados - przewodnik', 'Carlos Hernandez'),
(400, 'Magiczny Kraków', 'Anna Kowalczyk'),
(401, 'Festiwale Nairobi', 'Wanjiku Njeri'),
(402, 'Madrid: z cyklu \"Gdzie cię niesie\"', 'Sofia Ramos'),
(403, 'Przewodnik po Moskwie', 'Ivan Petrov'),
(404, 'Witamy w Las Vegas', 'Emily Johnson'),
(405, 'Dubai Dreams', 'Khalid Al-Farsi'),
(406, 'Oslo Nocą', 'Lars Eriksson'),
(407, 'Seoul tu i tam', 'Ji-Hoon Kim'),
(408, 'Paryska bagietka - przewodnik kulinarny', 'Claire Dubois'),
(409, 'Przewodnik po Buenos Aires', 'Sofia Morales'),
(410, 'Witamy w Sydney', 'Emily Johnson'),
(411, 'Monolog Mumbai', 'Raj Kapoor'),
(412, 'Osaka - śladami wielkich ludzi', 'Yuki Tanaka'),
(413, 'Liverpool zaprasza', 'James Turner'),
(414, 'Los Angeles Nocturne', 'John Smith'),
(415, 'Tajemnice Gizy', 'Amira Hassan'),
(416, 'Wenecka przygoda', 'Giulia Rossi'),
(417, 'Barcelona latem', 'Sofia Ramos'),
(418, 'Rio de Janeiro : z cyklu \"Gdzie cię niesie\"', 'Sofia Ramos'),
(419, 'Irlandzkie tajemnice', 'Eleanor Campbell'),
(420, 'Tel Awiw - wzgórze wiosny', 'Avi Cohen'),
(421, 'W Cork z Corgi', 'Sean Murphy'),
(422, 'Ateny - przewodnik dla ciekawych', 'Eleni Papadopoulos'),
(423, 'Toronto zaprasza', 'Luis Rodriguez'),
(424, 'Polonez w Pradze', 'Katerina Novak'),
(425, 'Romeo w Rydze', 'Giorgio Bianchi'),
(426, 'Johannesburg? To tam', 'Thabo Mbeki'),
(427, 'Montreal za kulisami', 'Claude Tremblay'),
(428, 'Witamy na Barbados', 'Carlos Hernandez'),
(429, 'Warszawa warta zobaczenia', 'Anna Kowalczyk'),
(430, 'Nairobi - gdzie się udać', 'Wanjiku Njeri'),
(431, 'Madryt oczami mieszkańca', 'Sofia Ramos'),
(432, 'Moskwa zimą', 'Ivan Petrov'),
(433, 'Los Angeles - miasto aniołów', 'Emily Johnson'),
(434, 'Dubai w 5 dni', 'Khalid Al-Farsi'),
(435, 'Oslo - przedownik po Norwegii', 'Lars Eriksson'),
(436, 'Busan - witamy w Korei', 'Ji-Hoon Kim'),
(437, 'Zakamarki Paryża', 'Claire Dubois'),
(438, 'Dżungla Brazylii', 'Sofia Morales'),
(439, 'Sydney - gdzie nie chodzić', 'Olivia Mitchell'),
(440, 'Chennai - poznaj Indie', 'Raj Kapoor'),
(441, 'Kyoto: z cyklu japoński sen', 'Yuki Tanaka'),
(442, 'Z Londynu na Pokątną', 'James Turner'),
(443, 'Chicago Nocturne', 'John Smith'),
(444, 'Piramidy Egiptu', 'Amira Hassan'),
(445, 'Wirtuoz wenecki', 'Giulia Rossi'),
(446, 'Grenada: z cyklu \"Gdzie cię niesie\"', 'Sofia Ramos'),
(447, 'Sao Paulo to tu', 'Lucia Silva'),
(448, 'Zamek Edinburgh', 'Eleanor Campbell'),
(449, 'Podróż kulinarna do Izraela', 'Avi Cohen'),
(450, 'Dublin rowerem', 'Lars Jensen'),
(451, 'Zaginiona Wyspa', 'Katarzyna Nowak'),
(452, 'Skarb Wyspy', 'Robert Stevenson'),
(453, 'Podróż do Środka Ziemi', 'Jules Verne'),
(454, 'Księga Dżungli', 'Rudyard Kipling'),
(455, 'Czytelniczka', 'Traci Chee'),
(456, 'Złodziejka Książek', 'Markus Zusak'),
(457, 'Zew Przygody', 'Jack London'),
(458, 'Władca Much', 'William Golding'),
(459, 'Podróż na Koniec Nocy', 'Louis-Ferdinand Céline'),
(460, 'Opowieści Z Ziemiomorza', 'Ursula K. Le Guin'),
(461, 'Czas Apokalipsy', 'Stephen King'),
(462, 'Park Jurajski', 'Michael Crichton'),
(463, 'Ostatni Mohikanin', 'James Fenimore Cooper'),
(464, 'Alicja w Krainie Czarów', 'Lewis Carroll'),
(465, 'Kod Leonarda da Vinci', 'Dan Brown'),
(466, 'Dziewczyna z Tatuażem Smoka', 'Stieg Larsson'),
(467, 'Wzgórze Psów', 'Jean-Paul Sartre'),
(468, 'Alchemik', 'Paulo Coelho'),
(469, 'Trzej Muszkieterowie', 'Alexandre Dumas'),
(470, 'Zatoka Serpów', 'John le Carré'),
(471, 'W Dziki świat', 'Jon Krakauer'),
(472, 'Wiatr w Wiklinie', 'Kenneth Grahame'),
(473, 'Tajemniczy Ogród', 'Frances Hodgson Burnett'),
(474, 'Rybak z Kairu', 'J.D. Salinger'),
(475, 'Przygody Hucka Finna', 'Mark Twain'),
(476, 'Drakula', 'Bram Stoker'),
(477, 'Wichry namiętności', 'Emily Brontë'),
(478, 'Mały kaktus John', 'Julius Marcus'),
(479, 'Wojna Światów', 'H.G. Wells'),
(480, 'Księżniczka Księżyca', 'William Goldman'),
(481, 'Droga', 'Cormac McCarthy'),
(482, 'Życie Pi', 'Yann Martel'),
(483, 'Szwajcarska Rodzina Robinsonów', 'Johann David Wyss'),
(484, 'Podróż do Wnętrza Ziemi', 'Jules Verne'),
(485, 'Kraina Oz', 'L. Frank Baum'),
(486, 'Wyspa Doktora Moreau', 'H.G. Wells'),
(487, 'Droga', 'Cormac McCarthy'),
(488, 'Biały Kieł', 'Jack London'),
(489, 'Niewidzialny Człowiek', 'H.G. Wells'),
(490, 'Tajemnicza Wyspa', 'Jules Verne'),
(491, 'Wokół Świata w Siedemdziesiąt Dwa Dni', 'Nellie Bly'),
(492, 'Droga do El Dorado', 'Isabella Silva'),
(493, 'Arabskie Noce', 'Anonimowy'),
(494, 'Zaginiony Raj', 'James Hilton'),
(495, 'Upiór w Operze', 'Gaston Leroux'),
(496, 'Sztuka Wojny', 'Sun Tzu'),
(497, 'Papillon', 'Henri Charrière'),
(498, 'Legenda Sennej Kotliny', 'Washington Irving'),
(499, 'Obrót Śruby', 'Henry James'),
(500, 'Szkarłatny Markiz', 'Bob Owens'),
(501, 'Czarna Strzała', 'Robert Louis Stevenson'),
(502, 'Wilcze Morze', 'Jack London'),
(503, 'Człowiek, który chciał być królem', 'Rudyard Kipling'),
(504, 'Skrzynia z Skarbem', 'Robert Louis Stevenson'),
(505, 'Trzydzieści Dziewięć Kroków', 'John Buchan'),
(506, 'Zaginiony Świat', 'Michael Crichton'),
(507, 'Wielki Napad na Pociąg', 'Michael Crichton'),
(508, 'Zaginiony Symbol', 'Dan Brown'),
(509, 'Cień Wiatru', 'Carlos Ruiz Zafón'),
(510, 'Tajemna Historia', 'Donna Tartt'),
(511, 'Marsjanin', 'Andy Weir'),
(512, 'Filary Ziemi', 'Ken Follett'),
(513, 'Dżungla', 'Upton Sinclair'),
(514, 'Wzgórza mają oczy', 'Henryk Sienkiewicz'),
(515, 'Eragon', 'Christopher Paolini'),
(516, 'Biegaczka', 'James Dashner'),
(517, 'Gwiazd naszych wina', 'John Green'),
(518, 'Dziennik cwaniaczka', 'Jeff Kinney'),
(519, 'Niezgodna', 'Veronica Roth'),
(520, 'Raport mniejszości', 'Philip K. Dick'),
(521, 'Martwy punkt', 'Michael Crichton'),
(522, 'Kosmiczne odyseje', 'Arthur C. Clarke'),
(523, 'Pamięć absolutna', 'Isaac Asimov'),
(524, 'Równość', 'Ursula K. Le Guin'),
(525, 'Kubuś Puchatek', 'A.A. Milne'),
(526, 'Dziewczynka z zapałkami', 'Hans Christian Andersen'),
(527, 'Baśnie Braci Grimm', 'Jacob i Wilhelm Grimm'),
(528, 'Baśnie łużyckie', 'Józef Burszta, Paweł Nedo'),
(529, 'Bajki dla dzieci', 'Hans Christian Andersen'),
(530, 'Wielka Księga Baśni', 'Wilhelm Grimm'),
(531, 'Pan Samochodzik i Fantomas', 'Zbigniew Nienacki'),
(532, 'Złote dary', 'Enid Blyton'),
(533, 'Bajki dla najmłodszych', 'Wilhelm Grimm'),
(534, 'Złoty klucz', 'Janosch'),
(535, 'Pszczoły Maji', 'Waldemar Wolański'),
(536, 'Koty i psy', 'Claire Bessant'),
(537, 'Święty Mikołaj', 'Clement Clarke Moore'),
(538, 'Tomcio Paluch', 'Maria Konopnicka'),
(539, 'Księżniczka z Krainy Oz', 'L. Frank Baum'),
(540, 'Zimowy poranek', 'Pearl S. Buck'),
(541, 'Mały Rycerz', 'Iza Trapani'),
(542, 'Pippi Langstrumpf', 'Astrid Lindgren'),
(543, 'Czy to Ty, mała myszko?', 'Steve Smallman'),
(544, 'Kubuś Puchatek i Dzień Tygrysa', 'A.A. Milne'),
(545, 'Święty Mikołaj i Czerwony Nosiłek', 'Kathryn Jackson'),
(546, 'Kropka i Kropek', 'David Shannon'),
(547, 'Dwunastu braci', 'Alexander Pushkin'),
(548, 'Przygody Tintina', 'Hergé'),
(549, 'Dzieci z Dworca Zoo', 'Christiane F.'),
(550, 'Podręcznik do magicznych stworzeń', 'J.K. Rowling'),
(551, 'Matylda', 'Roald Dahl'),
(552, 'Miś Uszatek', 'Czesław Janczarski'),
(553, 'Opowieści z 1001 Nocy', '-'),
(554, 'Czarodziejka z Księżyca', 'Elizabeth George Speare'),
(555, 'Książę Czaruś', 'E. Nesbit'),
(556, 'Złota rybka', 'Alexander Pushkin'),
(557, 'Wielki Mysz Griswold', 'Beverly Cleary'),
(558, 'Gdzie jest Nemo?', 'Disney Press'),
(559, 'Kraina Koczkodanów', 'Lewis Carroll'),
(560, 'Mała syrenka', 'Disney Press'),
(561, 'Kopciuszek', 'Disney Press'),
(562, 'Opowieści z Zielonego Lasu', 'Thornton W. Burgess'),
(563, 'Królewna Śnieżka', 'Disney Press'),
(564, 'Śpiąca Królewna', 'Disney Press'),
(565, 'Przygody Flinta w cudownej krainie', 'L. Frank Baum'),
(566, 'Lilo i Stitch', 'Disney Press'),
(567, 'Mulan', 'Disney Press'),
(568, 'Poczekajka', 'H.A. Rey'),
(569, 'Biała Twarz', 'Anna Sewell'),
(570, 'Stuart Malutki', 'E.B. White'),
(571, 'Mary Poppins', 'P.L. Travers'),
(572, 'Piękna i bestia', 'Disney Press'),
(573, 'Alladyn', 'Disney Press'),
(574, 'Makbet dla dzieci', 'Adam Wallenta'),
(575, 'Pippi w krainie koni', 'Astrid Lindgren'),
(576, 'Frankenstein dla dzieci', 'Stephanie Baudet'),
(577, 'Mustang z dzikiej doliny', 'Disney Press'),
(578, 'Romeo i Julia dla dzieci', 'Adam Wallenta'),
(579, 'Król lew', 'Disney Press'),
(580, 'Świnka Peppa: Moje ulubione bajki', 'Neville Astley'),
(581, 'Księżniczka Lillifee i magiczny jednorożec', 'Monika Finsterbusch'),
(582, 'Roszpunka', 'Disney Press'),
(583, 'Dobranoc, Panie Kacie!', 'Stefan Wiechecki'),
(584, 'Wróżki', 'Marta Kurczewska'),
(585, 'Ptasie Opowieści', 'Arkady Fiedler'),
(586, 'Kosmos', 'Carl Sagan'),
(587, 'Krótka historia czasu', 'Stephen Hawking'),
(588, 'Sapiens: Od zwierząt do bogów', 'Yuval Noah Harari'),
(589, 'W krainie czarnych dziur', 'Neil deGrasse Tyson'),
(590, 'Rozmowy z Bogiem', 'Neale Donald Walsch'),
(591, 'Wielki projekt', 'Stephen Hawking'),
(592, 'Einstein. Jego życie i wszechświat', 'Walter Isaacson'),
(593, 'Niepokonany umysł', 'Sylvia Nasar'),
(594, 'Kobiety matematyki. 36 opowieści', 'Laura Taalman'),
(595, 'Geneza. Nauka o pochodzeniu człowieka', 'Jared Diamond'),
(596, 'Czarne dziury i krzywizny czasoprzestrzeni', 'Kip S. Thorne'),
(597, 'Astrofizyka dla zabieganych', 'Neil deGrasse Tyson'),
(598, 'Kraina języka w Polsce', 'Leszek Bednarczuk'),
(599, 'Wszystko jest liczba', 'Michio Kaku'),
(600, 'Narodziny gwiazd', 'George R. Ricker'),
(601, 'Zjawisko LHC', 'Katarzyna Bosacka'),
(602, 'Biologia ludzkiego losu', 'Robert M. Sapolsky'),
(603, 'Czy czarne dziury są zielone?', 'Paul Parsons'),
(604, 'Życie i twórczość delfinów', 'Georgine McMaus'),
(605, 'Astrofizyka dla ludzi w pośpiechu', 'Neil deGrasse Tyson'),
(606, 'Mózg. Opowieść o nas', 'David Eagleman'),
(607, 'Gwiezdny pył', 'Carl Sagan'),
(608, 'Zrozumieć fizykę kwantową', 'Michael Brooks'),
(609, 'Anatomia nienawiści', 'Ryszard Kozłowski'),
(610, 'Dlaczego piłka jest okrągła?', 'Simon Kuper'),
(611, 'Sekret Rzeczypospolitej', 'Tadeusz Płużański'),
(612, 'Fizyka w życiu codziennym', 'Len Fisher'),
(613, 'Chaos. Twórcza siła nieporządku', 'James Gleick'),
(614, 'Prawda o robieniu przedświątecznych porządków', 'Karol Sagan'),
(615, 'Podróż do wnętrza atoma', 'Marcus Chown'),
(616, 'Pętla czasu', 'Brian Greene'),
(617, 'Jak działa wszystko', 'Louis Bloomfield'),
(618, 'Kwiaty dla Algernona', 'Daniel Keyes'),
(619, 'Wszechświat w skorupce orzecha włoskiego', 'Stephen Hawking'),
(620, 'Niewidzialny goryl', 'Richard Panek'),
(621, 'Witaj, wszechświecie', 'Jorge Cham'),
(622, 'Zabójcze komórki', 'Matt Ridley'),
(623, 'Chemia dla zmysłów', 'Diane Ackerman'),
(624, 'Pętle czasu', 'Brian Greene'),
(625, 'Krótkie odpowiedzi na wielkie pytania', 'Stephen Hawking'),
(626, 'Historia matematyki', 'Marcus du Sautoy'),
(627, 'Mózg: Opowieść o nas', 'David Eagleman'),
(628, 'Wielki projekt konstytucji', 'George R. Ricker'),
(629, 'Rzeczy, których nie wiesz o historii', 'Miles Kelly'),
(630, 'Kosmos: Przymierze z Niebem', 'Carl Sagan'),
(631, 'Boska komedia nauki', 'Carl Sagan'),
(632, 'Anatomia ludzkiego ciała', 'Henry Gray'),
(633, 'Chemia: Central Science', 'Theodore L. Brown'),
(634, 'Encyklopedia genów i genomy', 'Jeffrey H. Miller'),
(635, 'Narodziny gwiazd i planet', 'John M. Horrobin'),
(636, 'Nauka angielskiego od podstaw', 'John Smith'),
(637, 'Hiszpański w 30 dni', 'Maria Rodriguez'),
(638, 'Francuski dla początkujących', 'Pierre Dubois'),
(639, 'Niemiecki w praktyce', 'Anna Müller'),
(640, 'Włoski krok po kroku', 'Giuseppe Rossi'),
(641, 'Rosyjski dla średniozaawansowanych', 'Svetlana Ivanova'),
(642, 'Chiński dla ambitnych', 'Li Wei'),
(643, 'Japoński w pigułce', 'Yuki Tanaka'),
(644, 'Arabski dla podróżników', 'Ahmed Al-Mansoori'),
(645, 'Portugalski na co dzień', 'Sofia Oliveira'),
(646, 'Holenderski z uśmiechem', 'Jan van den Berg'),
(647, 'Koreański dla fanów K-dram', 'Kim Min-Ji'),
(648, 'Szwedzki bez tajemnic', 'Lena Svensson'),
(649, 'Turecki na wakacje', 'Ayşe Yılmaz'),
(650, 'Węgierski dla ciekawych', 'Gábor Nagy'),
(651, 'Hindi w szybkim tempie', 'Priya Kapoor'),
(652, 'Indonezyjski z pasją', 'Agus Santoso'),
(653, 'Polski dla obcokrajowców', 'Anna Nowak'),
(654, 'Grecki na wyjeździe', 'Nikos Papadopoulos'),
(655, 'Słowacki dla biznesmenów', 'Ján Kovač'),
(656, 'Duński w pracy', 'Mette Andersen'),
(657, 'Finska gramatyka w pigułce', 'Leena Virtanen'),
(658, 'Hebrajski dla zaawansowanych', 'David Cohen'),
(659, 'Tajski dla podróżujących', 'Kritika Phanich'),
(660, 'Wietnamski dla smakoszy kultury', 'Nguyen Minh'),
(661, 'Islandzki dla entuzjastów', 'Ólafur Björnsson'),
(662, 'Rumuński na co dzień', 'Ana Popescu'),
(663, 'Malajski z uściskiem dłoni', 'Siti Aminah'),
(664, 'Ukraiński bez bariery', 'Olena Kovalenko'),
(665, 'Bengalski w domu i pracy', 'Rajesh Das'),
(666, 'Serbski z nutką humoru', 'Ivan Petrović'),
(667, 'Perski dla ambitnych', 'Farid Mansouri'),
(668, 'Irlandzki dla miłośników tradycji', 'Sean OMalley'),
(669, 'Syngaleski w podróży', 'Anika Silva'),
(670, 'Uzbecki na rynku pracy', 'Dilshod Ahmedov'),
(671, 'Kurdyjski w codziennym życiu', 'Leyla Karim'),
(672, 'Azerbejdżański dla studentów', 'Aydin Abbasov'),
(673, 'Białoruski w kontaktach międzynarodowych', 'Natasha Ivanova'),
(674, 'Lao dla miłośników kuchni azjatyckiej', 'Vilayvanh Phommasone'),
(675, 'Gudżarati dla biznesu', 'Raj Patel'),
(676, 'Walijski na wakacjach', 'Eleri Jones'),
(677, 'Albański dla turystów', 'Arben Krasniqi'),
(678, 'Macedoński w biznesie', 'Marija Petrova'),
(679, 'Singaleski dla relaksu', 'Nimal Ranasinghe'),
(680, 'Tatar w kontaktach międzykulturowych', 'Amina Sharipova'),
(681, 'Mongolski w podróży', 'Batbayar Tsend'),
(682, 'Kazachski dla studentów', 'Aigerim Zhunusova'),
(683, 'Zulu na co dzień', 'Sipho Ndlovu'),
(684, 'Suahili w Afryce Wschodniej', 'Nia Juma'),
(685, 'Kurmali w Indiach', 'Rajiv Verma'),
(686, 'Ugruski dla odkrywców', 'Giorgi Bakradze'),
(687, 'Malediwski w raju', 'Aisha Mohamed'),
(688, 'Kaszmirski dla podróżujących', 'Arun Singh'),
(689, 'Nawaho wśród Indian', 'Kaya Tsosie'),
(690, 'Tonga w Polinezji', 'Hina Tuifua'),
(691, 'Python w praktyce', 'Anna Kowalska'),
(692, 'JavaScript: Podstawy programowania', 'Piotr Nowak'),
(693, 'Java dla początkujących', 'Marcin Wiśniewski'),
(694, 'Cpp od podstaw', 'Karolina Zając'),
(695, 'PHP i MySQL: Tworzenie aplikacji webowych', 'Michał Nowak'),
(696, 'HTML i CSS: Projektowanie stron internetowych', 'Aleksandra Woźniak'),
(697, 'Ruby: Programowanie w praktyce', 'Bartłomiej Kowal'),
(698, 'Swift: Tworzenie aplikacji mobilnych', 'Katarzyna Nowak'),
(699, 'C dla zaawansowanych', 'Wojciech Kowalczyk'),
(700, 'React: Budowanie nowoczesnych interfejsów', 'Kamil Nowakowski'),
(701, 'Angular: Framework do budowy aplikacji webowych', 'Alicja Jankowska'),
(702, 'TypeScript: Programowanie z typami', 'Michał Wiśniewski'),
(703, 'Vue.js: Tworzenie responsywnych interfejsów', 'Anna Zalewska'),
(704, 'Node.js: Budowanie skalowalnych aplikacji', 'Paweł Kowalik'),
(705, 'Django: Tworzenie aplikacji internetowych', 'Karolina Nowak'),
(706, 'Express.js: Budowanie serwerów webowych', 'Krzysztof Wiśniewski'),
(707, 'MongoDB: Bazy danych NoSQL', 'Agata Kowalska'),
(708, 'SQL: Podstawy i zaawansowane techniki', 'Michał Wiśniewski'),
(709, 'Git: Wprowadzenie do systemu kontroli wersji', 'Adam Nowak'),
(710, 'Docker: Wprowadzenie do konteneryzacji', 'Piotr Kowalczyk'),
(711, 'Kubernetes: Orkiestracja kontenerami', 'Karolina Zalewska'),
(712, 'Machine Learning: Algorytmy i zastosowania', 'Marcin Nowak'),
(713, 'Deep Learning: Sieci neuronowe w praktyce', 'Alicja Kowalska'),
(714, 'Data Science: Analiza i wizualizacja danych', 'Wojciech Nowak'),
(715, 'Big Data: Przetwarzanie i analiza danych', 'Kamil Kowalski'),
(716, 'Blockchain: Technologia decentralizowanych systemów', 'Magdalena Zalewska'),
(717, 'Cybersecurity: Bezpieczeństwo systemów informatycznych', 'Paweł Nowak'),
(718, 'Cloud Computing: Wprowadzenie do usług chmurowych', 'Aleksandra Wiśniewska'),
(719, 'DevOps: Kultura współpracy i automatyzacji', 'Michał Kowalski'),
(720, 'Web Design: Tworzenie responsywnych stron', 'Katarzyna Zalewska'),
(721, 'UX/UI Design: Projektowanie intuicyjnych interfejsów', 'Adam Kowalczyk'),
(722, 'E-commerce: Budowanie sklepów internetowych', 'Karolina Nowakowska'),
(723, 'Mobile App Development: Tworzenie aplikacji mobilnych', 'Piotr Kowalski'),
(724, 'Game Development: Tworzenie gier komputerowych', 'Alicja Nowak'),
(725, 'Artificial Intelligence: Wprowadzenie do sztucznej inteligencji', 'Marcin Wiśniewski'),
(726, 'IoT: Internet Rzeczy w praktyce', 'Anna Kowalik'),
(727, 'RPA: Automatyzacja procesów biznesowych', 'Krzysztof Nowak'),
(728, 'VR and AR: Technologie wirtualnej i rozszerzonej rzeczywistości', 'Aleksandra Kowalska'),
(729, 'Quantum Computing: Kwantowe obliczenia', 'Paweł Wiśniewski'),
(730, 'IT Project Management: Zarządzanie projektami informatycznymi', 'Magdalena Kowalska'),
(731, 'ITIL: Zarządzanie usługami informatycznymi', 'Adam Nowakowski'),
(732, 'Scrum: Metodologia wytwarzania oprogramowania', 'Katarzyna Zalewska'),
(733, 'Agile Development: Elastyczne metodyki programowania', 'Karolina Nowak'),
(734, 'Software Testing: Testowanie oprogramowania', 'Piotr Kowalik'),
(735, 'Code Complete: Praktyki doskonałego programisty', 'Alicja Nowakowska'),
(736, 'Clean Code: Sztuka tworzenia czytelnego kodu', 'Michał Kowalski'),
(737, 'Design Patterns: Wzorce projektowe', 'Anna Kowalczyk'),
(738, 'Refactoring: Doskonalenie struktury istniejącego kodu', 'Marcin Wiśniewski'),
(739, 'The Pragmatic Programmer: Your Journey to Mastery', 'Dave Thomas'),
(740, 'Java Performance: The Definitive Guide', 'Benjamin J. Evans'),
(741, 'Python Cookbook', 'David Beazley'),
(742, 'Matematyka 1: Podręcznik dla szkół średnich', 'Maria Kowalska'),
(743, 'Fizyka 1: Podstawy fizyki klasycznej', 'Alicja Wiśniewska'),
(744, 'Chemia 1: Podstawy chemii organicznej', 'Piotr Kowalczyk'),
(745, 'Biologia 1: Podręcznik dla liceum', 'Anna Nowakowska'),
(746, 'Historia 1: Polska i świat w XIX wieku', 'Katarzyna Zalewska'),
(747, 'Geografia 1: Struktura geograficzna świata', 'Marcin Kowalski'),
(748, 'Informatyka 1: Podstawy programowania', 'Aleksandra Kowalik'),
(749, 'Wiedza o społeczeństwie 1: Podręcznik do nauki społeczności', 'Michał Wiśniewski'),
(750, 'Matematyka 2: Zaawansowane zagadnienia', 'Paweł Kowalczyk'),
(751, 'Fizyka 2: Elektromagnetyzm i optyka', 'Alicja Nowak'),
(752, 'Chemia 2: Reakcje chemiczne i chemia nieorganiczna', 'Piotr Kowalski'),
(753, 'Biologia 2: Genetyka i ewolucja', 'Karolina Zalewska'),
(754, 'Historia 2: Polska i świat w XX wieku', 'Anna Kowalik'),
(755, 'Geografia 2: Geografia społeczno-ekonomiczna', 'Marcin Nowak'),
(756, 'Informatyka 2: Algorytmy i struktury danych', 'Michał Kowalski'),
(757, 'Wiedza o społeczeństwie 2: Polityka i społeczeństwo', 'Alicja Kowalczyk'),
(758, 'Matematyka 3: Analiza matematyczna', 'Karolina Nowak'),
(759, 'Fizyka 3: Teoria względności i fizyka kwantowa', 'Michał Kowalski'),
(760, 'Chemia 3: Chemia fizyczna i organiczna', 'Aleksandra Wiśniewska'),
(761, 'Biologia 3: Anatomia i fizjologia człowieka', 'Piotr Kowalik'),
(762, 'Historia 3: Historia sztuki i kultury', 'Alicja Kowalczyk'),
(763, 'Geografia 3: Geografia polityczna i globalne problemy', 'Anna Nowakowska'),
(764, 'Informatyka 3: Bazy danych i programowanie obiektowe', 'Marcin Wiśniewski'),
(765, 'Wiedza o społeczeństwie 3: Współczesne problemy świata', 'Aleksandra Kowalik'),
(766, 'Matematyka 4: Geometria analityczna i algebra', 'Piotr Kowalczyk'),
(767, 'Fizyka 4: Mechanika kwantowa i fizyka statystyczna', 'Alicja Nowak'),
(768, 'Chemia 4: Chemia analityczna i technologia chemiczna', 'Michał Kowalski'),
(769, 'Biologia 4: Ekologia i ochrona środowiska', 'Karolina Zalewska'),
(770, 'Historia 4: Historia gospodarcza i społeczna', 'Anna Kowalik'),
(771, 'Geografia 4: Geografia kultury i globalne migracje', 'Marcin Kowalski'),
(772, 'Informatyka 4: Projektowanie systemów informatycznych', 'Michał Wiśniewski'),
(773, 'Wiedza o społeczeństwie 4: Filozofia i etyka', 'Aleksandra Kowalik'),
(774, 'Matematyka 5: Równania różniczkowe i algebra liniowa', 'Paweł Kowalczyk'),
(775, 'Fizyka 5: Fizyka cząstek elementarnych i astrofizyka', 'Alicja Nowak'),
(776, 'Chemia 5: Chemia bioorganiczna i biochemia', 'Piotr Kowalczyk'),
(777, 'Biologia 5: Biotechnologia i genetyka molekularna', 'Karolina Zalewska'),
(778, 'Historia 5: Historia myśli politycznej i społecznej', 'Anna Kowalik'),
(779, 'Geografia 5: Geografia polityczna świata i geopolityka', 'Marcin Kowalski'),
(780, 'Informatyka 5: Systemy operacyjne i sieci komputerowe', 'Michał Wiśniewski'),
(781, 'Wiedza o społeczeństwie 5: Psychologia społeczna', 'Aleksandra Kowalik'),
(782, 'Matematyka 6: Topologia i teoria liczb', 'Piotr Kowalczyk'),
(783, 'Fizyka 6: Fizyka medyczna i techniki pomiarowe', 'Alicja Nowak'),
(784, 'Chemia 6: Chemia materiałów i nanotechnologia', 'Michał Kowalski'),
(785, 'Biologia 6: Medycyna i anatomia porównawcza', 'Karolina Zalewska'),
(786, 'Historia 6: Historia sztuki i kultury', 'Anna Kowalik'),
(787, 'Geografia 6: Geografia społeczno-ekonomiczna świata', 'Marcin Kowalski'),
(788, 'Informatyka 6: Inżynieria oprogramowania i projektowanie interfejsów', 'Michał Wiśniewski'),
(789, 'Wiedza o społeczeństwie 6: Socjologia i antropologia kulturowa', 'Aleksandra Kowalik'),
(790, 'Miłość pod gwiazdami', 'Anna Kowalska'),
(791, 'Zakazane uczucie', 'Piotr Nowak'),
(792, 'Gorzka czekolada i miłość', 'Katarzyna Zalewska'),
(793, 'Bez wyjścia z miłości', 'Michał Wiśniewski'),
(794, 'Szept letniej nocy', 'Aleksandra Kowalik'),
(795, 'Strzał Amora', 'Karolina Nowak'),
(796, 'Za zamkniętymi drzwiami', 'Marcin Kowalski'),
(797, 'Błękitna roza', 'Alicja Nowakowska'),
(798, 'Cienie przeszłości', 'Paweł Kowalczyk'),
(799, 'Gra o miłość', 'Anna Nowakowska'),
(800, 'Tango serc', 'Adam Kowalczyk'),
(801, 'Zakochane przypadki', 'Alicja Wiśniewska'),
(802, 'Skrywane pragnienia', 'Piotr Kowalski'),
(803, 'Deszczowa miłość', 'Karolina Zalewska'),
(804, 'Za kulisami uczuć', 'Michał Wiśniewski'),
(805, 'Promienie miłości', 'Aleksandra Nowak'),
(806, 'Na skraju marzeń', 'Paweł Kowalik'),
(807, 'Gdy gasną gwiazdy', 'Katarzyna Nowak'),
(808, 'Złamane serce', 'Anna Kowalik'),
(809, 'Cicha obsesja', 'Marcin Kowalski'),
(810, 'Po drugiej stronie snu', 'Alicja Nowakowska'),
(811, 'Niepewność uczuć', 'Piotr Kowalski'),
(812, 'W krainie marzeń', 'Karolina Zalewska'),
(813, 'Słodki zaklęty moment', 'Michał Wiśniewski'),
(814, 'Złote serce', 'Aleksandra Kowalik'),
(815, 'Gwiazdy nad oceanem', 'Adam Kowalczyk'),
(816, 'Zakochane dusze', 'Anna Nowakowska'),
(817, 'Bez śladu miłości', 'Paweł Kowalczyk'),
(818, 'Za zamkniętymi drzwiami', 'Katarzyna Zalewska'),
(819, 'Czas miłości', 'Michał Wiśniewski'),
(820, 'Uwięziona w uczuciach', 'Alicja Nowak'),
(821, 'Słodka zemsta miłości', 'Piotr Kowalski'),
(822, 'Romans pod gwiazdami', 'Karolina Nowak'),
(823, 'Zakazane pragnienia', 'Aleksandra Kowalik'),
(824, 'Tango uczuć', 'Marcin Kowalski'),
(825, 'Szepty miłości', 'Anna Kowalska'),
(826, 'Gra uczuć', 'Adam Kowalczyk'),
(827, 'Cieniste sekrety', 'Paweł Kowalik'),
(828, 'Za zamkniętymi kurtynami', 'Alicja Nowakowska'),
(829, 'Deszczowa noc', 'Michał Wiśniewski'),
(830, 'Utkane marzenia', 'Aleksandra Nowak'),
(831, 'Na skraju szczęścia', 'Piotr Kowalski'),
(832, 'W cieniu zakazanej miłości', 'Karolina Zalewska'),
(833, 'Po drugiej stronie serca', 'Anna Nowakowska'),
(834, 'Miłość w oczach niebieskich', 'Marcin Kowalski'),
(835, 'Zaklęte uczucia', 'Adam Kowalczyk'),
(836, 'Tajemnice serca', 'Alicja Wiśniewska'),
(837, 'Zmierzch uczuć', 'Paweł Kowalczyk'),
(838, 'Bezpowrotne zaklęcie', 'Katarzyna Nowak'),
(839, 'Słodki romans', 'Michał Wiśniewski'),
(840, 'Gwiazdy miłości', 'Aleksandra Nowak'),
(841, 'Zew Cthulhu', 'H.P. Lovecraft'),
(842, 'Dom na Wzgórzu', 'Shirley Jackson'),
(843, 'Martwi', 'Gregory Scared'),
(844, 'Krąg', 'Dave Eggers'),
(845, 'Inwazja', 'Robin Cook'),
(846, 'Opowieści niesamowite', 'Edgar Allan Poe'),
(847, 'Czary Mary', 'Mary Chary'),
(848, 'Dom na skale', 'William Faulkner'),
(849, 'Koszmar z ulicy Wiązów', 'Wes Craven'),
(850, 'Cisza owadów', 'Michael Crichton'),
(851, 'Duch w labiryncie', 'Mark Z. Danielewski'),
(852, 'Nocny portier', 'Lilian Jackson Braun'),
(853, 'Dramat Dominica', 'Dominic Devilsville'),
(854, 'Wpuszczony w kowadło', 'Stephen King'),
(855, 'Strach', 'H.P. Lovecraft'),
(856, 'Nadchodzi burza', 'Stephen King'),
(857, 'Klatka', 'Ruth Ware'),
(858, 'Kruk', 'Edgar Allan Poe'),
(859, 'Czerwony pokój', 'August Strindberg'),
(860, 'Zaklęty dom', 'Shirley Jackson'),
(861, 'Potępieniec', 'Fiodor Dostojewski'),
(862, 'Ponury dom', 'Agatha Christie'),
(863, 'Zaginiona', 'Gillian Flynn'),
(864, 'Głosy', 'Dean Koontz'),
(865, 'Labirynt', 'Kate Mosse'),
(866, 'Błękitny ognik', 'Stephen King'),
(867, 'Demonologia', 'Rick Moody'),
(868, 'Bezlitosny', 'Karolina Zalewska'),
(869, 'Pieśń ciemności', 'Robert Jordan'),
(870, 'Ostatni dom na lewo', 'Wes Craven'),
(871, 'Głos z grobu', 'Agatha Christie'),
(872, 'Nienawidzę tego miejsca', 'Tonya Hurley'),
(873, 'Płonący krzyż', 'Ray Bradbury'),
(874, 'Wszyscy mamy tajemnice', 'Karen M. McManus'),
(875, 'Nieprzyjemny dom', 'Shirley Jackson'),
(876, 'Zmierzch', 'Stephenie Meyer'),
(877, 'Czarownice z Salem', 'Arthur Miller'),
(878, 'Zagubieni w lasach', 'Gillian Flynn'),
(879, 'Bezsenność', 'Stephen King'),
(880, 'Pamiętnik starego zegarmistrza', 'Carlos Ruiz Zafón'),
(881, 'Rytuał', 'Adam Nevill'),
(882, 'Zła godzina', 'Anne Rice'),
(883, 'Nie oglądaj się teraz', 'Daphne du Maurier'),
(884, 'Zagubiona autostrada', 'Neil Gaiman'),
(885, 'Popatrz w prawo', 'Damien Truedread'),
(886, 'Krzyk ciszy', 'Dean Koontz'),
(887, 'Zawiedzione zaufanie', 'Gillian Flynn'),
(888, 'Dziennik ciemności', 'Aleksandra Nowak'),
(889, 'Zabójcza cisza', 'Thomas Harris'),
(890, 'Szklana kula', 'Robert Silverberg'),
(891, 'Klątwa Szeptaczy', 'Zofia Ziemann'),
(892, 'Szmaragdowy Księżyc', 'Stanisław Niedźwiecki'),
(893, 'Ostatni Zaklinacz Ognia', 'Eliza Malinowska'),
(894, 'Księga Zmierzchu', 'Kamil Nowak'),
(895, 'Cienie Zapomnianych', 'Marta Wolska'),
(896, 'Mroczny Znak', 'Filip Jastrzębski'),
(897, 'Smocza Moc', 'Dominika Kowalczyk'),
(898, 'Wiatr Wędrujących Gwiazd', 'Artur Kowalik'),
(899, 'Labirynt Mgły', 'Magdalena Zalewska'),
(900, 'Kraina Wiecznego Cienia', 'Adrian Kowalski'),
(901, 'Zaklęta Wyspa', 'Natalia Nowak'),
(902, 'Droga Królowej', 'Tomasz Zalewski'),
(903, 'Gwiezdne Runy', 'Monika Wiśniewska'),
(904, 'Legendy Zapomnianych Krain', 'Bartosz Kowalczyk'),
(905, 'Ostatni Elf', 'Aleksandra Zalewska'),
(906, 'Tajemnicze Ostrze', 'Rafał Nowak'),
(907, 'Złota Wieża', 'Karolina Zalewska'),
(908, 'Przeznaczenie Smoków', 'Dawid Kowalski'),
(909, 'Magia Płomieni', 'Dominika Nowakowska'),
(910, 'Wędrowiec Cieni', 'Artur Kowalik'),
(911, 'Słowiańska Saga', 'Marta Zalewska'),
(912, 'Dziedzictwo Księżyca', 'Kamil Kowalczyk'),
(913, 'Wrota Zagubionego Królestwa', 'Alicja Nowakowska'),
(914, 'Czarodziejski Labirynt', 'Michał Zalewski'),
(915, 'Szept Drzew', 'Aleksandra Wiśniewska'),
(916, 'Znak Magii', 'Piotr Kowalczyk'),
(917, 'Podniebna Kraina', 'Karolina Nowak'),
(918, 'Ostatni Strażnik', 'Rafał Zalewski'),
(919, 'Zagubiona Opowieść', 'Magdalena Kowalska'),
(920, 'Legendy Krasnoludzkiego Królestwa', 'Bartłomiej Nowak'),
(921, 'Władca Cieni', 'Aleksandra Kowalik'),
(922, 'Skryte Siły', 'Krzysztof Zalewski'),
(923, 'Smocze Runy', 'Anna Nowakowska'),
(924, 'Złote Miasto', 'Paweł Kowalczyk'),
(925, 'Wieża Mędrców', 'Monika Wiśniewska'),
(926, 'Księga Czarownic', 'Artur Kowalik'),
(927, 'Wędrowiec Pośród Gwiazd', 'Dominika Nowakowska'),
(928, 'Sny Nadziei', 'Rafał Nowak'),
(929, 'Ród Elfów', 'Karolina Zalewska'),
(930, 'Mroczny Portal', 'Dawid Kowalski'),
(931, 'Legenda Dzikiego Lasu', 'Alicja Nowakowska'),
(932, 'Ostatnia Krucjata', 'Michał Zalewski'),
(933, 'Szept Straconego Świata', 'Piotr Kowalczyk'),
(934, 'Wyspa Młodych Duchów', 'Aleksandra Wiśniewska'),
(935, 'Przeznaczenie Zaklętych', 'Krzysztof Zalewski'),
(936, 'Podniebne Kamienie', 'Anna Nowakowska'),
(937, 'Strażnik Starych Legend', 'Paweł Kowalczyk'),
(938, 'Magia Zapomnianych Marzeń', 'Monika Wiśniewska'),
(939, 'Księga Zaginionych Czasów', 'Artur Kowalik'),
(940, 'Legenda Ostatniego Królestwa', 'Dominika Nowakowska'),
(941, 'Zaklęty Las', 'Rafał Zalewski'),
(942, 'Złodziejka Cieni', 'Bartłomiej Nowak'),
(943, 'Szmaragdowa Rzeka', 'Aleksandra Kowalik'),
(944, 'Wędrowiec Wiatrów', 'Krzysztof Zalewski'),
(945, 'Gwiezdna Przełęcz', 'Anna Nowakowska'),
(946, 'Znak Wielkiego Drzewa', 'Piotr Kowalczyk'),
(947, 'Władca Starych Run', 'Karolina Zalewska'),
(948, 'Zmierzch Czarodziejki', 'Dawid Kowalski'),
(949, 'Klątwa Zaklętych', 'Alicja Nowakowska'),
(950, 'Ostatni Upiór', 'Michał Zalewski'),
(951, 'Znak czterech', 'Arthur Conan Doyle'),
(952, 'Przygody Sherlocka Holmesa', 'Arthur Conan Doyle'),
(953, 'Dzienniki Sherlocka Holmesa', 'Arthur Conan Doyle'),
(954, 'Pies Baskervilleów', 'Arthur Conan Doyle'),
(955, 'Powrót Sherlocka Holmesa', 'Arthur Conan Doyle'),
(956, 'Dolina strachu', 'Arthur Conan Doyle'),
(957, 'Pożegnalny ukłon', 'Arthur Conan Doyle');

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
  `blurb` text DEFAULT 'Brak opisu',
  `status` enum('AVAILABLE','UNAVAILABLE') NOT NULL DEFAULT 'AVAILABLE',
  `library_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `copy`
--

INSERT INTO `copy` (`copy_id`, `publisher`, `isbn`, `release_year`, `format`, `language`, `blurb`, `status`, `library_id`, `book_id`) VALUES
(1, 'Wydawnictwo XYZ', '9781234567855', 2022, 'BOOK', 'Polski', '\"Pan Wołodyjowski\" to opowieść o nieustraszonym pułkowniku Michału Wołodyjowskim, który stawia czoła zagrożeniom tureckiego najazdu w Rzeczypospolitej szlacheckiej. W tej epickiej historii miłość, honor i odwaga przeplatają się w trudnym tańcu bohatera z politycznymi intrygami i militarnymi konfliktami.', 'AVAILABLE', 1, 1),
(2, 'Inne Wydawnictwo', '9782345678901', 2021, 'BOOK', 'Angielski', '\"1984\" by George Orwell is a dystopian masterpiece that explores a nightmarish future where a totalitarian regime, led by the enigmatic Big Brother, controls every aspect of its citizens\' lives. Through the eyes of protagonist Winston Smith, the novel delves into the chilling consequences of thought control, surveillance, and the manipulation of truth in a society stripped of individuality and freedom.', 'AVAILABLE', 1, 2),
(3, 'Wydawnictwo ABC', '9783456789436', 2020, 'BOOK', 'Polski', '\"Erystyka\" Arthura Schopenhauera to niezwykłe dzieło, w którym autor odkrywa sztukę argumentacji i sztuczki używane w dyskusjach. Z głębokim zrozumieniem ludzkiej psychologii Schopenhauer ukazuje, jak manipulować retoryką i jakie pułapki czyhają na niewprawionego dyskutanta. To praktyczne kompendium dla tych, którzy chcą zrozumieć tajniki perswazji i obronić się przed erystycznymi chwytami w dialogu.', 'UNAVAILABLE', 2, 3),
(4, 'Nowoczesne Wydawnictwo', '9784567890523', 2019, 'BOOK', 'Angielski', 'A timeless American classic that delves into the glittering, yet ultimately hollow, world of the Roaring Twenties. Through the eyes of the enigmatic Jay Gatsby and the narrator Nick Carraway, the novel unravels themes of wealth, love, and the elusive American Dream, painting a poignant portrait of a society intoxicated by excess and haunted by unattainable aspirations.', 'AVAILABLE', 2, 4),
(5, 'Książki Świata', '9785678907234', 2022, 'EBOOK', 'Polski', '\"Rozprawa o metodzie\" to kluczowe dzieło René Descartesa, w którym filozof przedstawia swoje zasady myślowe i metodyczne podejście do poznania. Opowiadając się za racjonalnym sceptycyzmem, Descartes podkreśla znaczenie wątpienia i samodzielnego myślenia, rzucając jednocześnie wyzwanie utartym przekonaniom swojej epoki i stawiając fundamenty dla nowoczesnej filozofi', 'AVAILABLE', 3, 5),
(6, 'Wydawnictwo XYZ', '9786789012645', 2021, 'BOOK', 'Angielski', 'A beloved fairy tale by Hans Christian Andersen, follows the journey of a cygnet ostracized for its perceived ugliness in a duckling family. Through resilience and transformation, the story celebrates the discovery of one\'s true identity, beauty, and acceptance, imparting a timeless lesson on the power of self-discovery and inner worth.', 'UNAVAILABLE', 3, 6),
(7, 'Inne Wydawnictwo', '9787890123486', 2020, 'BOOK', 'Polski', '\"Władca Pierścieni\" to epicka opowieść J.R.R. Tolkiena o wyprawie młodego hobbita Froda Bagginsa, który wraz z niezwykłym towarzystwem wyrusza, by zniszczyć potężny Pierścień Władzy. To niezwykłe dzieło literatury fantasy urzeka czytelników nie tylko wspaniałym światem Śródziemia, lecz także głębokimi przemyśleniami na temat przyjaźni, odwagi i wiecznej walki dobra ze złem.', 'AVAILABLE', 4, 7),
(8, 'Wydawnictwo ABC', '9788901234560', 2019, 'BOOK', 'Angielski', 'W \"Dumie i uprzedzeniu\" Jane Austen, śmiało zaklasyfikowanej jako arcydzieło literatury romantycznej, czytelnik wchodzi w świat burzliwych romansów i społecznych konwenansów XIX wieku. Opowiadanie o miłości i uprzedzeniach między Elizabeth Bennet a panem Darcy\'m stanowi niezapomnianą podróż przez zawiłości ludzkich uczuć i złożoność społeczeństwa tego czasu.', 'UNAVAILABLE', 4, 8),
(9, 'Nowoczesne Wydawnictwo', '9789012345679', 2022, 'BOOK', 'Polski', '„Wiele hałasu o nic” to komedia Williama Shakespearea, której akcja toczy się w krainie Messyny. Historia opowiada o dwóch parach zakochanych, Benedykcie i Beatrycze oraz Klaudiuszu i Hero, które stają w obliczu intryg i zawirowań miłosnych. Pełna humoru i zgryźliwego spojrzenia na ludzkie relacje, sztuka ta rzuca spojrzenie na to, jak często błahe sytuacje mogą prowadzić do wielkiego zamieszania.', 'AVAILABLE', 5, 9),
(10, 'Książki Świata', '9780123456784', 2021, 'BOOK', 'Angielski', '\"The Chronicles of Narnia\" by C.S. Lewis is a captivating series that transports readers to the magical land of Narnia, where talking animals, mythical creatures, and epic adventures unfold. Through the Pevensie siblings\' remarkable journey, the series weaves a rich tapestry of courage, friendship, and the eternal struggle between good and evil.', 'AVAILABLE', 5, 10),
(11, 'Wydawnictwo XYZ', '9781234567895', 2020, 'BOOK', 'Rosyjski', '\"Преступление и наказание\" - великолепное произведение Федора Достоевского, рассказывающее о молодом студенте Родионе Раскольникове, который, убивая старую личварку Алёну Ивановну, сталкивается с моральными и психологическими последствиями своего поступка. Роман исследует глубину человеческой души, а его герой становится объектом изучения вопросов нравственности, вины и искупления.', 'AVAILABLE', 1, 11),
(12, 'Inne Wydawnictwo', '9782345678971', 2019, 'BOOK', 'Polski', '\"Moby Dick\" to powieść Hermana Melville\'a o kapitanie Ahabie, który walczy z obsesyjną zemstą na olbrzymim białym wielorybie, znanym jako Moby Dick. Opowieść, narracyjnie prowadzona przez marynarza Ishmaela, porusza tematy obsesji, natury ludzkiej, i relacji z nieuchwytną siłą przyrody.', 'UNAVAILABLE', 1, 12),
(13, 'Wydawnictwo ABC', '9783456789012', 2022, 'BOOK', 'Polski', '\"Odyseja\" to starożytny epos przypisywany greckiemu poecie Homerowi. Opowiada o przygodach Odyseusza, króla Itaki, który po zakończeniu wojny trojańskiej walczy o powrót do domu. Podczas długiej podróży musi przeciwstawić się licznym przeszkodom, w tym mitycznym stworzeniom i bogom. \"Odyseja\" to nie tylko opowieść o heroicznej podróży, ale także rozważania na temat wierności, mądrości i siły ludzkiego ducha.', 'AVAILABLE', 2, 13),
(14, 'Nowoczesne Wydawnictwo', '9784567890123', 2021, 'BOOK', 'Angielski', '\"Frankenstein\" by Mary Shelley is a gothic masterpiece that explores the consequences of scientific ambition and the pursuit of knowledge. Dr. Victor Frankenstein\'s creation of a living being from reanimated corpses leads to a tragic tale of isolation, societal rejection, and the profound questions about the ethical boundaries of scientific discovery and the responsibilities that come with playing god.', 'AVAILABLE', 2, 14),
(15, 'Książki Świata', '9785678901234', 2020, 'BOOK', 'Polski', 'Zapraszamy do fascynującej podróży z Robinsonem Crusoe - młodym angielskim żeglarzem, który przetrwał na bezludnej wyspie. Jego walka z samotnością, zdobywanie umiejętności przetrwania i niezwykłe przygody sprawiają, że ta klasyczna opowieść Daniela Defoe wciąż porusza serca czytelników. Odkryj magię przygody, nauki życiowej i triumfu ludzkiego ducha w tej niezapomnianej powieści przygodowej!', 'UNAVAILABLE', 3, 15),
(16, 'Wydawnictwo XYZ', '9786789012345', 2019, 'EBOOK', 'Polski', '\"Pan Wołodyjowski\" to opowieść o nieustraszonym pułkowniku Michału Wołodyjowskim, który stawia czoła zagrożeniom tureckiego najazdu w Rzeczypospolitej szlacheckiej. W tej epickiej historii miłość, honor i odwaga przeplatają się w trudnym tańcu bohatera z politycznymi intrygami i militarnymi konfliktami.', 'AVAILABLE', 3, 1),
(17, 'Inne Wydawnictwo', '9787890123456', 2022, 'BOOK', 'Polski', '\"1984\" George\'a Orwella przenosi czytelnika do ponurej rzeczywistości totalitarnej władzy, gdzie każda myśl jest kontrolowana, a prawda podlega manipulacji. W świecie bezwzględnej inwigilacji śledzimy losy buntowniczego Winstona Smitha, który staje do walki o indywidualizm w obliczu bezlitosnego reżimu.', 'AVAILABLE', 4, 2),
(18, 'Wydawnictwo ABC', '9788901234567', 2021, 'BOOK', 'Francuski', 'Le Discours de la méthode (1637) est le manifeste de la philosophie cartésienne, visant à unifier les sciences et établir une science universelle. Cette œuvre défend la primauté de la raison contre toute tradition et autorité, avec pour objectif ultime d\'atteindre la certitude philosophique.', 'AVAILABLE', 4, 5),
(19, 'Nowoczesne Wydawnictwo', '9789012345678', 2020, 'EBOOK', 'Polski', 'Wyjątkowe piękno kryje się w odrzuconym – to przesłanie, które niesie ze sobą \'Brzydkie Kaczątko\' Hansa Christiana Andersena. Ta ujmująca baśń opowiada o kaczątku, które, mimo swojej odmienności, odnajduje swoją prawdziwą wartość, przypominając nam o sile akceptacji i pięknie ukrytym głęboko wewnątrz każdej istoty.', 'AVAILABLE', 5, 6),
(20, 'Książki Świata', '9780123456789', 2019, 'BOOK', 'Polski', '\"Władca Pierścieni\" to epicka opowieść J.R.R. Tolkiena o wyprawie młodego hobbita Froda Bagginsa, który wraz z niezwykłym towarzystwem wyrusza, by zniszczyć potężny Pierścień Władzy. To niezwykłe dzieło literatury fantasy urzeka czytelników nie tylko wspaniałym światem Śródziemia, lecz także głębokimi przemyśleniami na temat przyjaźni, odwagi i wiecznej walki dobra ze złem.', 'UNAVAILABLE', 5, 7),
(21, 'Wydawnictwo XYZ', '9781234567890', 2022, 'BOOK', 'Polski', '\"Opowieści z Narnii\" to seria siedmiu powieści C.S. Lewisa, zabierająca czytelników w magiczne podróże do krainy Narnii, gdzie dobro i zło toczą wieczną walkę. Seria dotyka tematów przyjaźni, odwagi i wiary, tworząc niezapomnianą opowieść dla czytelników wszystkich grup wiekowych.', 'AVAILABLE', 1, 10),
(22, 'Inne Wydawnictwo', '9782345678931', 2021, 'BOOK', 'Polski', '\"Zbrodnia i kara\" to klasyczna powieść Fiodora Dostojewskiego, która skupia się na losach Rodiona Raskolnikowa, studenta w Petersburgu. Raskolnikow, przekonany o swojej wyjątkowości, popełnia brutalne morderstwo, co prowadzi go do wewnętrznej walki z moralnymi dylematami oraz doświadczenia kary psychicznej. Powieść analizuje tematy winy, kary, moralności i cierpienia, stawiając pytania dotyczące ludzkiej natury i etyki.', 'AVAILABLE', 1, 11),
(23, 'Wydawnictwo ABC', '9783456789011', 2020, 'EBOOK', 'Polski', '\"Odyseja\" to starożytny epos przypisywany greckiemu poecie Homerowi. Opowiada o przygodach Odyseusza, króla Itaki, który po zakończeniu wojny trojańskiej walczy o powrót do domu. Podczas długiej podróży musi przeciwstawić się licznym przeszkodom, w tym mitycznym stworzeniom i bogom. \"Odyseja\" to nie tylko opowieść o heroicznej podróży, ale także rozważania na temat wierności, mądrości i siły ludzkiego ducha.', 'AVAILABLE', 2, 13),
(24, 'Nowoczesne Wydawnictwo', '9784567890183', 2019, 'EBOOK', 'Polski', '\"Frankenstein\" to klasyczna powieść Mary Shelley, która opowiada historię młodego naukowca, Victora Frankenstein, który tworzy istotę ożywioną z martwych ciał. Twór Victora staje się potworem, który wobec odrzucenia i samotności zaczyna pogrążać się w zbrodniach. Powieść porusza tematy nauki, etyki, samotności i ludzkiej natury, stając się jednym z najważniejszych dzieł literatury gotyckiej i science fiction.', 'AVAILABLE', 2, 14),
(25, 'Książki Świata', '9785678901284', 2022, 'BOOK', 'Polski', '\"1984\" George\'a Orwella przenosi czytelnika do ponurej rzeczywistości totalitarnej władzy, gdzie każda myśl jest kontrolowana, a prawda podlega manipulacji. W świecie bezwzględnej inwigilacji śledzimy losy buntowniczego Winstona Smitha, który staje do walki o indywidualizm w obliczu bezlitosnego reżimu.', 'AVAILABLE', 3, 2),
(26, 'Wydawnictwo XYZ', '9786789012045', 2021, 'BOOK', 'Polski', 'Wyjątkowe piękno kryje się w odrzuconym – to przesłanie, które niesie ze sobą \'Brzydkie Kaczątko\' Hansa Christiana Andersena. Ta ujmująca baśń opowiada o kaczątku, które, mimo swojej odmienności, odnajduje swoją prawdziwą wartość, przypominając nam o sile akceptacji i pięknie ukrytym głęboko wewnątrz każdej istoty.', 'AVAILABLE', 3, 6),
(27, 'Inne Wydawnictwo', '9787890123956', 2020, 'BOOK', 'Polski', '\"Władca Pierścieni\" to epicka opowieść J.R.R. Tolkiena o wyprawie młodego hobbita Froda Bagginsa, który wraz z niezwykłym towarzystwem wyrusza, by zniszczyć potężny Pierścień Władzy. To niezwykłe dzieło literatury fantasy urzeka czytelników nie tylko wspaniałym światem Śródziemia, lecz także głębokimi przemyśleniami na temat przyjaźni, odwagi i wiecznej walki dobra ze złem.', 'UNAVAILABLE', 4, 7),
(28, 'Wydawnictwo ABC', '9788901234507', 2019, 'BOOK', 'Polski', '\"Odyseja\" to starożytny epos przypisywany greckiemu poecie Homerowi. Opowiada o przygodach Odyseusza, króla Itaki, który po zakończeniu wojny trojańskiej walczy o powrót do domu. Podczas długiej podróży musi przeciwstawić się licznym przeszkodom, w tym mitycznym stworzeniom i bogom. \"Odyseja\" to nie tylko opowieść o heroicznej podróży, ale także rozważania na temat wierności, mądrości i siły ludzkiego ducha.', 'AVAILABLE', 4, 13);

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
  `position` enum('MANAGER','LIBRARIAN') NOT NULL DEFAULT 'LIBRARIAN',
  `library_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `first_name`, `last_name`, `address`, `phone_number`, `position`, `library_id`, `account_id`) VALUES
(1, 'Jan', 'Kowalski', 'ul. Główna 123', '+48123456789', 'MANAGER', 1, 1),
(2, 'Anna', 'Nowak', 'ul. Dębowa 456', '+48451545145', 'LIBRARIAN', 2, 2),
(3, 'Robert', 'Jankowski', 'ul. Sosnowa 789', '+48789289489', 'LIBRARIAN', 3, 3),
(4, 'Emilia', 'Wiśniewska', 'ul. Lipowa 101', '+48123948576', 'LIBRARIAN', 4, 4),
(5, 'Michał', 'Brązowski', 'ul. Modrzewiowa 202', '+48987654444', 'MANAGER', 5, 5),
(6, 'Amanda', 'Miler', 'ul. Brzozowa 303', '+48111222334', 'LIBRARIAN', 1, 6),
(7, 'Daniel', 'Dawidowski', 'ul. Cedrowa 404', '+48444555667', 'LIBRARIAN', 2, 7),
(8, 'Zofia', 'Pasińska', 'ul. Stumilowa 100', '+48777888900', 'MANAGER', 3, 8),
(9, 'Rafał', 'Anderson', 'ul. Orzechowa 606', '+48123456790', 'LIBRARIAN', 4, 9),
(10, 'Joanna', 'Tatrzańska', 'ul. Świerkowa 707', '+48987654322', 'LIBRARIAN', 5, 10);

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
  `return_date` date NOT NULL DEFAULT (curdate() + interval 30 day),
  `status` enum('ACTIVE','RETURNED','OVERDUE') NOT NULL DEFAULT 'ACTIVE',
  `employee_id` int(11) DEFAULT NULL,
  `copy_id` int(11) DEFAULT NULL,
  `reader_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`loan_id`, `loan_date`, `return_date`, `status`, `employee_id`, `copy_id`, `reader_id`) VALUES
(1, '2023-01-10', '2023-02-10', 'RETURNED', 6, 1, 1),
(2, '2023-01-12', '2023-02-12', 'RETURNED', 3, 25, 3),
(3, '2023-01-17', '2023-02-17', 'RETURNED', 6, 2, 22),
(4, '2023-01-20', '2023-02-20', 'RETURNED', 2, 4, 5),
(5, '2023-01-24', '2023-02-24', 'RETURNED', 7, 3, 8),
(6, '2023-01-28', '2023-02-28', 'RETURNED', 3, 6, 17),
(7, '2023-02-01', '2023-03-01', 'RETURNED', 4, 28, 16),
(8, '2023-02-04', '2023-03-04', 'RETURNED', 9, 17, 2),
(9, '2023-02-05', '2023-03-05', 'RETURNED', 10, 9, 23),
(10, '2023-02-13', '2023-03-13', 'RETURNED', 9, 7, 20),
(11, '2023-02-16', '2023-03-16', 'RETURNED', 4, 8, 4),
(12, '2023-02-21', '2023-03-21', 'RETURNED', 6, 12, 19),
(13, '2023-02-25', '2023-03-25', 'RETURNED', 9, 27, 16),
(14, '2023-02-26', '2023-03-26', 'RETURNED', 2, 14, 5),
(15, '2023-02-26', '2023-03-26', 'RETURNED', 3, 15, 1),
(16, '2023-03-07', '2024-04-07', 'RETURNED', 3, 16, 22),
(17, '2023-03-12', '2024-05-12', 'RETURNED', 4, 17, 13),
(18, '2023-03-15', '2024-04-15', 'RETURNED', 9, 18, 6),
(19, '2023-03-27', '2024-04-27', 'RETURNED', 10, 10, 11),
(20, '2023-03-31', '2024-05-01', 'RETURNED', 7, 3, 18),
(21, '2023-04-01', '2023-05-01', 'RETURNED', 6, 21, 12),
(22, '2023-04-01', '2023-05-01', 'RETURNED', 6, 22, 7),
(23, '2023-04-02', '2023-05-02', 'RETURNED', 10, 19, 17),
(24, '2023-04-09', '2023-05-09', 'RETURNED', 2, 24, 16),
(25, '2023-04-21', '2023-05-21', 'RETURNED', 3, 26, 7),
(26, '2023-04-22', '2023-05-22', 'RETURNED', 7, 13, 1),
(27, '2023-04-25', '2023-05-25', 'RETURNED', 6, 11, 3),
(28, '2023-04-25', '2023-05-25', 'RETURNED', 7, 23, 19),
(29, '2023-04-29', '2023-06-29', 'RETURNED', 6, 1, 20),
(30, '2023-05-07', '2023-06-07', 'RETURNED', 6, 12, 8),
(31, '2023-05-08', '2023-06-08', 'RETURNED', 3, 2, 5),
(32, '2023-05-09', '2023-06-09', 'RETURNED', 7, 14, 14),
(33, '2023-05-10', '2023-06-10', 'RETURNED', 6, 21, 10),
(34, '2023-05-14', '2023-06-14', 'RETURNED', 9, 18, 15),
(35, '2023-05-18', '2023-06-18', 'RETURNED', 10, 19, 9),
(36, '2023-05-26', '2023-06-26', 'RETURNED', 2, 13, 13),
(37, '2023-05-31', '2023-07-01', 'RETURNED', 6, 21, 21),
(38, '2023-06-05', '2023-07-05', 'RETURNED', 4, 27, 22),
(39, '2023-06-15', '2023-07-15', 'RETURNED', 7, 23, 23),
(40, '2023-06-16', '2023-07-16', 'RETURNED', 2, 24, 9),
(41, '2023-06-13', '2023-07-13', 'RETURNED', 3, 25, 15),
(42, '2023-06-30', '2023-07-30', 'RETURNED', 9, 17, 11),
(43, '2023-07-05', '2023-08-05', 'RETURNED', 10, 20, 22),
(44, '2023-07-09', '2023-08-09', 'RETURNED', 10, 10, 21),
(45, '2023-07-11', '2023-08-11', 'RETURNED', 6, 2, 14),
(46, '2023-07-31', '2023-08-31', 'RETURNED', 4, 8, 19),
(47, '2023-08-02', '2023-09-02', 'RETURNED', 9, 7, 20),
(48, '2023-08-06', '2023-09-06', 'RETURNED', 2, 23, 13),
(49, '2023-08-13', '2023-09-13', 'RETURNED', 7, 24, 2),
(50, '2023-08-19', '2023-09-19', 'RETURNED', 3, 25, 4),
(51, '2023-08-22', '2023-09-22', 'RETURNED', 6, 1, 5),
(52, '2023-08-26', '2023-09-26', 'RETURNED', 6, 11, 15),
(53, '2023-09-08', '2023-10-08', 'RETURNED', 2, 14, 17),
(54, '2023-09-10', '2023-10-10', 'RETURNED', 4, 18, 12),
(55, '2023-09-11', '2023-10-11', 'RETURNED', 3, 6, 4),
(56, '2023-09-18', '2023-10-18', 'RETURNED', 3, 16, 7),
(57, '2023-09-20', '2023-10-20', 'RETURNED', 6, 2, 18),
(58, '2023-09-29', '2023-10-29', 'RETURNED', 3, 26, 23),
(59, '2023-10-03', '2023-11-03', 'RETURNED', 3, 15, 10),
(60, '2023-10-07', '2023-11-07', 'RETURNED', 9, 17, 5),
(61, '2023-10-13', '2023-11-13', 'RETURNED', 4, 18, 20),
(62, '2023-10-23', '2023-11-23', 'RETURNED', 10, 19, 16),
(63, '2023-10-24', '2023-11-24', 'RETURNED', 4, 18, 6),
(64, '2023-10-28', '2023-11-28', 'RETURNED', 6, 21, 12),
(65, '2023-11-04', '2023-12-04', 'RETURNED', 6, 22, 18),
(66, '2023-11-05', '2023-12-05', 'RETURNED', 2, 23, 23),
(67, '2023-11-20', '2023-12-20', 'ACTIVE', 7, 3, 1),
(68, '2023-11-28', '2023-12-28', 'ACTIVE', 3, 6, 3),
(69, '2023-12-02', '2023-01-02', 'ACTIVE', 4, 8, 13),
(70, '2023-12-02', '2023-01-02', 'ACTIVE', 6, 12, 23),
(71, '2023-12-02', '2023-01-02', 'ACTIVE', 3, 15, 5),
(72, '2023-12-02', '2023-01-02', 'ACTIVE', 10, 20, 18),
(73, '2023-12-02', '2023-01-02', 'ACTIVE', 9, 27, 8);

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
  `status` enum('REMAINING','READY') NOT NULL DEFAULT 'REMAINING',
  `reader_id` int(11) DEFAULT NULL,
  `copy_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_date`, `status`, `reader_id`, `copy_id`) VALUES
(1, '2023-12-20', 'REMAINING', 1, 5),
(2, '2023-12-20', 'READY', 2, 1),
(3, '2023-12-21', 'REMAINING', 3, 20),
(4, '2023-12-21', 'READY', 4, 10),
(5, '2023-12-22', 'REMAINING', 5, 25),
(6, '2023-12-22', 'REMAINING', 6, 3),
(7, '2023-12-23', 'READY', 7, 18),
(8, '2023-12-23', 'REMAINING', 8, 12),
(9, '2023-12-24', 'READY', 9, 1),
(10, '2023-12-24', 'REMAINING', 10, 22),
(11, '2023-12-25', 'READY', 11, 8),
(12, '2023-12-25', 'REMAINING', 12, 27),
(13, '2023-12-26', 'REMAINING', 13, 14),
(14, '2023-12-26', 'READY', 14, 7),
(15, '2023-12-27', 'REMAINING', 15, 23),
(16, '2023-12-27', 'READY', 16, 6),
(17, '2023-12-28', 'REMAINING', 17, 16),
(18, '2023-12-28', 'REMAINING', 18, 9),
(19, '2023-12-29', 'READY', 19, 21),
(20, '2023-12-29', 'REMAINING', 20, 2);

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
-- Wyzwalacze `reader`
--
DELIMITER $$
CREATE TRIGGER `delete_reader_ref` BEFORE DELETE ON `reader` FOR EACH ROW BEGIN
    DELETE FROM loan WHERE reader_id = OLD.reader_id;
    DELETE FROM orders WHERE reader_id = OLD.reader_id;
END
$$
DELIMITER ;

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
  ADD KEY `copy_id` (`copy_id`);

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
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1025;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=958;

--
-- AUTO_INCREMENT for table `copy`
--
ALTER TABLE `copy`
  MODIFY `copy_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  MODIFY `loan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `opening`
--
ALTER TABLE `opening`
  MODIFY `opening_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `reader`
--
ALTER TABLE `reader`
  MODIFY `reader_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

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
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`copy_id`);

--
-- Constraints for table `reader`
--
ALTER TABLE `reader`
  ADD CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
