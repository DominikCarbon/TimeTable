/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.stmt;
import java.sql.SQLException;
import model.Seance_Groupe;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Etudiant;

/**
 *
 * @author Dominik
 */
public class Seance_GroupeDAO extends DAO<Seance_Groupe>{

    @Override
    public boolean create(Seance_Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance_Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance_Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Groupe find(Seance_Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Seance_Groupe> trouver(Seance_Groupe obj) 
    {
        if(obj==null)
    {
        System.out.println("nuuuuul");
    }
    else
    {
    try {
        int idG=obj.getIDGroupe();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`Seance_Groupe` WHERE (ID_Groupe='"+idG+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("on est dans find, nb colonne="+nbColonne);

        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            int idS;
            ArrayList<Seance_Groupe> A=new ArrayList<>();
            while(rset.next())
            {
                idS=rset.getInt(1);
                Seance_Groupe S=new Seance_Groupe(obj.getIDGroupe(),idS);
                A.add(S);
            }
            return A;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    return null;
    }
}
