DROP DATABASE IF EXISTS veterinario;
CREATE database veterinario;
USE veterinario;

CREATE TABLE `animal` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(45) NOT NULL,
    `peso` float NOT NULL,
    `fecha_creacion` date NOT NULL,
    `estado` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `persona` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    `apellido` VARCHAR(45) NOT NULL,
    `documento` VARCHAR(45) NOT NULL,
    `estado` VARCAHR(45) NOT NULL,
    primary key(`id`)
);

CREATE TABLE `propietario` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `correo` VARCHAR(45) NOT NULL,
    `telefono` VARCHAR(45) NOT NULL,
    primary key(`id`)
);
