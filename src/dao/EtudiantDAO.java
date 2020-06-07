/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Etudiant;


/**
 *
 * @aobjhor PC fixe
 */
public class EtudiantDAO extends DAO<Etudiant>  {
  

     @Override
  public boolean create(Etudiant obj) {
    return false;
  }

     @Override
  public boolean delete(Etudiant obj) {
    return false;
  }
   
     @Override
  public boolean update(Etudiant obj) {
    return false;
  }
   
     @Override
  public Etudiant find(Etudiant obj) {
    try {
        int id=obj.getID();
        int p=obj.getPasswd();
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`etudiant` WHERE (ID_Utilisateur='"+id+"')");
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
            int idG=0;
            int num = 0;
            while(rset.next())
            {
                num=rset.getInt(2);
                idG=rset.getInt(3);
            }
            
            Etudiant E=new Etudiant(obj.getID(),obj.getEmail(),obj.getPasswd(),obj.getNom(),obj.getPrenom(),obj.getDroit(),num,idG);
            return E;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
   return null;
  }}
