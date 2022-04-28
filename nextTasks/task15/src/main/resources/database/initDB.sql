CREATE TABLE IF NOT EXISTS Authors
(
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(256) NOT NULL,
    last_name VARCHAR(256) NOT NULL,
    middle_name VARCHAR(256) NOT NULL,
    date VARCHAR(256) NOT NULL
);

CREATE SEQUENCE authors_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS Books
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(256) NOT NULL,
    date VARCHAR(256) NOT NULL
);

CREATE SEQUENCE books_sequence start 1 increment 1;