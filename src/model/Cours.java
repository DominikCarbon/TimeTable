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
public class Cours {
    private int ID;
    private String Nom;
    
    public Cours(int id)
    {
        ID=id;
    }
    
    public Cours(int id, String nom)
    {
        ID=id;
        Nom=nom;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public String getNom()
    {
        return Nom;
    }
}
