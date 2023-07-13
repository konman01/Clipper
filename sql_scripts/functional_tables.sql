DROP SCHEMA IF EXISTS `clipper`;

CREATE SCHEMA `clipper`;

use `clipper`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `contact_detail`;

-- Table to store the Contact details of the user
CREATE TABLE `contact_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `line_1` varchar(128) DEFAULT NULL,
  `line_2` varchar(128) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `account_detail`;

-- Table to store the Contact details of the user
CREATE TABLE `account_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `effective_start_date` varchar(128) DEFAULT NULL,
  `effective_end_date` varchar(128) DEFAULT NULL,
  `total_balance` varchar(20) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `user_detail`;

-- Table to store the basic information of the user
CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `contact_detail_id` int(11) DEFAULT NULL,
  `account_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CONTACT_DETAIL_idx` (`contact_detail_id`),
  CONSTRAINT `FK_CONTACT_DETAIL` FOREIGN KEY (`contact_detail_id`) REFERENCES `contact_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_CONTACT_DETAIL_idx` (`contact_detail_id`),
  CONSTRAINT `FK_ACCOUNT_DETAIL` FOREIGN KEY (`account_detail_id`) REFERENCES `account_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_ACCOUNT_DETAIL_idx` (`account_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `clipper_card`;

-- Table to Save Clipper Card Information related to each user
CREATE TABLE clipper_card (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(128) DEFAULT NULL,
  `type` varchar(24) DEFAULT NULL,
  `status` varchar(24) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user_detail` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE sales_order (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(128) DEFAULT NULL,
  `sales_order_number` varchar(24) DEFAULT NULL,
  `order_date` date DEFAULT null,
  `clipper_id` int(11) DEFAULT null,
  PRIMARY KEY (`id`),
  
  KEY `FK_clipper_idx` (`clipper_id`),
  
  CONSTRAINT `FK_CLIPPER` 
  FOREIGN KEY (`clipper_id`) 
  REFERENCES `clipper_card` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;



SET FOREIGN_KEY_CHECKS = 1;