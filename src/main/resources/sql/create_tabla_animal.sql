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
