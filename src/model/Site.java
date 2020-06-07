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
public class Site {
    private int ID;
    private String Nom;
    
    public Site(){}
    
    public Site(int ID, String Nom)
    {
        this.ID=ID;
        this.Nom=Nom;
    }
    public Site(int ID)
    {
        this.ID=ID;
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
