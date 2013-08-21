DROP DATABASE IF EXISTS locationvoiture;
CREATE DATABASE locationvoiture;
USE locationvoiture;

CREATE TABLE VOITURE (id_voiture INTEGER NOT NULL AUTO_INCREMENT, marque_voiture VARCHAR(255),modele_voiture VARCHAR(255) ,PRIMARY KEY (id_voiture));
