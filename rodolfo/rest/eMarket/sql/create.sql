DROP TABLE IF EXISTS compra;
DROP TABLE IF EXISTS ofrece;
DROP TABLE IF EXISTS libreria;
DROP TABLE IF EXISTS libro;
DROP TABLE IF EXISTS lector;

CREATE TABLE libreria (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  cif CHAR(9) NOT NULL UNIQUE KEY,
  direccion VARCHAR(200),
  nombre VARCHAR(50) NOT NULL
) ENGINE = InnoDB; 

CREATE TABLE libro (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(50) NOT NULL,
  autor VARCHAR(100) NOT NULL, 
  precio FLOAT NOT NULL
) ENGINE = InnoDB; 

CREATE TABLE lector (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  fecha_nacimiento DATE,
  direccion VARCHAR(200)
) ENGINE = InnoDB; 

CREATE TABLE ofrece (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  libreria_id INT NOT NULL,
  libro_id INT NOT NULL,
  precio FLOAT NOT NULL,
  CONSTRAINT uq_ofrece_libreria_libro UNIQUE KEY (libreria_id, libro_id),
  CONSTRAINT fk_ofrece_libreria FOREIGN KEY (`libreria_id`) REFERENCES libreria(`id`),
  CONSTRAINT fk_ofrece_libro FOREIGN KEY (`libro_id`) REFERENCES libro(`id`)
) ENGINE = InnoDB; 

CREATE TABLE compra (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  lector_id INT NOT NULL,
  libreria_id INT NOT NULL,
  libro_id INT NOT NULL,
  fecha DATE NOT NULL,
  montante FLOAT NOT NULL,
  CONSTRAINT uq_compra_lector_libreria_libro UNIQUE KEY (lector_id, libreria_id, libro_id),
  CONSTRAINT fk_compra_lector FOREIGN KEY (`lector_id`) REFERENCES lector(`id`),
  CONSTRAINT fk_compra_libreria FOREIGN KEY (`libreria_id`) REFERENCES libreria(`id`),
  CONSTRAINT fk_compra_libro FOREIGN KEY (`libro_id`) REFERENCES libro(`id`)
) ENGINE = InnoDB; 


