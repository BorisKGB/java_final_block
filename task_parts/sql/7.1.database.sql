DROP DATABASE IF EXISTS `Human Friends`;
CREATE DATABASE `Human Friends`;
USE `Human Friends`;

-- Доступные комманды
DROP TABLE IF EXISTS available_commands;
CREATE TABLE available_commands (
  id SERIAL PRIMARY KEY,
  name TEXT
);

INSERT INTO available_commands (id, name)
VALUES
(1, 'Sit'), (2, 'Stay'),
(3, 'Fetch'), (4, 'Pounce'),
(5, 'Roll'), (6, 'Hide'),
(7, 'Paw'), (8, 'Voice'),
(9, 'Scratch'), (10, 'Spin'),
(11, 'Jump'), (12, 'Trot'),
(13, 'Canter'), (14, 'Gallop'),
(15, 'Walk'), (16, 'CarryLoad'),
(17, 'Bray'), (18, 'Kick'),
(19, 'Run');

-- Группы животных
DROP TABLE IF EXISTS animal_groups;
CREATE TABLE animal_groups (
  id SERIAL PRIMARY KEY,
  name TEXT
);

INSERT INTO animal_groups (id, name)
VALUES (1, 'Pets'), (2, 'Pack animals');

-- Типы животных
DROP TABLE IF EXISTS animal_types;
CREATE TABLE animal_types (
  id SERIAL PRIMARY KEY,
  name TEXT,
  animal_group_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_group_id) REFERENCES animal_groups(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animal_types (id, name, animal_group_id) VALUES
(1, 'Cat', 1), (2, 'Dog', 1),
(3, 'Hamster', 1), (4, 'Horse', 2),
(5, 'Camel', 2), (6, 'Donkey', 2);

-- Животные
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
  id SERIAL PRIMARY KEY,
  name TEXT,
  birthdate DATE,
  animal_type_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_type_id) REFERENCES animal_types(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animals (id, name, birthdate, animal_type_id) VALUES
(1, 'Fido', '2020-01-01', 2), (2, 'Whiskers', '2019-05-15', 1),
(3, 'Hammy', '2021-03-10', 3), (4, 'Buddy', '2018-12-10', 2),
(5, 'Smudge', '2020-02-20', 1), (6, 'Peanut', '2021-08-01', 3),
(7, 'Bella', '2019-11-11', 2), (8, 'Oliver', '2020-06-30', 1),
(9, 'Thunder', '2015-07-21', 4), (10, 'Sandy', '2016-11-03', 5),
(11, 'Eeyore', '2017-09-18', 6), (12, 'Storm', '2014-05-05', 4),
(13, 'Dune', '2018-12-12', 5), (14, 'Burro', '2019-01-23', 6),
(15, 'Blaze', '2016-02-29', 4), (16, 'Sahara', '2015-08-14', 5);

-- Комманды, которые умеют животные
DROP TABLE IF EXISTS commands;
CREATE TABLE commands (
--  id SERIAL PRIMARY KEY,
  animal_id BIGINT UNSIGNED NOT NULL,
  command_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES animals(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (command_id) REFERENCES available_commands(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO commands (animal_id, command_id) VALUES
(1, 1), (1, 2), (1, 3), (2, 1), (2, 4), (3, 5),
(3, 6), (4, 1), (4, 7), (4, 8), (5, 1), (5, 4),
(5, 9), (6, 5), (6, 10), (7, 1), (7, 2), (7, 5),
(8, 8), (8, 9), (8, 11), (9, 12), (9, 13), (9, 14),
(10, 15), (10, 16), (11, 15), (11, 16), (11, 17), (12, 12),
(12, 13), (13, 15), (13, 1), (14, 15), (14, 17), (14, 18),
(15, 12), (15, 11), (15, 14), (16, 15), (16, 19);
