-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema evoting
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema evoting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `evoting` DEFAULT CHARACTER SET utf8 ;
USE `evoting` ;

-- -----------------------------------------------------
-- Table `evoting`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `evoting`.`admin` (
  `ADMIN_ID` INT(11) NOT NULL,
  `ADMIN_PASSWORD` VARCHAR(10) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evoting`.`candidate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `evoting`.`candidate` (
  `CANDIDATE_NAME` VARCHAR(50) NULL DEFAULT NULL,
  `TALLY` INT(11) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evoting`.`voter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `evoting`.`voter` (
  `VOTER_NAME` VARCHAR(50) NULL DEFAULT NULL,
  `LAST_4_SOCIAL` INT(11) NOT NULL,
  `VOTER_ID` INT(11) NOT NULL,
  `HAS_VOTED` INT(11) NULL DEFAULT NULL,
  `CANDIDATE_PICKED` VARCHAR(50) NULL DEFAULT NULL)
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `evoting` ;

-- -----------------------------------------------------
-- procedure drop_user_if_exists
-- -----------------------------------------------------

DELIMITER $$
USE `evoting`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `drop_user_if_exists`()
BEGIN
    DECLARE userCount BIGINT DEFAULT 0 ;

    SELECT COUNT(*) INTO userCount FROM mysql.user
    WHERE User = 'evoting_user' and  Host = 'localhost';

    IF userCount > 0 THEN
        DROP USER evoting_user@localhost;
    END IF;
END$$

DELIMITER ;


INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Troy","1424","5639422","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Janine","7324","5521429","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Mary","9214","6634544","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Clark","1634","4486932","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Steven","1342","2965035","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Jasmine","5432","9394203","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Junior","3324","8593021","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Matt","9462","49382034","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Joy","6482","93840234","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Peter","6183","2543892","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Barry","1334","1344353","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Tubster","3853","9384729","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Borng","4334","84928233","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Wagner","6343","4252334","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Pablo","7843","4987342","0");
INSERT INTO voter (VOTER_NAME,LAST_4_SOCIAL,VOTER_ID,HAS_VOTED) VALUES("Christian","8343","48539739","0");




INSERT INTO candidate (CANDIDATE_NAME,TALLY) VALUES("Henry Brown","0");
INSERT INTO candidate (CANDIDATE_NAME,TALLY) VALUES("Joyce Smalls","0");


INSERT INTO admin (ADMIN_ID,ADMIN_PASSWORD) VALUES("1234","admin");
INSERT INTO admin (ADMIN_ID,ADMIN_PASSWORD) VALUES("5678","admin");




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;





