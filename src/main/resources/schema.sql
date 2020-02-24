DROP TABLE questions_data IF EXISTS;
CREATE TABLE questions_data(
id serial primary key,
name VARCHAR(255),
answer VARCHAR(255));

DROP TABLE answer_data IF EXISTS;
CREATE TABLE answer_data(
id serial primary key,
questions_data long references questions_data(id),
is_right boolean,
name VARCHAR(255));

DROP TABLE question_type if EXISTS;
CREATE TABLE question_type(
id serial primary key,
questions_data long references questions_data(id),
name VARCHAR(255));




--insert into question_type (id, name)
--values
--(1, "Вопрос со свободным выбором ответа"),
--(2, "Вопрос с выбором из вариантов");