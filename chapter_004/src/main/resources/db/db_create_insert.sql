-- -----------------------------------------------------
-- DATABASE system_items
-- -----------------------------------------------------
--DROP DATABASE  system_items;
CREATE DATABASE system_items
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- -----------------------------------------------------
-- Table `system_items`.`usr`
-- -----------------------------------------------------
DROP TABLE IF EXISTS usr CASCADE;
CREATE TABLE usr
(
    usr_id  SERIAL PRIMARY KEY,
    name    VARCHAR(45) NULL,
    sername VARCHAR(45) NOT NULL,
    role_id INT         NOT NULL,
    CONSTRAINT fk_role_id
        FOREIGN KEY (role_id) REFERENCES role(role_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `system_items`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS  role CASCADE;

CREATE TABLE role
(
    role_id SERIAL PRIMARY KEY,
    r_name  VARCHAR(45) NOT NULL
);

-- -----------------------------------------------------
-- Table `system_items`.`rules`
-- -----------------------------------------------------
DROP TABLE IF EXISTS rules CASCADE;

CREATE TABLE rules
(
    rules_id SERIAL PRIMARY KEY,
    ru_name  VARCHAR(45) NULL
);

-- -----------------------------------------------------
-- Table `system_items`.`state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS state Cascade;

CREATE TABLE state
(
    state_id SERIAL PRIMARY KEY,
    status   VARCHAR(45) NULL
);


-- -----------------------------------------------------
-- Table `system_items`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category
(
    ca_id   SERIAL PRIMARY KEY,
    ca_name VARCHAR(45) NOT NULL
);


-- -----------------------------------------------------
-- Table `system_items`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS item CASCADE;

CREATE TABLE item
(
    item_id  SERIAL PRIMARY KEY,
    it_name  VARCHAR(60) NOT NULL,
    usr_id   INT         NOT NULL,
    ca_id    INT         NOT NULL,
    state_id INT         NOT NULL,
    FOREIGN KEY (state_id) REFERENCES state (state_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (ca_id)
        REFERENCES category (ca_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (usr_id) REFERENCES usr (usr_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table `system_items`.`attaches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS attaches CASCADE;

CREATE TABLE attaches
(
    att_id        SERIAL PRIMARY KEY,
    att_file_name VARCHAR(100) NULL,
    att_file      bytea        NULL,
    item_id       INT          NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item (item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


-- -----------------------------------------------------
-- Table `system_items`.`role_rules`
-- -----------------------------------------------------
DROP TABLE IF EXISTS role_rules CASCADE;

CREATE TABLE role_rules
(
    id_role_rules SERIAL PRIMARY KEY,
    role_id       INT NOT NULL,
    rules_id      INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (role_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (rules_id)
        REFERENCES rules (rules_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `system_items`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS comments CASCADE;

CREATE TABLE IF NOT EXISTS comments
(
    co_id  SERIAL PRIMARY KEY,
    comment_text VARCHAR(255) NOT NULL DEFAULT 'no comments',
    item_id INT NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item(item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Insert data into tables
-- -----------------------------------------------------
INSERT INTO usr(name,sername,role_id) VALUES ('Andrej','Sulimov', 1);
INSERT INTO usr(name,sername,role_id) VALUES ('Petr','Stepanenko',2);
INSERT INTO usr(name,sername,role_id) VALUES ('John','Silver',2);

INSERT INTO role (r_name) VALUES ('admin');
INSERT INTO role (r_name) VALUES ('manager');

INSERT INTO  rules (ru_name) VALUES ('CREATE');
INSERT INTO  rules (ru_name) VALUES ('GRANT ');
INSERT INTO  rules (ru_name) VALUES ('Select');
INSERT INTO  rules (ru_name) VALUES ('INSERT');
INSERT INTO  rules (ru_name) VALUES ('UPDATE');
INSERT INTO  rules (ru_name) VALUES ('ALTER');
INSERT INTO  rules (ru_name) VALUES ('DELETE');
INSERT INTO  rules (ru_name) VALUES ('DROP');
INSERT INTO  rules (ru_name) VALUES ('TRUNCATE');

INSERT INTO role_rules (role_id, rules_id) VALUES (1,1);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,2);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,3);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,4);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,5);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,6);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,7);
INSERT INTO role_rules (role_id, rules_id) VALUES (1,8);
INSERT INTO role_rules (role_id, rules_id) VALUES (2,3);
INSERT INTO role_rules (role_id, rules_id) VALUES (2,4);
INSERT INTO role_rules (role_id, rules_id) VALUES (2,5);
INSERT INTO role_rules (role_id, rules_id) VALUES (2,7);

INSERT INTO category (ca_name) VALUES ('system_admin');
INSERT INTO category (ca_name) VALUES ('manage_operate');

INSERT INTO state (status) VALUES ('ready');
INSERT INTO state (status) VALUES ('processing');

INSERT INTO item (it_name, usr_id, ca_id, state_id) VALUES ('Create localDB', 1, 1, 2);
INSERT INTO item (it_name, usr_id, ca_id, state_id) VALUES ('Add data', 2, 2, 2);
INSERT INTO item (it_name, usr_id, ca_id, state_id) VALUES ('Update data', 2, 2, 1);
INSERT INTO item (it_name, usr_id, ca_id, state_id) VALUES ('Edit table', 1, 1, 1);

INSERT INTO comments(comment_text,item_id) VALUES('Its testing database', 2);

INSERT INTO attaches (att_file_name,att_file,item_id) values ('copy_passport', '/home/user/123.txt', 2);
INSERT INTO attaches (att_file_name,att_file,item_id) values ('passp_foto', '/home/user/f1.png', 3);

-- -----------------------------------------------------
-- Test queries
-- -----------------------------------------------------
SELECT * from item;
SELECT * from attaches;
SELECT * from comments;
SELECT * from state;
SELECT * from category;
SELECT * from role;
SELECT * from usr;
SELECT * from rules;