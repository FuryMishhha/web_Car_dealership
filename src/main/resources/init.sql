CREATE TABLE IF NOT EXISTS `car_dealership`.`users` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `car_dealership`.`roles` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `car_dealership`.`products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `mileage` INT,
    `number_of_owners` INT,
    `brand` VARCHAR(45) NOT NULL,
    `model` VARCHAR(45) NOT NULL,
    `release_year` INT NOT NULL,
    `body` VARCHAR(45) NOT NULL,
    `color` VARCHAR(45) NOT NULL,
    `engine` VARCHAR(45) NOT NULL,
    `drive` VARCHAR(45) NOT NULL,
    `wheel` VARCHAR(45) NOT NULL,
    `price` INT NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `picture` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `car_dealership`.`orders` (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `user_id` INT(11) NOT NULL,
     `car_id` INT(11) NOT NULL,
     `status` VARCHAR(45) NOT NULL,
     PRIMARY KEY (`id`)
);

# CREATE TABLE IF NOT EXISTS `car_dealership`.`token` (
#      `id` INT NOT NULL AUTO_INCREMENT,
#      `name` VARCHAR(45) NOT NULL,
#      PRIMARY KEY (`id`));
# INSERT INTO car_dealership.roles
# VALUES ('1','ROLE_USER'), ('2','ROLE_ADMIN');
