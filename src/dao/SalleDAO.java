/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.stmt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Salle;

/**
 *
 * @author Dominik
 */
public class SalleDAO extends DAO<Salle> {

    @Override
    public boolean create(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle find(Salle obj) {
        try {
        int id=obj.getID();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`salle` WHERE (ID='"+id+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("on est dans findSalle, nb colonne="+nbColonne);

        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            int c=0, idSite=0;
            String nom = null;
            while(rset.next())
            {
                nom=rset.getString(2);
                c=rset.getInt(3);
                idSite=rset.getInt(4);
            }
            
           Salle S=new Salle(obj.getID(),c,idSite,nom);
           return S;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
   return null;
    }

}
