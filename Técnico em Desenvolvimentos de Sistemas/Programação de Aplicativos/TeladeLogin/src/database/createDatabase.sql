create schema palogin;
use palogin;

CREATE TABLE `login` (
  `cod_login` int NOT NULL AUTO_INCREMENT,
  `user_login` varchar(50) NOT NULL,
  `pas_login` varchar(50) NOT NULL,
  `nom_login` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `palogin`.`login` (`user_login`, `pas_login`, `nom_login`) VALUES ('piske', '123', 'piske');
