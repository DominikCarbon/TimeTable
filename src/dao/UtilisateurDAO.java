/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Utilisateur;

/**
 *
 * @author PC fixe
 */
public class UtilisateurDAO extends DAO<Utilisateur> {


@Override
public boolean create(Utilisateur obj) {
    return false;
}

@Override
public boolean delete(Utilisateur obj) {
    return false;
}
   
@Override
public boolean update(Utilisateur obj) {
    return false;}

@Override
public Utilisateur find(Utilisateur ut)
{
    Connection conn;
    if(ut==null)
    {
        System.out.println("nuuuuul");
    }
    else
    {
    try {
        String m=ut.getEmail();
        int p=ut.getPasswd();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`utilisateur` WHERE (Email='"+m+"') AND (Passwd='"+p+"')");
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
            int id = 0,mdp = 0,droit = 0;
            String mail = null,nom = null,prenom = null;
            while(rset.next())
            {
                id=rset.getInt(1);
                mail=rset.getString(2);
                mdp=rset.getInt(3);
                nom=rset.getString(4);
                prenom=rset.getString(5);
                droit=rset.getInt(6);
            }
            
            Utilisateur uti=new Utilisateur(id,mail,mdp,nom,prenom,droit);
            return uti;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    return null;
}}
    

