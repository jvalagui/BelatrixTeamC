DROP DATABASE IF EXISTS bd_belatrix;

CREATE DATABASE bd_belatrix;

USE bd_belatrix;

CREATE TABLE tb_persona(
	id_persona			INTEGER			NOT NULL AUTO_INCREMENT,
	dni_persona			CHAR(8)			NOT NULL,
    nombre_persona		VARCHAR(30)		NOT NULL,
    ape_pat_persona		VARCHAR(30)		NOT NULL,
    ape_mat_persona		VARCHAR(30)		NOT NULL,
    PRIMARY KEY(id_persona)
);

CREATE TABLE tb_cliente(
	id_cliente			INTEGER			NOT NULL,
    PRIMARY KEY(id_cliente),
	FOREIGN KEY(id_cliente) REFERENCES tb_persona(id_persona)
);

CREATE TABLE tb_mesero(
	id_mesero			INTEGER			NOT NULL,
    PRIMARY KEY(id_mesero),
	FOREIGN KEY(id_mesero) REFERENCES tb_persona(id_persona)
);

CREATE TABLE tb_mesa(
	id_mesa				INTEGER			NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id_mesa)
);

CREATE TABLE tb_visita(
	id_visita			INTEGER			NOT NULL AUTO_INCREMENT,
    id_cliente			INTEGER			NOT NULL,
    id_mesero			INTEGER			NOT NULL,
    id_mesa				INTEGER			NOT NULL,
    PRIMARY KEY(id_visita),
    FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente),
    FOREIGN KEY(id_mesero) REFERENCES tb_mesero(id_mesero),
    FOREIGN KEY(id_mesa) REFERENCES tb_mesa(id_mesa)
    
);

CREATE TABLE tb_venta(
	id_venta			INTEGER			NOT NULL AUTO_INCREMENT,
	numero_venta		CHAR(6)			NOT NULL,
    fecha_venta			DATETIME		NOT NULL,
    total_venta			DOUBLE			NOT NULL,
    id_visita			INTEGER			NOT NULL,
	PRIMARY KEY(id_venta),
    FOREIGN KEY(id_visita) REFERENCES tb_visita(id_visita)
);

CREATE TABLE tb_producto(
	id_producto			INTEGER			NOT NULL AUTO_INCREMENT,
    descrip_producto	VARCHAR(50)		NOT NULL,
    tipo_producto		INTEGER			NOT NULL,
    categoria_producto	INTEGER			NOT NULL,
    costo_producto		DOUBLE			NOT NULL,
	precio_producto		DOUBLE			NOT NULL,
    stock_producto		INTEGER			NOT NULL,
    PRIMARY KEY(id_producto)
);

CREATE TABLE tb_venta_detalle(
	id_venta			INTEGER			NOT NULL,
    id_producto			INTEGER			NOT NULL,
    cantidad			INTEGER			NOT NULL,
    PRIMARY KEY(id_venta, id_producto),
    FOREIGN KEY(id_venta) REFERENCES tb_venta(id_venta),
    FOREIGN KEY(id_producto) REFERENCES tb_producto(id_producto)
);