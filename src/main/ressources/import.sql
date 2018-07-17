--Clients
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`,`idConseiller`) VALUES ('Client', '1', '19 rue Danton, 69003, Lyon', '2018-07-10 00:00:00', 'vadcard.felix@gmail.com', 'lili','Felix', 'Vadard', '0613938746', '1589','3');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '2', '27 allee du petit bois, 06100, Cannes', '2018-07-09 00:00:00', 'gunter@mail.com', 'gunter', 'Gunter', 'Mark', '0678469587','4987', NULL, NULL, NULL,'3');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '5', '35 rue de la riviere, 12007, Tarar', '1975-03-07 00:00:00', 'angelina.jolie@gmail.com', 'angelina', 'Angelina', 'Jolie', '0645789463','5346', NULL, NULL, NULL,'3');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '6', '85 rue de la republique, 69001, Lyon', '1962-07-14 00:00:00', 'martin.patrick@mail.com', 'patrick', 'Partick', 'Martin', '0648963789','6798', NULL, NULL, NULL,'3');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '7', '107 rue servient, 69003, Lyon', '1985-01-09 00:00:00', 'poutine.vladimire@mail.com', 'vladimire', 'Vladimire', 'Poutine', '0645697832','1247', NULL, NULL, NULL,'12');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '8', '18 rue nez, 85000, Rouen', '1964-06-09 00:00:00', 'brato.aline@mail.com', 'aline', 'Aline', 'Brato', '062567896','3697', NULL, NULL, NULL,'13');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '9', '65 rue du pilat, 42000, Saint-Etienne', '1986-09-24 00:00:00', 'amin.senhaji@mail.com', 'amin', 'Amin', 'Senhaji', '0678469587','7852', NULL, NULL, NULL,'13');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '10', '164 rue de la rize, 69006, Lyon', '2018-07-09 00:00:00', 'michel.dafri@mail.com', 'michel', 'Michel', 'Dafri', '0678469587','1347', NULL, NULL, NULL,'0');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '11', '222 cours thomas, 69100, Villeurbanne', '2018-07-09 00:00:00', 'lilian.arroyo@mail.com', 'lilian', 'Lilian', 'Arroyo', '0678469587','3678', NULL, NULL, NULL,'0');
--Comptes
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('64930045', '2018-07-09 00:00:00', 'courant', '1000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('46449735', '2018-07-09 00:00:00', 'remunere', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('52729559', '2018-07-09 00:00:00', 'courant', '3000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('84947109', '2018-07-09 00:00:00', 'courant', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('32428602', '2018-07-09 00:00:00', 'courant', '3000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('69927026', '2018-07-09 00:00:00', 'courant', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('74738941', '2018-07-09 00:00:00', 'courant', '3000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('43770840', '2018-07-09 00:00:00', 'remunere', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('91978065', '2018-07-09 00:00:00', 'courant', '3000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('74060509', '2018-07-09 00:00:00', 'remunere', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('75550751', '2018-07-09 00:00:00', 'courant', '3000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('75285110', '2018-07-09 00:00:00', 'remunere', '2000');
--INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('20354140', '2018-07-09 00:00:00', 'courant', '3000');
--INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258102', '2018-07-09 00:00:00', 'remunere', '2000');
--INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('97545214', '2018-07-09 00:00:00', 'courant', '3000');
--INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('40646226', '2018-07-09 00:00:00', 'remunere', '2000');
--INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('78707935', '2018-07-09 00:00:00', 'courant', '3000');
--Table de jointure Clients->Comptes
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '64930045');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '52729559');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '46449735'), ('5', '84947109'), ('5', '32428602'), ('6', '69927026'), ('7', '74738941'), ('7', '43770840'), ('8', '91978065'), ('9', '74060509');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('1', '75550751'), ('1', '75285110');
--Operations
INSERT INTO `gestibankbd`.`operation` (`OPERATION_TYPE`, `id`, `date`, `somme`) VALUES ('DEPOT', '1', '2018-07-09 00:00:00', '200');
INSERT INTO `gestibankbd`.`operation` (`OPERATION_TYPE`, `id`, `date`, `somme`) VALUES ('RETRAIT', '2', '2018-07-09 00:00:00', '300');
--Table de jointure Comptes->Opérations
INSERT INTO `gestibankbd`.`compte_operation` (`Compte_rib`, `operations_id`) VALUES ('10258101', '1');
INSERT INTO `gestibankbd`.`compte_operation` (`Compte_rib`, `operations_id`) VALUES ('10258102', '2');
--Conseiller
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Conseiller', '13', '45 rue du Four, 69017, le Cannet', '1919-07-15 00:00:00', 'pollet.sarah@mail.com', 'Sarah', 'Pollet', 'sarah', '0609786496', NULL, '2016-05-12 00:00:00', NULL, 'C964879'); 
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Conseiller', '12', '45 rue du Four, 69017, le Cannet', '1919-07-15 00:00:00', 'jusforgues.quentin@mail.com', 'Quentin', 'Jusforgues', 'quentin', '0609786496', NULL, '2016-05-12 00:00:00', NULL, 'C875496');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Conseiller', '3', '17 rue de ma banque, 75000, Paris', '1987-07-15 00:00:00', 'conseiller@mail.com', 'Conseiller', 'Conseiller', 'Conseiller', '0654798216', NULL, '2018-05-16 00:00:00', NULL, 'C015496');
--Admin
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Admin', '4', 'le siege de la banque', '1990-03-11 00:00:00', 'admin@mail.com', 'Admin', 'Admin', 'Admin', '0615789436', NULL, '2017-12-12 00:00:00', 'Admin', '05134679');
--Table de jointure Conseillers->Clients
INSERT INTO `gestibankbd`.`user_user` (`User_id`, `clients_id`) VALUES ('3', '1'), ('3', '2'), ('3', '5'), ('3', '6'), ('12', '7'), ('13', '8'), ('13', '9')

