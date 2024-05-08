DROP SCHEMA IF EXISTS voz;
CREATE SCHEMA voz DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE voz;

CREATE TABLE vozovi (
brojVoza BIGINT NOT NULL,
nazivVoza VARCHAR (40) NOT NULL,
datumPolaska DATETIME,
cenaKarte DECIMAL (10,2) NOT NULL,
brojMesta INT NOT NULL,
PRIMARY KEY(brojVoza)
);

CREATE TABLE karte (
id BIGINT AUTO_INCREMENT,
brojVoza BIGINT,
datumProdajeKarte DATETIME,
kupac VARCHAR(70) NOT NULL,
razred INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (brojVoza) REFERENCES vozovi(brojVoza)
);

INSERT INTO vozovi (brojVoza, nazivVoza, datumPolaska, cenaKarte, brojMesta) VALUES ('2405', 'Regio', '2022-05-06 07:43', 600.00, 5);
INSERT INTO vozovi (brojVoza, nazivVoza, datumPolaska, cenaKarte, brojMesta) VALUES ('543', 'Soko', '2022-05-06 13:00', 1000.00, 4);
INSERT INTO vozovi (brojVoza, nazivVoza, datumPolaska, cenaKarte, brojMesta) VALUES ('749', 'Brzi', '2022-05-06 21:30', 800.00, 7);
INSERT INTO vozovi (brojVoza, nazivVoza, datumPolaska, cenaKarte, brojMesta) VALUES ('541', 'Soko', '2022-05-07 07:04', 1000.00, 8);
INSERT INTO vozovi (brojVoza, nazivVoza, datumPolaska, cenaKarte, brojMesta) VALUES ('245', 'Regio', '2022-05-06 08:43', 900.00, 7);

INSERT INTO karte (brojVoza,datumProdajeKarte,kupac,razred) VALUES (749, '2022-05-01 10:00', 'Kupac1', 1);
INSERT INTO karte (brojVoza,datumProdajeKarte,kupac,razred) VALUES (749, '2022-05-01 12:00', 'Kupac2', 1);
INSERT INTO karte (brojVoza,datumProdajeKarte,kupac,razred) VALUES (541, '2022-05-01 10:00', 'Kupac3', 2);
INSERT INTO karte (brojVoza,datumProdajeKarte,kupac,razred) VALUES (245, '2022-05-01 10:00', 'Kupac4', 3);
INSERT INTO karte (brojVoza,datumProdajeKarte,kupac,razred) VALUES (543, '2022-05-01 10:00', 'Kupac5', 2);
INSERT INTO karte (brojVoza,datumProdajeKarte,kupac,razred) VALUES (543, '2022-05-01 10:00', 'Kupac6', 3);

 

