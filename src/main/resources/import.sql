
insert into variables (identificador, valor) values ('NUM_CUOTA', 1);
insert into variables (identificador, valor) values ('NUM_CUOTA', 3);
insert into variables (identificador, valor) values ('NUM_CUOTA', 6);
insert into variables (identificador, valor) values ('NUM_CUOTA', 9);
insert into variables (identificador, valor) values ('NUM_CUOTA', 12);
insert into variables (identificador, valor) values ('NUM_CUOTA', 18);
insert into variables (identificador, valor) values ('NUM_CUOTA', 24);
insert into variables (identificador, valor) values ('NUM_CUOTA', 36);

insert into variables (identificador, valor) values ('DIA_PAGO', 5);
insert into variables (identificador, valor) values ('DIA_PAGO', 20);


insert into variables (identificador, valor) values ('TEA', '99.90%');
insert into variables (identificador, valor) values ('TEA', '95.90%');
insert into variables (identificador, valor) values ('TEA', '90.90%');


insert into clientes (nombre, apellido_paterno,apellido_materno, dni) values ('Juan', 'Rojas', 'Perez', '48267857');
insert into clientes (nombre, apellido_paterno,apellido_materno, dni) values ('Rosas', 'Marquez', 'Castillo', '10067857');
insert into clientes (nombre, apellido_paterno,apellido_materno, dni) values ('Emiliano', 'Bermudez', 'Quispe', '75367857');
insert into clientes (nombre, apellido_paterno,apellido_materno, dni) values ('Rocio', 'Patron', 'Huaman', '98756661');

insert into teas (valor) values ('99.90%');
insert into teas (valor) values ('95.90%');
insert into teas (valor) values ('90.90%');

insert into tipo_tarjeta (nombre, descripcion, proveedor, tea_id) values ('clasica', 'Clásica', 'VISA', 1);
insert into tipo_tarjeta (nombre, descripcion, proveedor, tea_id) values ('oro', 'Oro', 'VISA', 2);
insert into tipo_tarjeta (nombre, descripcion, proveedor, tea_id) values ('black', 'Black', 'VISA', 3);

insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('123456789123456',1,1);
insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('234577666469786',2,1);
insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('124796323912345',3,1);
insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('234346786469786',2,2);
insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('243298096469786',1,3);
insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('235349875656554',3,3);
insert into tarjetas (numero_tarjeta, tipo_tarjeta_id, cliente_id) values ('123346586469786',1,4);


