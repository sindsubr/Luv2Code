DROP DATABASE IF EXISTS `hb_02_onetoonebi_hibernate`;
CREATE DATABASE `hb_02_onetoonebi_hibernate`;
DROP TABLE  IF EXISTS `hb_02_onetoonebi_hibernate`.`instructor`;
CREATE TABLE `hb_02_onetoonebi_hibernate`.`instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5h8q2s9b2twvpdln31m1q70tw` (`instructor_detail_id`),
  CONSTRAINT `FK5h8q2s9b2twvpdln31m1q70tw` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DROP TABLE IF EXISTS `hb_02_onetoonebi_hibernate`.`instructor_detail`;
CREATE TABLE `hb_02_onetoonebi_hibernate`.`instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hobby` varchar(255) DEFAULT NULL,
  `youtube_channel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

