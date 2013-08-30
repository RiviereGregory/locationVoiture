DROP DATABASE IF EXISTS locationvoiture;
CREATE DATABASE locationvoiture;
USE locationvoiture;

CREATE TABLE VOITURE (id_voiture INTEGER NOT NULL AUTO_INCREMENT, marque_voiture VARCHAR(255),modele_voiture VARCHAR(255) , dateMiseEnCirculation DATE,PRIMARY KEY (id_voiture));
CREATE TABLE Client(id INTEGER NOT NULL AUTO_INCREMENT, nom VARCHAR(255), prenom VARCHAR(255), mail VARCHAR(255),PRIMARY KEY (id));
CREATE TABLE Reservation(id INTEGER NOT NULL AUTO_INCREMENT, datePriseVehicule DATE,dateRetour DATE, client_id INTEGER, voiture_id_voiture INTEGER, dateReservation DATE, PRIMARY KEY (id));

ALTER TABLE Reservation ADD CONSTRAINT fk_Reservation_Client_id FOREIGN KEY (client_id) REFERENCES Client (id);
ALTER TABLE Reservation ADD CONSTRAINT fk_Reservation_VOITURE_id FOREIGN KEY (voiture_id_voiture) REFERENCES VOITURE (id_voiture);


CREATE TABLE users (nom VARCHAR(255) NOT NULL , password VARCHAR(255),enabled BOOLEAN ,PRIMARY KEY (nom));
CREATE TABLE roles (nom VARCHAR(255) NOT NULL , role VARCHAR(255),PRIMARY KEY (nom,role));
ALTER TABLE roles ADD CONSTRAINT fk_roles_user_nom FOREIGN KEY (nom) REFERENCES users (nom);

INSERT INTO users (nom , password,enabled) VALUES ('user','user',true),('admin','admin',true);
INSERT INTO roles (nom , role) VALUES ('user','ROLE_USER'),('admin','ROLE_USER'),('admin','ROLE_ADMIN');