/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.stmt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seance_Infos;

/**
 *
 * @author Dominik
 */
public class Seance_InfosDAO extends DAO<Seance_Infos>{

    @Override
    public boolean create(Seance_Infos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance_Infos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance_Infos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Infos find(Seance_Infos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Seance_Infos> trouverEtudiant(Seance_Infos obj) throws SQLException 
    {
        //// ARRAYLIST QUI VA STOCKER TOUTES LES INFOSSEANCES ASSOCIES AUX SEANCES TROUVEES
        ArrayList<Seance_Infos> A=new ArrayList<>();
        try {
            int idG=obj.getIDGroupe();
        stmt=this.co.createStatement();
        rset = stmt.executeQuery("SELECT SG.ID_Seance,ID_Groupe,ID_Salle,ID_Enseignant FROM `Seance_Groupe` SG, `Seance_Salles` SS, `Seance_Enseignants` SE WHERE SG.ID_Seance=SE.ID_Seance AND SG.ID_Seance=SS.ID_Seance AND SG.ID_Groupe='"+idG+"'");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        int nbColonne = rsetMeta.getColumnCount();
        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            int idS,idSalle,idE,idGr;
            while(rset.next())
            {
                idS=rset.getInt(1);
                idGr=rset.getInt(2);
                idSalle=rset.getInt(3);
                idE=rset.getInt(4);
                Seance_Infos S=new Seance_Infos(idS,idGr,idSalle,idE);
                A.add(S);
            }
            return A;
        }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
    public ArrayList<Seance_Infos> trouverEnseignant(Seance_Infos obj)
       {
//// ARRAYLIST QUI VA STOCKER TOUTES LES INFOSSEANCES ASSOCIES AUX SEANCES TROUVEES
        ArrayList<Seance_Infos> A=new ArrayList<>();
        try {
        int idG=obj.getIDEnseignant();
        stmt=this.co.createStatement();
        rset = stmt.executeQuery("SELECT SG.ID_Seance,ID_Groupe,ID_Salle,ID_Enseignant FROM `Seance_Groupe` SG, `Seance_Salles` SS, `Seance_Enseignants` SE WHERE SG.ID_Seance=SE.ID_Seance AND SG.ID_Seance=SS.ID_Seance AND SE.ID_Enseignant='"+idG+"'");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        int nbColonne = rsetMeta.getColumnCount();
        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            int idS,idSalle,idE,idGr;
            while(rset.next())
            {
                idS=rset.getInt(1);
                idGr=rset.getInt(2);
                idSalle=rset.getInt(3);
                idE=rset.getInt(4);
                Seance_Infos S=new Seance_Infos(idS,idGr,idSalle,idE);
                A.add(S);
            }
            return A;
        }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
       }
}
