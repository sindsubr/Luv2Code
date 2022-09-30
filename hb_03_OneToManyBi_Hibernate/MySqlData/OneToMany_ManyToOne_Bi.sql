DROP DATABASE IF EXISTS `hb_03_onetomanybi_hibernate`;
CREATE DATABASE `hb_03_onetomanybi_hibernate`;
DROP TABLE IF EXISTS `hb_03_onetomanybi_hibernate`.`instructor`;
CREATE TABLE `hb_03_onetomanybi_hibernate`.`instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5h8q2s9b2twvpdln31m1q70tw` (`instructor_detail_id`),
  CONSTRAINT `FK5h8q2s9b2twvpdln31m1q70tw` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DROP TABLE `hb_03_onetomanybi_hibernate`.`instructor_detail`;
CREATE TABLE `hb_03_onetomanybi_hibernate`.`instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hobby` varchar(255) DEFAULT NULL,
  `youtube_channel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `hb_03_onetomanybi_hibernate`.`course`;
CREATE TABLE `hb_03_onetomanybi_hibernate`.`course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqk2yq2yk124dhlsilomy36qr9` (`instructor_id`),
  CONSTRAINT `FKqk2yq2yk124dhlsilomy36qr9` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


