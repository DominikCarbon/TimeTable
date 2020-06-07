/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import dao.DAO;
import dao.Connexion;
import dao.EtudiantDAO;
import dao.UtilisateurDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Etudiant;
import model.Utilisateur;
import view.FirstPage;
import view.LoginPage;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.ReferentInterface;

/**
 *
 * @author PC fixeas
 */
public class Controleur {
    
    
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
         
         
    /*String rq=("INSERT INTO `projet_java`.`cours` (`Nom`) VALUES ('NouveauCours')");
    //bdd.ajouterRequete(rq);
    String rq2=("INSERT INTO `projet_java`.`cours` (`Nom`) VALUES ('EncoreUnCours')");
    //bdd.ajouterRequete(rq2);
    bdd.executeUpdate(rq);
    bdd.executeUpdate(rq2);
  */
      new FirstPage().setVisible(true);
    
  
}
    
}
