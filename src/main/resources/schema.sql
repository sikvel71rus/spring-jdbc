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