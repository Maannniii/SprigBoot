CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `book`(`description`, `title`) VALUES('Hello Koding', 'Simple coding examples and tutorials');
INSERT INTO `book`(`description`, `title`) VALUES('Hello Koding 2', 'Simple coding examples and tutorials 2');
