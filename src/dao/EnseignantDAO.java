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
import model.Enseignant;
import model.Utilisateur;

/**
 *
 * @author PC fixe
 */
public class EnseignantDAO extends DAO<Enseignant>{
  



  @Override
  public boolean create(Enseignant obj) {
    return false;
  }

  @Override
  public boolean delete(Enseignant obj) {
    return false;
  }

  @Override
  public boolean update(Enseignant obj) {
    return false;
  }
   
  @Override
  public Enseignant find(Enseignant obj) {
    try {
        int id=obj.getID();
        int p=obj.getPasswd();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`enseignant` WHERE (ID_Utilisateur='"+id+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("on est dans findEnseignant, nb colonne="+nbColonne);

        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            int idC = 0;
            while(rset.next())
            {
                idC=rset.getInt(2);
            }
            Enseignant E;
            E = new Enseignant(obj.getID(),obj.getEmail(),obj.getPasswd(),obj.getNom(),obj.getPrenom(),obj.getDroit(),obj.getID(),idC);
            return E;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
      public Enseignant findEn(Enseignant obj)
      {
        try {
        int id=obj.getCours();
        int p=obj.getPasswd();
        Enseignant uti=new Enseignant();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`enseignant` WHERE (ID_Cours='"+id+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        if(nbColonne==0)
        {
            return null;   
        }
        else
        {
            int idU = 0;
            while(rset.next())
            {
                idU=rset.getInt(1);
            }
            stmt=this.co.createStatement();
        
            rset = stmt.executeQuery("SELECT * FROM `projet_java`.`utilisateur` WHERE (ID='"+idU+"')");
            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();
            
            int nbResult=rsetMeta.getColumnCount();
            if(nbResult==0)
            {}
            else
            {
            int iD,mdp = 0,droit = 0;
            String mail = null,nom = null,prenom = null;
            while(rset.next())
            {
                iD=rset.getInt(1);
                mail=rset.getString(2);
                mdp=rset.getInt(3);
                nom=rset.getString(4);
                prenom=rset.getString(5);
                droit=rset.getInt(6);
            }
            uti=new Enseignant(id,mail,mdp,nom,prenom,droit);
            }
           return uti; 
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Enseignant;

/**
 *
 * @author PC fixe
 */
public class EnseignantDAO extends DAO<Enseignant>{
  



  @Override
  public boolean create(Enseignant obj) {
    return false;
  }

  @Override
  public boolean delete(Enseignant obj) {
    return false;
  }

  @Override
  public boolean update(Enseignant obj) {
    return false;
  }
   
  @Override
  public Enseignant find(Enseignant obj) {
      return null;
  }

 
  public boolean update() {
    return false;
  }

    
}
>>>>>>> master
