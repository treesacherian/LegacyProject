DROP TABLE `item` CASCADE;
DROP TABLE `cart`CASCADE;
CREATE TABLE `cart`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`buyer` VARCHAR);

CREATE TABLE `item`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`item_name` VARCHAR,
`item_price` DOUBLE,
`item_quantity` INT,
`cart_id` INT,
FOREIGN KEY (`cart_id`) REFERENCES `cart`(`id`));