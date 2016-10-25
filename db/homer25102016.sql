CREATE DATABASE homer;
USE homer;

CREATE TABLE `homer`.`modules` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `prefix` VARCHAR(45) NOT NULL,
  `version` VARCHAR(45) NULL DEFAULT '0.01',
  `date_installed` DATETIME NULL,
  `status` TINYINT(2) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `prefix_UNIQUE` (`prefix` ASC));
  
  CREATE TABLE `homer`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `EAN` VARCHAR(13) NULL,
  `date` DATE NULL,
  `amount` FLOAT NULL,
  `unit` VARCHAR(12) NULL,
  `status` TINYINT(2) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `homer`.`recipes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL,
  `fulltext` TEXT NOT NULL,
  `url` VARCHAR(256) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `homer`.`lists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_created` DATE NOT NULL,
  `status` TINYINT(1) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `homer`.`list_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `list_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `amount` FLOAT NULL,
  `unit` VARCHAR(12) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_list_items_1_idx` (`list_id` ASC),
  INDEX `fk_list_items_2_idx` (`item_id` ASC),
  CONSTRAINT `fk_list_items_1`
    FOREIGN KEY (`list_id`)
    REFERENCES `homer`.`lists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_list_items_2`
    FOREIGN KEY (`item_id`)
    REFERENCES `homer`.`items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `homer`.`notifications` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
