CREATE DATABASE Vendas;

USE Vendas;

CREATE TABLE vendas_trimestre (
    trimestre VARCHAR(5), -- Ex: 'T1', 'T2'
    valor INT
);

INSERT INTO vendas_trimestre VALUES('T1', 10);
INSERT INTO vendas_trimestre VALUES('T1', 18);
INSERT INTO vendas_trimestre VALUES('T1', 9);
INSERT INTO vendas_trimestre VALUES('T2', 23);
INSERT INTO vendas_trimestre VALUES('T2', 25);
INSERT INTO vendas_trimestre VALUES('T2', 32);
