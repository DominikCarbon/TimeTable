/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC fixe
 */
public class Utilisateur {
    
    protected int ID;
    protected String Email;
    protected int Passwd;
    protected String Nom;
    protected String Prenom;
    protected int Droit;
    
    public Utilisateur()
    {}  


 public int getID() {
    return ID;
  }

  public void setId(int ID) {
    this.ID = ID;
  }
  
  public String getEmail()
  {return Email;}

  public void setEmail()
  {this.Email=Email;}
  
  public int getPasswd()
  {return Passwd;}
  
  public void setPasswd()
  {this.Passwd=Passwd;}
  
  public String getNom() {
    return Nom;
  }

  public void setNom(String Nom) {
    this.Nom = Nom;
  }

  public String getPrenom() {
    return Prenom;
  }

  public void setPrenom(String Prenom) {
    this.Prenom = Prenom;
  }   
  
  public int getDroit()
  {return Droit;}
  
  public void setDroit()
  {this.Droit=Droit;}
  
}