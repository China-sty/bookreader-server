DROP TABLE IF EXISTS `book`;
create table `book`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `bookIndex` varchar(255) default null,
    `bookImgUrl` varchar(255) default null,
    `bookName` varchar(255) default null,
    `bookAuthor` varchar(255) default null,
    `bookPages` int(11) default null,
    `bookDescription` varchar(255) default null,
    `savePath` varchar(255) default null,
    PRIMARY KEY (`id`)
);
BEGIN ;
insert into `book` VALUES (1,'L1',null,'海底两万里','凡尔纳',500,'译林出版社',null),(2,'N1',null,'希区柯克小说集','希区柯克',1000,'译林出版社',null),(3,'H1',null,'儒林外史','吴敬梓',800,'古籍出版社',null);
COMMIT ;


DROP TABLE IF EXISTS  `user`;
create table `user`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) DEFAULT NULL,
    `password` varchar(11) NOT NULL,
    `username` varchar(255) DEFAULT NULL,
    `phonenumber` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
BEGIN ;
insert into `user` VALUES (1,'1012681@qq.com','123456','测试一号','12345678919'),(2,'123@qq.com','123456','测试二号','12345678911'),(3,'333@qq.com','123456','测试三号',NULL);
COMMIT ;

DROP TABLE IF EXISTS `userstatus`;

DROP TABLE IF EXISTS  `shelf`;
create table `shelf`(
    `userName` varchar(255) DEFAULT NULL,
    `bookIndex` varchar(255) DEFAULT NULL,
    `mark` int(11) DEFAULT NULL,
    `process` float(11) DEFAULT NULL

);
BEGIN ;
insert into `shelf` VALUES ('测试一号','L1',0,0),('测试二号','H1',20,20);
Commit ;