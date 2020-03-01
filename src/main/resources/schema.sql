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

DROP TABLE roles if EXISTS;
create TABLE role(
    id serial primary key,
    users long references users(id),
    authority_name VARCHAR(255));

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

DROP TABLE userscore if EXISTS;
CREATE TABLE userscore(
    id serial primary key,
    user_id long references users(id),
    user_score long);