CREATE DATABASE  IF NOT EXISTS `mydatabase` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydatabase`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actors` (
  `actors_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`actors_id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors` VALUES (1,'Tim Robbins'),(2,'Morgan Freeman'),(3,'Bob Gunton'),(4,'Marlon Brando'),(5,'Al Pacino'),(6,'James Caan'),(7,'Christian Bale'),(8,'Health Ledger'),(9,'Aaron Eckhart'),(11,'Robert Duvall'),(12,'Henry Ford'),(13,'Lee J. Cobb'),(14,'Martin Balsam'),(15,'Liam Neeson'),(16,'Raplh Fiennes'),(17,'Ben Kingsley'),(18,'Elijah Wood'),(19,'Viggo Mortensen'),(20,'Ian McKellen'),(21,'John Travolta'),(22,'Uma Thurman'),(23,'Samuel L. Jackson'),(24,'Orlando Bloom'),(25,'CLint Eastwood'),(26,'ELi Wallach'),(27,'Lee Van CLeef'),(28,'Tom Hanks'),(29,'Robin Wright'),(30,'Gary Sinise'),(31,'Brad Pitt'),(32,'Edward Norton'),(33,'Meat Loaf'),(34,'Leonardo DiCaprio'),(35,'Jospeh Gordon-Levitt'),(36,'Eliot Page'),(37,'Mark Hamill'),(38,'Harrison Ford'),(39,'Carrie Fisher'),(40,'Keanu Reeves'),(41,'Laurence Fishbourne'),(42,'Carrie-Anne Moss'),(43,'Robert De Niro'),(44,'Ray Liotta'),(45,'Joe Pesci'),(46,'Timothee CHalamet'),(47,'Zendaya'),(48,'Rebecca Ferguson'),(49,'Jack Nicholson'),(50,'Lousie Fletcher'),(51,'Michael Berryman'),(52,'Kevin Spacey'),(53,'Mathew McConaughey '),(54,'Anne Hathaway '),(55,'Jessica Chastain'),(56,'James Stewart'),(57,'Donna Reed'),(58,'Lionel Barrymore'),(59,'Toshiro Mifune'),(60,'Takashi Shimura'),(61,'Keiko Tsushimura'),(62,'Jodie Foster '),(63,'Anthony Hopkins'),(64,'Scott Glenn'),(65,'Matt Damon'),(66,'Tom Sizemore'),(67,'Alexandra Rodrigues'),(68,'Leandro Firmino'),(69,'Matheus Nachtergaele'),(70,'Roberto Benigni'),(71,'Nicoletta Braschi'),(72,'Giorgio Cantarini'),(73,'Micheal Clarke Duncan'),(74,'David Morse'),(75,'Arnold Schwarzenegger'),(76,'Linda Hamilton'),(77,'Edward Furlong'),(78,'Micheal J. Fox'),(79,'Christopher Lloyd'),(80,'Lea Thompson'),(81,'Daveigh Chase'),(82,'Suzanne Pleshette'),(83,'Miyu Irino'),(84,'Adrien Brody'),(85,'Thomas Kretschmann'),(86,'Frank Finlay'),(87,'Song Kang-ho'),(88,'Lee Sun-Kyun'),(89,'Cho Yeo-jeong'),(90,'Anthony Perkins'),(91,'Janet Leigh'),(92,'Vera Miles'),(93,'Shameik Moore'),(94,'Hailee Steinfeld'),(95,'Brian Tyree Henry'),(96,'Russel Crowe'),(97,'Joaquin Phoenix'),(98,'Connie Nielsen'),(99,'Mathew Broderick'),(100,'Jeremy Irons'),(101,'James Earl Jones'),(102,'Jean Reno '),(103,'Gary Oldman'),(104,'Natalie Portman'),(107,'Beverly D\'Angelo'),(108,'Miles Teller'),(109,'J.K Simmons'),(110,'Melissa Benoist'),(111,'Hugh Jackman'),(112,'Scarlett Johansson'),(113,'Tsutomu Tatsumi'),(114,'Ayano Shiraishi'),(115,'Akemi Yamaguchi'),(116,'Tatsuya Nakadai'),(117,'Akira Ishihama'),(118,'Shima Iwashita'),(119,'Gabriel Byrne'),(120,'Chazz Palminteri'),(121,'Humphrey Bogart'),(122,'Ingrid Bergman'),(123,'Paul Henreid'),(124,'François Cluzet'),(125,'Omar Sy'),(126,'Anne Le Ny'),(127,'Philippe Noiret'),(128,'Enzo Cannavale'),(129,'Antonella Attili'),(130,'Charles Chaplin'),(131,'Paulette Goddard'),(132,'Henry Bergman');
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `director_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  PRIMARY KEY (`director_id`),
  KEY `director_ibfk_1` (`movie_id`),
  CONSTRAINT `director_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Frank Darabont',NULL),(2,'Francis Ford Coppola',NULL),(3,'Christopher Nolan',NULL),(4,'Sidney Lumet',NULL),(5,'Steven Spielbelrg',NULL),(6,'Peter Jackson',NULL),(7,'Sergio Leone',NULL),(8,'Robert Zemeckis',NULL),(9,'David Fincher',NULL),(10,'Irvin Kershner',NULL),(11,'Lana Wachowski',NULL),(12,'Lily Wachowski',NULL),(13,'Martin Scorsese',NULL),(14,'Milo Forman',NULL),(15,'Frank Capra',NULL),(16,'Akira Kurosawa',NULL),(17,'Jonathan Demme',NULL),(18,'Fernando Meirlles',NULL),(19,'Roberto Benigni',NULL),(20,'James Cameron',NULL),(21,'George Lucas',NULL),(23,'Roman Polanski',NULL),(24,'Bong Joon Ho',NULL),(25,'Alfred Hitchcook',NULL),(26,'Joaquim Dos Santos',NULL),(27,'Ridley Scott',NULL),(28,'Roger Allers',NULL),(29,'Luc Besson',NULL),(30,'Tom Kaye',NULL),(31,'Damien Chazelle',NULL),(32,'Isao Takahata',NULL),(33,'Masaki Koboyashi',NULL),(34,'Bryan Singer',NULL),(35,'Micheal Curtiz',NULL),(36,'Olivier Nakache',NULL),(37,'Giuseppe Tornatore',NULL),(38,'Charles Chaplin',NULL),(39,'Hayao Miyazaki',NULL),(40,'Denis Villeneuve',NULL),(41,'Quentin Tarantino',NULL);
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_movies`
--

DROP TABLE IF EXISTS `favorite_movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite_movies` (
  `movie_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_movies`
--

LOCK TABLES `favorite_movies` WRITE;
/*!40000 ALTER TABLE `favorite_movies` DISABLE KEYS */;
INSERT INTO `favorite_movies` VALUES (10,10),(19,1),(24,9),(34,8),(49,5);
/*!40000 ALTER TABLE `favorite_movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `genre_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Drama'),(2,'Action'),(3,'Romance'),(4,'Thriller'),(5,'Adventure'),(6,'Comedy'),(7,'Crime'),(8,'Animation'),(9,'Horror'),(10,'Music');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `release_date` int DEFAULT NULL,
  `length` int DEFAULT NULL,
  `genre_id` int DEFAULT NULL,
  `director_id` varchar(50) DEFAULT NULL,
  `actors_id` int DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `synopsis` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`movie_id`),
  KEY `genre_id_idx` (`genre_id`),
  KEY `actor_id_idx` (`actors_id`),
  CONSTRAINT `genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'The Shawshank Redemtion',1994,142,1,'1',NULL,9.3,'Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.'),(2,'The GodFather',1972,175,7,'2',NULL,9.2,'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),(3,'The Dark Knight',2008,152,2,'3',NULL,9,'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.'),(4,'The GodFather Part II',1974,202,7,'2',NULL,9,'The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.'),(5,'12 Angry Men',1957,96,1,'4',NULL,9,'The jury in a New York City murder trial is frustrated by a single member whose skeptical caution forces them to more carefully consider the evidence before jumping to a hasty verdict.'),(6,'Schindler\'s List',1993,195,1,'5',NULL,9,'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.'),(7,'The Lord of the Rings: The Return of the King',2003,201,2,'6',NULL,9,'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.'),(8,'Pulp Fiction',1994,154,7,'41',NULL,8.9,'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.'),(9,'The Lord of the Rings: The Fellowship of the Ring',2001,178,2,'6',NULL,8.9,'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.'),(10,'The Good, the Bad and Ugly',1966,148,5,'7',NULL,8.8,'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery'),(11,'Forest Gump',1994,142,3,'6',NULL,8.8,'The history of the United States from the 1950s to the \'70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart.'),(12,'The Lord of the Rings: The Two Towers',2002,179,2,'9',NULL,8.8,'While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\'s new ally, Saruman, and his hordes of Isengard.'),(13,'Fight Club',1999,139,7,'3',NULL,8.8,'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.'),(14,'Inception',2010,148,2,'3',NULL,8.8,'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.'),(15,'Star Wars: Episode V - The Empire Strikes Back',1980,124,5,'10',NULL,8.7,'After the Rebel Alliance are overpowered by the Empire, Luke Skywalker begins his Jedi training with Yoda.'),(16,'Dune: Part Two',2024,166,2,'40',NULL,8.8,'Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family.'),(17,'The Matrix',1999,136,2,'11',NULL,8.7,'When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.'),(18,'GoodFellas',1990,145,7,'13',NULL,8.7,'The story of Henry Hill and his life in the mafia, covering his relationship with his wife Karen and his mob partners Jimmy Conway and Tommy DeVito.'),(19,'One Flew Over the Cuckoo\'s Nest',1975,133,1,'14',NULL,8.7,'In the Fall of 1963, a Korean War veteran and criminal pleads insanity and is admitted to a mental institution, where he rallies up the scared patients against the tyrannical nurse.'),(20,' Seven',1995,127,7,'9',NULL,8.6,'Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.'),(21,'Interstellar',2014,169,5,'3',NULL,8.6,'When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.'),(22,'It\'s a Wonderful Life',1946,130,1,'15',NULL,8.7,'An angel is sent from Heaven to help a desperately frustrated businessman by showing him what life would have been like if he had never existed.'),(23,'Seven Samurai',1954,207,2,'16',NULL,8.6,'Farmers from a village exploited by bandits hire a veteran samurai for protection, who gathers six other samurai to join him'),(24,'The Silence of the Lambs',1991,118,7,'17',NULL,8.6,'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.'),(25,'Saving Private Ryan',1998,169,1,'5',NULL,8.6,'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.'),(26,'City of God',2002,130,7,'18',NULL,8.6,'In the slums of Rio, two kids\' paths diverge as one struggles to become a photographer and the other a kingpin.'),(27,'Life Is Beautiful',1997,116,6,'19',NULL,8.6,'When an open-minded Jewish waiter and his son become victims of the Holocaust, he uses a perfect mixture of will, humor and imagination to protect his son from the dangers around their camp.'),(28,'Terminator 2: Judgment Day',1991,137,2,'20',NULL,8.6,'A cyborg, identical to the one who failed to kill Sarah Connor, must now protect her ten year old son John from an even more advanced and powerful cyborg.'),(29,'Star Wars: Episode IV - A New Hope',1977,121,2,'21',NULL,8.6,'Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee to save the galaxy from the Empire\'s world-destroying battle station, while also attempting to rescue Princess Leia.'),(30,'The Green Mile',1999,189,7,'1',NULL,8.6,'A tale set on death row, where gentle giant possesses the mysterious power to heal people. When the lead guard, recognizes John\'s gift, he tries to help stave off the condemned man\'s execution.'),(31,'Back to the Future',1985,116,5,'8',NULL,8.5,'Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.'),(32,'Spirited Away',2001,125,8,'39',NULL,8.5,'During her family\'s move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches and spirits, and where humans are changed into beasts.'),(33,'The pianist',2002,150,10,'23',NULL,8.5,'During WWII, acclaimed Polish musician Wladyslaw faces various struggles as he loses contact with his family. As the situation worsens, he hides in the ruins of Warsaw in order to survive.'),(34,'Modern Times',1936,147,6,'38',NULL,8.5,'The Tramp struggles to live in modern industrial society with the help of a young homeless woman.'),(35,'Parasite',2019,135,4,'24',NULL,8.5,'Greed and class discrimination threaten the newly-formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.'),(36,'Psycho',1960,109,9,'25',NULL,8.5,'A Phoenix secretary embezzles $40,000 from her employer\'s client, goes on the run and checks into a remote motel run by a young man under the domination of his mother.'),(37,'Spider-Man:Across the Spider-Verse',2023,140,8,'26',NULL,8.6,'Miles Morales swings accross the multiverse, he encounters a team of People charged with protecting it. When the heroes clash on how to handle threats, Miles must redefine what it means to be a hero.'),(38,'Gladiator',2000,155,1,'27',NULL,8.5,'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.'),(39,'The Lion King',1994,188,9,'28',NULL,8.5,'Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.'),(40,'Leon',1994,110,2,'29',NULL,8.5,'12-year-old Mathilda is reluctantly taken in by Léon, a professional assassin, after her family is murdered. An unusual relationship forms as she becomes his protégée and learns the assassin\'s trade.'),(41,'The Departed',2006,151,7,'13',NULL,8.5,'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.'),(42,'American History',1998,119,7,'30',NULL,8.5,'Living life marked by violence a neo-Nazi finally goes to prison after killing two black kids. Upon his release he vows to prevent his brother, who idolizes him, from following in his footsteps.'),(43,'Whiplash',2014,106,10,'31',NULL,8.5,'A promising young drummer enrolls at a cut-throat music conservatory where his dreams of greatness are mentored by an instructor who will stop at nothing to realize a student\'s potential.'),(44,'The Prestige',2006,130,1,'3',NULL,8.5,'After a tragic accident, two stage magicians in 1890s London engage in a battle to create the ultimate illusion while sacrificing everything they have to outwit each other.'),(45,'Grave of Fireflies',1988,149,9,'32',NULL,8.5,'A young boy and his little sister struggle to survive in Japan during World War II.'),(46,'Harakiri',1962,133,2,'33',NULL,8.5,'A ronin requesting seppuku at a feudal lord\'s palace is told of the brutal suicide of another ronin, he reveals how their pasts are intertwined  and challenges the clan\'s integrity.'),(47,'The Usual Suspects',1995,106,7,'34',NULL,8.5,'The sole survivor of a pier shoot-out tells the story of how a notorious criminal influenced the events that began with five criminals meeting in a seemingly random police lineup.'),(48,'Casablanca',1942,102,3,'35',NULL,8.5,'A cynical expatriate American cafe owner struggles to decide whether or not to help his former lover and her fugitive husband escape the Nazis in French Morocco.'),(49,'Untouchable',2011,112,6,'36',NULL,8.5,'After he becomes a quadriplegic from a paragliding accident, an aristocrat hires a young man from the projects to be his caregiver.'),(50,'Cinema Paradiso',1988,174,3,'37',NULL,8.5,'A filmmaker recalls his childhood when falling in love with the pictures at the cinema of his home village and forms a deep friendship with the cinema\'s projectionist.'),(51,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tyrese Mumia','g00421432@atu.ie','2004-02-17','visixn','academicweapon','male','Kenya'),(2,'Sam Olauye','g00421177@atu.ie','2005-09-15','samskillz','69420','male','Nigeria'),(3,'David Jayakumar','g00419108@atu.ie','2005-07-07','davidjacuzzi','7705','male','Sri Lanka'),(4,'Ben McCormak','g00416547@atu.ie','2003-08-19','benson','80085','male','Ireland'),(5,'Paul lenon','plenon@gmail.com','1970-01-01','legend','iloveoop','male','Ireland'),(6,'Margret Thatcher','iron@yahoo.com','1925-09-13','ironfist','weloveuk','female','Britain'),(7,'Michelle Obama','eagel@hotmail.com','1964-01-17','USOFA','godblessamerica','female','USA'),(8,'Eve','eve@smokesignal','0000-01-01','woman1','iamwoman','female','Eden'),(9,'Ghengis Khan','Khan@smartpigeon.com','1162-10-15','iamasia','06666','male','Mongolia'),(10,'Diana Frances','PrincessD@twitter.com','1961-07-01','crashout1','tfgoingon','female','Britain');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watchlist`
--

DROP TABLE IF EXISTS `watchlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `watchlist` (
  `movie_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`user_id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watchlist`
--

LOCK TABLES `watchlist` WRITE;
/*!40000 ALTER TABLE `watchlist` DISABLE KEYS */;
INSERT INTO `watchlist` VALUES (2,1),(7,1),(10,1),(1,2),(3,2),(4,5);
/*!40000 ALTER TABLE `watchlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-19 15:09:08
