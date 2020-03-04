DROP TABLE questions IF EXISTS;
CREATE TABLE questions(
    id serial primary key,
    name VARCHAR(255));

DROP TABLE users if EXISTS;
CREATE TABLE users(
    id serial primary key,
    user_name VARCHAR(255),
    password VARCHAR(255));

DROP TABLE role if EXISTS;
create TABLE role(
    id serial primary key,
    users long references users(id),
    authority_name VARCHAR(255));

DROP TABLE answers IF EXISTS;
CREATE TABLE answers(
    id serial primary key,
    questions long references questions(id),
    is_right boolean,
    name VARCHAR(255));

drop table user_answers if exists;
create table user_answers(
    id serial primary key,
    user_answer VARCHAR(255),
    user_id long references users(id),
    question_id long references questions(id),
    is_right boolean);

DROP TABLE user_scores if EXISTS;
CREATE TABLE user_scores(
    id serial primary key,
    user_id long references users(id),
    user_score long);