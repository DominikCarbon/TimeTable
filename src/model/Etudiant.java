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
public class Etudiant extends Utilisateur{


    private int ID_Groupe;
    private int Numero;


    public Etudiant(int ID, String Email, int Passwd, String Nom, String Prenom, int Droit,int Numero,int idGroupe) 
    {
        super(ID, Email, Passwd, Nom, Prenom, Droit);
        this.ID_Groupe=idGroupe;
        this.Numero=Numero;
    }
        public Etudiant(int ID, String Email, int Passwd, String Nom, String Prenom, int Droit) 
    {
        super(ID, Email, Passwd, Nom, Prenom, Droit);
    }
 
    
    public int getNumero()
    {return Numero;}
    
    public int getGroupe()
    {return ID_Groupe;}
    
    public void setNumero(int Numero)
    {this.Numero=Numero;}
    
    
}
 





=======
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


    private int ID_Groupe;
    private int Numero;


    public Etudiant(int ID, String Email, int Passwd, String Nom, String Prenom, int Droit,int Numero,int idGroupe) 
    {
        super(ID, Email, Passwd, Nom, Prenom, Droit);
        this.ID_Groupe=idGroupe;
        this.Numero=Numero;
    }
        public Etudiant(int ID, String Email, int Passwd, String Nom, String Prenom, int Droit) 
    {
        super(ID, Email, Passwd, Nom, Prenom, Droit);
    }
 
    
    public int getNumero()
    {return Numero;}
    
    public int getGroupe()
    {return ID_Groupe;}
    
    public void setNumero(int Numero)
    {this.Numero=Numero;}
    
    
}
 





>>>>>>> master
