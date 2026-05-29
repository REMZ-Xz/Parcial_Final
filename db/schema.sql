CREATE DATABASE IF NOT EXISTS parcial_final_db;
USE parcial_final_db;

DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS personaje;
DROP TABLE IF EXISTS clase;

CREATE TABLE clase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE personaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    clase_id INT NOT NULL,
    vida INT NOT NULL,
    FOREIGN KEY (clase_id) REFERENCES clase(id) ON DELETE CASCADE
);

CREATE TABLE item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(30), -- Arma, Poción, Escudo
    personaje_id INT NOT NULL,
    FOREIGN KEY (personaje_id) REFERENCES personaje(id) ON DELETE CASCADE
);

INSERT INTO clase (nombre) VALUES ('Guerrero'), ('Mago'), ('Arquero');

INSERT INTO personaje (nombre, clase_id, vida) VALUES ('Thor', 1, 150);
INSERT INTO personaje (nombre, clase_id, vida) VALUES ('Gandalf', 2, 100);
INSERT INTO personaje (nombre, clase_id, vida) VALUES ('Legolas', 3, 120);

INSERT INTO item (nombre, tipo, personaje_id) VALUES ('Espada Relámpago', 'Arma', 1);
INSERT INTO item (nombre, tipo, personaje_id) VALUES ('Poción de Maná', 'Consumible', 2);
INSERT INTO item (nombre, tipo, personaje_id) VALUES ('Arco Élfico', 'Arma', 3);