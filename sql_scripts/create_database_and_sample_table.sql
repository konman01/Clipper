CREATE DATABASE  IF NOT EXISTS `clipper`;
USE `clipper`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student_test`;

CREATE TABLE `student_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;