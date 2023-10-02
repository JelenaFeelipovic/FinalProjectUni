/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`agencija` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `agencija`;

DROP TABLE IF EXISTS `MarketinskaAgencija`;

CREATE TABLE `MarketinskaAgencija` (
  `AgencijaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivAgencije` VARCHAR(30) NOT NULL,
  `GradAgencije` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`AgencijaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT  INTO `MarketinskaAgencija` VALUES 
(1,'Ziska','Beograd'),
(2,'Popular','Nis');


DROP TABLE IF EXISTS `Konsultant`;

CREATE TABLE `Konsultant` (
  `KonsultantID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  `AgencijaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`KonsultantID`),
  CONSTRAINT `fk_agencija_id` FOREIGN KEY (`AgencijaID`) REFERENCES `Agencija` (`AgencijaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT  INTO `Konsultant` VALUES 
(1,'Jelena','Filipovic','jelena','jelena123',1),
(2,'Petar','Jovanovic','pera','pera123',2);


DROP TABLE IF EXISTS `Klijent`;

CREATE TABLE `Klijent` (
  `KlijentID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivFirme` VARCHAR(30) NOT NULL,
  `GradFirme` VARCHAR(30) NOT NULL,
  `Industrija` VARCHAR(30) NOT NULL,
  `ImeVlasnika` VARCHAR(30) NOT NULL,
  `Kontakt` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`KlijentID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT  INTO `Klijent` VALUES 
(1,'Jaffa', 'Beograd','Konditorija','John Smith', '0112382192'),
(2,'NIS', 'Nis', 'Petrol', 'Aleksej Blagodarov', '0112732819'),
(3,'Velux', 'Novi Sad', 'Prozorska', 'Natasa Torbica','0112831789');


DROP TABLE IF EXISTS `Usluga`;

CREATE TABLE `Usluga` (
  `UslugaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivUsluge` VARCHAR(30) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  `Trajanje` INT(7) NOT NULL,
  `Cena` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`UslugaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT  INTO `Usluga` VALUES 
(1,'Strategija', 'Stateski plan.', 45, 50),
(2,'Medijskki plan', 'Planiranje sponzorisanja.', 45, 50),
(3,'Drustveni mediji', 'Plan objava na drustvenim mrezama.', 45, 50),
(4,'Planiranje dogadjaja', 'Osmisljavanje i organizovanje dogadjaja.', 45, 50);




DROP TABLE IF EXISTS `Termin`;

CREATE TABLE `Termin` (
  `TerminID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DatumVreme` DATETIME NOT NULL,
  `CenaTermina` DECIMAL(10,2) NOT NULL,
  `KlijentID` BIGINT(10) UNSIGNED NOT NULL,
  `KonsultantID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`TerminID`),
  CONSTRAINT `fk_klijent_id` FOREIGN KEY (`KlijentID`) REFERENCES `Klijent` (`KlijentID`),
  CONSTRAINT `fk_konsultant_id` FOREIGN KEY (`KonsultantID`) REFERENCES `Konsultant` (`KonsultantID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Termin` VALUES 
(1,'2023-01-10 10:00:00', 200, 1, 1);


DROP TABLE IF EXISTS `StavkaTermina`;

CREATE TABLE `StavkaTermina` (
  `TerminID` BIGINT(10) UNSIGNED NOT NULL,
  `RbStavke` INT(7) NOT NULL,
  `CenaStavke` DECIMAL(10,2) NOT NULL,
  `UslugaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`TerminID`,`RbStavke`),
  CONSTRAINT `fk_termin_id` FOREIGN KEY (`TerminID`) REFERENCES `Termin` (`TerminID`) ON DELETE CASCADE,
  CONSTRAINT `fk_usluga_id` FOREIGN KEY (`UslugaID`) REFERENCES `Usluga` (`UslugaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `StavkaTermina` VALUES 
(1,1,50,1),
(1,2,50,2),
(1,3,50,3),
(1,4,50,4);





/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
