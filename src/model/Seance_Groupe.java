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
public class Seance_Groupe {
    private int ID_Groupe, ID_Seance;
    
    public Seance_Groupe(int idG)
    {
        ID_Groupe=idG;
    }
    
    public Seance_Groupe(int idG, int idS)
    {
        ID_Groupe=idG;
        ID_Seance=idS;
    }
    
    public int getIDSeance()
    {
        return ID_Seance;
    }
    
    public int getIDGroupe()
    {
        return ID_Groupe;
    }
    
}
