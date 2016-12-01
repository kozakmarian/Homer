CREATE DATABASE homer;
USE homer;

CREATE TABLE `homer`.`modules` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `prefix` VARCHAR(45) NOT NULL,
    `version` VARCHAR(45) NULL DEFAULT '0.01',
    `status` TINYINT(2) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC),
    UNIQUE INDEX `prefix_UNIQUE` (`prefix` ASC));

CREATE TABLE `homer`.`products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(64) NOT NULL,
    `image` VARCHAR(256) NULL,
    `status` TINYINT(2) NULL,
    PRIMARY KEY (`id`));

CREATE TABLE `homer`.`recipes` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `preparation` INT NULL,
    `cooking` INT NULL,
    `portions` INT NULL,
    `image` VARCHAR(256),
    `instructions` TEXT NOT NULL,
    `url` VARCHAR(256) NULL,
    `status` TINYINT(1) NULL,
    `category` VARCHAR(45) NULL,
    PRIMARY KEY (`id`));

CREATE TABLE `homer`.`recipe_product` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `recipe_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `amount` DECIMAL,
    `unit` VARCHAR(12),
    PRIMARY KEY(`id`),
    INDEX `fk_recipe_idx` (`recipe_id` ASC),
    INDEX `fk_product_idx` (`product_id` ASC),
    CONSTRAINT `fk_recipe`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `homer`.`recipes` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `homer`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);

CREATE TABLE `homer`.`shoppingLists` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `date_created` DATE NOT NULL,
    `status` TINYINT(1) NULL,
    PRIMARY KEY (`id`));

CREATE TABLE `homer`.`items` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `list_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `amount` DECIMAL NULL,
    `unit` VARCHAR(12) NULL,
    `status` TINYINT(1) NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_list_idx` (`list_id` ASC),
    INDEX `fk_product_item_idx` (`product_id` ASC),
    CONSTRAINT `fk_list`
    FOREIGN KEY (`list_id`)
    REFERENCES `homer`.`shoppingLists` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_product_item`
    FOREIGN KEY (`product_id`)
    REFERENCES `homer`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE TABLE `homer`.`storage` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `product_id` INT NOT NULL,
    `amount` DECIMAL,
    `unit` VARCHAR(12),
    PRIMARY KEY (`id`),
    UNIQUE (`product_id`)
);
