--Insertar datos de ejemplo en la tabla de usuarios
INSERT INTO usuario (nombre, contrasena) VALUES ('maxi', '1234');
INSERT INTO usuario (nombre, contrasena) VALUES ('user', '$2a$12$SlpV8ZblK/SXq1i5wHF67O5sZt9XduojXyBfQkry317PXAlAlhF8u');

-- Insertar datos de ejemplo en la tabla de dueños
INSERT INTO duenio (nombre, direccion) VALUES ('Maxi', 'Calle 123');
INSERT INTO duenio (nombre, direccion) VALUES ('Natalia', 'Avenida 456');
INSERT INTO duenio (nombre, direccion) VALUES ('Antonella', 'Avenida 457');
INSERT INTO duenio (nombre, direccion) VALUES ('Brian', 'Avenida 458');
INSERT INTO duenio (nombre, direccion) VALUES ('Sergio', 'Avenida 458');
INSERT INTO duenio (nombre, direccion) VALUES ('Juan', 'Avenida 459');

-- Insertar datos de ejemplo en la tabla de mascotas
INSERT INTO mascota (nombre, especie, edad, duenio_id) VALUES ('Chano','Aspiradora Robot',2,1);
INSERT INTO mascota (nombre, especie, edad, duenio_id) VALUES ('pepe','rana',3,2);
INSERT INTO mascota (nombre, especie, edad, duenio_id) VALUES ('Morita','perro',10,3);
INSERT INTO mascota (nombre, especie, edad, duenio_id) VALUES ('Mara','perro',2,4);
INSERT INTO mascota (nombre, especie, edad, duenio_id) VALUES ('Bondiola','perro',3,5);
INSERT INTO mascota (nombre, especie, edad, duenio_id) VALUES ('Momo','gato',2,6);