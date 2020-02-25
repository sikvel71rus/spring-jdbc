DROP TABLE questions_data IF EXISTS;
CREATE TABLE questions_data(
id serial primary key,
name VARCHAR(255));

DROP TABLE users if EXISTS;
CREATE TABLE users(
id serial primary key,
user_name VARCHAR(255),
password VARCHAR(255),
user_score float);

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

drop table user_answer if exists;
create table user_answer(
id serial primary key,
user_answer VARCHAR(255),
user_id long references users(id),
question_id long references questions_data(id),
is_right boolean);

drop table answer_user if exists;
create table answer_user(
user long,
user_answer long,
primary key (user,user_answer));

drop table question_answer if exists;
create table question_answer(
question long,
user_answer long,
primary key (question, user_answer));






--insert into question_type (id, name)
--values
--(1, "Вопрос со свободным выбором ответа"),
--(2, "Вопрос с выбором из вариантов");