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
    

