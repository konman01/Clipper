-- Table to store the Contact details of the user
CREATE TABLE `contact_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `line_1` varchar(128) DEFAULT NULL,
  `line_2` varchar(128) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL
  PRIMARY KEY (`id`)
)

-- Table to store the basic information of the user
CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `contact_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CONTACT_DETAIL_idx` (`contact_detail_id`),
  CONSTRAINT `FK_CONTACT_DETAIL` FOREIGN KEY (`contact_detail_id`) REFERENCES `contact_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;