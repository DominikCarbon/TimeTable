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
public class Seance {
    private int ID, Horaire, Semaine, Etat, ID_Cours, ID_Type;
    private String Date;
    
    public Seance(int ID)
    {
        this.ID=ID;
    }
    
    public Seance(int ID, int Semaine, int Horaire, int Etat, int ID_Cours, int ID_Type,String Date)
    {
        this.ID=ID;
        this.Horaire=Horaire;
        this.Semaine=Semaine;
        this.Etat=Etat;
        this.ID_Cours=ID_Cours;
        this.ID_Type=ID_Type;
        this.Date=Date;
    }
    
    public Seance(){}
    
    public int getID()
    {return ID;}
    
    public int getHoraire()
    {return Horaire;}
    
    public int getSemaine()
    {return Semaine;}
    
    public int getEtat()
    {return Etat;}
    
    public int getCours()
    {return ID_Cours;}
    
    public int getType()
    {return ID_Type;}
    
    public String getDate()
    {
        return Date;
    }
}
