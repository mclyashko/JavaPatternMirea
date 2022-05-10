CREATE TABLE IF NOT EXISTS Authors
(
    id BIGINT PRIMARY KEY NOT NULL,
    first_name VARCHAR(256) NOT NULL,
    last_name VARCHAR(256) NOT NULL,
    middle_name VARCHAR(256) NOT NULL,
    date VARCHAR(256) NOT NULL
);

CREATE SEQUENCE authors_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS Books
(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(256) NOT NULL,
    date VARCHAR(256) NOT NULL,
    author_id INTEGER NOT NULL
);

CREATE SEQUENCE books_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS Users
(
    id BIGINT PRIMARY KEY NOT NULL,
    login VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL
);

CREATE SEQUENCE users_sequence start 1 increment 1;