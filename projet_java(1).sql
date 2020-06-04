
-- phpMyAdmin SQL Dump

-- version 4.9.2

-- https://www.phpmyadmin.net/

--

-- Hôte : 127.0.0.1:3308

-- Généré le :  lun. 18 mai 2020 à 13:06

-- Version du serveur :  8.0.18

-- Version de PHP :  7.3.12

 

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

SET AUTOCOMMIT = 0;

START TRANSACTION;

SET time_zone = "+00:00";

 

 

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

/*!40101 SET NAMES utf8 */;

 

--

-- Base de données :  `projet java`

--

 

-- --------------------------------------------------------

 

--

-- Structure de la table `cours`

--

 

DROP TABLE IF EXISTS `cours`;

CREATE TABLE IF NOT EXISTS `cours` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Nom` varchar(255) NOT NULL,

  PRIMARY KEY (`ID`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `cours`

--

 

INSERT INTO `cours` (`Nom`) VALUES

('Analyse'),

('Thermodynamique');

 

-- --------------------------------------------------------

 

--

-- Structure de la table `enseignant`

--

 

DROP TABLE IF EXISTS `enseignant`;

CREATE TABLE IF NOT EXISTS `enseignant` (

  `ID_Utilisateur` int(10) NOT NULL,

  `ID_Cours` int(10) NOT NULL,

  PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),

  KEY `ID_Utilisateur` (`ID_Utilisateur`),

  KEY `ID_Cours` (`ID_Cours`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `enseignant`

--

 

INSERT INTO `enseignant` (`ID_Utilisateur`, `ID_Cours`) VALUES

(2, 1);

 

-- --------------------------------------------------------

 

--

-- Structure de la table `etudiant`

--

 

DROP TABLE IF EXISTS `etudiant`;

CREATE TABLE IF NOT EXISTS `etudiant` (

  `ID_Utilisateur` int(10) NOT NULL,

  `Numero` int(10) NOT NULL,

  `ID_Groupe` int(10) NOT NULL,

  PRIMARY KEY (`ID_Utilisateur`),

  KEY `ID_Utilisateur` (`ID_Utilisateur`),

  KEY `ID_Groupe` (`ID_Groupe`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `etudiant`

--

 

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES

(1, 1999, 1);

 

-- --------------------------------------------------------

 

--

-- Structure de la table `groupe`

--

 

DROP TABLE IF EXISTS `groupe`;

CREATE TABLE IF NOT EXISTS `groupe` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Nom` varchar(255) NOT NULL,

  `ID_Promotion` int(10) NOT NULL,

  PRIMARY KEY (`ID`),

  KEY `ID_Promotion` (`ID_Promotion`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `groupe`

--

 

INSERT INTO `groupe` (`Nom`, `ID_Promotion`) VALUES

('Demi Groupe Promo 2022', 1);

 

-- --------------------------------------------------------

 

--

-- Structure de la table `promotion`

--

 

DROP TABLE IF EXISTS `promotion`;

CREATE TABLE IF NOT EXISTS `promotion` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Nom` varchar(255) NOT NULL,

  PRIMARY KEY (`ID`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `promotion`

--

 

INSERT INTO `promotion` (`Nom`) VALUES

('Promo 2022');

 

-- --------------------------------------------------------

 

--

-- Structure de la table `salle`

--

 

DROP TABLE IF EXISTS `salle`;

CREATE TABLE IF NOT EXISTS `salle` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Nom` varchar(255) NOT NULL,

  `Capacite` int(10) NOT NULL,

  `ID_Site` int(10) NOT NULL,

  PRIMARY KEY (`ID`),

  KEY `ID_Site` (`ID_Site`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `salle`

--

 

INSERT INTO `salle` (`Nom`, `Capacite`, `ID_Site`) VALUES

('Salle 01', 100, 1),

('Salle 02', 35, 2);

 

-- --------------------------------------------------------

 

--

-- Structure de la table `seance`

--

 

DROP TABLE IF EXISTS `seance`;

CREATE TABLE IF NOT EXISTS `seance` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Semaine` int(10) NOT NULL,

  `Date` date NOT NULL,

  `Heure_Debut` time NOT NULL,

  `Heure_Fin` time NOT NULL,

  `Etat` int(10) NOT NULL,

  `ID_Cours` int(10) NOT NULL,

  `ID_Type` int(10) NOT NULL,

  PRIMARY KEY (`ID`),

  KEY `ID_Cours` (`ID_Cours`),

  KEY `ID_Type` (`ID_Type`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `seance`

--

 

INSERT INTO `seance` (`Semaine`, `Date`, `Heure_Debut`, `Heure_Fin`, `Etat`, `ID_Cours`, `ID_Type`) VALUES

(1, '2020-05-18', '17:00:00', '18:00:00', 0, 1, 1);

 

-- --------------------------------------------------------

 

--

-- Structure de la table `seance_enseignants`

--

 

DROP TABLE IF EXISTS `seance_enseignants`;

CREATE TABLE IF NOT EXISTS `seance_enseignants` (

  `ID_Seance` int(10) NOT NULL,

  `ID_Enseignant` int(10) NOT NULL,

  PRIMARY KEY (`ID_Seance`,`ID_Enseignant`),

  KEY `ID_Seance` (`ID_Seance`),

  KEY `ID_Enseignant` (`ID_Enseignant`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

-- --------------------------------------------------------

 

--

-- Structure de la table `seance_groupe`

--

 

DROP TABLE IF EXISTS `seance_groupe`;

CREATE TABLE IF NOT EXISTS `seance_groupe` (

  `ID_Seance` int(10) NOT NULL,

  `ID_Groupe` int(10) NOT NULL,

  PRIMARY KEY (`ID_Seance`,`ID_Groupe`),

  KEY `ID_Seance` (`ID_Seance`),

  KEY `ID_Groupe` (`ID_Groupe`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

-- --------------------------------------------------------

 

--

-- Structure de la table `seance_salles`

--

 

DROP TABLE IF EXISTS `seance_salles`;

CREATE TABLE IF NOT EXISTS `seance_salles` (

  `ID_Seance` int(10) NOT NULL,

  `ID_Salle` int(10) NOT NULL,

  PRIMARY KEY (`ID_Seance`,`ID_Salle`),

  KEY `ID_Seance` (`ID_Seance`),

  KEY `ID_Salle` (`ID_Salle`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

-- --------------------------------------------------------

 

--

-- Structure de la table `site`

--

 

DROP TABLE IF EXISTS `site`;

CREATE TABLE IF NOT EXISTS `site` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Nom` varchar(255) NOT NULL,

  PRIMARY KEY (`ID`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `site`

--

 

INSERT INTO `site` (`Nom`) VALUES

('Eiffel 1'),

('Eiffel 2');

 

-- --------------------------------------------------------

 

--

-- Structure de la table `type_cours`

--

 

DROP TABLE IF EXISTS `type_cours`;

CREATE TABLE IF NOT EXISTS `type_cours` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Nom` varchar(255) NOT NULL,

  PRIMARY KEY (`ID`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `type_cours`

--

 

INSERT INTO `type_cours` (`Nom`) VALUES

('Magistral'),

('TD');

 

-- --------------------------------------------------------

 

--

-- Structure de la table `utilisateur`

--

 

DROP TABLE IF EXISTS `utilisateur`;

CREATE TABLE IF NOT EXISTS `utilisateur` (

  `ID` int(10) NOT NULL AUTO_INCREMENT,

  `Email` varchar(255) NOT NULL,

  `Passwd` varchar(255) NOT NULL,

  `Nom` varchar(255) NOT NULL,

  `Prenom` varchar(255) NOT NULL,

  `Droit` int(4) NOT NULL,

  PRIMARY KEY (`ID`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

 

--

-- Déchargement des données de la table `utilisateur`

--

 

INSERT INTO `utilisateur` (`Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES

('tescelin.hanoteaux@edu.ece.fr', '1234', 'Hanoteaux', 'Tescelin', 4),

('coudray@edu.ece.fr', '1234', 'Coudray', 'Fabienne', 3),

('admin@edu.ece.fr', '1234', 'Admin', 'Admin', 1),

('referent@edu.ece.fr', '1234', 'Referent', 'Referent', 2);

 

--

-- Contraintes pour les tables déchargées

--

 

--

-- Contraintes pour la table `enseignant`

--

ALTER TABLE `enseignant`

  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,

  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `etudiant`

--

ALTER TABLE `etudiant`

  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,

  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `groupe`

--

ALTER TABLE `groupe`

  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`ID_Promotion`) REFERENCES `promotion` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `salle`

--

ALTER TABLE `salle`

  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`ID_Site`) REFERENCES `site` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `seance`

--

ALTER TABLE `seance`

  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,

  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_Type`) REFERENCES `type_cours` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `seance_enseignants`

--

ALTER TABLE `seance_enseignants`

  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`ID_Enseignant`) REFERENCES `enseignant` (`ID_Utilisateur`) ON DELETE RESTRICT ON UPDATE RESTRICT,

  ADD CONSTRAINT `seance_enseignants_ibfk_2` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `seance_groupe`

--

ALTER TABLE `seance_groupe`

  ADD CONSTRAINT `seance_groupe_ibfk_1` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,

  ADD CONSTRAINT `seance_groupe_ibfk_2` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

 

--

-- Contraintes pour la table `seance_salles`

--

ALTER TABLE `seance_salles`

  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`ID_Salle`) REFERENCES `salle` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,

  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

COMMIT;

 

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;