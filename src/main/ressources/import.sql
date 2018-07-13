--Clients
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`,`idConseiller`) VALUES ('Client', '1', '19 rue Danton', '2018-07-10 00:00:00', 'vadcard.felix@gmail.com', 'lili','Felix', 'Vadard', '613938746', '1589','0');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`,`idConseiller`) VALUES ('Client', '2', '27 allee du petit bois', '2018-07-09 00:00:00', 'gunter@mail.com', 'Gunter', 'Gunter', 'Gunter', '678469587','4987', NULL, NULL, NULL,'0');
--Comptes
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258101', '2018-07-09 00:00:00', 'Bonjour je suis le compte 1', '1000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258102', '2018-07-09 00:00:00', 'Bonjour je suis le compte 2', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258103', '2018-07-09 00:00:00', 'Bonjour je suis le compte 3', '3000');
--Table de jointure Clients->Comptes
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '10258101');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '10258102');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '10258103');
--Operations
INSERT INTO `gestibankbd`.`operation` (`OPERATION_TYPE`, `id`, `date`, `somme`) VALUES ('DEPOT', '1', '2018-07-09 00:00:00', '200');
INSERT INTO `gestibankbd`.`operation` (`OPERATION_TYPE`, `id`, `date`, `somme`) VALUES ('RETRAIT', '2', '2018-07-09 00:00:00', '300');
--Table de jointure Comptes->Opérations
INSERT INTO `gestibankbd`.`compte_operation` (`Compte_rib`, `operations_id`) VALUES ('10258101', '1');
INSERT INTO `gestibankbd`.`compte_operation` (`Compte_rib`, `operations_id`) VALUES ('10258102', '2');
--Conseiller
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Conseiller', '3', 'la banque', '2015-07-15 00:00:00', 'conseiller@mail.com', 'Conseiller', 'Conseiller', 'Conseiller', '0654798216', NULL, '2018-05-16 00:00:00', NULL, '06015496');
--Admin
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Admin', '4', 'le siege de la banque', '1990-03-11 00:00:00', 'admin@mail.com', 'Admin', 'Admin', 'Admin', '0615789436', NULL, '2017-12-12 00:00:00', 'Admin', '05134679');
--Table de jointure Conseillers->Clients
INSERT INTO `gestibankbd`.`user_user` (`User_id`, `clients_id`) VALUES ('3', '1'), ('3', '2')

