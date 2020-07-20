CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(32),
    tipe_id      INT,
    expired_date DATE DEFAULT CURRENT_DATE,
    price        DECIMAL(12, 2),
    FOREIGN KEY (tipe_id) REFERENCES type (id)
);

CREATE TABLE type
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(32)
);


SET client_encoding TO 'utf8';
INSERT INTO public.product(name, type_id, expired_date, price)
VALUES ('RUSSO_SIR', 1, '2020-03-05', 28.02);
INSERT INTO public.product(name, type_id, expired_date, price)
VALUES ('RUSSO_SIR', 1, '2020-03-05', 28.02);
INSERT INTO public.product(name, type_id, expired_date, price)
VALUES ('Nnn_SIR', 1, '2020-03-05', 35.08),
       ('PROSTO_MILK', 2, '2020-04-01', 28.02),
       ('TT_MILK', 2, '2020-04-01', 28.02)
;
-- SELECT  products;
SELECT * FROM product ORDER BY id ASC;
--TRUNCATE public.type  RESTART IDENTITY CASCADE ;

UPDATE product
SET expired_date = now() + interval '1 month'
WHERE name = 'RUSSO_SIR';

SET client_encoding TO 'utf8';

INSERT INTO public.type(
    name)
VALUES ('SIR'),
       ('MOLOKO'),
       ('MYASO');

SELECT *
FROM type;

-----------------------
--Tasks filters
-----------------------
--1
SELECT p.id, p.name, p.expired_date, p.price
FROM product p
INNER JOIN type t ON t.id = p.type_id
WHERE t.name = 'СЫР';
--2
SELECT *
FROM product
WHERE product.name LIKE '%мороженное%';
--3
SELECT *
FROM product p
WHERE extract(month FROM p.expired_date) = extract(month FROM now() + interval '1 month') ;
--4
SELECT p.name, p.expired_date, p.price most_expensive
FROM product p
WHERE p.price = (select max(price) from product);
--5
SELECT t.name, COUNT(p.*)
FROM product p
RIGHT OUTER JOIN type t ON t.id = p.type_id
GROUP BY t.name;
--6
SELECT p.id, t.name, p.name, p.expired_date, p.price
FROM product p
INNER JOIN type t ON t.id = p.type_id
WHERE t.name IN ('СЫР', 'МОЛОКО')
ORDER BY 2;
--7
SELECT t.name, COUNT(p.*) as col_pr
FROM type t
INNER JOIN product p ON t.id = p.type_id
GROUP BY t.name
HAVING COUNT(p.*) < 10;
--8
SELECT  p.name, t.name, p.expired_date, p.price
FROM product p INNER JOIN type t ON t.id = p.type_id
ORDER  BY  p.name, t.name DESC;





