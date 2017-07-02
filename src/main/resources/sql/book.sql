DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
`id` SMALLINT(6) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`author` VARCHAR(100) NOT NULL,
`category`VARCHAR(50),
`overview` VARCHAR(255) NOT NULL,
`cover` VARCHAR(100),
`thumbails` VARCHAR(100),
`chapterQty` SMALLINT(6) NOT NULL,
`questionQty` SMALLINT(6) NOT NULL,
`replyQty` SMALLINT(6) NOT NULL,
`readingQty` SMALLINT(6) NOT NULL,
`finishQty` SMALLINT(6) NOT NULL,
`starQty` SMALLINT(6) NOT NULL,
`editedQty` SMALLINT(6) NOT NULL,
`createdId` SMALLINT(6) NOT NULL,
`createdName` SMALLINT(100) NOT NULL,
`createdTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updatedTime` DATETIME DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO book(name, author, overview) VALUES ('Effecive Java', 'Joshua Bloch', '机械工业出版社');
