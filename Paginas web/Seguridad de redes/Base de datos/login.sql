
  CREATE TABLE login (

    id int (11) NOT NULL AUTO_INCREMENT,
    correo varchar (150) NOT NULL,
    usuario varchar (150) NOT NULL,
    contrasena varchar (100) NOT NULL,

    UNIQUE KEY (id));
