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
import model.Site;

/**
 *
 * @author Dominik
 */
public class SiteDAO extends DAO<Site>{

    @Override
    public boolean create(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Site obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Site find(Site obj) {
          try {
        int id=obj.getID();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`site` WHERE (ID='"+id+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("on est dans findSite, nb colonne="+nbColonne);

        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            String nom = null;
            while(rset.next())
            {
                nom=rset.getString(2);
            }
            
           Site S=new Site(obj.getID(),nom);
           return S;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
   return null;
    }
    
}
