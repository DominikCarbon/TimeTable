<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author Dominik
 */

public class Enseignant extends Utilisateur{
  //ID
  private int IDE = 0;
  private int IDCours=0;

  public Enseignant(int ID, String Email, int Passwd, String Nom, String Prenom, int Droit,int IDE, int IDCours) {
    super(ID, Email, Passwd, Nom, Prenom, Droit);
    this.IDCours = IDCours;
    this.IDE = IDE;
  }
  
    public Enseignant(int ID, String Email, int Passwd, String Nom, String Prenom, int Droit) {
    super(ID, Email, Passwd, Nom, Prenom, Droit);
  }
    
    public Enseignant(int IDCours) {
        this.IDCours=IDCours;
  } 
  
  public Enseignant(){}

  public int getEnseignant() {
    return IDE;
  }

  public int getCours() {
    return IDCours;
  }
}
    

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author PC fixe
 */


public class Enseignant {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";
  //Prénom du professeur
  private String prenom = "";
  //Liste des matières dispensées
  private Set<Cours> listMatiere = new HashSet<>();

  public Enseignant(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  public Enseignant(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Set<Cours> getListMatiere() {
    return listMatiere;
  }

  public void setListMatiere(Set<Cours> listMatiere) {
    this.listMatiere = listMatiere;
  }

  //Ajoute une matière à un professeur
  public void addMatiere(Cours matiere){
    this.listMatiere.add(matiere);
  }

  //Retire une matière à un professeur
  public void removeMatiere(Cours matiere){
    this.listMatiere.remove(matiere);
  }
}
    

>>>>>>> master
