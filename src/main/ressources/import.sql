INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`) VALUES ('Client', '1', '19 rue Danton', '2018-07-10 00:00:00', 'vadcard.felix@gmail.com', 'lili','Felix', 'Vadard', '613938746', '1589');
INSERT INTO `gestibankbd`.`user` (`USER_TYPE`, `id`, `address`, `dateOfBirth`, `email`, `password`, `firstName`, `lastName`, `phonenumber`, `numeroclient`, `contratStartingDate`, `fonction`, `matricule`) VALUES ('Client', '2', '27 allee du petit bois', '2018-07-09 00:00:00', 'gunter@mail.com', 'Gunter', 'Gunter', 'Gunter', '678469587','4987', NULL, NULL, NULL);
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258101', '2018-07-09 00:00:00', 'Bonjour je suis le compte 1', '1000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258102', '2018-07-09 00:00:00', 'Bonjour je suis le compte 2', '2000');
INSERT INTO `gestibankbd`.`compte` (`rib`, `dateCreation`, `description`, `solde`) VALUES ('10258103', '2018-07-09 00:00:00', 'Bonjour je suis le compte 3', '3000');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '10258101');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '10258102');
INSERT INTO `gestibankbd`.`user_compte` (`User_id`, `comptes_rib`) VALUES ('2', '10258103');
INSERT INTO `gestibankbd`.`operation` (`OPERATION_TYPE`, `id`, `date`, `somme`) VALUES ('DEPOT', '1', '2018-07-09 00:00:00', '200');
INSERT INTO `gestibankbd`.`operation` (`OPERATION_TYPE`, `id`, `date`, `somme`) VALUES ('RETRAIT', '2', '2018-07-09 00:00:00', '300');
INSERT INTO `gestibankbd`.`compte_operation` (`Compte_rib`, `operations_id`) VALUES ('10258101', '1');
INSERT INTO `gestibankbd`.`compte_operation` (`Compte_rib`, `operations_id`) VALUES ('10258102', '2');