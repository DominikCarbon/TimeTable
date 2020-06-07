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
public class Type_Cours {
    private int ID;
    private String Nom;
    
    public Type_Cours(int ID)
    {
        this.ID=ID;
    }
    public Type_Cours(int ID, String Nom)
    {
        this.Nom=Nom;
        this.ID=ID;
    }
    
    public Type_Cours(){}
    
    public int getID()
    {return ID;}
    
    public String getNom()
    {return Nom;}
    
}
