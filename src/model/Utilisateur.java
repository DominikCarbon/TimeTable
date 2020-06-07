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
public class Utilisateur {
    
    protected int ID;
    protected String Email;
    protected int Passwd;
    protected String Nom;
    protected String Prenom;
    protected int Droit;
    

    public Utilisateur(){}
    
    public Utilisateur(int id,String mail, int mdp, String nom, String prenom, int droit)
    {
        ID=id;
        Email=mail;
        Passwd=mdp;
        Nom=nom;
        Prenom=prenom;
        Droit=droit;
    }
    
    public Utilisateur(String mail, int mdp)
    {
        Email=mail;
        Passwd=mdp;
    }  
 
    public Utilisateur(int ID, String Nom)
    {
       this.ID=ID;
       this.Nom=Nom;
    } 


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