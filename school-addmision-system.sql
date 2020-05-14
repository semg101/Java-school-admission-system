/*
SQLyog Community Edition- MySQL GUI v5.22a
Host - 5.0.19-nt : Database - school_admission-system
*********************************************************************
Server version : 5.0.19-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `school_admission-system`;

USE `school_admission-system`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(25) default NULL,
  `duration` varbinary(50) default NULL,
  `fee` int(11) default NULL,
  `admission_open_on` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `course` */

insert  into `course`(`id`,`name`,`duration`,`fee`,`admission_open_on`) values (1,'BCA','3 yrs',250000,'2012-05-07'),(2,'B.Com','3 yrs',250000,'2012-05-07'),(3,'BBA','3 yrs',250000,'2012-05-07'),(4,'BA','3 yrs',250000,'2012-05-07'),(5,'B.Sc','3 yrs',250000,'2012-05-07'),(6,'B.Tech','4 yrs',600000,'2012-05-07'),(7,'B Sc IT','3 yrs',250000,'2012-05-07'),(8,'MCA','3 yrs',300000,'2012-05-07'),(9,'MBA','2 yrs',700000,'2012-05-07'),(10,'M Sc. IT','3 yrs',250000,'2012-05-07'),(11,'M.Tech','3 yrs',250000,'2012-05-07');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `roll_no` int(11) NOT NULL auto_increment,
  `address` varchar(255) default NULL,
  `admission_date` datetime default NULL,
  `course` int(11) default NULL,
  `name` varchar(255) default NULL,
  `phone_no` bigint(20) default NULL,
  PRIMARY KEY  (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`roll_no`,`address`,`admission_date`,`course`,`name`,`phone_no`) values (7,'Patna',NULL,3,'Ram',12365894165),(8,'Patiyala','2012-05-02 11:22:29',2,'Rohan',1235648974521),(9,'Alipur','2012-05-02 11:24:07',7,'Ali',5865985555);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
