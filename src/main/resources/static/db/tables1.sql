CREATE TABLE `countonrd`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
  AUTO_INCREMENT=6 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin ;
  
DROP TABLE IF EXISTS `item_types`;
CREATE TABLE `countonrd`.`item_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
  AUTO_INCREMENT=1 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin ;
  
DROP TABLE IF EXISTS `currencies`;
CREATE TABLE `currencies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(3) CHARACTER SET utf8 NOT NULL,
  `exch_rate` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
  AUTO_INCREMENT=1 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin ;
  
DROP TABLE IF EXISTS `invoice_types`;
CREATE TABLE `invoice_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
  AUTO_INCREMENT=1 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin ;
  
DROP TABLE IF EXISTS `countonrd`.`companies`;
CREATE TABLE IF NOT EXISTS `countonrd`.`companies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `pib` VARCHAR(14) COLLATE utf8_bin NOT NULL,
  `mb` VARCHAR(14) COLLATE utf8_bin NOT NULL,
  `adress` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `city` VARCHAR(60) COLLATE utf8_bin NOT NULL,
  `zip_code` INT NOT NULL,
  `phone` VARCHAR(30) COLLATE utf8_bin NOT NULL,
  `email` VARCHAR(45) COLLATE utf8_bin NOT NULL,
  `bank` VARCHAR(60) COLLATE utf8_bin NOT NULL,
  `account_num` VARCHAR(16) COLLATE utf8_bin NOT NULL,
  `contact` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin;

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_type`INT NOT NULL,
  `name` VARCHAR(250) COLLATE utf8_bin NOT NULL,
  `code` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `mes_unit` VARCHAR(15) COLLATE utf8_bin NOT NULL,
  `tax` INT NOT NULL,
  `stock` DECIMAL(10,2) NOT NULL,
  `description` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `buying_price` DECIMAL(15,2) NOT NULL,
  `selling_price` DECIMAL(15,2) NOT NULL,
  `seller` INT NOT NULL,
  `sellers_code` VARCHAR(255) COLLATE utf8_bin  NOT NULL,
  `sellers_name` VARCHAR(250) COLLATE utf8_bin  NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`seller`)
  REFERENCES `countonrd`.`companies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`item_type`)
  REFERENCES `countonrd`.`item_types` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
  AUTO_INCREMENT=1 DEFAULT CHARACTER SET =utf8 COLLATE=utf8_bin;
  
DROP TABLE IF EXISTS `entries`;
CREATE TABLE IF NOT EXISTS `entries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `seller` INT NOT NULL ,
  `date` VARCHAR(20) COLLATE utf8_bin NOT NULL,
  `currency` INT NOT NULL,
  `total` DECIMAL(16,2) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`seller`)
  REFERENCES `countonrd`.`companies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`currency`)
  REFERENCES `countonrd`.`currencies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  INDEX `seller` (`seller` ASC) VISIBLE
) AUTO_INCREMENT=1 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin;

DROP TABLE IF EXISTS `entry_items`;
CREATE TABLE IF NOT EXISTS `entry_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `entry_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `exch_rate` DECIMAL(16,2) NOT NULL,
  `buying_frn` DECIMAL(16,2) NOT NULL,
  `buying_home` DECIMAL(16,2) NOT NULL,
  `selling_frn` DECIMAL(16,2) NOT NULL,
  `selling_home` DECIMAL(16,2) NOT NULL,
  `total` DECIMAL(16,2) NOT NULL,
  `quantity` DECIMAL(16,2) NOT NULL,
  FOREIGN KEY (`item_id`)
  REFERENCES `countonrd`.`items` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`entry_id`)
  REFERENCES `countonrd`.`entries` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  PRIMARY KEY (`id`)
  ) AUTO_INCREMENT=61 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `invoices`;
CREATE TABLE IF NOT EXISTS `invoices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inv_num` VARCHAR(16) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `seller` INT COLLATE utf8_bin NOT NULL,
  `buyer` INT COLLATE utf8_bin NOT NULL,
  `currency` INT NOT NULL,
  `discount` DECIMAL(15,2) NOT NULL,
  `total` DECIMAL(15,2) NOT NULL,
  `payed` DECIMAL(15,2) NOT NULL,
  `due` DECIMAL(15,2) NOT NULL,
  `pay_deadline` date NOT NULL,
  `inv_type` INT NOT NULL,
  `notes` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `letters` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`inv_type`)
  REFERENCES `countonrd`.`invoice_types` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`currency`)
  REFERENCES `countonrd`.`currencies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`buyer`)
  REFERENCES `countonrd`.`companies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`seller`)
  REFERENCES `countonrd`.`companies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  INDEX `inv_type` (`inv_type` ASC) VISIBLE
) AUTO_INCREMENT=1 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin;
-- invoices type: avans, profaktura, gotovinski, konacni

DROP TABLE IF EXISTS `invoice_items`;
CREATE TABLE IF NOT EXISTS `countonrd`.`invoice_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_id` INT NOT NULL,
  `invoice_id` INT NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `tax` INT NOT NULL,
  `quantity` DECIMAL(10,2) NOT NULL,
  `discount` DECIMAL(15,2) NOT NULL,
  `total` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`item_id`)
  REFERENCES `countonrd`.`items` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  FOREIGN KEY (`invoice_id`)
  REFERENCES `countonrd`.`invoices` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
) AUTO_INCREMENT=1 DEFAULT CHARACTER SET = utf8 , COLLATE = utf8_bin;

-- select * from `groups`;
-- insert into `groups`(`name`) values('dane');