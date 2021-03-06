INSERT INTO libro(id, titulo, autor, precio) VALUES(1, 'Libro #1', 'Autor #1', 200);
INSERT INTO libro(id, titulo, autor, precio) VALUES(2, 'Libro #2', 'Autor #2', 50);
INSERT INTO libro(id, titulo, autor, precio) VALUES(3, 'Libro #3', 'Autor #1', 500);
INSERT INTO libro(id, titulo, autor, precio) VALUES(4, 'Libro #4', 'Autor #3', 250);
INSERT INTO libreria(id, cif, nombre, direccion) VALUES(1, '12345678A', 'Librería #1', 'Dirección #1');
INSERT INTO libreria(id, cif, nombre, direccion) VALUES(2, '90123456B', 'Librería #2', 'Dirección #2');
INSERT INTO libreria(id, cif, nombre, direccion) VALUES(3, '78901234C', 'Librería #3', 'Dirección #3');
INSERT INTO libreria(id, cif, nombre, direccion) VALUES(4, '56789012D', 'Librería #4', 'Dirección #4');
INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(1, 'Lector #1', 'Lector #1', '1980-01-03', 'Dirección #1');
INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(2, 'Lector #2', 'Lector #2', '1986-03-23', 'Dirección #2');
INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(3, 'Lector #3', 'Lector #3', '1990-12-30', 'Dirección #3');
INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(4, 'Lector #4', 'Lector #4', '1989-06-04', 'Dirección #4');
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(1, 1, 200);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(1, 2, 220);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(2, 2, 100);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(3, 2, 500);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(3, 3, 510);
INSERT INTO compra(lector_id, libro_id, libreria_id, fecha, montante) VALUES(1, 1, 1, CURRENT_DATE, 200);
INSERT INTO compra(lector_id, libro_id, libreria_id, fecha, montante) VALUES(1, 2, 1, CURRENT_DATE, 240);
INSERT INTO compra(lector_id, libro_id, libreria_id, fecha, montante) VALUES(2, 1, 1, CURRENT_DATE, 205);
INSERT INTO compra(lector_id, libro_id, libreria_id, fecha, montante) VALUES(3, 2, 2, CURRENT_DATE, 80);
INSERT INTO compra(lector_id, libro_id, libreria_id, fecha, montante) VALUES(3, 3, 3, CURRENT_DATE, 505);