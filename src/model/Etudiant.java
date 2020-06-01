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
public class Etudiant extends Utilisateur{
    
    private int ID_Utilisateur;
    //private int ID_Groupe;
    private int Numero;
  
    
    public Etudiant(int ID_Utilisateur,int Numero)
    {
     super();
     
     this.ID_Utilisateur=ID_Utilisateur;
    
     this.Numero=Numero;
     }

    public Etudiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getID_Utilisateur()
    {return ID_Utilisateur;}
    
    public void setID_Utilisateur(int ID_Utilisateur)
    {this.ID_Utilisateur=ID_Utilisateur;}
    
    public int getNumero()
    {return Numero;}
    
    public void setNumero(int Numero)
    {this.Numero=Numero;}

 
}
