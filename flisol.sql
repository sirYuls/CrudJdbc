CREATE DATABASE flisol;
CREATE TABLE usuario (
  id_usuario int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  apellido_paterno varchar(100) NOT NULL,
  apellido_materno varchar(100) NOT NULL,
  edad int(11) NOT NULL,
  username varchar(100) NOT NULL,
  password varchar(300) NOT NULL,
  PRIMARY KEY (id_usuario)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



apt-get install mysql-server