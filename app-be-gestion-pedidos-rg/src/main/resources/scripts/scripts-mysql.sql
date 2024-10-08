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
