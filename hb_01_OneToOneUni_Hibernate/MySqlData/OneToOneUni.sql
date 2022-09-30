CREATE TABLE hb_01_onetooneuni_hibernate.instructor (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  instructor_detail_id int DEFAULT NULL,
  PRIMARY KEY (`id`), 
  FOREIGN KEY (instructor_detail_id)
  REFERENCES instructor_detail (id)
);
