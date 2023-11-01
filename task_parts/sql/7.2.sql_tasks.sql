-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

-- Удаляю всех, кто 'Camel'
-- SELECT * FROM animals
DELETE FROM animals
WHERE animal_type_id=(SELECT id FROM animal_types WHERE name='Camel');

-- У меня нет отдельных таблиц под разные типы животных, я могу просто
SELECT id, name FROM animals
WHERE animal_type_id IN (SELECT id FROM animal_types
                         WHERE name='Horse' OR name='Donkey');

-- Но задача стоит "объединить", значит будет
SELECT id, name FROM animals
WHERE animal_type_id=(SELECT id FROM animal_types WHERE name='Horse')
UNION
SELECT id, name FROM animals
WHERE animal_type_id=(SELECT id FROM animal_types WHERE name='Donkey');

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и
--   вычислить их возраст с точностью до месяца.

--  Сделаю view, т.к. кажется, что он лучше подходит под задачу
CREATE OR REPLACE VIEW aged_animals AS
SELECT name, birthdate FROM animals a
-- с точностью до месяца это получить разницу с текущкй датой в месяцах и взять тех, кто попал в диапазон [12 ... 36]
WHERE Timestampdiff(MONTH, a.birthdate, Curdate()) BETWEEN 12 AND 36;

SELECT * FROM aged_animals;

-- Объединить все созданные таблицы в одну, сохраняя
--   информацию о принадлежности к исходным таблицам

--  Вероятно имелось в виду собрать "красивую таблицу" как в постановке задачи, но для всех животных
--  Также VIEW тут наверное предпочтительнее, использую его
CREATE OR REPLACE VIEW fancy_all_animals AS
SELECT
  a.name AS 'name',
  a.birthdate,
  atp.name AS 'type',
  agr.name AS 'group',
  GROUP_CONCAT(ac.name SEPARATOR ',') AS 'commands'
FROM animal_groups agr
JOIN animal_types atp ON agr.id = atp.animal_group_id
JOIN animals a ON a.animal_type_id = atp.id
JOIN commands c ON c.animal_id = a.id
JOIN available_commands ac on c.command_id = ac.id
GROUP BY a.id;

SELECT * FROM fancy_all_animals;
