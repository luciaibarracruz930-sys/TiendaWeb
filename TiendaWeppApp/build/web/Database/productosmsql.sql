create database Store;

Use  Store;

create table productos  (
  ID int Auto_increment primary key,
  Name varchar(100) NOT NULL,
  Precio Decimal(10,2) NOT NULL,
  Stock int NOT NULL
  );
  

INSERT INTO productos (Name, Precio, Stock)
 Values 
 ('Airpods' ,150000,10),
 ('Iphone15',450000,5),
 ('Samsung Galaxy',350000,8),
 ('Camara kodak pix pro fz45',90000,4),
 ('Ipad9g',250000,3);
 
 SELECT * FROM productos;
 


 