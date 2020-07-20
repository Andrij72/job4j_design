--DROP DATABASE  system_items;
CREATE DATABASE spammer
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

----Create table users
CREATE TABLE users
(
    usr_id   SERIAL,
    usr_name VARCHAR(32),
    email    VARCHAR(64)
);