drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS customers (
customer_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(40) NOT NULL,
surname VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS items (
item_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
item_name VARCHAR(80) NOT NULL,
item_price Decimal(8,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
order_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
fk_customer_id INT NOT NULL 
references customers(customer_id),
address VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS order_contents (
order_contents_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
fk_order_id INT NOT NULL
references orders(order_id),
fk_item_id INT NOT NULL
references items(item_id),
quantity INT NOT NULL,
price INT NOT NULL
);
