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
public class Salle {
    private int ID, Capacite, ID_Site;
    private String Nom;
    
    public Salle(){}
    
    public Salle(int ID,int Capacite,int ID_Site,String Nom )
    {
        this.ID=ID;
        this.Capacite=Capacite;
        this.ID_Site=ID_Site;
        this.Nom=Nom;
    }
        public Salle(int ID)
    {
        this.ID=ID;
    }
        
        public int getID()
        {
            return ID;
        }
        
        public int getCapacite()
        {
            return Capacite;
        }
        
    public int getSite()
    {
        return ID_Site;
    }
    
    public String getNom()
    {
        return Nom;
    }
}
