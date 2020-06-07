<<<<<<< HEAD
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

import model.Seance;

/**
 *
 * @author Dominik
 */
public class SeanceDAO extends DAO<Seance> {

    @Override
    public boolean create(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(Seance obj) {
        int id=obj.getID();
        
        //System.out.println("L'id dans l'objet Seance envoyé est : "+id);
        try {
            stmt=this.co.createStatement();

            rset = stmt.executeQuery("SELECT * FROM `projet_java`.`seance` WHERE (ID='"+id+"')");
            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();
            //System.out.println("on est dans find, nb colonne="+nbColonne);

            if(nbColonne==0)
            {
                return null;
            }
            else
            {    
                int idS = 0, h = 0, s = 0, c = 0, t = 0, e = 0;
                String d = null;
                while(rset.next())
                {
                    idS=rset.getInt(1);
                    s=rset.getInt(2);
                    d=rset.getString(3);
                    h=rset.getInt(4);
                    e=rset.getInt(5);
                    c=rset.getInt(6);
                    t=rset.getInt(7);
                }
                Seance Se=new Seance(idS,s,h,e,c,t,d);
                return Se;
            }
        } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static dao.DAO.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Seance;
import model.Seance_Groupe;

/**
 *
 * @author Dominik
 */
public class SeanceDAO extends DAO<Seance> {

    @Override
    public boolean create(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(Seance obj) {
        int id=obj.getID();
        
        //System.out.println("L'id dans l'objet Seance envoyé est : "+id);
        try {
            stmt=this.co.createStatement();

            rset = stmt.executeQuery("SELECT * FROM `projet_java`.`seance` WHERE (ID='"+id+"')");
            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();
            //System.out.println("on est dans find, nb colonne="+nbColonne);

            if(nbColonne==0)
            {
                return null;
            }
            else
            {    
                int idS = 0, h = 0, s = 0, c = 0, t = 0, e = 0;
                String d = null;
                while(rset.next())
                {
                    idS=rset.getInt(1);
                    s=rset.getInt(2);
                    d=rset.getString(3);
                    h=rset.getInt(4);
                    e=rset.getInt(5);
                    c=rset.getInt(6);
                    t=rset.getInt(7);
                }
                Seance Se=new Seance(idS,s,h,e,c,t,d);
                return Se;
            }
        } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Seance find(Seance obj, int semaine) {
        int id=obj.getID();
        //int s=obj.getSemaine();
        
        //System.out.println("L'id dans l'objet Seance envoyé est : "+id);
        try {
            stmt=this.co.createStatement();

            rset = stmt.executeQuery("SELECT * FROM `projet_java`.`seance` WHERE (ID='"+id+"') AND (Semaine='"+semaine+"')");
            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();
            //System.out.println("on est dans find, nb colonne="+nbColonne);

            if(nbColonne==0)
            {
                return null;
            }
            else
            {    
                int idS = 0, h = 0, s = 0, c = 0, t = 0, e = 0;
                String d = null;
                while(rset.next())
                {
                    idS=rset.getInt(1);
                    s=rset.getInt(2);
                    d=rset.getString(3);
                    h=rset.getInt(4);
                    e=rset.getInt(5);
                    c=rset.getInt(6);
                    t=rset.getInt(7);
                }
                Seance Se=new Seance(idS,s,h,e,c,t,d);
                return Se;
            }
        } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        
}
>>>>>>> master
