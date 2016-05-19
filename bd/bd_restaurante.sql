-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd_restaurante
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_restaurante
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_restaurante` DEFAULT CHARACTER SET latin1 ;
USE `bd_restaurante` ;

-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_persona` (
  `id_persona` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `dni_persona` CHAR(8) NOT NULL COMMENT '',
  `nombre_persona` VARCHAR(30) NOT NULL COMMENT '',
  `ape_pat_persona` VARCHAR(30) NOT NULL COMMENT '',
  `ape_mat_persona` VARCHAR(30) NOT NULL COMMENT '',
  PRIMARY KEY (`id_persona`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_cliente` (
  `id_cliente` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_cliente`)  COMMENT '',
  CONSTRAINT `tb_cliente_ibfk_1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `bd_restaurante`.`tb_persona` (`id_persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_mesa` (
  `id_mesa` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `usada_mesa` TINYINT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`id_mesa`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_mesero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_mesero` (
  `id_mesero` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_mesero`)  COMMENT '',
  CONSTRAINT `tb_mesero_ibfk_1`
    FOREIGN KEY (`id_mesero`)
    REFERENCES `bd_restaurante`.`tb_persona` (`id_persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_producto` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descrip_producto` VARCHAR(50) NOT NULL COMMENT '',
  `tipo_producto` INT(11) NOT NULL COMMENT '',
  `categoria_producto` INT(11) NOT NULL COMMENT '',
  `costo_producto` DOUBLE NOT NULL COMMENT '',
  `precio_producto` DOUBLE NOT NULL COMMENT '',
  `stock_producto` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_producto`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_visita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_visita` (
  `id_visita` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_cliente` INT(11) NOT NULL COMMENT '',
  `id_mesero` INT(11) NOT NULL COMMENT '',
  `id_mesa` INT(11) NOT NULL COMMENT '',
  `estado_visita` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_visita`)  COMMENT '',
  INDEX `id_cliente` (`id_cliente` ASC)  COMMENT '',
  INDEX `id_mesero` (`id_mesero` ASC)  COMMENT '',
  INDEX `id_mesa` (`id_mesa` ASC)  COMMENT '',
  CONSTRAINT `tb_visita_ibfk_1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `bd_restaurante`.`tb_cliente` (`id_cliente`),
  CONSTRAINT `tb_visita_ibfk_2`
    FOREIGN KEY (`id_mesero`)
    REFERENCES `bd_restaurante`.`tb_mesero` (`id_mesero`),
  CONSTRAINT `tb_visita_ibfk_3`
    FOREIGN KEY (`id_mesa`)
    REFERENCES `bd_restaurante`.`tb_mesa` (`id_mesa`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_venta` (
  `id_venta` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `numero_venta` CHAR(6) NOT NULL COMMENT '',
  `fecha_venta` DATETIME NOT NULL COMMENT '',
  `total_venta` DOUBLE NOT NULL COMMENT '',
  `id_visita` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_venta`)  COMMENT '',
  INDEX `id_visita` (`id_visita` ASC)  COMMENT '',
  CONSTRAINT `tb_venta_ibfk_1`
    FOREIGN KEY (`id_visita`)
    REFERENCES `bd_restaurante`.`tb_visita` (`id_visita`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_restaurante`.`tb_venta_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_restaurante`.`tb_venta_detalle` (
  `id_venta` INT(11) NOT NULL COMMENT '',
  `id_producto` INT(11) NOT NULL COMMENT '',
  `cantidad` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_venta`, `id_producto`)  COMMENT '',
  INDEX `id_producto` (`id_producto` ASC)  COMMENT '',
  CONSTRAINT `tb_venta_detalle_ibfk_1`
    FOREIGN KEY (`id_venta`)
    REFERENCES `bd_restaurante`.`tb_venta` (`id_venta`),
  CONSTRAINT `tb_venta_detalle_ibfk_2`
    FOREIGN KEY (`id_producto`)
    REFERENCES `bd_restaurante`.`tb_producto` (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `bd_restaurante` ;

-- -----------------------------------------------------
-- procedure usp_cliente_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cliente_create`(id INT, dni CHAR(8), nombre VARCHAR(30), ape_pat VARCHAR(30), ape_mat VARCHAR(30))
BEGIN
	INSERT tb_persona VALUES(id, dni, nombre, ape_pat, ape_mat);
	INSERT tb_cliente VALUES(LAST_INSERT_ID());
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_cliente_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cliente_delete`(id INT)
BEGIN
	DELETE FROM tb_cliente WHERE id_cliente = id;
    DELETE FROM tb_persona WHERE id_persona = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_cliente_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cliente_obtain`(dni CHAR(8))
BEGIN
	SELECT p.* FROM tb_cliente c JOIN tb_persona p ON c.id_cliente = p.id_persona WHERE dni_persona = dni;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_cliente_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cliente_read`()
BEGIN
	SELECT p.* FROM tb_cliente c JOIN tb_persona p ON c.id_cliente = p.id_persona;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_cliente_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cliente_update`(id INT, dni CHAR(8), nombre VARCHAR(30), ape_pat VARCHAR(30), ape_mat VARCHAR(30))
BEGIN
	UPDATE tb_persona SET dni_persona = dni, nombre_persona = nombre, ape_pat_persona = ape_pat, ape_mat_persona = ape_mat WHERE id_persona = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesa_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesa_create`(id INT, usada INT)
BEGIN
	INSERT tb_mesa VALUES(id, usada);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesa_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesa_delete`(id INT)
BEGIN
	DELETE FROM tb_mesa WHERE id_mesa = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesa_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesa_obtain`(id INTEGER)
BEGIN
	SELECT * FROM tb_mesa WHERE id_mesa = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesa_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesa_read`()
BEGIN
	SELECT * FROM tb_mesa;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesa_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesa_update`(id INT, usada INT)
BEGIN
	UPDATE tb_mesa SET usada_mesa = usada WHERE id_mesa = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesero_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesero_create`(id INT, dni CHAR(8), nombre VARCHAR(30), ape_pat VARCHAR(30), ape_mat VARCHAR(30))
BEGIN
	INSERT tb_persona VALUES(id, dni, nombre, ape_pat, ape_mat);
	INSERT tb_mesero VALUES(LAST_INSERT_ID());
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesero_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesero_delete`(id INT)
BEGIN
	DELETE FROM tb_mesero WHERE id_mesero = id;
    DELETE FROM tb_persona WHERE id_persona = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesero_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesero_obtain`(dni CHAR(8))
BEGIN
	SELECT p.* FROM tb_mesero c JOIN tb_persona p ON c.id_mesero = p.id_persona WHERE dni_persona = dni;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesero_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesero_read`()
BEGIN
	SELECT p.* FROM tb_mesero c JOIN tb_persona p ON c.id_mesero = p.id_persona;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_mesero_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_mesero_update`(id INT, dni CHAR(8), nombre VARCHAR(30), ape_pat VARCHAR(30), ape_mat VARCHAR(30))
BEGIN
	UPDATE tb_persona SET dni_persona = dni, nombre_persona = nombre, ape_pat_persona = ape_pat, ape_mat_persona = ape_mat WHERE id_persona = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_producto_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_producto_create`(id INT, descrip VARCHAR(50), tipo INT, categoria INT, costo DOUBLE, precio DOUBLE, stock INT)
BEGIN
	INSERT tb_producto VALUES(id, descrip, tipo, categoria, costo, precio, stock);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_producto_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_producto_delete`(id INT)
BEGIN
	DELETE FROM tb_producto WHERE id_producto = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_producto_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_producto_obtain`(id INTEGER)
BEGIN
	SELECT * FROM tb_producto WHERE id_producto = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_producto_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_producto_read`()
BEGIN
	SELECT * FROM tb_producto;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_producto_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_producto_update`(id INT, descrip VARCHAR(50), tipo INT, categoria INT, costo DOUBLE, precio DOUBLE, stock INT)
BEGIN
	UPDATE tb_producto SET descrip_producto = descrip, tipo_producto = tipo, categoria_producto = categoria, 
		costo_producto = costo, precio_producto = precio, stock_producto = stock
	WHERE id_producto = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_create`(id INT, numero CHAR(6), fecha DATETIME, total DOUBLE, id_visita INT)
BEGIN
	INSERT tb_venta VALUES(id, numero, fecha, total, id_visita);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_delete`(id INT)
BEGIN
	DELETE FROM tb_venta WHERE id_venta = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_detalle_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_detalle_create`(id_ven INT, id_prod INT, cant INT)
BEGIN
	INSERT tb_venta_detalle VALUES(id_ven, id_prod, cant);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_detalle_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_detalle_delete`(id_ven INT, id_prod INT)
BEGIN
	DELETE FROM tb_venta_detalle WHERE id_venta = id_ven AND id_producto = id_prod;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_detalle_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_detalle_obtain`(id_ven INT, id_prod INT)
BEGIN
	SELECT * FROM tb_venta_detalle WHERE id_venta = id_ven AND id_producto = id_prod;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_detalle_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_detalle_read`()
BEGIN
	SELECT * FROM tb_venta_detalle;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_detalle_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_detalle_update`(id_ven INT, id_prod INT, cant INT)
BEGIN
	UPDATE tb_venta_detalle SET cantidad = cant
    WHERE id_venta = id_ven AND id_producto = id_prod;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_obtain`(id INTEGER)
BEGIN
	SELECT * FROM tb_venta WHERE id_venta = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_read`()
BEGIN
	SELECT * FROM tb_venta;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_venta_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_venta_update`(id INT, numero CHAR(6), fecha DATETIME, total DOUBLE, id_vis INT)
BEGIN
	UPDATE tb_venta SET numero_venta = numero, fecha_venta = fecha, total_venta = total, id_visita = id_vis
    WHERE id_venta = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_visita_create
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_visita_create`(id INT, idcli INT, idmese INT, idmesa INT, estadovisita INT)
BEGIN
	INSERT tb_visita VALUES(id, idcli, idmese, idmesa, estadovisita);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_visita_delete
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_visita_delete`(id INT)
BEGIN
	DELETE FROM tb_visita WHERE id_visita = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_visita_obtain
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_visita_obtain`(id INTEGER)
BEGIN
	SELECT * FROM tb_visita WHERE id_visita = id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_visita_read
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_visita_read`()
BEGIN
	SELECT * FROM tb_visita;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure usp_visita_update
-- -----------------------------------------------------

DELIMITER $$
USE `bd_restaurante`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_visita_update`(id INT, idcli INT, idmese INT, idmesa INT, estadovisita INT)
BEGIN
	UPDATE tb_visita SET id_cliente = idcli, id_mesero = idmese, id_mesa = idmesa, estado_visita = estadovisita
    WHERE id_visita = id;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
