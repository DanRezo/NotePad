-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema NotePadDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `NotePadDB` ;

-- -----------------------------------------------------
-- Schema NotePadDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NotePadDB` DEFAULT CHARACTER SET utf8 ;
USE `NotePadDB` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `alias` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `profile_picture` VARCHAR(45) NULL,
  `admin_level` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `playlist` ;

CREATE TABLE IF NOT EXISTS `playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_playlist_user1_idx` (`owner_id` ASC),
  CONSTRAINT `fk_playlist_user1`
    FOREIGN KEY (`owner_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `album` ;

CREATE TABLE IF NOT EXISTS `album` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `release_year` VARCHAR(45) NULL,
  `picture` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `song`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `song` ;

CREATE TABLE IF NOT EXISTS `song` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_song_album1_idx` (`album_id` ASC),
  CONSTRAINT `fk_song_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artist` ;

CREATE TABLE IF NOT EXISTS `artist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `picture` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genre` ;

CREATE TABLE IF NOT EXISTS `genre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `album_artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `album_artist` ;

CREATE TABLE IF NOT EXISTS `album_artist` (
  `album_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`album_id`, `artist_id`),
  INDEX `fk_album_has_artist_artist1_idx` (`artist_id` ASC),
  INDEX `fk_album_has_artist_album1_idx` (`album_id` ASC),
  CONSTRAINT `fk_album_has_artist_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_album_has_artist_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `artist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `song_playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `song_playlist` ;

CREATE TABLE IF NOT EXISTS `song_playlist` (
  `song_id` INT NOT NULL,
  `playlist_id` INT NOT NULL,
  PRIMARY KEY (`song_id`, `playlist_id`),
  INDEX `fk_song_has_playlist_playlist1_idx` (`playlist_id` ASC),
  INDEX `fk_song_has_playlist_song1_idx` (`song_id` ASC),
  CONSTRAINT `fk_song_has_playlist_song1`
    FOREIGN KEY (`song_id`)
    REFERENCES `song` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_song_has_playlist_playlist1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `playlist_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `playlist_user` ;

CREATE TABLE IF NOT EXISTS `playlist_user` (
  `playlist_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`playlist_id`, `user_id`),
  INDEX `fk_playlist_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_playlist_has_user_playlist1_idx` (`playlist_id` ASC),
  CONSTRAINT `fk_playlist_has_user_playlist1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genre_album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genre_album` ;

CREATE TABLE IF NOT EXISTS `genre_album` (
  `genre_id` INT NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`genre_id`, `album_id`),
  INDEX `fk_genre_has_album_album1_idx` (`album_id` ASC),
  INDEX `fk_genre_has_album_genre1_idx` (`genre_id` ASC),
  CONSTRAINT `fk_genre_has_album_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_genre_has_album_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO notepad@localhost;
 DROP USER notepad@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'notepad'@'localhost' IDENTIFIED BY 'DYWs8o';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'notepad'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `user` (`id`, `alias`, `first_name`, `last_name`, `password`, `profile_picture`, `admin_level`) VALUES (1, 'gmurricane', 'Matt', 'Gmur', 'password', NULL, 'ADMIN');
INSERT INTO `user` (`id`, `alias`, `first_name`, `last_name`, `password`, `profile_picture`, `admin_level`) VALUES (2, 'danrezo', 'Daniel', 'Balarezo', 'password', NULL, 'ADMIN');
INSERT INTO `user` (`id`, `alias`, `first_name`, `last_name`, `password`, `profile_picture`, `admin_level`) VALUES (3, 'jackie_boy', 'Jack', 'Hammer', 'password', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `playlist`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `playlist` (`id`, `title`, `owner_id`) VALUES (1, 'My First Playlist', 1);
INSERT INTO `playlist` (`id`, `title`, `owner_id`) VALUES (2, 'Work Out Jams', 2);
INSERT INTO `playlist` (`id`, `title`, `owner_id`) VALUES (3, 'Bedroom Jams', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `album`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (1, 'MTV Unplugged in New York (Live)', '1994', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (2, 'Nevermind', '1991', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (3, 'Believe', '2012', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (4, 'My World', '2009', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (5, 'Coloring Book', '2016', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (6, 'Unleashed', '2002', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (7, 'White Trash With Money', '2006', NULL);
INSERT INTO `album` (`id`, `title`, `release_year`, `picture`) VALUES (8, 'Chocolate Factory', '2003', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `song`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (1, 'Smells Like Teen Spirit', 2);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (2, 'Lithium', 2);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (3, 'Come As You Are', 2);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (4, 'Polly', 2);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (5, 'Come As You Are (Live)', 1);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (6, 'About A Girl (Live)', 1);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (7, 'All Apologies (Live)', 1);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (8, 'Boyfriend', 3);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (9, 'As Long As You Love Me', 3);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (10, 'Love Me', 4);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (11, 'One Time', 4);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (12, 'One Less Lonely Girl', 4);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (13, 'Blessings', 5);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (14, 'All Night', 5);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (15, 'All We Got', 5);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (16, 'Angels', 5);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (17, 'Courtesy of the Red, White and Blue (The Angry American)', 6);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (18, 'Beer for My Horses', 6);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (19, 'Get Drunk and Be Somebody', 7);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (20, 'A Little Too Late', 7);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (21, 'Ignition', 8);
INSERT INTO `song` (`id`, `title`, `album_id`) VALUES (22, 'Step in the Name of Love', 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `artist`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `artist` (`id`, `name`, `picture`) VALUES (1, 'Nirvana', NULL);
INSERT INTO `artist` (`id`, `name`, `picture`) VALUES (2, 'Justin Bieber', NULL);
INSERT INTO `artist` (`id`, `name`, `picture`) VALUES (3, 'Chance The Rapper', NULL);
INSERT INTO `artist` (`id`, `name`, `picture`) VALUES (4, 'Toby Keith', NULL);
INSERT INTO `artist` (`id`, `name`, `picture`) VALUES (5, 'R. Kelly', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `genre`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `genre` (`id`, `name`) VALUES (1, 'ROCK');
INSERT INTO `genre` (`id`, `name`) VALUES (2, 'POP');
INSERT INTO `genre` (`id`, `name`) VALUES (3, 'HIP_HOP');
INSERT INTO `genre` (`id`, `name`) VALUES (4, 'COUNTRY');
INSERT INTO `genre` (`id`, `name`) VALUES (5, 'R_AND_B');

COMMIT;


-- -----------------------------------------------------
-- Data for table `album_artist`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (1, 1);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (2, 1);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (3, 2);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (4, 2);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (5, 3);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (6, 4);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (7, 4);
INSERT INTO `album_artist` (`album_id`, `artist_id`) VALUES (8, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `song_playlist`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (2, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (5, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (8, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (7, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (9, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (3, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (6, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (13, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (17, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (11, 1);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (4, 2);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (13, 2);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (22, 2);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (21, 2);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (10, 2);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (8, 3);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (9, 3);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (10, 3);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (11, 3);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (12, 3);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (21, 3);
INSERT INTO `song_playlist` (`song_id`, `playlist_id`) VALUES (22, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `playlist_user`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `playlist_user` (`playlist_id`, `user_id`) VALUES (1, 1);
INSERT INTO `playlist_user` (`playlist_id`, `user_id`) VALUES (2, 1);
INSERT INTO `playlist_user` (`playlist_id`, `user_id`) VALUES (3, 1);
INSERT INTO `playlist_user` (`playlist_id`, `user_id`) VALUES (3, 2);
INSERT INTO `playlist_user` (`playlist_id`, `user_id`) VALUES (1, 3);
INSERT INTO `playlist_user` (`playlist_id`, `user_id`) VALUES (3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `genre_album`
-- -----------------------------------------------------
START TRANSACTION;
USE `NotePadDB`;
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (1, 1);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (1, 2);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (2, 3);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (2, 4);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (3, 5);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (4, 6);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (4, 7);
INSERT INTO `genre_album` (`genre_id`, `album_id`) VALUES (5, 8);

COMMIT;

