CREATE TABLE owner(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 surname VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 patronymics VARCHAR(255) NOT NULL,
 date DATE NOT NULL
);

CREATE TABLE floor(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 flat_value INTEGER NOT NULL CHECK (flat_value > 0),
 number_flat INTEGER NOT NULL CHECK (number_flat > 0)
);

CREATE TABLE flat(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 id_floor INTEGER NOT NULL CHECK(id_floor > 0),
 area NUMERIC(19, 2) NOT NULL CHECK(area > 0),
 floor_space NUMERIC(19, 2) NOT NULL CHECK(floor_space > 0),
 room_value INTEGER NOT NULL CHECK(room_value > 0),
 number_flat INTEGER NOT NULL CHECK(number_flat > 0),
 FOREIGN KEY (id_floor) REFERENCES floor (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE owner_flat(
 id_owner INTEGER NOT NULL CHECK(id_owner > 0),
 id_flat INTEGER NOT NULL CHECK(id_flat > 0),
 FOREIGN KEY (id_owner) REFERENCES owner(id) ON DELETE RESTRICT ON UPDATE CASCADE,
 FOREIGN KEY (id_flat) REFERENCES flat(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE type(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 name VARCHAR(50)
);

CREATE TABLE counter(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 id_flat INTEGER NOT NULL CHECK (id_flat > 0),
 id_type INTEGER NOT NULL CHECK (id_type > 0),
 FOREIGN KEY (id_flat) REFERENCES flat(id) ON DELETE RESTRICT ON UPDATE CASCADE,
 FOREIGN KEY (id_type) REFERENCES type(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE reading(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 id_counter INTEGER NOT NULL CHECK(id_counter > 0),
 value NUMERIC(19, 2) NOT NULL CHECK(value > 0),
 date DATE NOT NULL,
 FOREIGN KEY (id_counter) REFERENCES counter(id) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO owner (id, surname, name, patronymics, date) VALUES (DEFAULT, 'Кононов', 'Андрей', 'Олегович', '2003-06-25'),
(DEFAULT, 'Хамрачёв', 'Евгений', 'Евгеньевич', '2002-03-14'),
(DEFAULT, 'Храпичева', 'Алина', 'Алексеевна', '2002-10-07');

INSERT INTO floor (id, flat_value, number_floor) VALUES (DEFAULT, 4, 1),
(DEFAULT, 4, 2),
(DEFAULT, 4, 3),
(DEFAULT, 3, 4),
(DEFAULT, 0, 5);

INSERT INTO flat (id, id_floor, area, floor_space, room_value, number_flat) VALUES (DEFAULT, 1, 80.00, 60.00, 3, 1),
(DEFAULT, 1, 100.00, 85.00, 4, 2),
(DEFAULT, 1, 100.00, 85.00, 4, 3),
(DEFAULT, 1, 80.00, 60.00, 3, 4),
(DEFAULT, 2, 80.00, 60.00, 2, 5);

INSERT INTO owner_flat (id_owner, id_flat) VALUES (1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5);

INSERT INTO type (id, name) VALUES (DEFAULT, 'холодная вода стояк 1'),
(DEFAULT, 'горячая вода стояк 1'),
(DEFAULT, 'холодная вода стояк 2'),
(DEFAULT, 'горячая вода стояк 2'),
(DEFAULT, 'электричество день'),
(DEFAULT, 'электричество ночь'),
(DEFAULT, 'газ');

INSERT INTO counter (id, id_flat, id_type) VALUES (DEFAULT, 1, 1),
(DEFAULT, 1, 2),
(DEFAULT, 1, 5),
(DEFAULT, 1, 7),
(DEFAULT, 2, 1),
(DEFAULT, 2, 2),
(DEFAULT, 2, 3),
(DEFAULT, 2, 4),
(DEFAULT, 2, 5),
(DEFAULT, 2, 6),
(DEFAULT, 2, 7),
(DEFAULT, 3, 1),
(DEFAULT, 3, 2),
(DEFAULT, 3, 3),
(DEFAULT, 3, 4),
(DEFAULT, 3, 5),
(DEFAULT, 3, 6),
(DEFAULT, 3, 7),
(DEFAULT, 4, 1),
(DEFAULT, 4, 2),
(DEFAULT, 4, 5),
(DEFAULT, 4, 7),
(DEFAULT, 5, 1),
(DEFAULT, 5, 2),
(DEFAULT, 5, 5),
(DEFAULT, 5, 6),
(DEFAULT, 5, 7),
(DEFAULT, 1, 3),
(DEFAULT, 1, 4),
(DEFAULT, 1, 6),
(DEFAULT, 4, 3),
(DEFAULT, 4, 4),
(DEFAULT, 4, 6);

INSERT INTO reading (id, id_counter, value, date) VALUES (DEFAULT, 1, 23.43, '2022-09-01'),
(DEFAULT, 2, 12.32, '2022-09-01'),
(DEFAULT, 3, 34.54, '2022-09-01'),
(DEFAULT, 4, 65.34, '2022-09-01'),
(DEFAULT, 5, 56.50, '2022-09-01'),
(DEFAULT, 6, 23.40, '2022-09-01'),
(DEFAULT, 7, 67.40, '2022-09-01'),
(DEFAULT, 8, 89.40, '2022-09-01'),
(DEFAULT, 9, 34.30, '2022-09-01'),
(DEFAULT, 10, 53.00, '2022-09-01'),
(DEFAULT, 11, 34.23, '2022-09-01'),
(DEFAULT, 12, 56.34, '2022-09-01'),
(DEFAULT, 13, 67.98, '2022-09-01'),
(DEFAULT, 14, 41.23, '2022-09-01'),
(DEFAULT, 15, 42.67, '2022-09-01'),
(DEFAULT, 16, 67.78, '2022-09-01'),
(DEFAULT, 17, 78.54, '2022-09-01'),
(DEFAULT, 18, 89.12, '2022-09-01'),
(DEFAULT, 19, 23.34, '2022-09-01'),
(DEFAULT, 20, 45.45, '2022-09-01'),
(DEFAULT, 21, 56.67, '2022-09-01'),
(DEFAULT, 22, 25.36, '2022-09-01'),
(DEFAULT, 23, 36.47, '2022-09-01'),
(DEFAULT, 24, 57.35, '2022-09-01'),
(DEFAULT, 25, 47.34, '2022-09-01'),
(DEFAULT, 26, 76.72, '2022-09-01'),
(DEFAULT, 27, 67.87, '2022-09-01'),
(DEFAULT, 28, 67.87, '2022-09-01'),
(DEFAULT, 29, 67.87, '2022-09-01'),
(DEFAULT, 30, 67.87, '2022-09-01'),
(DEFAULT, 31, 67.87, '2022-09-01'),
(DEFAULT, 32, 67.87, '2022-09-01'),
(DEFAULT, 33, 67.87, '2022-09-01');











