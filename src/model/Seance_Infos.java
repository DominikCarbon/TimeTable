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
public class Seance_Infos {
        private int ID_Groupe, ID_Seance,ID_Salle,ID_Enseignant;
    
    public Seance_Infos(int ID_Groupe)
    {
        this.ID_Groupe=ID_Groupe;
    }
    
    public Seance_Infos(int ID_Enseignant, int autre)
    {
        this.ID_Enseignant=ID_Enseignant;
    }
    
    public Seance_Infos(int ID_Seance,int ID_Groupe,int ID_Salle, int ID_Enseignant)
    {
        this.ID_Groupe=ID_Groupe;
        this.ID_Seance=ID_Seance;
        this.ID_Salle=ID_Salle;
        this.ID_Enseignant=ID_Enseignant;
    }
    
    public int getIDSeance()
    {
        return ID_Seance;
    }
    
    public int getIDGroupe()
    {
        return ID_Groupe;
    }
       public int getIDSalle()
    {
        return ID_Salle;
    }
    
    public int getIDEnseignant()
    {
        return ID_Enseignant;
    }
}
