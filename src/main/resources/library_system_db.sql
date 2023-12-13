-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2023 at 09:31 PM
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
