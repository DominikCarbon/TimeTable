/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
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

public void deleteS (int id) throws SQLException{

    stmt=this.co.createStatement();
    stmt.executeUpdate ("DELETE FROM seance WHERE (`ID`='"+id+"')" );
    stmt=this.co.createStatement();
    stmt.executeUpdate ("DELETE FROM seance_groupe WHERE (`ID_Seance`='"+id+"')" );
    stmt=this.co.createStatement();
    stmt.executeUpdate ("DELETE FROM seance_salles WHERE (`ID_Seance`='"+id+"')" );
    stmt=this.co.createStatement();
    stmt.executeUpdate ("DELETE FROM seance_enseignant WHERE (`ID`='"+id+"')" );
  }
   
   
  public void modif_nom_cours (int id, String nom) throws SQLException{
      
    stmt=this.co.createStatement();
    stmt.executeUpdate ("UPDATE cours SET Nom = '"+nom+"' WHERE(ID='"+id+"')" );
 
  }
  
  public void annuler_seance (int id) throws SQLException{
      
    stmt=this.co.createStatement();
    stmt.executeUpdate ("UPDATE seance SET Etat='"+3+"' WHERE(ID='"+id+"')" );
 
  }
  
  public void valider_seance (int id) throws SQLException{
      
    stmt=this.co.createStatement();
    stmt.executeUpdate ("UPDATE seance SET Etat= '"+1+"' WHERE(ID='"+id+"')" );
 
  }
  
   public void modif_horaire_seance (int id, int nvl_plage) throws SQLException{
      
    stmt=this.co.createStatement();
    stmt.executeUpdate ("UPDATE seance SET Plage_horaire= '"+nvl_plage+"' WHERE(ID='"+id+"')" );
 
  }
   
   public void ajout_seance (int id, int nvl_plage) throws SQLException{
      
    stmt=this.co.createStatement();
    stmt.executeUpdate ("UPDATE seance SET Plage_horaire= '"+nvl_plage+"' WHERE(ID='"+id+"')" );
 
  }
  
public void affectation_enseignant (int id_seance, int id_enseignant, String date) throws SQLException{
      
    stmt=this.co.createStatement();
    
    rset = stmt.executeQuery("SELECT ID_Seance FROM `seance_enseignants` WHERE (ID_Enseignants='"+id_enseignant+"')");
    rsetMeta = rset.getMetaData();
    int id_s = rset.getInt(1);
    
    rset = stmt.executeQuery  ("SELECT Date AND Horaire FROM `seance` WHERE (ID='"+id_seance+"')");
    int date_voulue = rset.getInt(1);
    int horaire_voulue = rset.getInt(2);
    
    rset = stmt.executeQuery("SELECT Date AND Horaire FROM `seance` WHERE (ID_Enseignants='"+id_s+"')");
    int date_prof = rset.getInt(1);
    int horaire_prof = rset.getInt(2);
    
    if ( (date_voulue==date_prof) && (horaire_voulue==horaire_prof) ){
        
         System.out.println("Le prof n' est pas disponible à ce moment là.");
        
    }
    else{
        
        stmt=this.co.createStatement();
        stmt.executeUpdate ("UPDATE `seance_enseignants` SET `ID_Enseignants`='"+id_enseignant+"' WHERE (ID_Seance='"+id_seance+"')");
        
    }        
  }

   
@Override
public boolean update(Utilisateur obj) {
    return false;}
@Override
public Utilisateur find(Utilisateur ut)
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
    return null;
}
public Utilisateur find(int id, String Nom)
{
    
    
    try {
       
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`utilisateur` WHERE (ID='"+id+"') AND (Nom='"+Nom+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("on est dans findUtilisateur!, nb colonne="+nbColonne);

        if(nbColonne==0)
        {
            return null;   
        }
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
            
            Utilisateur uti=new Utilisateur(id,mail,mdp,nom,prenom,droit);
            return uti;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }   
    return null;
}

public Utilisateur find(int id)
{
    
    
    try {
       
        stmt=this.co.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM `projet_java`.`utilisateur` WHERE (ID='"+id+"')");
        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        System.out.println("on est dans findUtilisateur!, nb colonne="+nbColonne);

        if(nbColonne==0)
        {
            return null;   
        }
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
            
            Utilisateur uti=new Utilisateur(id,mail,mdp,nom,prenom,droit);
            return uti;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
    }   
    return null;
}

public ArrayList<String> findu(int Droit)
{ArrayList<String> L= new ArrayList<>();


try {

stmt=this.co.createStatement();

rset = stmt.executeQuery("SELECT * FROM `projet_java`.`utilisateur` WHERE (Droit='"+Droit+"')");
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

int iD,mdp = 0,droit = 0;
String mail = null,nom = null,prenom = null;
L.add("ID  NOM");
while(rset.next())
{
iD=rset.getInt(1);
nom=rset.getString(4);
prenom=rset.getString(5);
droit=rset.getInt(6);
String id =Integer.toString(iD);

L.add(id+" "+nom+" "+prenom);

}

return L;
}
} catch (SQLException ex) {
Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return null;


}}
    

