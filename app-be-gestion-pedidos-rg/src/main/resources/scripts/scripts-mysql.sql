-- MYSQL
--------------------------------------------
create database dbcursFs;

use dbcursFs;

create table tbl_cliente(
    cliente_id int not null auto_increment  primary key,
    razon_social varchar(260) not null unique,
    ruc char(11) not null unique,
    direccion varchar(400) not null,
    telefono varchar(20) null,
    correo varchar(60) null,
    estado char(1) default '1' not null 
);

INSERT INTO tbl_cliente(razon_social,ruc,direccion,telefono,correo)
VALUES('CLARO EMPRESAS','20544987258','AV. LARCO 237-SAN ISIDRO','456-4574','contacto@claro.com.pe');

--------------------------------------------

use dbcursfs;

create table tbl_producto(
producto_id int not null auto_increment primary key,
nombre varchar(60) not null,
precio float null,
stock int not null,
estado char(1) default '1'
);

drop table tbl_producto;

insert into tbl_producto(nombre, precio, stock, estado) values ('LAPTOP ASUS VIVOBOOK PRO', 3500, 4, '1');
insert into tbl_producto(nombre, precio, stock, estado) values ('ALCOHOL ISOPROPILICO 70', 7.00, 15, '1');
insert into tbl_producto(nombre, precio, stock, estado) values ('LAPTOP ASUS VIVOBOOK PRO', 4500, 15, '1');
insert into tbl_producto(nombre, precio, stock, estado) values ('ALCOHOL ISOPROPILICO 90', 7.00, 12, '1');
insert into tbl_producto(nombre, precio, stock, estado) values ('CARGADOR LENEVO ORIGINAL MODELO 2471', 8.00, 10, '1');
insert into tbl_producto(nombre, precio, stock, estado) values ('LAPTOP ASUS VIVOBOOK PLUS', 3800, 4, '1');

SELECT producto_id, nombre, precio, stock, estado FROM tbl_producto;

